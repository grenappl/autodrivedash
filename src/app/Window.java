package app;

import views.*;
import controllers.*;

import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bases.BaseController;
import bases.BasePage;

public class Window extends JFrame {                                           
    public final String LOGIN_KEY = "Login";
    public final String SIGNUP_KEY = "Signup";
    public final String MENU_KEY = "Menu";
    public final String OPTIONS_KEY = "Options";
    public final String GAME_KEY = "Game";

    private Map<String, BasePage> pages = new HashMap<>();
    private Map<String, BaseController> controllers = new HashMap<>();

    public Map<String, BasePage> getPages() { return pages; }
    public Map<String, BaseController> getControllers() { return controllers; }

    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);

    public Window(){
        pages.put(LOGIN_KEY, new LoginPage());
        pages.put(SIGNUP_KEY, new SignupPage());
        pages.put(MENU_KEY, new MenuPage());
        pages.put(OPTIONS_KEY, new OptionsPage());
        pages.put(GAME_KEY, new GamePage());

        controllers.put(LOGIN_KEY, new LoginController((LoginPage) pages.get(LOGIN_KEY)));
        controllers.put(SIGNUP_KEY, new SignupController((SignupPage) pages.get(SIGNUP_KEY)));
        controllers.put(MENU_KEY, new MenuController((MenuPage) pages.get(MENU_KEY)));
        controllers.put(OPTIONS_KEY, new OptionsController((OptionsPage) pages.get(OPTIONS_KEY)));
        controllers.put(GAME_KEY, new GameController((GamePage) pages.get(GAME_KEY)));

        for(String key : pages.keySet()) cardPanel.add(pages.get(key), key);

        cardLayout.show(cardPanel, LOGIN_KEY);
        this.add(cardPanel);
        this.setTitle(App.NAME);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void display(String key){
        cardLayout.show(cardPanel, key);
    }
}