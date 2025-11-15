package autodrivedash.menu;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MenuUtils {
    public void setMouseFocuses(Parent focusedPane, Parent... unfocusedPanes) {
        focusedPane.setMouseTransparent(false);
        for (Parent unfocusedPane : unfocusedPanes)
            unfocusedPane.setMouseTransparent(true);
    }

    public void displayError(Parent popUpCtn, Parent uiCtn, Text errorText, String error) {
        setMouseFocuses(popUpCtn, uiCtn);
        errorText.setText("Error: " + error);
        FadeTransition ft = new FadeTransition(Duration.millis(50), popUpCtn);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }
}
