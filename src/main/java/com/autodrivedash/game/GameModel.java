package autodrivedash.game;

import java.sql.Connection;
import java.util.ArrayList;

import com.almasb.fxgl.entity.Entity;

import autodrivedash.game.entity.EntitySpawner;
import autodrivedash.game.entity.EntityType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.input.UserAction;

import static com.almasb.fxgl.dsl.FXGL.*;

public class GameModel {
    KeyCode upKey, downKey, leftKey, rightKey;

    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    private double vx = 0;
    private double vy = 0;

    private double accel = 700; // pixels / s^2
    private double maxSpeed = 150; // pixels / s
    private double friction = 0.8; // per-frame multiplier when no input (0..1)
    private double stopThreshold = 5; // snap to zero when |v| < threshold

    private UserAction upAction, downAction, leftAction, rightAction;

    public GameModel(KeyCode up, KeyCode down, KeyCode left, KeyCode right) {
        this.upKey = up;
        this.downKey = down;
        this.leftKey = left;
        this.rightKey = right;
    }

    public EntityType et;

    private Entity player;
    public Entity getPlayer(){ return this.player; }
    public void setPlayer(Entity player){
        this.player = player;
    }

    private ArrayList<Entity> entities = new ArrayList<>();

    private EntitySpawner entitySpawner = new EntitySpawner();
    public EntitySpawner getSpawnHandler(){ return this.entitySpawner; }



    // public void setPlayer(){
    //     player = FXGL.entityBuilder()
    //         .type(EntityType.PLAYER)
    //         .at(250, 275)
    //         .view(FXGL.texture("../../images/p.png",50 ,50))
    //         .collidable()
    //         .build();
    // }
}
