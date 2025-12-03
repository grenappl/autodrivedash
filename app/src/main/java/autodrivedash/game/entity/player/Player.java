package autodrivedash.game.entity.player;

import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;

import autodrivedash.game.entity.EntityTexture;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.util.Duration;

import com.almasb.fxgl.entity.Entity;

public final class Player extends EntityTexture {
    public static final PlayerCharacter CAR = new PlayerCharacter(
            "car.png", TILE_SIZE, TILE_SIZE / 2,
            new HitBox("PlayerHitbox", new Point2D(1, 1),
                    BoundingShape.box(TILE_SIZE - 2, TILE_SIZE / 2 - 2)),
            new PlayerMovement(600, 200), 3);
    public static final PlayerCharacter BIKE = new PlayerCharacter(
            "bike.png", TILE_SIZE - 16, TILE_SIZE / 3,
            new HitBox("PlayerHitbox", new Point2D(1, 1),
                    BoundingShape.box(TILE_SIZE - 16 - 2, TILE_SIZE / 3 - 2)),
            new PlayerMovement(800, 220), 2);
    public static final PlayerCharacter TRUCK = new PlayerCharacter(
            "truck.png", TILE_SIZE * 2, TILE_SIZE - 16,
            new HitBox("PlayerHitbox", new Point2D(1, 1),
                    BoundingShape.box(TILE_SIZE * 2 - 2, TILE_SIZE - 16 - 2)),
            new PlayerMovement(400, 200), 5);

    private static PlayerCharacter selectedCharacter = CAR;
    private static boolean isInvincible = false;
    private static int invincibilityDuration = 2;

    public Player() {
        super(getSelectedCharacter().getSpritePath());
        this.setFitHeight(getSelectedCharacter().getHeight());
        this.setFitWidth(getSelectedCharacter().getWidth());
    }

    private static Timeline invincibilityTimer;

    public static void setInvincibilityTimer(Entity player) {
        Player.invincibilityTimer = new Timeline(
                new KeyFrame(Duration.seconds(invincibilityDuration), e -> {
                    setIsInvincible(false);
                    player.setOpacity(1);
                }));
    }

    public static void setInvincibilityDuration(int invincibilityDuration) {
        Player.invincibilityDuration = invincibilityDuration;
    }

    public static void setInvincible(boolean isInvincible) {
        Player.isInvincible = isInvincible;
    }

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
}
