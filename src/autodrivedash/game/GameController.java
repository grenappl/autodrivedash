package autodrivedash.game;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Timer;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import autodrivedash.ScreenSettings;
import autodrivedash.game.handlers.Collision;
import autodrivedash.game.handlers.Movement;

public class GameController implements ScreenSettings {
    private GameModel gameModel;
    public void setModel(GameModel model) {
        this.gameModel = model;
    }

    @FXML private Pane bg;
    @FXML private ImageView player;

    private Movement movement;
    private Collision collision;

    public Scene setScene(Parent gamePage){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(bg);
        translate.setDuration(Duration.seconds(1));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setInterpolator(Interpolator.LINEAR);
        translate.setByX(-(SCREEN_WIDTH));
        translate.play();

        movement = new Movement(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT);
        // collision = new Collision();

        Scene scene = new Scene(gamePage);
        scene.setOnKeyPressed(e -> movement.setKeyStates(e.getCode(), true));
        scene.setOnKeyReleased(e -> movement.setKeyStates(e.getCode(), false));

        movement.setPlayerMovement(player);

        return scene;
    }

    // private Player player;
    // private GameLoop gameLoop;
    // private GameIntro gameIntro;
    // private Timer scoreTimer;
    // public SpawnHandler spawn;

    // public static final int SCORE_INTERVAL = 100;
    
    // public GameIntro getGameIntro(){ return gameIntro; }

    // public Player getPlayer(){ return player; }
    // public void setPlayer(){ // will change based on customization
    //     player = new Player(
    //         (double) -(TILE_SIZE),
    //         (double)SCREEN_HEIGHT_CENTER,
    //         TILE_SIZE, TILE_SIZE, 2.5,
    //         "assets/images/p.png",
    //         new MovementHandler(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT));
    //     // getGamePage().setPlayer(player);
    // }

    // public GameController(GamePage gamePage){

    // }

    // public void startGame(){
    //     this.setPlayer();
    //     // page.addKeyListener(player.movement);
    //     spawn = new SpawnHandler();
    //     scoreTimer = new Timer(SCORE_INTERVAL, e -> player.score++);
    //     // page.requestFocusInWindow();

    //     // gameIntro = new GameIntro(this, (GamePage)page);
    //     gameIntro.setDaemon(true);
    //     gameIntro.start();

    //     // gameLoop = new GameLoop(this, (GamePage)page);
    //     gameLoop.setDaemon(true);
    //     gameLoop.start();
    // }

    // public void update(){
    //     player.move();
    //     // getGamePage().setEntities(spawn.entities);
    //     player.checkCollision(spawn.entities);
    // }

    // public void startTimers(){
    //     scoreTimer.start();
    //     spawn.beginTimers();
    // }
    // void stopTimers(){
    //     // scoreTimer.stop();
    //     // spawn.stopTimers();
    // }


    // OG GAMEPAGE.java
        //     private void drawBg(Graphics2D g2D){
        //     for(int i = 2; i < TILE_MAX_ROW - 2; i++){
        //         for(int j = 0; j < TILE_MAX_COL + 2; j++){
        //             g2D.setColor(g2D.getColor() == PRIMARY_ROAD && (i == 5 || i == 9)? PRIMARY_YELLOW : PRIMARY_ROAD);
        //             g2D.fillRect(TILE_SIZE * j - tilePos, TILE_SIZE * i, TILE_SIZE, TILE_SIZE);
        //         }
        //     }
        //     setTilePos(tilePos + scrollSpd);
        // }

        // private void drawEntities(Graphics2D g2D){
        //     g2D.setColor(Color.WHITE);
        //     for(int i = 0; i < entities.size(); i++){
        //         entities.get(i).move();
        //         g2D.drawRect(entities.get(i).hitbox.x,  entities.get(i).hitbox.y, entities.get(i).hitbox.width, entities.get(i).hitbox.height);
        //         if(entities.get(i).x <= -(TILE_SIZE)) entities.remove(i--);
        //     }
        // }

        // private void drawPlayer(Graphics2D g2D){
        //     g2D.drawImage(player.sprite, (int)player.x, (int)player.y, player.width, player.height, null);
        //     g2D.setColor(Color.BLUE);
        //     g2D.drawRect(player.hitbox.x, player.hitbox.y, player.hitbox.width, player.hitbox.height);
        // }

        // private void drawUI(Graphics2D g2D){
        //     g2D.setColor(Color.BLACK);
        //     g2D.setFont(new Font("Arial", Font.ITALIC, 36));
        //     g2D.drawString((player.hasCollided ? "Collision" : "No Collision"), SCREEN_WIDTH - (TILE_SIZE * 5), 50);
        //     g2D.drawString(String.valueOf(player.score), TILE_SIZE, 50);
        // }

        // private void drawCountDown(Graphics2D g2D){
        //     g2D.setColor(new Color(0, 0, 0, 100));
        //     g2D.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        //     g2D.setColor(Color.WHITE);
        //     g2D.setFont(new Font("Arial", Font.BOLD, 100));
        //     String countStr = String.valueOf(startCount);
        //     int strWidth = g2D.getFontMetrics().stringWidth(countStr);
        //     g2D.drawString(countStr, (SCREEN_WIDTH - strWidth) / 2, SCREEN_HEIGHT / 2);
        // }
}
