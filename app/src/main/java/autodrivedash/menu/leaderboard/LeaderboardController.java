package autodrivedash.menu.leaderboard;

import java.sql.ResultSet;
import java.sql.SQLException;

import autodrivedash.App;
import autodrivedash.menu.MenuPageController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class LeaderboardController extends MenuPageController {
    @FXML
    private Pane listCtn, bestResultCtn;

    private final int FONT_SIZE = 16;
    private final String FONT_FAMILY = "Yu Gothic UI Semibold";

    public void getListScores() {
        try {
            displayResults(Leaderboard.getScoresOrdered());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayResults(ResultSet result) throws SQLException {
        listCtn.getChildren().clear();
        int layoutY = 20;
        while (result.next()) {
            Pane detailCtn = new Pane();
            detailCtn.setPrefWidth(400);
            detailCtn.setPrefHeight(60);
            detailCtn.setLayoutX(40);
            detailCtn.setLayoutY(layoutY);
            detailCtn.getStyleClass().add("detail-ctn");
            listCtn.getChildren().add(detailCtn);
            layoutY += 75;

            setTextDetails(detailCtn, result);
        }
        String email = App.getMainMenu().getStartController().getEmailLabel().getText();
        ResultSet oneUserResult = Leaderboard.getUserBestScore(email);
        bestResultCtn.getChildren().clear();
        if (oneUserResult.next()) {
            setTextDetails(bestResultCtn, oneUserResult);
        } else {
            Text noResultsText = new Text();
            noResultsText.setText("You have no results...");
            noResultsText.setLayoutX(bestResultCtn.getPrefWidth() / 3);
            noResultsText.setLayoutY(35);
            noResultsText.setFont(Font.font(FONT_FAMILY, FONT_SIZE));
            bestResultCtn.getChildren().add(noResultsText);
        }
    }

    private void setTextDetails(Pane ctn, ResultSet result) throws SQLException {
        Text rank = new Text();
        rank.setText("#" + result.getInt("row_count"));
        rank.setLayoutX(25);
        rank.setLayoutY(35);
        switch (result.getInt("row_count")) {
            case 1:
                rank.setFill(Paint.valueOf("#b8cc00ff"));
                rank.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, FONT_SIZE));
                break;
            case 2:
                rank.setFill(Paint.valueOf("#5a5a5aff"));
                rank.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, FONT_SIZE));
                break;
            case 3:
                rank.setFill(Color.BROWN);
                rank.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, FONT_SIZE));
                break;
            default:
                rank.setFont(Font.font(FONT_FAMILY, FONT_SIZE));
                break;
        }
        ctn.getChildren().add(rank);

        Text name = new Text();
        if (ctn != bestResultCtn)
            name.setText(result.getString("username"));
        else {
            name.setText(result.getString("username") + " (You)");
        }
        name.setTextAlignment(TextAlignment.CENTER);
        name.setWrappingWidth(200);
        name.setLayoutX(100);
        name.setLayoutY(35);
        name.setFont(Font.font(FONT_FAMILY, FONT_SIZE));
        ctn.getChildren().add(name);

        Text score = new Text();
        score.setText(String.valueOf(result.getInt("score")));
        score.setTextAlignment(TextAlignment.RIGHT);
        score.setWrappingWidth(100);
        score.setLayoutX(280);
        score.setLayoutY(35);
        score.setFont(Font.font(FONT_FAMILY, FONT_SIZE));
        ctn.getChildren().add(score);
    }

    public void setUserScore() {
        if (App.getDb().getConn() != null)
            Leaderboard.setUserScore();
    }

    @Override
    public void hidePopUp() {
    }
}
