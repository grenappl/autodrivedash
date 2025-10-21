package autodrivedash.game.entity;

import static com.almasb.fxgl.dsl.FXGL.*;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Renderer;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.ViewComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;

import autodrivedash.App;
import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.player.Player;
import autodrivedash.game.entity.player.PlayerMovement;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class EntitySpawner implements EntityFactory, ScreenConstants {
    public final static String PLAYER_KEY = "PLAYER";
    public final static String ENEMY_CAR_KEY = "ENEMY_CAR";

    @Spawns(PLAYER_KEY)
    public Entity newPlayer(SpawnData data){
        return entityBuilder(data)
            .type(EntityType.PLAYER)
            .at(TILE_SIZE, SCREEN_HEIGHT_CENTER - (TILE_SIZE / 2))
            .view(FXGL.texture("../../images/p.png", TILE_SIZE, TILE_SIZE))
            .bbox(new HitBox("PlayerHitbox", new Point2D(0, (TILE_SIZE / 2) / 2), BoundingShape.box(TILE_SIZE, TILE_SIZE / 2)))
            .with(new PlayerMovement())
            .with("lives", 3)
            .collidable()
            .zIndex(10)
            .build();
    }

    @Spawns(ENEMY_CAR_KEY)
    public Entity newEnemyCar(SpawnData data){
        int randomY = FXGL.random(TILE_SIZE * 2, SCREEN_HEIGHT - (TILE_SIZE * 3));

        return entityBuilder(data)
            .type(EntityType.ENEMY_CAR)
            .at(500, randomY)
            .viewWithBBox(new Rectangle(50, 50, Color.BLUE))
            .collidable()
            .zIndex(1)
            .build();
    }
}
