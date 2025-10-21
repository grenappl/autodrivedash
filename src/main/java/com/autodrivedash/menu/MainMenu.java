package autodrivedash.menu;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;
import autodrivedash.UiManager;
import autodrivedash.db.Database;

import java.io.IOException;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import static com.almasb.fxgl.dsl.FXGL.*;

public class MainMenu extends FXGLMenu {
    public MainMenu(MenuType type) {
        super(type);
        try {
            App.db = new Database();
            App.ui = new UiManager();

            Node root = getContentRoot();
            ObservableList<Node> rootNodes = getContentRoot().getChildren();

            rootNodes.add(App.ui.getMenuPage());
            root.setCursor(Cursor.DEFAULT);

            MenuController menuCtrl = App.ui.getMenuController();
            Button startBtn = menuCtrl.getStartBtn();
            startBtn.setOnAction(e -> fireNewGame());
            // startBtn.setOnAction(e -> {
            //     rootNodes.removeLast();
            //     rootNodes.add(App.ui.getLoginPage());
            // });
            setCursorForNode(startBtn);

            // Button optionsBtn = menuCtrl.getOptionsBtn();
            // optionsBtn.setOnAction(e -> fire(new Event()));
            
            // Button exitBtn = menuCtrl.getExitBtn();
            // exitBtn.setOnAction(e -> fireExit());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setCursorForNode(Node btn){
        btn.setOnMouseEntered(e -> getContentRoot().setCursor(Cursor.HAND));
        btn.setOnMouseExited(e -> getContentRoot().setCursor(Cursor.DEFAULT));
    }
}
