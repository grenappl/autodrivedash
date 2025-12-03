package autodrivedash.game.entity.enemy;

import static com.almasb.fxgl.dsl.FXGL.run;
import static com.almasb.fxgl.dsl.FXGL.spawn;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.game.entity.EntitySpawner;
import javafx.util.Duration;

public class EnemySpawnTimer {
    private double carIntervalMillis1 = 600;
    private double carIntervalMillis2 = 1524;
    private double bikeIntervalMillis = 1100;
    private double truckIntervalMillis = 1400;

    public EnemySpawnTimer() {
        this.spawnCar();
        this.spawnBike();
        this.spawnTruck();
    }

    private void spawnCar() {
        run(() -> {
            spawn(EntitySpawner.ENEMY_CAR_KEY);
            if (FXGL.getd("SCORE") == 300)
                carIntervalMillis1 = 500;
            if (FXGL.getd("SCORE") == 600)
                carIntervalMillis1 = 400;
            if (FXGL.getd("SCORE") == 1000)
                carIntervalMillis1 = 300;
            if (FXGL.getd("SCORE") == 2000)
                carIntervalMillis1 = 200;
        }, Duration.millis(carIntervalMillis1));
        run(() -> {
            spawn(EntitySpawner.ENEMY_CAR_KEY);
            if (FXGL.getd("SCORE") == 500)
                carIntervalMillis2 = 662;
            if (FXGL.getd("SCORE") == 700)
                carIntervalMillis2 = 441;
            if (FXGL.getd("SCORE") == 1200)
                carIntervalMillis2 = 220;
            if (FXGL.getd("SCORE") == 2000)
                carIntervalMillis2 = 176;
        }, Duration.millis(carIntervalMillis2));
    }

    private void spawnBike() {
        run(() -> {
            int random = FXGL.random(1, 4);
            if ((FXGL.getd("SCORE") >= 300 && random == 1) ||
                    (FXGL.getd("SCORE") >= 600 && random <= 2) ||
                    (FXGL.getd("SCORE") >= 1500 && random <= 3))
                spawn(EntitySpawner.ENEMY_BIKE_KEY);
            if (FXGL.getd("SCORE") >= 1000)
                bikeIntervalMillis = 900;
        }, Duration.millis(bikeIntervalMillis));
    }

    private void spawnTruck() {
        run(() -> {
            int random = FXGL.random(1, 6);
            if ((FXGL.getd("SCORE") >= 700 && random == 1) ||
                    (FXGL.getd("SCORE") >= 1600 && random <= 2))
                spawn(EntitySpawner.ENEMY_TRUCK_KEY);
            if (FXGL.getd("SCORE") == 1200)
                truckIntervalMillis = 1200;
            if (FXGL.getd("SCORE") == 2500)
                truckIntervalMillis = 1000;
        }, Duration.millis(truckIntervalMillis));
    }
}
