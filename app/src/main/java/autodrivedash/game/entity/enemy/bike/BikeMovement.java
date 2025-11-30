package autodrivedash.game.entity.enemy.bike;

import autodrivedash.game.entity.enemy.EnemyMovement;

public class BikeMovement extends EnemyMovement {
    public BikeMovement(int xSpd) {
        super(xSpd);
    }

    @Override
    public void onUpdate(double tpf) {
        double x = entity.getX();

        entity.translateX(this.xSpd * DELTA_TIME);
        if (x >= SCREEN_WIDTH)
            entity.removeFromWorld();
    }
}
