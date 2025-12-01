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
    private void updateKeybind(MouseEvent e) {
        Pane[] ctns = { upCtn, downCtn, leftCtn, rightCtn, boostCtn };
        Text[] txts = { upText, downText, leftText, rightText, boostText };
        String[] keys = { GameInput.UP, GameInput.DOWN, GameInput.LEFT, GameInput.RIGHT, GameInput.BOOST };
        for (int i = 0; i < ctns.length; i++) {
            if (e.getTarget() == ctns[i]) {
                Pane ctn = ctns[i];
                Text txt = txts[i];
                String key = keys[i];
                ctn.setStyle("-fx-background-color: #341adbff;");
                txt.setStyle("-fx-fill: #FFFFFF;");
                optionsCtn.setMouseTransparent(true);
                optionsCtn.setOnKeyPressed(e1 -> {
                    for (int j = 0; j < keys.length; j++) {
                        if (GameInput.getAllKeyCodes().get(keys[j]) == e1.getCode()) {
                            exitKeybinding(ctn, txt);
                            optionsCtn.requestFocus();
                            return;
                        }
                    }
                    exitKeybinding(ctn, txt);
                    txt.setText(e1.getCode().getName());
                    Options.changeKeybind(key, e1.getCode());
                });
                volumeSlider.setDisable(true);
                optionsCtn.requestFocus();
            }
        }
    }

    private void exitKeybinding(Pane ctn, Text txt) {
        ctn.setStyle("-fx-background-color: #FFFFFF;");
        txt.setStyle("-fx-fill: #000000;");
        optionsCtn.setMouseTransparent(false);
        optionsCtn.setOnKeyPressed(null);
        volumeSlider.setDisable(false);
    }

    @Override
    public void hidePopUp() {
    }
}
