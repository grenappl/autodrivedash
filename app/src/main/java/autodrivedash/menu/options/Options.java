package autodrivedash.menu.options;

import autodrivedash.game.GameInput;
import javafx.scene.input.KeyCode;

public class Options {
    public static void changeKeybind(String key, KeyCode code) {
        GameInput.rebindKey(key, code);
    }
}
