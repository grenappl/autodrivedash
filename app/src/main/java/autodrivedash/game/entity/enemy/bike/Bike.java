package autodrivedash.game.entity.enemy.bike;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.game.entity.enemy.Enemy;

public class Bike extends Enemy {
    public Bike() {
        super("/images/sprites/enemy/bike/green.png");
        this.movement = new BikeMovement(FXGL.random(3, 4) * SPD_SCALE);
        this.setFitWidth(TILE_SIZE / 2 + 8);
        this.setFitHeight(TILE_SIZE / 4);
    }

    public static int yLoc() {
        return FXGL.random(TILE_SIZE * 2, SCREEN_HEIGHT - (TILE_SIZE * 3 - (TILE_SIZE / 2) - 12));
    }
}
