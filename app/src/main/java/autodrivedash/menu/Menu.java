package autodrivedash.menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;
import autodrivedash.App;
import autodrivedash.game.GameSound;
import autodrivedash.menu.leaderboard.LeaderboardController;
import autodrivedash.menu.login.LoginController;
import autodrivedash.menu.options.OptionsController;
import autodrivedash.menu.select.SelectController;
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
    public static final String SELECT = "/ui/select.fxml";
    public static final String LEADERBOARD = "/ui/leaderboard.fxml";
    public static final String OPTIONS = "/ui/options.fxml";

    private String keys[] = { START, LOGIN, SIGNUP, SELECT, LEADERBOARD, OPTIONS };

    public Map<String, Parent> ui = new HashMap<>();

    public void displayStartPage() {
        if (App.getLoggedUserId() == -1) {
            getStartController().getLeaderboardIcon().setOpacity(0);
            getStartController().getLeaderboardIcon().setMouseTransparent(true);
        } else {
            getStartController().getLeaderboardIcon().setOpacity(1);
            getStartController().getLeaderboardIcon().setMouseTransparent(false);
        }
        display(this.ui.get(START));
    }

    public void displayLoginPage() {
        display(this.ui.get(LOGIN));
    }

    public void displaySignupPage() {
        display(this.ui.get(SIGNUP));
    }

    public void displaySelectPage() {
        getSelectController().displaySelected();
        display(this.ui.get(SELECT));
    }

    public void displayLeaderboardPage() {
        getLeaderboardController().getListScores();
        display(this.ui.get(LEADERBOARD));
    }

    public void displayOptionsPage() {
        getOptionsController().setKeyBindings();
        display(this.ui.get(OPTIONS));
    }

    public void display(Parent newPage) {
        if (!getContentRoot().getChildren().isEmpty())
            getContentRoot().getChildren().removeLast();
        getContentRoot().getChildren().add(newPage);
    }

    private Map<String, MenuPageController> controllers = new HashMap<>();

    public StartController getStartController() {
        return (StartController) this.controllers.get(START);
    }

    public LoginController getLoginController() {
        return (LoginController) this.controllers.get(LOGIN);
    }

    public SignupController getSignupController() {
        return (SignupController) this.controllers.get(SIGNUP);
    }

    public SelectController getSelectController() {
        return (SelectController) this.controllers.get(SELECT);
    }

    public LeaderboardController getLeaderboardController() {
        return (LeaderboardController) this.controllers.get(LEADERBOARD);
    }

    public OptionsController getOptionsController() {
        return (OptionsController) this.controllers.get(OPTIONS);
    }

    public Menu(MenuType type) {
        super(type);
        try {
            App.setGameSound(new GameSound());
            App.getGameSound().getMenuMusic().play();
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
            getStartController().getEmailLabel().setText(null);
            getStartController().getUsernameLabel().setText(null);
            getStartController().hidePopUp();
            getContentRoot().setCursor(Cursor.DEFAULT);

            Slider volSlider = getOptionsController().getVolumeSlider();
            MediaPlayer hurtAudio = App.getGameSound().getHurtAudio();
            volSlider.valueProperty().bindBidirectional(hurtAudio.volumeProperty());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void startGame() {
        fireNewGame();
    }
}