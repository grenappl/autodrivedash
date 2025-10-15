package controllers;

import java.awt.event.KeyEvent;

import javax.swing.Timer;

import app.settings.Screen;
import bases.BaseController;
import handlers.GameIntro;
import handlers.GameLoop;
import handlers.MovementHandler;
import handlers.SpawnHandler;
import models.game.Player;
import views.GamePage;

public class GameController extends BaseController implements Screen {
    public GamePage getGamePage(){ return (GamePage)this.page; }

    private Player player;
    private GameLoop gameLoop;
    private GameIntro gameIntro;
    private Timer scoreTimer;
    public SpawnHandler spawn;

    public static final int SCORE_INTERVAL = 100;
    
    public GameIntro getGameIntro(){ return gameIntro; }

    public Player getPlayer(){ return player; }
    public void setPlayer(){ // will change based on customization
        player = new Player(
            (double) -(TILE_SIZE),
            (double)SCREEN_HEIGHT_CENTER,
            TILE_SIZE, TILE_SIZE, 2.5,
            "assets/images/p.png",
            new MovementHandler(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT));
        getGamePage().setPlayer(player);
    }

    public GameController(GamePage gamePage){
        super(gamePage);
    }

    public void startGame(){
        this.setPlayer();
        page.addKeyListener(player.movement);
        spawn = new SpawnHandler();
        scoreTimer = new Timer(SCORE_INTERVAL, _ -> player.score++);
        page.requestFocusInWindow();

        gameIntro = new GameIntro(this, (GamePage)page);
        gameIntro.setDaemon(true);
        gameIntro.start();

        gameLoop = new GameLoop(this, (GamePage)page);
        gameLoop.setDaemon(true);
        gameLoop.start();
    }

    public void update(){
        player.move();
        getGamePage().setEntities(spawn.entities);
        player.checkCollision(spawn.entities);
    }

    public void startTimers(){
        scoreTimer.start();
        spawn.beginTimers();
    }
    void stopTimers(){
        // scoreTimer.stop();
        // spawn.stopTimers();
    }
}
