package autodrivedash.menu;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.util.Duration;

public abstract class MenuPageController {
    @FXML
    protected Pane popUpCtn;
    @FXML
    protected Label popupLabel;
    @FXML
    protected Text popupText;

    public void setMouseFocuses(Parent focusedPane, Parent... unfocusedPanes) {
        focusedPane.setMouseTransparent(false);
        for (Parent unfocusedPane : unfocusedPanes)
            unfocusedPane.setMouseTransparent(true);
    }

    public void displayPopUp(String error, boolean isSuccess, Parent uiCtn) {
        if (isSuccess) {
            popupLabel.setText("Success!");
            popupLabel.setTextFill(Paint.valueOf("#00bf63"));
        } else if (popupLabel.getText() != "Error!") {
            popupLabel.setText("Error!");
            popupLabel.setTextFill(Color.RED);
        }
        setMouseFocuses(popUpCtn, uiCtn);
        popupText.setText(error);
        FadeTransition ft = new FadeTransition(Duration.millis(50), popUpCtn);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    public abstract void hidePopUp();
}
