package autodrivedash.game.entity.enemy;

import static com.almasb.fxgl.dsl.FXGL.run;
import static com.almasb.fxgl.dsl.FXGL.spawn;

import autodrivedash.game.entity.EntitySpawner;
import javafx.util.Duration;

public final class EnemySpawnTimer {
    public static void spawnCar() {
        run(() -> spawn(EntitySpawner.ENEMY_CAR_KEY), Duration.millis(600));
    }
}
