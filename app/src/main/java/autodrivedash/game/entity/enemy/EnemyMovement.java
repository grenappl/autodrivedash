package autodrivedash.game.entity.enemy;

import com.almasb.fxgl.entity.component.Component;

import autodrivedash.ScreenConstants;

public class EnemyMovement extends Component implements ScreenConstants {
    protected int xSpd;

    public int getxSpd() {
        return xSpd;
    }

    public void setxSpd(int xSpd) {
        this.xSpd = xSpd;
    }

    public EnemyMovement(int xSpd) {
        this.xSpd = xSpd;
    }
}
