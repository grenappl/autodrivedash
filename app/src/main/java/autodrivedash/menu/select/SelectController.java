package autodrivedash.menu.select;

import autodrivedash.App;
import autodrivedash.game.entity.player.Player;
import autodrivedash.menu.MenuPageController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SelectController extends MenuPageController {
    @FXML
    private Rectangle carCtn, bikeCtn, truckCtn;
    @FXML
    private Pane carBg, bikeBg, truckBg, selectCtn;
    @FXML
    private Label vehicleLabel;
    @FXML
    private Text vehicleText;
    @FXML
    private Button selectBtn;
    @FXML
    private ImageView bikeLock, truckLock;

    private int highScore;

    @FXML
    private void selectVehicle(MouseEvent e) {
        Rectangle selectedCtn = (Rectangle) e.getTarget();
        if (selectedCtn == carCtn) {
            setSelectionStyles(selectedCtn);
            Select.setSelectedCharacter(Player.CAR);
            setSelectionTexts(Select.CAR);
        } else if (selectedCtn == bikeCtn) {
            if (highScore >= Select.BIKE_UNLOCK_SCORE) {
                setSelectionStyles(selectedCtn);
                Select.setSelectedCharacter(Player.BIKE);
                setSelectionTexts(Select.BIKE);
            } else {
                displayPopUp("You need a score of at least " + Select.BIKE_UNLOCK_SCORE + " to unlock this vehicle.",
                        false, selectCtn);
            }
        } else if (selectedCtn == truckCtn) {
            if (highScore >= Select.TRUCK_UNLOCK_SCORE) {
                setSelectionStyles(selectedCtn);
                Select.setSelectedCharacter(Player.TRUCK);
                setSelectionTexts(Select.TRUCK);
            } else {
                displayPopUp("You need a score of at least " + Select.TRUCK_UNLOCK_SCORE + " to unlock this vehicle.",
                        false, selectCtn);
            }
        }
    }

    @FXML
    private void setPlayerCharacter() {
        Select.setPlayerCharacter();
        configSelectBtn(true);
    }

    private void setSelectionTexts(SelectionChoice ch) {
        vehicleLabel.setText(ch.getVehicleName());
        vehicleText.setText(ch.getVehicleDesc());
        if ((ch.getVehicleName() == "Car" && Player.getSelectedCharacter() == Player.CAR) ||
                (ch.getVehicleName() == "Bike" && Player.getSelectedCharacter() == Player.BIKE) ||
                (ch.getVehicleName() == "Truck" && Player.getSelectedCharacter() == Player.TRUCK)) {
            configSelectBtn(true);
        } else {
            configSelectBtn(false);
        }
    }

    private void setSelectionStyles(Rectangle selectedCtn) {
        Rectangle[] ctns = { carCtn, bikeCtn, truckCtn };
        Pane[] bgs = { carBg, bikeBg, truckBg };
        for (int i = 0; i < 3; i++) {
            if (ctns[i] == selectedCtn) {
                ctns[i].setStroke(Color.WHITE);
                bgs[i].setStyle("-fx-background-color: #004aad;");
            } else {
                ctns[i].setStroke(Color.BLACK);
                bgs[i].setStyle("-fx-background-color: transparent;");
            }
        }
    }

    public void displaySelected() {
        if (Player.getSelectedCharacter() == Player.CAR) {
            setSelectionTexts(Select.CAR);
            setSelectionStyles(carCtn);
        } else if (Player.getSelectedCharacter() == Player.BIKE) {
            setSelectionTexts(Select.BIKE);
            setSelectionStyles(bikeCtn);
        } else if (Player.getSelectedCharacter() == Player.TRUCK) {
            setSelectionTexts(Select.TRUCK);
            setSelectionStyles(truckCtn);
        }
        configSelectBtn(true);
        setUnlocked();
    }

    private void configSelectBtn(boolean isSelected) {
        if (isSelected) {
            selectBtn.setText("Selected");
            selectBtn.setDisable(true);
        } else {
            selectBtn.setText("Select");
            selectBtn.setDisable(false);
        }
    }

    private void setUnlocked() {
        highScore = Integer.valueOf(App.getMainMenu().getStartController().getHighestScoreLabel().getText());
        if (highScore >= Select.BIKE_UNLOCK_SCORE) {
            bikeLock.setOpacity(0);
        } else {
            bikeLock.setOpacity(1);
        }
        if (highScore >= Select.TRUCK_UNLOCK_SCORE) {
            truckLock.setOpacity(0);
        } else {
            truckLock.setOpacity(1);
        }
    }

    @Override
    public void hidePopUp() {
        setMouseFocuses(selectCtn, popUpCtn);
        popUpCtn.setOpacity(0);
    }
}
