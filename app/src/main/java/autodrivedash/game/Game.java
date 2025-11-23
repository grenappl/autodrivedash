package autodrivedash.game;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.EntitySpawner;
import autodrivedash.game.entity.EntityType;
import autodrivedash.game.entity.enemy.EnemySpawnTimer;
import autodrivedash.game.entity.enemy.car.CarMovement;
import autodrivedash.game.entity.player.Player;
import autodrivedash.game.tile.TileSpawner;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

import static com.almasb.fxgl.dsl.FXGL.*;

public class Game implements ScreenConstants {
    // game init
    public void spawnEntities() {
        getGameWorld().addEntityFactory(new TileSpawner());
        getGameWorld().addEntityFactory(new EntitySpawner());

        for (int i = 0; i < TILE_MAX_ROW; i++) {
            String key = (i >= 2 && i <= 10) ? TileSpawner.ROAD_KEY : TileSpawner.SIDE_KEY;
            for (int j = 0; j < TILE_MAX_COL + 2; j++) {
                if (key != TileSpawner.SIDE_KEY)
                    key = (i == 6 && j % 2 != 0) ? TileSpawner.ROAD_STRIPE_KEY : TileSpawner.ROAD_KEY;
                spawn(key, TILE_SIZE * j, TILE_SIZE * i);
            }
        }
        EnemySpawnTimer.spawnCar();
        spawn(EntitySpawner.PLAYER_KEY);
    }

    public void addCollisions(Text livesCount) {
        livesCount.setText("3");
        FXGL.onCollision(EntityType.PLAYER, EntityType.ENEMY_CAR, (player, car) -> {
            if (!Player.isInvincible()) {
                MediaPlayer hurtPlayer = new MediaPlayer(new Media(
                        getClass().getResource("/audio/hurt.m4a").toExternalForm()));
                if (player.getInt("LIVES") > 0)
                    hurtPlayer.play();
                player.setProperty("LIVES", player.getInt("LIVES") - 1);
                livesCount.setText(String.valueOf(player.getInt("LIVES")));
                if (player.getInt("LIVES") > 0) {
                    Player.setIsInvincible(true);
                    Player.getInvincibilityTimer().play();
                } else if (player.getInt("LIVES") == 0) {
                    FXGL.getGameController().pauseEngine();
                    // App.getGameMenu()
                    FXGL.getGameController().gotoGameMenu();
                }
            }
        });
        FXGL.onCollision(EntityType.ENEMY_CAR, EntityType.ENEMY_CAR, (car1, car2) -> {
            CarMovement carMovement1 = car1.getComponent(CarMovement.class);
            CarMovement carMovement2 = car2.getComponent(CarMovement.class);
            carMovement1.setxSpd(carMovement2.getxSpd());
            if (car1.getX() < car2.getX())
                car1.setX(car1.getX() - 4);
            else
                car2.setX(car2.getX() - 4);
        });
    }

    // constant updates
    public void setScore(Text scoreCount) {
        inc("SCORE", 0.1);
        double score = getd("SCORE");
        scoreCount.setText(String.valueOf((int) score));
    }
}
