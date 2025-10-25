package autodrivedash.menu;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

import autodrivedash.App;
import autodrivedash.game.GameController;

import static com.almasb.fxgl.dsl.FXGL.*;

public class MenuController {
    private MenuModel menuModel;
    public void setModel(MenuModel model) {
        this.menuModel = model;
    }

    @FXML private Button startBtn;

    public Button getStartBtn(){ return this.startBtn; }

    @FXML
    protected void showGame(ActionEvent e){
        App.getMainMenu().startGame();
    }

    // protected void goToLogin(){
    //     App.ui.display();
    // }
}
