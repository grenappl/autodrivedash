package models;

public class Car extends Entity{
    public static final int SPAWN_RATE = 750;
    public static final float SPAWN_CHANCE = (float)7 / 10;

    public Car(int x, int y, int width, int height, int spd, String filePath){
        super(x, y, width, height, spd, filePath);
    }
}