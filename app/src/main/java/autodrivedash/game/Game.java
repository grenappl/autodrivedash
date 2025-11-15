package autodrivedash.game;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.EntitySpawner;
import autodrivedash.game.entity.EntityType;
import autodrivedash.game.entity.player.Player;
import autodrivedash.game.entity.tile.TileSpawner;
import javafx.scene.text.Text;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;

public class Game implements ScreenConstants {
    // game init
    public void spawnEntities() {
        getGameWorld().addEntityFactory(new EntitySpawner());
        getGameWorld().addEntityFactory(new TileSpawner());

        for (int i = 0; i < TILE_MAX_ROW; i++) {
            String key = (i >= 2 && i <= 10) ? TileSpawner.ROAD_KEY : TileSpawner.SIDE_KEY;
            for (int j = 0; j < TILE_MAX_COL + 2; j++) {
                if (key != TileSpawner.SIDE_KEY)
                    key = (i == 6 && j % 2 != 0) ? TileSpawner.ROAD_STRIPE_KEY : TileSpawner.ROAD_KEY;
                spawn(key, TILE_SIZE * j, TILE_SIZE * i);
            }
        }
        run(() -> spawn(EntitySpawner.ENEMY_CAR_KEY), Duration.millis(500));
        spawn(EntitySpawner.PLAYER_KEY);
    }

    public void addCollisions(Text livesCount) {
        livesCount.setText("3");
        FXGL.onCollision(EntityType.PLAYER, EntityType.ENEMY_CAR, (player, enemy) -> {
            if (!Player.isInvincible()) {
                player.setProperty("LIVES", player.getInt("LIVES") - 1);
                livesCount.setText(String.valueOf(player.getInt("LIVES")));
                System.out.println(player.getInt("LIVES"));
                if (player.getInt("LIVES") > 0) {
                    Player.setIsInvincible(true);
                    runOnce(() -> {
                        Player.setIsInvincible(false);
                    }, Duration.seconds(Player.invincibilityDuration()));
                } else {
                    FXGL.getGameController().pauseEngine();
                    FXGL.getGameController().gotoGameMenu();
                }
            }
        });
    }

    // constant updates
    public void setScore(Text scoreCount) {
        inc("SCORE", 0.1);
        double score = getd("SCORE");
        scoreCount.setText(String.valueOf((int) score));
    }
}
