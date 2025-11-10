package autodrivedash.game.entity.player;

import com.almasb.fxgl.entity.component.Component;
import autodrivedash.ScreenConstants;
import autodrivedash.game.GameInputManager;

public class PlayerMovement extends Component implements ScreenConstants {
    private double vx = 0;
    private double vy = 0;

    private double accel, maxSpd, friction;

    public PlayerMovement(double accel, double maxSpd, double friction) {
        this.accel = accel;
        this.maxSpd = maxSpd;
        this.friction = friction;
    }

    @Override
    public void onUpdate(double tpf) {
        if(GameInputManager.getRightPressed()) vx += accel * tpf;
        if(GameInputManager.getLeftPressed()) vx -= accel * tpf;
        if(GameInputManager.getDownPressed()) vy += accel * tpf;
        if(GameInputManager.getUpPressed()) vy -= accel * tpf;

        double posY = entity.getY();
        double posX = entity.getX();

        if(posY <= TILE_SIZE * 2) entity.setY(TILE_SIZE * 2);
        if(posY + TILE_SIZE / 2 >= SCREEN_HEIGHT - TILE_SIZE * 2) entity.setY(SCREEN_HEIGHT - TILE_SIZE * 2 - TILE_SIZE / 2);
        if(posX <= 0) entity.setX(0);
        if(posX + TILE_SIZE >= SCREEN_WIDTH) entity.setX(SCREEN_WIDTH - TILE_SIZE);
        
        if(!GameInputManager.getLeftPressed() && !GameInputManager.getRightPressed()) vx *= friction;
        if(!GameInputManager.getUpPressed() && !GameInputManager.getDownPressed()) vy *= friction;

        vx = clamp(vx, -maxSpd, maxSpd);
        vy = clamp(vy, -maxSpd, maxSpd);

        entity.translateX(vx * tpf);
        entity.translateY(vy * tpf);
    }

    private double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    public void setAccel(double accel) { this.accel = accel; }
    public void setMaxSpeed(double maxSpd) { this.maxSpd = maxSpd; }
    public void setFriction(double friction) { this.friction = friction; }
}