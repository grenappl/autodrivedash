package autodrivedash.game;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;
import autodrivedash.game.entity.EntityType;
import autodrivedash.game.entity.player.Player;
import autodrivedash.game.entity.player.PlayerMovement;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import autodrivedash.ScreenConstants;

public class GameCollisions implements ScreenConstants {
    public void setPlayerToEnemy(ImageView[] health) {
        FXGL.onCollision(EntityType.PLAYER, EntityType.ENEMY, (player, car) -> {
            if (!Player.isInvincible()) {
                App.getGameSound().getHurtAudio().play();
                player.getViewComponent().setOpacity(0.7);
                player.setProperty("LIVES", player.getInt("LIVES") - 1);
                if (player.getInt("LIVES") >= 0)
                    health[player.getInt("LIVES")].setOpacity(0);
                App.getGameSound().getHurtAudio().seek(Duration.ZERO);
                if (player.getInt("LIVES") > 0) {
                    Player.setIsInvincible(true);
                    Player.getInvincibilityTimer().play();
                } else if (player.getInt("LIVES") == 0) {
                    PlayerMovement movement = Player.getSelectedCharacter().getMovement();
                    movement.setVx(0);
                    movement.setVy(0);
                    FXGL.getInput().clearAll();
                    FXGL.getGameController().pauseEngine();
                    App.getGameMenu().displayGameOver();
                    FXGL.getGameController().gotoGameMenu();
                }
            }
        });
    }

    public void setPlayertoPowerup(ImageView[] health) {
        FXGL.onCollision(EntityType.PLAYER, EntityType.HP, (player, hp) -> {
            int currLives = player.getInt("LIVES");
            if ((Player.getSelectedCharacter() == Player.CAR && currLives < 3) ||
                    (Player.getSelectedCharacter() == Player.BIKE && currLives < 2) ||
                    (Player.getSelectedCharacter() == Player.TRUCK && currLives < 5)) {
                health[currLives].setOpacity(1);
                player.setProperty("LIVES", currLives + 1);
            }
            App.getGameSound().playPowerupAudio();
            hp.removeFromWorld();
        });
        FXGL.onCollision(EntityType.PLAYER, EntityType.BOOST, (player, boost) -> {
            int boostVal = 70;
            Rectangle boostBar = App.getGameController().getBoostBar();
            if (boostBar.getWidth() + boostVal >= 250)
                boostBar.setWidth(boostBar.getWidth() + (250 - boostBar.getWidth()));
            else
                boostBar.setWidth(boostBar.getWidth() + boostVal);
            App.getGameSound().playPowerupAudio();
            boost.removeFromWorld();
        });
    }

    public void setPlayertoSidewalk() {
        FXGL.onCollision(EntityType.PLAYER, EntityType.SIDEWALK, (player, sidewalk) -> {
            if (player.getY() <= TILE_SIZE * 2) {
                player.setY((double) TILE_SIZE * 2);
            } else if (player.getY() >= SCREEN_HEIGHT - (TILE_SIZE * 2 + Player.getSelectedCharacter().getHeight())) {
                player.setY((double) (SCREEN_HEIGHT - (TILE_SIZE * 2 + Player.getSelectedCharacter().getHeight())));
            }
        });
    }
}
