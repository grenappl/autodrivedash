package autodrivedash;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import autodrivedash.game.GameController;
import autodrivedash.login.LoginController;
import autodrivedash.menu.MenuController;
import autodrivedash.options.OptionsController;
import autodrivedash.signup.SignupController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Window extends Stage implements ScreenSettings {
    public final String LOGIN = "/assets/views/LoginPage.fxml";
    public final String SIGNUP = "/assets/views/SignupPage.fxml";
    public final String MENU = "/assets/views/MenuPage.fxml";
    public final String OPTIONS = "/assets/views/OptionsPage.fxml";
    public final String GAME = "/assets/views/GamePage.fxml";
    private String[] keys = {LOGIN, SIGNUP, MENU, GAME};

    private Map<String, Parent> pages = new HashMap<>();
    private Map<String, Object> controllers = new HashMap<>();

    public Parent getLoginPage() { return this.pages.get(LOGIN); }
    public Parent getSignupPage() { return this.pages.get(SIGNUP); }
    public Parent getMenuPage() { return this.pages.get(MENU); }
    public Parent getOptionsPage() { return this.pages.get(OPTIONS); }
    public Parent getGamePage() { return this.pages.get(GAME); }

    public LoginController getLoginController() { return (LoginController)this.controllers.get(LOGIN); }
    public SignupController getSignupController() { return (SignupController)this.controllers.get(SIGNUP); }
    public MenuController getMenuController() { return (MenuController)this.controllers.get(MENU); }
    public OptionsController getOptionsController() { return (OptionsController)this.controllers.get(OPTIONS); }
    public GameController getGameController() { return (GameController)this.controllers.get(GAME); }

    public Window() throws IOException {
        for(String key : keys){
            FXMLLoader loader = new FXMLLoader(getClass().getResource(key));
            pages.put(key, loader.load());
            controllers.put(key, loader.getController());
        }
        
        // String css = this.getClass().getResource("styles/main.css").toExternalForm();
        Parent root = pages.get(MENU); // start pages
        // root.getStylesheets().add(css);

        this.setScene(new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setResizable(false);
        this.centerOnScreen();
    }
    
    public void display(Scene scene){
        this.setScene(scene);
        this.show();
    }
}