package autodrivedash.game;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import static com.almasb.fxgl.dsl.FXGL.*;

public class GameMenu extends FXGLMenu {
    public GameMenu(MenuType type) {
        super(type);
        
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
    }
}
