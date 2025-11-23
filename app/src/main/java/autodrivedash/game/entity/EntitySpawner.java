package autodrivedash.game.entity;

import static com.almasb.fxgl.dsl.FXGL.*;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.texture.Texture;

import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.enemy.car.Car;
import autodrivedash.game.entity.enemy.car.CarMovement;
import autodrivedash.game.entity.player.Player;
import autodrivedash.game.entity.player.PlayerCharacter;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EntitySpawner implements EntityFactory, ScreenConstants {
    public final static String PLAYER_KEY = "PLAYER";
    public final static String ENEMY_CAR_KEY = "ENEMY_CAR";

    @Spawns(PLAYER_KEY)
    public Entity newPlayer(SpawnData data) {
        return entityBuilder(data)
                .type(EntityType.PLAYER)
                .at(TILE_SIZE, SCREEN_HEIGHT_CENTER + (TILE_SIZE / 4))
                .view(new Player())
                .bbox(Player.getSelectedCharacter().getHitbox())
                .with(Player.getSelectedCharacter().getMovement())
                .with("LIVES", 3)
                .collidable()
                .zIndex(10)
                .build();
    }

    @Spawns(ENEMY_CAR_KEY)
    public Entity newEnemyCar(SpawnData data) {
        int randomY = FXGL.random(TILE_SIZE * 2, SCREEN_HEIGHT - (TILE_SIZE * 3) - 2);
        int randomSpd = FXGL.random(1, 4);
        String dirPath = "/images/sprites/enemy/car/";
        String filePaths[] = {
                dirPath + "blue.png"
        };
        String randomFilePath = filePaths[0];
        Car car = new Car(randomFilePath, randomSpd);

        return entityBuilder(data)
                .type(EntityType.ENEMY_CAR)
                .at(SCREEN_WIDTH, randomY)
                .viewWithBBox(car)
                .with(car.movement)
                .collidable()
                .zIndex(1)
                .build();
    }
}
