package autodrivedash.game;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.getInput;

import java.util.HashMap;
import java.util.Map;

import com.almasb.fxgl.input.UserAction;

import autodrivedash.App;

public abstract class GameInput {
    public static final String UP = "UP";
    public static final String DOWN = "DOWN";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";
    public static final String BOOST = "BOOST";

    private static boolean upPressed = false;
    private static boolean downPressed = false;
    private static boolean leftPressed = false;
    private static boolean rightPressed = false;
    private static boolean boostPressed = false;

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

    public static boolean boostPressed() {
        return boostPressed;
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

    public static void setBoostPressed(boolean shiftPressed) {
        GameInput.boostPressed = shiftPressed;
    }

    public static UserAction upAction, downAction, leftAction, rightAction, boostAction;

    public static void setUpAction(UserAction upAction) {
        GameInput.upAction = upAction;
    }

    public static void setDownAction(UserAction downAction) {
        GameInput.downAction = downAction;
    }

    public static void setLeftAction(UserAction leftAction) {
        GameInput.leftAction = leftAction;
    }

    public static void setRightAction(UserAction rightAction) {
        GameInput.rightAction = rightAction;
    }

    public static void setBoostAction(UserAction boostAction) {
        GameInput.boostAction = boostAction;
    }

    private static Map<String, KeyCode> keyBindings = new HashMap<>();

    static { // default bindings
        keyBindings.put(UP, KeyCode.UP);
        keyBindings.put(DOWN, KeyCode.DOWN);
        keyBindings.put(LEFT, KeyCode.LEFT);
        keyBindings.put(RIGHT, KeyCode.RIGHT);
        keyBindings.put(BOOST, KeyCode.SPACE);
    }

    public static KeyCode getKeyCode(String actionKey) {
        return keyBindings.get(actionKey);
    }

    public static void rebindKey(String actionKey, KeyCode keyCode) {
        keyBindings.put(actionKey, keyCode);
        if (actionKey == UP)
            getInput().rebind(upAction, GameInput.getKeyCode(actionKey));
        else if (actionKey == DOWN)
            getInput().rebind(downAction, GameInput.getKeyCode(actionKey));
        else if (actionKey == LEFT)
            getInput().rebind(leftAction, GameInput.getKeyCode(actionKey));
        else if (actionKey == RIGHT)
            getInput().rebind(rightAction, GameInput.getKeyCode(actionKey));
        else
            getInput().rebind(boostAction, GameInput.getKeyCode(actionKey));
    }

    public static Map<String, KeyCode> getAllKeyCodes() {
        return keyBindings;
    }

    public static void setInputs() {
        setUpAction(new UserAction(UP) {
            @Override
            protected void onActionBegin() {
                if (!GameCountdown.isRunning())
                    GameInput.setUpPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInput.setUpPressed(false);
            }
        });
        setDownAction(new UserAction(DOWN) {
            @Override
            protected void onActionBegin() {
                if (!GameCountdown.isRunning())
                    GameInput.setDownPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInput.setDownPressed(false);
            }
        });
        setLeftAction(new UserAction(LEFT) {
            @Override
            protected void onActionBegin() {
                if (!GameCountdown.isRunning())
                    GameInput.setLeftPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInput.setLeftPressed(false);
            }
        });
        setRightAction(new UserAction(RIGHT) {
            @Override
            protected void onActionBegin() {
                if (!GameCountdown.isRunning())
                    GameInput.setRightPressed(true);
            }

            @Override
            protected void onActionEnd() {
                GameInput.setRightPressed(false);
            }
        });
        setBoostAction(new UserAction(BOOST) {
            @Override
            protected void onAction() {
                if (!GameCountdown.isRunning()) {
                    Rectangle boostBar = App.getGameController().getBoostBar();
                    if (boostBar.getWidth() > 0) {
                        GameInput.setBoostPressed(true);
                        boostBar.setWidth(boostBar.getWidth() - 1);
                    } else {
                        GameInput.setBoostPressed(false);
                    }
                }
            }

            @Override
            protected void onActionEnd() {
                GameInput.setBoostPressed(false);
            }
        });

        getInput().addAction(upAction, GameInput.getKeyCode(UP));
        getInput().addAction(downAction, GameInput.getKeyCode(DOWN));
        getInput().addAction(leftAction, GameInput.getKeyCode(LEFT));
        getInput().addAction(rightAction, GameInput.getKeyCode(RIGHT));
        getInput().addAction(boostAction, GameInput.getKeyCode(BOOST));
    }
}