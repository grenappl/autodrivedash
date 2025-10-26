package autodrivedash.game.entity.tile;

import com.almasb.fxgl.entity.component.Component;

import autodrivedash.ScreenConstants;

import static com.almasb.fxgl.dsl.FXGL.*;

public class TileMovement extends Component implements ScreenConstants {
    
    @Override
    public void onUpdate(double tpf){
        double x = entity.getX();
        double y = entity.getY();

        entity.setX(x - 6);
        if(x <= -(TILE_SIZE * 2 - 8)){
            entity.setX(SCREEN_WIDTH);
        }
    }
}
