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
import javafx.scene.paint.Color;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import static com.almasb.fxgl.dsl.FXGL.*;

public final class App extends GameApplication implements ScreenConstants {
    // start here
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

    // main app variables
    private static Menu mainMenu;
    private static GameMenu gameMenu;
    private static GameController gameCtrl;
    private static Database db;
    private static GameSound gameSound;

    // getters
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

    // setters
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
        settings.setSceneFactory(new AppSceneFactory()); // menu init
        settings.setMainMenuEnabled(true);
        settings.setGameMenuEnabled(true);
        settings.setDeveloperMenuEnabled(true); // debug
    }

    @Override
    protected void initInput() {
        GameInput.setInputs();
    }

    // init global variables
    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("SCORE", 0.0);
    }

    // start of game after clicking play
    @Override
    protected void initGame() {
        // when game starts, load game ui
        try {
            FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/ui/game.fxml"));
            getGameScene().addUINode(gameLoader.load());
            setGameCtrl(gameLoader.getController());
            getGameScene().setCursor(Cursor.DEFAULT);
            getGameScene().setBackgroundColor(Color.GRAY);
            gameCtrl.startGame(); // call start from game controller
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onUpdate(double tpf) {
        gameCtrl.update();
    }
}