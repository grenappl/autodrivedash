package autodrivedash.game.entity.powerup;

import com.almasb.fxgl.entity.component.Component;

import autodrivedash.ScreenConstants;

public class PowerupMovement extends Component implements ScreenConstants {
    @Override
    public void onUpdate(double tpf) {
        double x = entity.getX();

        entity.translateX(-(1 * SPD_SCALE * DELTA_TIME));
        if (x <= -TILE_SIZE)
            entity.removeFromWorld();
    }
}
