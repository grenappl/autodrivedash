package autodrivedash.game;

import javafx.scene.input.KeyCode;

import static com.almasb.fxgl.dsl.FXGL.getInput;

import java.util.HashMap;
import java.util.Map;

import com.almasb.fxgl.input.UserAction;

public final class GameInputManager {
    private static boolean upPressed = false, downPressed = false, leftPressed = false, rightPressed = false;

    public static boolean getUpPressed() {
        return upPressed;
    }

    public static boolean getDownPressed() {
        return downPressed;
    }

    public static boolean getLeftPressed() {
        return leftPressed;
    }

    public static boolean getRightPressed() {
        return rightPressed;
    }

    public static void setUpPressed(boolean isUpPressed) {
        upPressed = isUpPressed;
    }

    public static void setDownPressed(boolean isDownPressed) {
        downPressed = isDownPressed;
    }

    public static void setLeftPressed(boolean isLeftPressed) {
        leftPressed = isLeftPressed;
    }

    public static void setRightPressed(boolean isRightPressed) {
        rightPressed = isRightPressed;
    }

    public static UserAction upAction, downAction, leftAction, rightAction;

    public static UserAction getUpAction() {
        return upAction;
    }

    public static UserAction getDownAction() {
        return downAction;
    }

    public static UserAction getLeftAction() {
        return leftAction;
    }

    public static UserAction getRightAction() {
        return rightAction;
    }

    public static void setUpAction(UserAction newUpAction) {
        upAction = newUpAction;
    }

    public static void setDownAction(UserAction newDownAction) {
        downAction = newDownAction;
    }

    public static void setLeftAction(UserAction newLeftAction) {
        leftAction = newLeftAction;
    }

    public static void setRightAction(UserAction newRightAction) {
        rightAction = newRightAction;
    }

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

    public static void setInputs() {
        setUpAction(new UserAction("UP") {
            @Override
            protected void onActionBegin() {
                GameInputManager.setUpPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInputManager.setUpPressed(false);
            }
        });
        setDownAction(new UserAction("DOWN") {
            @Override
            protected void onActionBegin() {
                GameInputManager.setDownPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInputManager.setDownPressed(false);
            }
        });
        setLeftAction(new UserAction("LEFT") {
            @Override
            protected void onActionBegin() {
                GameInputManager.setLeftPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInputManager.setLeftPressed(false);
            }
        });
        setRightAction(new UserAction("RIGHT") {
            @Override
            protected void onActionBegin() {
                GameInputManager.setRightPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInputManager.setRightPressed(false);
            }
        });

        getInput().addAction(GameInputManager.getUpAction(), GameInputManager.getKeyCode("UP"));
        getInput().addAction(GameInputManager.getDownAction(), GameInputManager.getKeyCode("DOWN"));
        getInput().addAction(GameInputManager.getLeftAction(), GameInputManager.getKeyCode("LEFT"));
        getInput().addAction(GameInputManager.getRightAction(), GameInputManager.getKeyCode("RIGHT"));
    }
}