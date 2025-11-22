package autodrivedash.menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import autodrivedash.menu.login.LoginController;
import autodrivedash.menu.options.OptionsController;
import autodrivedash.menu.signup.SignupController;
import autodrivedash.menu.start.StartController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;

public class Menu extends FXGLMenu {
    public static final String START = "/ui/start.fxml";
    public static final String LOGIN = "/ui/login.fxml";
    public static final String SIGNUP = "/ui/signup.fxml";
    public static final String OPTIONS = "/ui/options.fxml";

    private String keys[] = { START, LOGIN, SIGNUP, OPTIONS };

    public Map<String, Parent> ui = new HashMap<>();

    public void displayStartPage() {
        display(this.ui.get(START));
    }

    public void displayLoginPage() {
        display(this.ui.get(LOGIN));
    }

    public void displaySignupPage() {
        display(this.ui.get(SIGNUP));
    }

    public void displayOptionsPage() {
        display(this.ui.get(OPTIONS));
    }

    public void display(Parent newPage) {
        if (!getContentRoot().getChildren().isEmpty())
            getContentRoot().getChildren().removeLast();
        getContentRoot().getChildren().add(newPage);
    }

    private Map<String, MenuPageController> controllers = new HashMap<>();

    public LoginController getLoginController() {
        return (LoginController) this.controllers.get(LOGIN);
    }

    public SignupController getSignupController() {
        return (SignupController) this.controllers.get(SIGNUP);
    }

    public StartController getStartController() {
        return (StartController) this.controllers.get(START);
    }

    public OptionsController getOptionsController() {
        return (OptionsController) this.controllers.get(OPTIONS);
    }

    public Menu(MenuType type) {
        super(type);
        try {
            for (String key : keys) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(key));
                ui.put(key, loader.load());
                System.out.println("Loading FXML: " + key + " => " + getClass().getResource(key));
                ui.get(key).setId(key);
                controllers.put(key, loader.getController());
                System.out.println("Controller for " + key + " = " + loader.getController());
                System.out.println();
            }
            displayStartPage();
            getContentRoot().setCursor(Cursor.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame() {
        fireNewGame();
    }
}