package autodrivedash.game.handlers;

import javafx.animation.AnimationTimer;
import autodrivedash.game.GameController;
import autodrivedash.game.entity.Player;

public class GameLoop extends AnimationTimer {
    private GameController gameCtrl;
    private Player player;
    int i = 0;

    public GameLoop(){
        // this.gameCtrl = gameCtrl;
        // this.gamePage = gamePage;
        // this.player = gameCtrl.getPlayer();
    }

    @Override
    public void handle(long arg0) {
        System.out.println(i++);
    }

    // @Override
    // public void run() {
    //     double drawInterval = 1_000_000_000 / Screen.FPS; // 1B ns / 60 = 16.7M ns = 0.017s
    //     double delta = 0;
    //     long lastTime = System.nanoTime();
    //     long currentTime;

    //     while (running){
    //         synchronized (this){
    //             while (paused){
    //                 try {
    //                     wait();
    //                 } catch (InterruptedException e) {
    //                     e.printStackTrace();
    //                 }
    //             }
    //         }
    //         while(this != null){
    //             currentTime = System.nanoTime(); 
    //             delta += (currentTime - lastTime) / drawInterval; // ex. 25M ns / 16.7M ns = 1.5
    //             lastTime = currentTime;
    //             if(delta >= 1){
    //                 if(gameCtrl.getGameIntro().isAlive()){
    //                     player.x += player.spd - 1.5;
    //                 } else {
    //                     gameCtrl.update();
    //                 }
    //                 gamePage.repaint();
    //                 delta--;
    //             }
    //         }
    //     }
    // }
}
