package autodrivedash.game.entity.player;

import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;

import autodrivedash.ScreenConstants;
import javafx.geometry.Point2D;

public final class Player implements ScreenConstants {
    private static boolean isInvincible = false;

    public static boolean isInvincible() {
        return isInvincible;
    }

    public static void setIsInvincible(boolean newIsInvincible) {
        isInvincible = newIsInvincible;
    }

    private static int invincibilityDuration = 2;

    public static int invincibilityDuration() {
        return invincibilityDuration;
    }

    public static void setInvincibilityDuration(int newInvincibilityDuration) {
        invincibilityDuration = newInvincibilityDuration;
    }

    private static PlayerMovement movement;

    public static PlayerMovement getMovement() {
        return movement;
    }

    public static void setMovement(PlayerMovement newMovement) {
        movement = newMovement;
    }

    private static PlayerCharacter currentCharacter;

    public static PlayerCharacter getCurrentCharacter() {
        return currentCharacter;
    }

    public static void setCurrentCharacter(PlayerCharacter newCurrentCharacter) {
        currentCharacter = newCurrentCharacter;
    }

    public static final PlayerCharacter CAR = new PlayerCharacter(
            "/images/sprites/p.png", TILE_SIZE, TILE_SIZE / 2,
            new HitBox("PlayerHitbox", new Point2D(1, 1), BoundingShape.box(TILE_SIZE - 2, TILE_SIZE / 2 - 2)),
            new PlayerMovement(700, 150, 0.8));
}
