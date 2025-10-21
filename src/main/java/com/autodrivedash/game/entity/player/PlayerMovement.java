package autodrivedash.game.entity.player;

import static com.almasb.fxgl.dsl.FXGL.*;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.BoundingBoxComponent;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;

import autodrivedash.App;
import autodrivedash.InputManager;
import autodrivedash.game.entity.EntityType;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PlayerMovement extends Component {
    private double vx = 0;
    private double vy = 0;

    private double accel = 700; // pixels / s^2
    private double maxSpeed = 150; // pixels / s
    private double friction = 0.8; // per-frame multiplier when no input (0..1)
    private double stopThreshold = 5; // snap to zero when |v| < threshold

    public PlayerMovement() {
        // will change to set accel, maxSpeed, etc depending on player character
    }

    // @Override
    // public void onAdded() {}

    @Override
    public void onUpdate(double tpf) {
        if(InputManager.getRightPressed()) vx += accel * tpf;
        if(InputManager.getLeftPressed()) vx -= accel * tpf;
        if(InputManager.getDownPressed()) vy += accel * tpf;
        if(InputManager.getUpPressed()) vy -= accel * tpf;
        
        if(!InputManager.getLeftPressed() && !InputManager.getRightPressed()) vx *= friction;
        if(!InputManager.getUpPressed() && !InputManager.getDownPressed()) vy *= friction;

        if(Math.abs(vx) < stopThreshold) vx = 0;
        if(Math.abs(vy) < stopThreshold) vy = 0;

        vx = clamp(vx, -maxSpeed, maxSpeed);
        vy = clamp(vy, -maxSpeed, maxSpeed);

        entity.translateX(vx * tpf);
        entity.translateY(vy * tpf);
    }

    private double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    public void setAccel(double accel) { this.accel = accel; }
    public void setMaxSpeed(double maxSpeed) { this.maxSpeed = maxSpeed; }
    public void setFriction(double friction) { this.friction = friction; }
}