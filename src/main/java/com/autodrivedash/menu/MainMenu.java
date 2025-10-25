package autodrivedash.menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.stage.Stage;
import autodrivedash.App;
import autodrivedash.db.Database;
import autodrivedash.game.GameController;
import autodrivedash.game.GameModel;
import autodrivedash.menu.login.LoginController;
import autodrivedash.menu.login.LoginModel;
import autodrivedash.menu.options.OptionsController;
import autodrivedash.menu.options.OptionsModel;
import autodrivedash.menu.signup.SignupController;
import autodrivedash.menu.signup.SignupModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.scene.Scene;

import static com.almasb.fxgl.dsl.FXGL.*;

public class MainMenu extends FXGLMenu {
    public static final String LOGIN = "/ui/login.fxml";
    public static final String SIGNUP = "/ui/signup.fxml";
    public static final String MENU = "/ui/menu.fxml";
    public static final String OPTIONS = "/ui/options.fxml";

    private String[] keys = {LOGIN, SIGNUP, MENU, OPTIONS};

    private Map<String, Parent> ui = new HashMap<>();
    private Map<String, Object> controllers = new HashMap<>();

    public Parent getLoginPage() { return this.ui.get(LOGIN); }
    public Parent getSignupPage() { return this.ui.get(SIGNUP); }
    public Parent getMenuPage() { return this.ui.get(MENU); }
    public Parent getOptionsPage() { return this.ui.get(OPTIONS); }

    public LoginController getLoginController() { return (LoginController)this.controllers.get(LOGIN); }
    public SignupController getSignupController() { return (SignupController)this.controllers.get(SIGNUP); }
    public MenuController getMenuController() { return (MenuController)this.controllers.get(MENU); }
    public OptionsController getOptionsController() { return (OptionsController)this.controllers.get(OPTIONS); }

    private Parent currentPage = null;

    public MainMenu(MenuType type){
        super(type);
        // App.db = new Database();
        try {
            for(String key : keys){
                FXMLLoader loader = new FXMLLoader(getClass().getResource(key));
                ui.put(key, loader.load());
                ui.get(key).setId(key);
                System.out.println(ui.get(key));
                controllers.put(key, loader.getController());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.getLoginController().setModel(new LoginModel());
        this.getSignupController().setModel(new SignupModel());
        this.getMenuController().setModel(new MenuModel());

        display(getLoginPage());
        getContentRoot().setCursor(Cursor.DEFAULT);
    }
    
    public void display(Parent newPage){
        if(currentPage != null) getContentRoot().getChildren().removeLast();
        currentPage = newPage;
        getContentRoot().getChildren().add(currentPage);
        System.out.println(currentPage);
    }

    public void startGame(){
        fireNewGame();
    }
}