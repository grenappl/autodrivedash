package autodrivedash.game.entity.enemy.truck;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.game.entity.enemy.Enemy;

public class Truck extends Enemy {
    public Truck() {
        super("/images/sprites/enemy/truck/white.png");
        this.movement = new TruckMovement(SPD_SCALE / FXGL.random(2, 3));
        this.setFitWidth(TILE_SIZE + 16);
        this.setFitHeight(TILE_SIZE - 18);
    }

    public static int yLoc() {
        return FXGL.random(TILE_SIZE * 2, SCREEN_HEIGHT - (TILE_SIZE * 3 - (TILE_SIZE - 18)));
    }
}
