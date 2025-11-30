package autodrivedash.menu.select;

import autodrivedash.game.entity.player.Player;
import autodrivedash.game.entity.player.PlayerCharacter;

public class Select {
    public static final SelectionChoice CAR = new SelectionChoice(
            "Car",
            "Good all-rounder, just like the millions it shares the road with.");
    public static final SelectionChoice BIKE = new SelectionChoice(
            "Bike",
            "The smallest option with the fastest acceleration.");
    public static final SelectionChoice TRUCK = new SelectionChoice(
            "Truck",
            "Slow to start, hard to maneuver, but can withstand many hits.");

    public static final int BIKE_UNLOCK_SCORE = 750;
    public static final int TRUCK_UNLOCK_SCORE = 1500;

    private static PlayerCharacter selectedCharacter;

    public static PlayerCharacter getSelectedCharacter() {
        return selectedCharacter;
    }

    public static void setSelectedCharacter(PlayerCharacter selectedCharacter) {
        Select.selectedCharacter = selectedCharacter;
    }

    public static void setPlayerCharacter() {
        Player.setSelectedCharacter(selectedCharacter);
    }
}
