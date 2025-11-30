package autodrivedash.game.entity.player;

import com.almasb.fxgl.entity.component.Component;
import autodrivedash.ScreenConstants;
import autodrivedash.game.GameInput;

public class PlayerMovement extends Component implements ScreenConstants {
    private double vx = 0;
    private double vy = 0;
    private double boost = 0;

    private final double friction = 0.8;

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    private double accel, maxSpd;

    public PlayerMovement(double accel, double maxSpd) {
        this.accel = accel;
        this.maxSpd = maxSpd;
    }

    @Override
    public void onUpdate(double tpf) {
        boost = GameInput.boostPressed() ? 100 : 0;

        if (GameInput.rightPressed())
            vx += (accel + boost) * DELTA_TIME;
        if (GameInput.leftPressed())
            vx -= (accel + boost) * DELTA_TIME;
        if (GameInput.downPressed())
            vy += (accel + boost) * DELTA_TIME;
        if (GameInput.upPressed())
            vy -= (accel + boost) * DELTA_TIME;

        double posY = entity.getY();
        double posX = entity.getX();

        if (posY <= TILE_SIZE * 2)
            entity.setY(TILE_SIZE * 2);
        if (posY + Player.getSelectedCharacter().getHeight() >= SCREEN_HEIGHT - TILE_SIZE * 2)
            entity.setY(SCREEN_HEIGHT - TILE_SIZE * 2 - Player.getSelectedCharacter().getHeight());
        if (posX <= 0)
            entity.setX(0);
        if (posX + Player.getSelectedCharacter().getWidth() >= SCREEN_WIDTH)
            entity.setX(SCREEN_WIDTH - Player.getSelectedCharacter().getWidth());

        if (!GameInput.leftPressed() && !GameInput.rightPressed())
            vx *= friction;
        if (!GameInput.upPressed() && !GameInput.downPressed())
            vy *= friction;

        vx = clamp(vx, -(maxSpd + boost), maxSpd + boost);
        vy = clamp(vy, -(maxSpd + boost), maxSpd + boost);

        entity.translate(vx * DELTA_TIME, vy * DELTA_TIME);
    }

    private double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }
}