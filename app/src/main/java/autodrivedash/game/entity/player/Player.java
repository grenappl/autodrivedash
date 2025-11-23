package autodrivedash.game.entity.player;

import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;

import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.Entity;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.util.Duration;

public final class Player extends Entity implements ScreenConstants {
    public static final PlayerCharacter CAR = new PlayerCharacter(
            "car.png", TILE_SIZE, TILE_SIZE / 2,
            new HitBox("PlayerHitbox", new Point2D(1, 1), BoundingShape.box(TILE_SIZE - 2, TILE_SIZE / 2 - 2)),
            new PlayerMovement(700, 150, 0.8));

    private static PlayerCharacter selectedCharacter = CAR;
    private static boolean isInvincible = false;
    private static int invincibilityDuration = 2;

    public Player() {
        super(getSelectedCharacter().getSpritePath());
        this.setFitHeight(getSelectedCharacter().getHeight());
        this.setFitWidth(getSelectedCharacter().getWidth());
    }

    private static final Timeline invincibilityTimer = new Timeline(
            new KeyFrame(Duration.seconds(invincibilityDuration), e -> {
                setIsInvincible(false);
                System.out.println("NOT invinc");
            }));

    public static Timeline getInvincibilityTimer() {
        return invincibilityTimer;
    }

    public static PlayerCharacter getSelectedCharacter() {
        return selectedCharacter;
    }

    public static boolean isInvincible() {
        return isInvincible;
    }

    public static void setSelectedCharacter(PlayerCharacter selectedCharacter) {
        Player.selectedCharacter = selectedCharacter;
    }

    public static void setIsInvincible(boolean isInvincible) {
        Player.isInvincible = isInvincible;
    }

    public static void setInvincibilityDuration(int invincibilityDuration) {
        Player.invincibilityDuration = invincibilityDuration;
    }
}
