package controllers;

import java.io.IOException;

import app.App;
import handlers.Movement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

public class MenuController {
    @FXML private Button startBtn;

    @FXML
    protected void showGame(ActionEvent e) throws IOException {
        GameController gameCtrl = App.window.getGameController();
        Parent gamePage = App.window.getGamePage();
        App.window.display(gameCtrl.setScene(gamePage));
        gamePage.requestFocus();
    }

    // public MenuPage getGamePage(){ return (MenuPage)this.page; }

    // public MenuController(MenuPage menuPage){
    //     super(menuPage);
    //     this.getGamePage().getStartBtn().addActionListener(showGame());
    //     this.getGamePage().getOptionsBtn().addActionListener(showOptions());
    //     this.getGamePage().getExitBtn().addActionListener(e -> System.exit(0));
    // }

    // public ActionListener showGame(){
    //     return new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             AutoDriveDash.window.display(AutoDriveDash.window.GAME_KEY);
    //             ((GameController)AutoDriveDash.window.getControllers().get(AutoDriveDash.window.GAME_KEY)).startGame();
    //         }
    //     };
    // }

    // public ActionListener showOptions(){
    //     return new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             // App.window.getCardLayout().show(App.window.getCardPanel(), "Options");
    //         }
    //     };
    // }
}
