package autodrivedash.game.entity;

import static com.almasb.fxgl.dsl.FXGL.*;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.enemy.bike.Bike;
import autodrivedash.game.entity.enemy.car.Car;
import autodrivedash.game.entity.player.Player;
import autodrivedash.game.entity.powerup.Repair;
import autodrivedash.game.entity.powerup.Powerup;
import autodrivedash.game.entity.powerup.PowerupMovement;
import autodrivedash.game.entity.road.Road;
import autodrivedash.game.entity.road.RoadMovement;
import autodrivedash.game.entity.road.RoadSidewalk;

public class EntitySpawner implements EntityFactory, ScreenConstants {
    public final static String PLAYER_KEY = "PLAYER";
    public final static String ROAD_KEY = "ROAD";
    public final static String SIDEWALK_KEY = "SIDEWALK";

    public final static String ENEMY_CAR_KEY = "ENEMY_CAR";
    public final static String ENEMY_BIKE_KEY = "ENEMY_BIKE";

    public final static String POWERUP_HP = "HP";

    @Spawns(PLAYER_KEY)
    public Entity newPlayer(SpawnData data) {
        return entityBuilder(data)
                .type(EntityType.PLAYER)
                .at(TILE_SIZE * 3, SCREEN_HEIGHT_CENTER + (TILE_SIZE / 4))
                .view(new Player())
                .with(Player.getSelectedCharacter().getMovement())
                .bbox(Player.getSelectedCharacter().getHitbox())
                .with("LIVES", Player.getSelectedCharacter().getLives())
                .collidable()
                .zIndex(10)
                .build();
    }

    // road
    @Spawns(ROAD_KEY)
    public Entity newRoad(SpawnData data) {
        return entityBuilder(data)
                .view(new Road())
                .with(new RoadMovement())
                .zIndex(1)
                .build();
    }

    @Spawns(SIDEWALK_KEY)
    public Entity newSidewalk(SpawnData data) {
        return entityBuilder(data)
                .view(new RoadSidewalk())
                .with(new RoadMovement())
                .zIndex(1)
                .build();
    }

    // enemies
    @Spawns(ENEMY_CAR_KEY)
    public Entity newEnemyCar(SpawnData data) {
        Car car = new Car();
        return entityBuilder(data)
                .type(EntityType.ENEMY)
                .at(SCREEN_WIDTH, Car.yLoc())
                .viewWithBBox(car)
                .with(car.movement)
                .collidable()
                .zIndex(5)
                .build();
    }

    @Spawns(ENEMY_BIKE_KEY)
    public Entity newEnemyBike(SpawnData data) {
        Bike bike = new Bike();
        return entityBuilder(data)
                .type(EntityType.ENEMY)
                .at(-TILE_SIZE, Bike.yLoc())
                .viewWithBBox(bike)
                .with(bike.movement)
                .collidable()
                .zIndex(5)
                .build();
    }

    // powerups
    @Spawns(POWERUP_HP)
    public Entity newRepairPowerup(SpawnData data) {
        return entityBuilder(data)
                .type(EntityType.HP)
                .at(SCREEN_WIDTH, Powerup.yLoc())
                .viewWithBBox(new Repair())
                .with(new PowerupMovement())
                .collidable()
                .zIndex(9)
                .build();
    }
}
