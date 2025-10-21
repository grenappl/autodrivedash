package autodrivedash;

import java.io.IOException;
import java.util.Map;

import autodrivedash.db.Database;
import autodrivedash.game.entity.EntitySpawner;
import autodrivedash.game.entity.EntityType;
import autodrivedash.game.entity.player.Player;
import autodrivedash.menu.MenuFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.util.Duration;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import static com.almasb.fxgl.dsl.FXGL.*;

public final class App extends GameApplication implements ScreenConstants {
    private static final String NAME = "Auto Drive Dash";
    public static UiManager ui;
    public static Database db;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(SCREEN_WIDTH);
        settings.setHeight(SCREEN_HEIGHT);
        settings.setTitle(NAME);
        settings.setSceneFactory(new MenuFactory());
        settings.setMainMenuEnabled(true);
        settings.setGameMenuEnabled(true);
        settings.setDeveloperMenuEnabled(true); // debug
    }

    @Override
    protected void onPreInit(){
        System.out.println(getGameScene());
    }

    @Override
    protected void initInput() {
        InputManager.setUpAction(new UserAction("UP") {
            @Override protected void onActionBegin() { InputManager.setUpPressed(true); }
            @Override protected void onActionEnd() { InputManager.setUpPressed(false); }
        });
        InputManager.setDownAction(new UserAction("DOWN") {
            @Override protected void onActionBegin() { InputManager.setDownPressed(true); }
            @Override protected void onActionEnd() { InputManager.setDownPressed(false); }
        });
        InputManager.setLeftAction(new UserAction("LEFT") {
            @Override protected void onActionBegin() { InputManager.setLeftPressed(true); }
            @Override protected void onActionEnd() { InputManager.setLeftPressed(false); }
        });
        InputManager.setRightAction(new UserAction("RIGHT") {
            @Override protected void onActionBegin() { InputManager.setRightPressed(true); }
            @Override protected void onActionEnd() { InputManager.setRightPressed(false); }
        });

        getInput().addAction(InputManager.getUpAction(), InputManager.getKeyCode("UP"));
        getInput().addAction(InputManager.getDownAction(), InputManager.getKeyCode("DOWN"));
        getInput().addAction(InputManager.getLeftAction(), InputManager.getKeyCode("LEFT"));
        getInput().addAction(InputManager.getRightAction(), InputManager.getKeyCode("RIGHT"));
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {

    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new EntitySpawner());
        spawn(EntitySpawner.PLAYER_KEY);
        spawn(EntitySpawner.ENEMY_CAR_KEY);
        spawn(EntitySpawner.ENEMY_CAR_KEY);
        spawn(EntitySpawner.ENEMY_CAR_KEY);
    }

    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER, EntityType.ENEMY_CAR) {
            @Override
            protected void onCollision(Entity player, Entity enemy) {
                if(!Player.isInvincible()){
                    System.err.println("Player has collided!");
                    Player.setIsInvincible(true);
                    runOnce(() -> {
                        System.out.println("NOT invincible!");
                        Player.setIsInvincible(false);
                    }, Duration.seconds(Player.invincibilityDuration()));
                }
            }
            @Override
            protected void onCollisionEnd(Entity player, Entity enemy) {
                System.out.println("Player no longer touching enemy!");
            }
        });
    }

    @Override
    protected void initUI() {
        try {
            getGameScene().addUINode(FXMLLoader.load(getClass().getResource(UiManager.GAME)));
            getGameScene().setCursor(Cursor.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}