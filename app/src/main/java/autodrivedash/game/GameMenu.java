package autodrivedash.game;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import static com.almasb.fxgl.dsl.FXGL.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameMenu extends FXGLMenu {
    public static final String PAUSE_MENU = "/ui/pause-menu.fxml";
    public static final String PAUSE_SETTINGS = "/ui/pause-settings.fxml";
    public static final String GAME_OVER = "/ui/game-over.fxml";

    private String[] keys = { PAUSE_MENU };

    private Map<String, Parent> ui = new HashMap<>();

    public Parent getPauseMenu() {
        return this.ui.get(PAUSE_MENU);
    }

    private Parent currentPage = null;

    public GameMenu(MenuType type) {
        super(type);
        try {
            for (String key : keys) {
                ui.put(key, FXMLLoader.load(getClass().getResource(key)));
                ui.get(key).setId(key);
            }
            display(getPauseMenu());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display(Parent newPage) {
        if (currentPage != null)
            getContentRoot().getChildren().removeLast();
        currentPage = newPage;
        getContentRoot().getChildren().add(currentPage);
    }

    public void exitToMainMenu() {
        FXGL.getGameController().gotoMainMenu();
    }
}
