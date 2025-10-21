package autodrivedash;

import javafx.scene.input.KeyCode;
import java.util.HashMap;
import java.util.Map;

import com.almasb.fxgl.input.UserAction;

public final class InputManager {
    private static boolean upPressed = false, downPressed = false, leftPressed = false, rightPressed = false;

    public static boolean getUpPressed(){ return upPressed; }
    public static boolean getDownPressed(){ return downPressed; }
    public static boolean getLeftPressed(){ return leftPressed; }
    public static boolean getRightPressed(){ return rightPressed; }

    public static void setUpPressed(boolean isUpPressed){ upPressed = isUpPressed; }
    public static void setDownPressed(boolean isDownPressed){ downPressed = isDownPressed; }
    public static void setLeftPressed(boolean isLeftPressed){ leftPressed = isLeftPressed; }
    public static void setRightPressed(boolean isRightPressed){  rightPressed = isRightPressed; }

    public static UserAction upAction, downAction, leftAction, rightAction;

    public static UserAction getUpAction(){ return upAction; }
    public static UserAction getDownAction(){ return downAction; }
    public static UserAction getLeftAction(){ return leftAction; }
    public static UserAction getRightAction(){ return rightAction; }

    public static void setUpAction(UserAction newUpAction){ upAction = newUpAction; }
    public static void setDownAction(UserAction newDownAction){ downAction = newDownAction; }
    public static void setLeftAction(UserAction newLeftAction){ leftAction = newLeftAction; }
    public static void setRightAction(UserAction newRightAction){  rightAction = newRightAction; }

    private static Map<String, KeyCode> keyBindings = new HashMap<>();

    static { // default bindings
        keyBindings.put("UP", KeyCode.UP);
        keyBindings.put("DOWN", KeyCode.DOWN);
        keyBindings.put("LEFT", KeyCode.LEFT);
        keyBindings.put("RIGHT", KeyCode.RIGHT);
    }

    public static KeyCode getKeyCode(String actionKey) {
        return keyBindings.get(actionKey);
    }

    public static void setKeyCode(String actionKey, KeyCode keyCode) {
        keyBindings.put(actionKey, keyCode);
    }

    public static Map<String, KeyCode> getAllKeyCodes() {
        return keyBindings;
    }
}