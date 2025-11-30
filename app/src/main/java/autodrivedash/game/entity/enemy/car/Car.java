package autodrivedash.game.entity.enemy.car;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.game.entity.enemy.Enemy;

public class Car extends Enemy {
    public Car() {
        String fileNames[] = {
                "blue.png", "orange.png"
        };
        String randomFileName = fileNames[FXGL.random(0, 1)];
        super("/images/sprites/enemy/car/" + randomFileName);
        this.movement = new CarMovement(FXGL.random(1, 4) * SPD_SCALE);
        this.setFitWidth(TILE_SIZE - 8);
        this.setFitHeight(TILE_SIZE / 2);
    }

    public static int yLoc() {
        return FXGL.random(TILE_SIZE * 2, SCREEN_HEIGHT - (TILE_SIZE * 3 - (TILE_SIZE / 2)));
    }
}
