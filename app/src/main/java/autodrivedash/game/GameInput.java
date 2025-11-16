package autodrivedash.game;

import javafx.scene.input.KeyCode;

import static com.almasb.fxgl.dsl.FXGL.getInput;

import java.util.HashMap;
import java.util.Map;

import com.almasb.fxgl.input.UserAction;

public abstract class GameInput {
    private static boolean upPressed = false, downPressed = false, leftPressed = false, rightPressed = false;

    public static boolean upPressed() {
        return upPressed;
    }

    public static boolean downPressed() {
        return downPressed;
    }

    public static boolean leftPressed() {
        return leftPressed;
    }

    public static boolean rightPressed() {
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
                GameInput.setUpPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInput.setUpPressed(false);
            }
        });
        setDownAction(new UserAction("DOWN") {
            @Override
            protected void onActionBegin() {
                GameInput.setDownPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInput.setDownPressed(false);
            }
        });
        setLeftAction(new UserAction("LEFT") {
            @Override
            protected void onActionBegin() {
                GameInput.setLeftPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInput.setLeftPressed(false);
            }
        });
        setRightAction(new UserAction("RIGHT") {
            @Override
            protected void onActionBegin() {
                GameInput.setRightPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInput.setRightPressed(false);
            }
        });

        getInput().addAction(GameInput.getUpAction(), GameInput.getKeyCode("UP"));
        getInput().addAction(GameInput.getDownAction(), GameInput.getKeyCode("DOWN"));
        getInput().addAction(GameInput.getLeftAction(), GameInput.getKeyCode("LEFT"));
        getInput().addAction(GameInput.getRightAction(), GameInput.getKeyCode("RIGHT"));
    }
}