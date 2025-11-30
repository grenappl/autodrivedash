package autodrivedash.game.entity.enemy.car;

import autodrivedash.game.entity.enemy.EnemyMovement;

public class CarMovement extends EnemyMovement {
    public CarMovement(int xSpd) {
        super(xSpd);
    }

    @Override
    public void onUpdate(double tpf) {
        double x = entity.getX();

        entity.translateX(-(this.xSpd * DELTA_TIME));
        if (x <= -TILE_SIZE)
            entity.removeFromWorld();
    }
}
