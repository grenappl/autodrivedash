package handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {
    public boolean upKeyPressed, downKeyPressed, leftKeyPressed, rightKeyPressed;
    int upKey, downKey, leftKey, rightKey;

    public Movement(int up, int down, int left, int right){
        this.upKey = up;
        this.downKey = down;
        this.leftKey = left;
        this.rightKey = right;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        this.setKeyStates(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.setKeyStates(e.getKeyCode(), false);
    }

    void setKeyStates(int code, boolean keyDown){
        if(this.upKey == code){
            this.upKeyPressed = keyDown;
        } else if(this.downKey == code){
            this.downKeyPressed = keyDown;
        } else if(this.leftKey == code){
            this.leftKeyPressed = keyDown;
        } else if(this.rightKey == code){
            this.rightKeyPressed = keyDown;
        }
    }
}