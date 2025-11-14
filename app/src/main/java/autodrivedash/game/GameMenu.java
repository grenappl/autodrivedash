package autodrivedash.game;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameMenu extends FXGLMenu {
    public static final String PAUSE_MENU = "/ui/pause-menu.fxml";
    public static final String PAUSE_SETTINGS = "/ui/pause-settings.fxml";
    public static final String GAME_OVER = "/ui/game-over.fxml";

    private String[] keys = { PAUSE_MENU };

    private Map<String, Parent> ui = new HashMap<>();

    public void displayPauseMenu() {
        display(this.ui.get(PAUSE_MENU));
    }

    private void display(Parent newPage) {
        if (!getContentRoot().getChildren().isEmpty())
            getContentRoot().getChildren().removeLast();
        getContentRoot().getChildren().add(newPage);
    }

    public GameMenu(MenuType type) {
        super(type);
        try {
            for (String key : keys) {
                ui.put(key, FXMLLoader.load(getClass().getResource(key)));
                ui.get(key).setId(key);
            }
            displayPauseMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exitToMainMenu() {
        FXGL.getGameController().gotoMainMenu();
    }
}
