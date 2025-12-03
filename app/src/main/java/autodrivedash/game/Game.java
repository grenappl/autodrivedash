package autodrivedash.game;

import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.EntitySpawner;
import autodrivedash.game.entity.player.Player;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import static com.almasb.fxgl.dsl.FXGL.*;

import com.almasb.fxgl.entity.Entity;

public class Game implements ScreenConstants {
    private static GameCollisions collisions = new GameCollisions();

    public static GameCollisions getCollisions() {
        return collisions;
    }

    // game init
    public static void spawnEntities() {
        getGameWorld().addEntityFactory(new EntitySpawner());

        spawn(EntitySpawner.SIDEWALK_KEY, 0, 0);
        spawn(EntitySpawner.SIDEWALK_KEY, SCREEN_WIDTH, 0);
        spawn(EntitySpawner.ROAD_KEY, 0, TILE_SIZE * 2);
        spawn(EntitySpawner.ROAD_KEY, SCREEN_WIDTH, TILE_SIZE * 2);
        spawn(EntitySpawner.SIDEWALK_KEY, 0, SCREEN_HEIGHT - (TILE_SIZE * 2));
        spawn(EntitySpawner.SIDEWALK_KEY, SCREEN_WIDTH, SCREEN_HEIGHT - (TILE_SIZE * 2));

        Entity player = spawn(EntitySpawner.PLAYER_KEY);
        Player.setInvincibilityTimer(player);
    }

    public static void addCollisions(ImageView[] health) {
        collisions.setPlayerToEnemy(health);
        collisions.setPlayertoPowerup(health);
        collisions.setPlayertoSidewalk();
    }

    public static void startCountdown(Label countdown) {
        GameCountdown.start(countdown);
    }

    // constant updates (increments score by 0.2)
    public static void setScore(Text scoreCount) {
        if (!GameCountdown.isRunning()) {
            inc("SCORE", 0.2);
            double score = getd("SCORE");
            scoreCount.setText(String.valueOf((int) score));
        }
    }
}
