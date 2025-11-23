package autodrivedash.game.entity.enemy.car;

import static com.almasb.fxgl.dsl.FXGL.getGameWorld;

import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.enemy.EnemyMovement;

public class CarMovement extends EnemyMovement implements ScreenConstants {
    public CarMovement(int xSpd) {
        super(xSpd);
    }

    @Override
    public void onUpdate(double tpf) {
        double x = entity.getX();

        entity.setX(x - this.xSpd);
        if (x <= -TILE_SIZE)
            entity.removeFromWorld();
    }
}
