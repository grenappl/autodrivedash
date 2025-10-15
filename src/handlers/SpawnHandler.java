package handlers;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Timer;

import app.settings.Screen;
import models.game.Car;
import models.game.Entity;

public class SpawnHandler implements Screen {
    public ArrayList<Entity> entities;
    public Timer carTimer, bikeTimer;

    public SpawnHandler(){
        this.entities = new ArrayList<>();
        setCarSpawn();
    }
    public void beginTimers(){
        carTimer.start();
    }
    public void stopTimers(){
        carTimer.stop();
    }
    int randomInt(int min, int max){ return ThreadLocalRandom.current().nextInt(min, max + 1); }
    void setCarSpawn(){
        this.carTimer = new Timer(250, e -> {
            if(randomInt(1, 10) <= (int)(Car.SPAWN_CHANCE * 10)){
                entities.add(
                    new Car(
                        SCREEN_WIDTH + TILE_SIZE,
                        randomInt(TILE_SIZE * 2, SCREEN_HEIGHT - TILE_SIZE * 3), 
                        TILE_SIZE, TILE_SIZE, randomInt(1, 3), 
                        null)
                );
            }
        });
    }
}
