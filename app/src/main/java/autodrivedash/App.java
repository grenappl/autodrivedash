package autodrivedash;

import java.io.IOException;
import java.util.Map;

import autodrivedash.db.Database;
import autodrivedash.game.GameController;
import autodrivedash.game.GameInput;
import autodrivedash.game.GameSound;
import autodrivedash.game.gameMenu.GameMenu;
import autodrivedash.menu.Menu;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.input.KeyCode;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.input.UserAction;

import static com.almasb.fxgl.dsl.FXGL.*;

public final class App extends GameApplication implements ScreenConstants {
    public static void main(String[] args) {
        launch(args);
    }

    private static final String NAME = "Auto Drive Dash";

    private static int loggedUserId = -1;

    public static int getLoggedUserId() {
        return loggedUserId;
    }

    public static void setLoggedUserId(int loggedUserId) {
        App.loggedUserId = loggedUserId;
    }

    private static Menu mainMenu;
    private static GameMenu gameMenu;
    private static GameController gameCtrl;
    private static Database db;
    private static GameSound gameSound;

    public static GameSound getGameSound() {
        return gameSound;
    }

    public static Menu getMainMenu() {
        return mainMenu;
    }

    public static GameMenu getGameMenu() {
        return gameMenu;
    }

    public static GameController getGameController() {
        return gameCtrl;
    }

    public static Database getDb() {
        return db;
    }

    public static void setMainMenu(Menu newMainMenu) {
        mainMenu = newMainMenu;
    }

    public static void setGameMenu(GameMenu newGameMenu) {
        gameMenu = newGameMenu;
    }

    public static void setGameCtrl(GameController newCtrl) {
        gameCtrl = newCtrl;
    }

    public static void setDb(Database newDb) {
        db = newDb;
    }

    public static void setGameSound(GameSound gameSound) {
        App.gameSound = gameSound;
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(SCREEN_WIDTH);
        settings.setHeight(SCREEN_HEIGHT);
        settings.setTitle(NAME);
        setDb(new Database());
        settings.setSceneFactory(new AppSceneFactory());
        settings.setMainMenuEnabled(true);
        settings.setGameMenuEnabled(true);
        settings.setDeveloperMenuEnabled(true); // debug
    }

    @Override
    protected void initInput() {
        GameInput.setInputs();
        getInput().addAction(new UserAction("ESC") {
            @Override
            protected void onActionBegin() {
                MediaPlayer bgMusic = getGameSound().getCurrentGameMusic();
                if (bgMusic.getStatus().equals(MediaPlayer.Status.PLAYING))
                    getGameSound().getCurrentGameMusic().pause();
            }
        }, KeyCode.ESCAPE);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("SCORE", 0.0);
    }

    @Override
    protected void initGame() {
        try {
            FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/ui/game.fxml"));
            getGameScene().addUINode(gameLoader.load());
            setGameCtrl(gameLoader.getController());
            getGameScene().setCursor(Cursor.DEFAULT);
            getGameScene().setBackgroundColor(Color.GRAY);
            gameCtrl.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onUpdate(double tpf) {
        gameCtrl.update();
    }
}