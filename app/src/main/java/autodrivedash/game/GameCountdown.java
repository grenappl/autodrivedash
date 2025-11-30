package autodrivedash.game;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.time.TimerAction;

import autodrivedash.game.entity.enemy.EnemySpawnTimer;
import autodrivedash.game.entity.player.Player;
import autodrivedash.game.entity.player.PlayerMovement;
import autodrivedash.game.entity.powerup.Powerup;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class GameCountdown {
    private static int startCount = 3;
    private static boolean isRunning = true;
    private static TimerAction countdownAction;

    public static boolean isRunning() {
        return isRunning;
    }

    public static void setRunning(boolean isRunning) {
        GameCountdown.isRunning = isRunning;
    }

    public static void start(Label countdown) {
        setRunning(true);
        countdownAction = FXGL.getGameTimer().runAtInterval(() -> {
            startCount--;
            if (startCount == 0) {
                startCount = 3;
                setRunning(false);
                countdown.setOpacity(0);
                countdownAction.expire();
                new EnemySpawnTimer();
                Powerup.startSpawn();
            } else {
                countdown.setText(String.valueOf(startCount));
            }
        }, Duration.millis(1000));
        countdown.setText(String.valueOf(startCount));
    }

    public static void reset() {
        PlayerMovement movement = Player.getSelectedCharacter().getMovement();
        movement.setVx(0);
        movement.setVy(0);
        startCount = 3;
    }
}
