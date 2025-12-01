package autodrivedash.game;

import com.almasb.fxgl.dsl.FXGL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class GameSound {
    private MediaPlayer hurtAudio = new MediaPlayer(new Media(
            getClass().getResource("/audio/sfx/hurt.mp3").toExternalForm()));
    private MediaPlayer powerupAudio = new MediaPlayer(new Media(
            getClass().getResource("/audio/sfx/powerup.wav").toExternalForm()));

    public MediaPlayer getPowerupAudio() {
        return powerupAudio;
    }

    private MediaPlayer menuMusic = new MediaPlayer(new Media(
            getClass().getResource("/audio/music/menu.mp3").toExternalForm()));

    private MediaPlayer[] gameBgMusic = {
            new MediaPlayer(new Media(
                    getClass().getResource("/audio/music/bgmusic1.mp3").toExternalForm())),
            new MediaPlayer(new Media(
                    getClass().getResource("/audio/music/bgmusic2.mp3").toExternalForm())),
            new MediaPlayer(new Media(
                    getClass().getResource("/audio/music/bgmusic3.mp3").toExternalForm()))
    };

    public MediaPlayer[] getGameBgMusic() {
        return gameBgMusic;
    }

    private MediaPlayer currentGameMusic;

    public MediaPlayer getHurtAudio() {
        return hurtAudio;
    }

    public void playPowerupAudio() {
        powerupAudio.play();
        powerupAudio.seek(Duration.ZERO);
    }

    public MediaPlayer getMenuMusic() {
        return menuMusic;
    }

    public MediaPlayer getCurrentGameMusic() {
        return currentGameMusic;
    }

    public void setCurrentGameMusic() {
        this.currentGameMusic = gameBgMusic[FXGL.random(0, 2)];
        this.currentGameMusic.seek(Duration.ZERO);
        this.currentGameMusic.setOnEndOfMedia(() -> {
            System.out.println("end of song!");
            this.currentGameMusic = gameBgMusic[FXGL.random(0, 2)];
            this.currentGameMusic.seek(Duration.ZERO);
            this.currentGameMusic.play();
        });
    }

    public GameSound() {
        menuMusic.setCycleCount(MediaPlayer.INDEFINITE);
    }
}
