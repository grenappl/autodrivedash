package autodrivedash.menu.start;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.sql.SQLException;

import autodrivedash.App;
import autodrivedash.game.entity.player.Player;
import autodrivedash.menu.MenuPageController;
import autodrivedash.menu.login.LoginController;

public class StartController extends MenuPageController {
    @FXML
    private Label usernameLabel, emailLabel, highestScoreLabel;
    @FXML
    private ImageView accountIcon;
    @FXML
    private Pane startCtn, accCtn;
    @FXML
    private ImageView leaderboardIcon;
    @FXML
    private TextField usernameTf;

    public ImageView getLeaderboardIcon() {
        return leaderboardIcon;
    }

    public Label getUsernameLabel() {
        return usernameLabel;
    }

    public Label getEmailLabel() {
        return emailLabel;
    }

    public Label getHighestScoreLabel() {
        return this.highestScoreLabel;
    }

    // executes when play is pressed
    @FXML
    protected void showGame(ActionEvent e) {
        Start.showGame();
    }

    @FXML
    protected void checkAccount() {
        if (emailLabel.getText() != null) {
            displayAcc();
        } else if (App.getDb().getConn() != null) {
            LoginController loginCtrl = App.getMainMenu().getLoginController();
            loginCtrl.hidePopUp();
            App.getMainMenu().displayLoginPage();
            loginCtrl.getLoginBtn().requestFocus();
        } else {
            displayPopUp("Unable to log in/sign up!\nPlease restart the app and try again.", false, startCtn);
        }
    }

    private void displayAcc() {
        setMouseFocuses(accCtn, startCtn, popUpCtn);
        FadeTransition ft = new FadeTransition(Duration.millis(50), accCtn);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    @FXML
    protected void changeUsername() {
        String newName = usernameTf.getText();
        if (newName.isBlank() || newName.equals(usernameLabel.getText()))
            return;
        try {
            int affected = Start.changeUsername(newName);
            usernameLabel.setText(newName);
            System.out.println("name updated: " + affected);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void logout() {
        App.setLoggedUserId(-1);
        usernameLabel.setText(null);
        emailLabel.setText(null);
        leaderboardIcon.setOpacity(0);
        leaderboardIcon.setMouseTransparent(true);
        highestScoreLabel.setText("0");
        Player.setSelectedCharacter(Player.CAR);
        hidePopUp();
    }

    @FXML
    protected void checkSelection() {
        App.getMainMenu().displaySelectPage();
    }

    @FXML
    protected void checkOptions() {
        App.getMainMenu().displayOptionsPage();
    }

    @FXML
    protected void checkLeaderboard() {
        App.getMainMenu().displayLeaderboardPage();
    }

    @FXML
    protected void exitGame() {
        Start.exitGame();
    }

    @FXML
    public void hidePopUp() {
        setMouseFocuses(startCtn, popUpCtn, accCtn);
        popUpCtn.setOpacity(0);
        accCtn.setOpacity(0);
    }
}
