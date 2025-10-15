package handlers;

import controllers.GameController;
import views.GamePage;

public class GameIntro extends Thread {
    private GamePage gamePage;
    private GameController gameCtrl;

    public GameIntro(GameController gameCtrl, GamePage gamePage){
        this.gamePage = gamePage;
        this.gameCtrl = gameCtrl;
    }

    @Override
    public void run(){
        for(; gamePage.startCount > 0; gamePage.startCount--){
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        gameCtrl.startTimers();
    }
}