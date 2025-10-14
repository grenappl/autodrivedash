package app;
import views.*;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app.settings.Screen;

public class Window extends JFrame {
    protected CardLayout pageController = new CardLayout();
    protected JPanel pages = new JPanel(pageController);

    LoginPage login = new LoginPage();
    SignupPage signup = new SignupPage();
    MenuPage menu = new MenuPage();
    OptionsPage options = new OptionsPage();
    GamePage game = new GamePage();

    public Window(){
        pages.add(login, "Login");
        pages.add(signup, "Signup");
        pages.add(menu, "Menu");
        pages.add(options, "Options");
        pages.add(game, "Game");

        setMenuActions();

        pageController.show(pages, "Menu");
        this.add(pages);
        this.setTitle(App.NAME);
        this.setSize(Screen.SCREEN_DIMENSIONS);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    void setLoginActions(){

    }
    void setSignupActions(){
        
    }
    void setMenuActions(){
        menu.getStartBtn().addActionListener(e -> {
            pageController.show(pages, "Game");
            game.start(e);
        });
        menu.getOptionsBtn().addActionListener(e -> {
            pageController.show(pages, "Options");
        });
        menu.getExitBtn().addActionListener(e -> System.exit(0));
    }
}