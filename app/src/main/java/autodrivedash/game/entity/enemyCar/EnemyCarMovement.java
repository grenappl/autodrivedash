package autodrivedash.game.entity.enemyCar;

import static com.almasb.fxgl.dsl.FXGL.getGameWorld;

import com.almasb.fxgl.entity.component.Component;

import autodrivedash.ScreenConstants;

public class EnemyCarMovement extends Component implements ScreenConstants {
    private int spd;

    public EnemyCarMovement(int spd){
        this.spd = spd;
    }

    @Override
    public void onUpdate(double tpf){
        double x = entity.getX();

        entity.setX(x - this.spd);
        if(x <= -TILE_SIZE) getGameWorld().removeEntity(entity);
    }
}
