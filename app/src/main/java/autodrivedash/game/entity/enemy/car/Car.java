package autodrivedash.game.entity.enemy.car;

import autodrivedash.game.entity.enemy.Enemy;

public class Car extends Enemy {
    public Car(String filePath, int spd) {
        super(filePath);
        this.movement = new CarMovement(spd);
    }
}
