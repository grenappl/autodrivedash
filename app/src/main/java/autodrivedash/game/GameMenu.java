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
    public static final String GAME_MENU = "/ui/game.fxml";
    private String[] keys = {GAME_MENU};

    private Map<String, Parent> ui = new HashMap<>();

    public Parent getMainGame() { return this.ui.get(GAME_MENU); }

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
        
        var resumeBtn = new Button("Resume");
        resumeBtn.setOnAction(e -> fireResume());

        var optionsBtn = new Button("Options");
        optionsBtn.setOnAction(e -> getGameController().gotoGameMenu());

        var mainMenuBtn = new Button("Main Menu");
        mainMenuBtn.setOnAction(e -> fireExitToMainMenu());

        var box = new VBox(15, resumeBtn, optionsBtn, mainMenuBtn);
        box.setFillWidth(true);
        box.setAlignment(Pos.BOTTOM_RIGHT);
        getContentRoot().getChildren().add(box);
        getContentRoot().setCursor(Cursor.DEFAULT);
    }
}
