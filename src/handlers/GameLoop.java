package handlers;

import app.settings.Screen;
import bases.PauseThread;
import controllers.GameController;
import models.game.Player;
import views.GamePage;

public class GameLoop extends PauseThread {
    private GameController gameCtrl;
    private GamePage gamePage;
    private Player player;

    public GameLoop(GameController gameCtrl, GamePage gamePage){
        this.gameCtrl = gameCtrl;
        this.gamePage = gamePage;
        this.player = gameCtrl.getPlayer();
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000 / Screen.FPS; // 1B ns / 60 = 16.7M ns = 0.017s
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (running){
            synchronized (this){
                while (paused){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            while(this != null){
                currentTime = System.nanoTime(); 
                delta += (currentTime - lastTime) / drawInterval; // ex. 25M ns / 16.7M ns = 1.5
                lastTime = currentTime;
                if(delta >= 1){
                    if(gameCtrl.getGameIntro().isAlive()){
                        player.x += player.spd - 1.5;
                    } else {
                        gameCtrl.update();
                    }
                    gamePage.repaint();
                    delta--;
                }
            }
        }
    }
}
