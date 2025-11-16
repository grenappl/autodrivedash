package autodrivedash.game.entity.player;

import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;

import autodrivedash.ScreenConstants;
import javafx.geometry.Point2D;

public final class Player implements ScreenConstants {
    public static final PlayerCharacter CAR = new PlayerCharacter(
            "/images/sprites/p.png", TILE_SIZE, TILE_SIZE / 2,
            new HitBox("PlayerHitbox", new Point2D(1, 1), BoundingShape.box(TILE_SIZE - 2, TILE_SIZE / 2 - 2)),
            new PlayerMovement(700, 150, 0.8));

    private static PlayerCharacter selectedCharacter = CAR;
    private static boolean isInvincible = false;
    private static int invincibilityDuration = 2;

    public static PlayerCharacter getSelectedCharacter() {
        return selectedCharacter;
    }

    public static boolean isInvincible() {
        return isInvincible;
    }

    public static int invincibilityDuration() {
        return invincibilityDuration;
    }

    public static void setSelectedCharacter(PlayerCharacter newSelectedCharacter) {
        selectedCharacter = newSelectedCharacter;
    }

    public static void setIsInvincible(boolean newIsInvincible) {
        isInvincible = newIsInvincible;
    }

    public static void setInvincibilityDuration(int newInvincibilityDuration) {
        invincibilityDuration = newInvincibilityDuration;
    }
}
