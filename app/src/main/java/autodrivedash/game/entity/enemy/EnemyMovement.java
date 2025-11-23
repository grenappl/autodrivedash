package autodrivedash.game.entity.enemy;

import com.almasb.fxgl.entity.component.Component;

public class EnemyMovement extends Component {
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
