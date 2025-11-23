package autodrivedash.game.tile;

import com.almasb.fxgl.entity.component.Component;

import autodrivedash.ScreenConstants;

public class TileMovement extends Component implements ScreenConstants {
    
    @Override
    public void onUpdate(double tpf){
        double x = entity.getX();

        entity.setX(x - 6);
        if(x <= -(TILE_SIZE * 2 - 8)){
            entity.setX(SCREEN_WIDTH);
        }
    }
}
