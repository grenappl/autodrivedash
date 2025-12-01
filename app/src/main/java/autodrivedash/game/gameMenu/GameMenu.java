package autodrivedash.game.gameMenu;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;
import autodrivedash.db.DatabaseTable;
import autodrivedash.game.GameCountdown;
import autodrivedash.menu.start.StartController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GameMenu extends FXGLMenu {
    public static final String PAUSE = "/ui/pause.fxml";
    public static final String GAME_OVER = "/ui/gameover.fxml";

    private String[] keys = { PAUSE, GAME_OVER };

    private Map<String, Parent> ui = new HashMap<>();

    public void displayPause() {
        display(this.ui.get(PAUSE));
    }

    public void displayGameOver() {
        if (getGameOverController().setNewHighScore())
            setHighScore();
        display(this.ui.get(GAME_OVER));
    }

    private void display(Parent newPage) {
        if (!getContentRoot().getChildren().isEmpty())
            getContentRoot().getChildren().removeLast();
        getContentRoot().getChildren().add(newPage);
    }

    private Map<String, GameMenuController> controllers = new HashMap<>();

    public GamePaused getPauseController() {
        return (GamePaused) this.controllers.get(PAUSE);
    }

    public GameOver getGameOverController() {
        return (GameOver) this.controllers.get(GAME_OVER);
    }

    public GameMenu(MenuType type) {
        super(type);
        try {
            // load game menu pages
            for (String key : keys) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(key));
                ui.put(key, loader.load());
                System.out.println("Loading FXML: " + key + " => " + getClass().getResource(key));
                ui.get(key).setId(key);
                controllers.put(key, loader.getController());
                System.out.println("Controller for " + key + " = " + loader.getController());
                System.out.println();
            }
            displayPause(); // pause menu to be displayed 1st
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setHighScore() {
        StartController startCtrl = App.getMainMenu().getStartController();
        Label highestScoreLabel = startCtrl.getHighestScoreLabel();
        if ((int) FXGL.getd("SCORE") > Integer.valueOf(highestScoreLabel.getText())) {
            highestScoreLabel.setText(String.valueOf((int) FXGL.getd("SCORE")));
            if (App.getMainMenu().getStartController().getEmailLabel().getText() != null) {
                DatabaseTable usersTable = App.getDb().getUserTable();
                String emailCol = usersTable.getColumn(2);
                String scoreCol = usersTable.getColumn(4);
                String playerEmail = startCtrl.getEmailLabel().getText();

                String query = "UPDATE " + usersTable.getName() + " SET " + scoreCol + " = ? WHERE " + emailCol
                        + " = ?";
                try {
                    PreparedStatement stmt = App.getDb().getConn().prepareStatement(query);
                    stmt.setInt(1, (int) FXGL.getd("SCORE"));
                    stmt.setString(2, playerEmail);
                    int affected = stmt.executeUpdate();
                    System.out.println("updated rows: " + affected);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        App.getMainMenu().getLeaderboardController().setUserScore();
    }

    public void resumeGame() {
        fireResume();
    }

    public void backToMainMenu() {
        GameCountdown.reset();
        App.getGameSound().getCurrentGameMusic().stop();
        App.getGameSound().getMenuMusic().seek(Duration.ZERO);
        App.getGameSound().getMenuMusic().play();
        FXGL.getGameController().resumeEngine();
        FXGL.getGameController().gotoMainMenu();
    }

    public void restartGame() {
        GameCountdown.reset();
        App.getGameSound().getCurrentGameMusic().stop();
        App.getGameSound().setCurrentGameMusic();
        App.getGameSound().getCurrentGameMusic().play();
        FXGL.getGameController().resumeEngine();
        fireNewGame();
    }
}
