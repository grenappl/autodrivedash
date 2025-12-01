package autodrivedash.game.entity.powerup;

import static com.almasb.fxgl.dsl.FXGL.run;
import static com.almasb.fxgl.dsl.FXGL.spawn;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.game.entity.EntitySpawner;
import autodrivedash.game.entity.EntityTexture;
import javafx.util.Duration;

public abstract class Powerup extends EntityTexture {
    public Powerup(String fileName) {
        super("/images/sprites/powerup/" + fileName);
        this.setFitHeight(TILE_SIZE - 8);
        this.setFitWidth(TILE_SIZE - 8);
    }

    public static int yLoc() {
        return FXGL.random(TILE_SIZE * 2, SCREEN_HEIGHT - (TILE_SIZE * 3) - 8);
    }

    private static int spawnInterval;

    public static void startSpawn() {
        spawnInterval = FXGL.random(55, 65);
        run(() -> {
            if (FXGL.random(1, 10) <= 6)
                spawn(EntitySpawner.POWERUP_BOOST);
            else
                spawn(EntitySpawner.POWERUP_HP);
            spawnInterval *= 1.5;
        }, Duration.seconds(spawnInterval));
    }
}
