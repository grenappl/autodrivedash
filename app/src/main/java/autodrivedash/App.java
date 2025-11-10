package autodrivedash;

import java.io.IOException;
import java.util.Map;

import autodrivedash.db.Database;
import autodrivedash.game.GameController;
import autodrivedash.game.GameInputManager;
import autodrivedash.game.GameMenu;
import autodrivedash.game.GameModel;
import autodrivedash.game.entity.EntitySpawner;
import autodrivedash.game.entity.EntityType;
import autodrivedash.game.entity.player.Player;
import autodrivedash.game.entity.tile.TileSpawner;
import autodrivedash.menu.MainMenu;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.util.Duration;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;

import static com.almasb.fxgl.dsl.FXGL.*;

public final class App extends GameApplication implements ScreenConstants {
    private static final String NAME = "Auto Drive Dash";
    private static MainMenu mainMenu;
    private static GameMenu gameMenu;
    public static Database db;
    public static GameController gameCtrl;

    public static MainMenu getMainMenu() {
        return mainMenu;
    }

    public static GameMenu getGameMenu() {
        return gameMenu;
    }

    public static void setMainMenu(MainMenu newMainMenu) {
        mainMenu = newMainMenu;
    }

    public static void setGameMenu(GameMenu newGameMenu) {
        gameMenu = newGameMenu;
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(SCREEN_WIDTH);
        settings.setHeight(SCREEN_HEIGHT);
        settings.setTitle(NAME);
        settings.setSceneFactory(new AppMenuFactory());
        settings.setMainMenuEnabled(true);
        settings.setGameMenuEnabled(true);
        settings.setDeveloperMenuEnabled(true); // debug
    }

    @Override
    protected void initInput() {
        GameInputManager.setInputs();
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("SCORE", 0);
    }

    @Override
    protected void initGame() {
        try {
            FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/ui/game.fxml"));
            getGameScene().addUINode(gameLoader.load());
            gameCtrl = gameLoader.getController();
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