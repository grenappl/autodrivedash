package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.App;
import bases.BaseController;
import views.MenuPage;

public class MenuController extends BaseController {
    public MenuPage getGamePage(){ return (MenuPage)this.page; }

    public MenuController(MenuPage menuPage){
        super(menuPage);
        this.getGamePage().getStartBtn().addActionListener(showGame());
        this.getGamePage().getOptionsBtn().addActionListener(showOptions());
        this.getGamePage().getExitBtn().addActionListener(e -> System.exit(0));
    }

    public ActionListener showGame(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.window.display(App.window.GAME_KEY);
                ((GameController)App.window.getControllers().get(App.window.GAME_KEY)).startGame();
            }
        };
    }

    public ActionListener showOptions(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // App.window.getCardLayout().show(App.window.getCardPanel(), "Options");
            }
        };
    }
}
