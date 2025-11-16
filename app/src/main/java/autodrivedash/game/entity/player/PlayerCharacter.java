package autodrivedash.game.entity.player;

import com.almasb.fxgl.physics.HitBox;

public class PlayerCharacter {
    private String spritePath;
    private double width, height;
    private HitBox hitbox;
    private PlayerMovement movement;

    public String getSpritePath() {
        return this.spritePath;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public HitBox getHitbox() {
        return this.hitbox;
    }

    public PlayerMovement getMovement() {
        return this.movement;
    }

    public PlayerCharacter(String spritePath, double width, double height, HitBox hitbox, PlayerMovement movement) {
        this.spritePath = spritePath;
        this.width = width;
        this.height = height;
        this.hitbox = hitbox;
        this.movement = movement;
    }
}
