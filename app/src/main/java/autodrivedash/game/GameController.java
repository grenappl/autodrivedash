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
import javafx.scene.text.Text;
import javafx.util.Duration;
import autodrivedash.App;
import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.EntitySpawner;
import autodrivedash.game.entity.EntityType;
import autodrivedash.game.entity.player.PlayerMovement;
import autodrivedash.game.entity.tile.TileSpawner;

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

    @FXML private Text scoreCount;


    public void startGame(){
        for(int i = 0; i < TILE_MAX_ROW; i++){
            String key = (i >= 2 && i <= 10) ? TileSpawner.ROAD_KEY : TileSpawner.SIDE_KEY;
            for(int j = 0; j < TILE_MAX_COL + 2; j++){
                if(key != TileSpawner.SIDE_KEY)
                    key = (i == 6 && j % 2 != 0) ? TileSpawner.ROAD_STRIPE_KEY : TileSpawner.ROAD_KEY;
                spawn(key, TILE_SIZE * j, TILE_SIZE * i);
            }
        }

        run(() -> spawn(EntitySpawner.ENEMY_CAR_KEY), Duration.millis(500));

        spawn(EntitySpawner.PLAYER_KEY);
    }
    public void setScore(int score){
        scoreCount.setText(String.valueOf(score));
    }
}
