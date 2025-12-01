package autodrivedash.game.entity.enemy.truck;

import autodrivedash.game.entity.enemy.EnemyMovement;

public class TruckMovement extends EnemyMovement {
    public TruckMovement(int xSpd) {
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
