package autodrivedash.game.entity.road;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;

import autodrivedash.ScreenConstants;

public class RoadMovement extends Component implements ScreenConstants {
    @Override
    public void onUpdate(double tpf) {
        if (FXGL.getd("SCORE") <= 1000)
            entity.translateX(-((SCREEN_WIDTH - TILE_SIZE) * DELTA_TIME));
        else {
            entity.translateX(-((SCREEN_WIDTH + TILE_SIZE) * DELTA_TIME));
        }
        if (entity.getX() <= -(SCREEN_WIDTH)) {
            entity.setX(SCREEN_WIDTH - (TILE_SIZE / 2));
        }
    }
}
