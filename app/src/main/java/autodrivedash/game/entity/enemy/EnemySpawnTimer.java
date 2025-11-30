package autodrivedash.game.entity.enemy;

import static com.almasb.fxgl.dsl.FXGL.run;
import static com.almasb.fxgl.dsl.FXGL.spawn;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.game.entity.EntitySpawner;
import javafx.util.Duration;

public class EnemySpawnTimer {
    private double carIntervalMillis = 600;
    private double bikeIntervalMillis = 1100;

    public EnemySpawnTimer() {
        this.spawnCar();
        this.spawnBike();
    }

    private void spawnCar() {
        run(() -> {
            spawn(EntitySpawner.ENEMY_CAR_KEY);
            if (FXGL.getd("SCORE") == 300)
                carIntervalMillis = 500;
            if (FXGL.getd("SCORE") == 600)
                carIntervalMillis = 400;
            if (FXGL.getd("SCORE") == 1000)
                carIntervalMillis = 300;
            if (FXGL.getd("SCORE") == 2000)
                carIntervalMillis = 200;
        }, Duration.millis(carIntervalMillis));
    }

    private void spawnBike() {
        run(() -> {
            int random = FXGL.random(1, 4);
            if ((FXGL.getd("SCORE") >= 300 && random == 1) ||
                    (FXGL.getd("SCORE") >= 600 && random <= 2))
                spawn(EntitySpawner.ENEMY_BIKE_KEY);
            if (FXGL.getd("SCORE") >= 1000)
                bikeIntervalMillis = 900;
        }, Duration.millis(bikeIntervalMillis));
    }
}
