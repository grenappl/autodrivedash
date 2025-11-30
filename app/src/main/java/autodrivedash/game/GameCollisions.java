package autodrivedash.game;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;
import autodrivedash.game.entity.EntityType;
import autodrivedash.game.entity.player.Player;
import autodrivedash.game.entity.player.PlayerMovement;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class GameCollisions {
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
            hp.removeFromWorld();
        });
    }
}
