package autodrivedash.menu.options;

import autodrivedash.game.GameInput;
import autodrivedash.menu.MenuPageController;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class OptionsController extends MenuPageController {
    @FXML
    private Slider volumeSlider;
    @FXML
    private Pane upCtn, downCtn, leftCtn, rightCtn, boostCtn, optionsCtn;
    @FXML
    private Text upText, downText, leftText, rightText, boostText;

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

    public void setKeyBindings() {
        upText.setText(GameInput.getKeyCode(GameInput.UP).getName());
        downText.setText(GameInput.getKeyCode(GameInput.DOWN).getName());
        leftText.setText(GameInput.getKeyCode(GameInput.LEFT).getName());
        rightText.setText(GameInput.getKeyCode(GameInput.RIGHT).getName());
        boostText.setText(GameInput.getKeyCode(GameInput.BOOST).getName());
    }

    @FXML
    private void updateKeyBind(MouseEvent e) {
        if (e.getTarget() == upCtn) {
            upCtn.setStyle("-fx-background-color: #341adbff;");
            upText.setStyle("-fx-fill: #FFFFFF;");
            optionsCtn.setMouseTransparent(true);
            optionsCtn.setOnKeyPressed(e1 -> {
                upText.setText(e1.getCode().getName());
                upCtn.setStyle("-fx-background-color: #FFFFFF;");
                upText.setStyle("-fx-fill: #000000;");
                optionsCtn.setMouseTransparent(false);
                optionsCtn.setOnKeyPressed(null);
            });
        }
    }

    @Override
    public void hidePopUp() {
    }
}
