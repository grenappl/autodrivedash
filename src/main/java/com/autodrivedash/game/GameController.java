package autodrivedash.game;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import autodrivedash.App;
import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.EntitySpawner;
import autodrivedash.game.entity.EntityType;
import autodrivedash.game.entity.player.PlayerMovement;

import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;

import static com.almasb.fxgl.dsl.FXGL.*;

import com.almasb.fxgl.entity.Entity;

public class GameController implements ScreenConstants {
    private GameModel gameModel;
    public void setModel(GameModel model) {
        this.gameModel = model;
    }
    public GameModel getModel(){ return this.gameModel; }

    // FXML
    // @FXML private Pane bg;


    // LOGIC
    public boolean isPaused = false;

    private PlayerMovement playerMovement;
    public PlayerMovement getPlayerMovement(){ return this.playerMovement; }

    public void startGame(){
        // App.window.display(App.window.getGamePage());

        // playerMovement = new PlayerMovement(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT);

        getGameWorld().addEntityFactory(gameModel.getSpawnHandler());
        spawn(EntitySpawner.PLAYER_KEY);
        spawn(EntitySpawner.ENEMY_CAR_KEY);
    }
}
