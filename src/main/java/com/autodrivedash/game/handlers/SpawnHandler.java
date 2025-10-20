package autodrivedash.game.handlers;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Timer;

import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.Car;
import autodrivedash.game.entity.Entity;

public class SpawnHandler implements ScreenConstants {
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
