package autodrivedash;

import java.io.IOException;
import java.util.Map;

import autodrivedash.db.Database;
import autodrivedash.game.GameController;
import autodrivedash.game.GameInput;
import autodrivedash.game.GameMenu;
import autodrivedash.menu.Menu;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

import static com.almasb.fxgl.dsl.FXGL.*;

public final class App extends GameApplication implements ScreenConstants {
    private static final String NAME = "Auto Drive Dash";

    private static boolean isUserLogged = false;

    public static boolean isUserLogged() {
        return isUserLogged;
    }

    public static void setIsUserLogged(boolean logged) {
        isUserLogged = logged;
    }

    private static Menu mainMenu;
    private static GameMenu gameMenu;
    private static GameController gameCtrl;
    private static Database db;

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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(SCREEN_WIDTH);
        settings.setHeight(SCREEN_HEIGHT);
        settings.setTitle(NAME);
        settings.setSceneFactory(new AppSceneFactory());
        settings.setMainMenuEnabled(true);
        settings.setGameMenuEnabled(true);
        settings.setDeveloperMenuEnabled(true); // debug
    }

    @Override
    protected void initInput() {
        GameInput.setInputs();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameCtrl.startGame();
    }

    @Override
    protected void onUpdate(double tpf) {
        gameCtrl.update();
    }
}