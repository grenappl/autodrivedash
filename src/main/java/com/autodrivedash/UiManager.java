package autodrivedash;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import autodrivedash.game.GameController;
import autodrivedash.game.GameModel;
import autodrivedash.login.LoginController;
import autodrivedash.login.LoginModel;
import autodrivedash.menu.MenuController;
import autodrivedash.menu.MenuModel;
import autodrivedash.options.OptionsController;
import autodrivedash.options.OptionsModel;
import autodrivedash.signup.SignupController;
import autodrivedash.signup.SignupModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.scene.Scene;

public class UiManager {
    public static final String LOGIN = "/views/login.fxml";
    public static final String SIGNUP = "/views/signup.fxml";
    public static final String MENU = "/views/menu.fxml";
    public static final String OPTIONS = "/views/options.fxml";
    public static final String GAME = "/views/game.fxml";

    private String[] keys = {LOGIN, SIGNUP, MENU, OPTIONS};

    private Map<String, Parent> pages = new HashMap<>();
    private Map<String, Object> controllers = new HashMap<>();

    public Parent getLoginPage() { return this.pages.get(LOGIN); }
    public Parent getSignupPage() { return this.pages.get(SIGNUP); }
    public Parent getMenuPage() { return this.pages.get(MENU); }
    public Parent getOptionsPage() { return this.pages.get(OPTIONS); }

    public LoginController getLoginController() { return (LoginController)this.controllers.get(LOGIN); }
    public SignupController getSignupController() { return (SignupController)this.controllers.get(SIGNUP); }
    public MenuController getMenuController() { return (MenuController)this.controllers.get(MENU); }
    public OptionsController getOptionsController() { return (OptionsController)this.controllers.get(OPTIONS); }

    private Parent currentPage = null;

    public UiManager() throws IOException {
        for(String key : keys){
            FXMLLoader loader = new FXMLLoader(getClass().getResource(key));
            pages.put(key, loader.load());
            pages.get(key).setId(key);
            controllers.put(key, loader.getController());
        }

        this.getLoginController().setModel(new LoginModel());
        this.getSignupController().setModel(new SignupModel());
        
        // String css = this.getClass().getResource("styles/main.css").toExternalForm();
        // Parent root = pages.get(LOGIN); // start pages
        // root.getStylesheets().add(css);
    }
    
    public void display(Parent newPage){
        if(currentPage != null) FXGL.getGameScene().removeUINode(currentPage);
        currentPage = newPage;
        FXGL.getGameScene().addUINode(currentPage);
        System.out.println(currentPage);
    }
}