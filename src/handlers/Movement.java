package handlers;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class Movement {
    public boolean upKeyPressed, downKeyPressed, leftKeyPressed, rightKeyPressed;
    private KeyCode upKey, downKey, leftKey, rightKey;

    public Movement(KeyCode up, KeyCode down, KeyCode left, KeyCode right) {
        this.upKey = up;
        this.downKey = down;
        this.leftKey = left;
        this.rightKey = right;
    }

    public void setKeyStates(KeyCode code, boolean isKeyPressed){
        if(this.upKey == code) this.upKeyPressed = isKeyPressed;
        if(this.downKey == code) this.downKeyPressed = isKeyPressed;
        if(this.leftKey == code) this.leftKeyPressed = isKeyPressed;
        if(this.rightKey == code) this.rightKeyPressed = isKeyPressed;
    }

    public void setPlayerMovement(ImageView player){
        Movement m = this;
        new AnimationTimer() {
            double vx = 0;
            double vy = 0;

            final double ACCEL = 0.3;
            final double FRICTION = 0.9;
            final double MAX_SPEED = 8;

            @Override
            public void handle(long now) {
                if (m.upKeyPressed)    vy -= ACCEL;
                if (m.downKeyPressed)  vy += ACCEL;
                if (m.leftKeyPressed)  vx -= ACCEL;
                if (m.rightKeyPressed) vx += ACCEL;

                vx *= FRICTION;
                vy *= FRICTION;

                if (vx > MAX_SPEED) vx = MAX_SPEED;
                if (vx < -MAX_SPEED) vx = -MAX_SPEED;
                if (vy > MAX_SPEED) vy = MAX_SPEED;
                if (vy < -MAX_SPEED) vy = -MAX_SPEED;

                player.setTranslateX(player.getTranslateX() + vx);
                player.setTranslateY(player.getTranslateY() + vy);
            }
        }.start();
    }
}