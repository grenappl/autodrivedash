package autodrivedash.game;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;

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

    private String[] keys = {PAUSE_MENU, PAUSE_SETTINGS};

    private Map<String, Parent> ui = new HashMap<>();

    public Parent getMainGame() { return this.ui.get(PAUSE_MENU); }

    public GameMenu(MenuType type) {
        super(type);
        // try {
        //     for(String key : keys){
        //         FXMLLoader loader = new FXMLLoader(getClass().getResource(key));
        //         pages.put(key, loader.load());
        //         pages.get(key).setId(key);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        var mainMenuBtn = new Button("Main Menu");
        mainMenuBtn.setOnAction(e -> fireExitToMainMenu());

        var box = new VBox(15, mainMenuBtn);
        box.setFillWidth(true);
        box.setAlignment(Pos.BOTTOM_RIGHT);
        getContentRoot().getChildren().add(box);
        getContentRoot().setCursor(Cursor.DEFAULT);
    }
}
