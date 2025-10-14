package views;

import handlers.MovementHandler;
import handlers.PauseHandler;
import handlers.SpawnHandler;
import models.Player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import app.settings.Screen;
import app.settings.ColorPallete;

public class GamePage extends JPanel implements Screen {
    private static final int SCORE_INTERVAL = 100;

    private Player player;
    private Thread gameThrd;
    private GameRunnable gameRunnable;
    private IntroThread introThrd;
    private int tile_pos;
    private Timer scoreTimer;
    private SpawnHandler spawn;

    private int scrollSpd = 6;
    private int startCount = 3;

    public GamePage(){
        setDoubleBuffered(true);
        setFocusable(true);
    }

    public void start(ActionEvent _e){
        setPlayer();
        scoreTimer = new Timer(SCORE_INTERVAL, e -> player.score++);
        spawn = new SpawnHandler();
        requestFocusInWindow();
        addKeyListener(player.movement);

        introThrd = new IntroThread();
        introThrd.setDaemon(true);
        introThrd.start();

        gameRunnable = new GameRunnable();
        gameThrd = new Thread(gameRunnable);
        gameThrd.setDaemon(true);
        gameThrd.start();
    }
    public void stop(){
        
    }

    void setPlayer(){
        this.player = new Player(
            (double) -(TILE_SIZE),
            (double)SCREEN_HEIGHT_CENTER,
            TILE_SIZE, TILE_SIZE, 2.5,
            "assets/images/p.png",
            new MovementHandler(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT));
    }

    class IntroThread extends Thread {
        @Override
        public void run(){
            for(; startCount > 0; startCount--){
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            startTimers();
        }
    }

    void startTimers(){
        scoreTimer.start();
        spawn.beginTimers();
    }
    void stopTimers(){
        scoreTimer.stop();
        spawn.stopTimers();
    }

    class GameRunnable extends PauseHandler implements Runnable {
        @Override
        public void run(){
            double drawInterval = 1_000_000_000 / FPS; // 1B ns / 60 = 16.7M ns = 0.017s
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

                while(this != null && !paused){
                    currentTime = System.nanoTime(); 
                    delta += (currentTime - lastTime) / drawInterval; // ex. 25M ns / 16.7M ns = 1.5
                    lastTime = currentTime;
                    if(delta >= 1){
                        if(introThrd.isAlive()){
                            player.x += player.spd - 1.5;
                        } else {
                            update();
                        }
                        repaint();
                        delta--;
                    }
                }
            }
        }
    }

    void update(){
        player.move();
        player.checkCollision(spawn.entities);
    }

    void draw(Graphics2D g2D){
        // background
        tile_pos += scrollSpd;
        for(int i = 2; i < TILE_MAX_ROW - 2; i++){
            for(int j = 0; j < TILE_MAX_COL + 2; j++){
                g2D.setColor(g2D.getColor() == ColorPallete.PRIMARY_ROAD && (i % 4 == 0 || i % 8 == 0)? Color.YELLOW : ColorPallete.PRIMARY_ROAD);
                g2D.fillRect(TILE_SIZE * j - tile_pos, TILE_SIZE * i, TILE_SIZE, TILE_SIZE);
            }
        }
        if(tile_pos == TILE_SIZE * 2) tile_pos = 0;

        // entities
        g2D.setColor(Color.WHITE);
        for(int i = 0; i < spawn.entities.size(); i++){
            spawn.entities.get(i).move();
            g2D.drawRect(spawn.entities.get(i).hitbox.x,  spawn.entities.get(i).hitbox.y, spawn.entities.get(i).hitbox.width, spawn.entities.get(i).hitbox.height);
            if(spawn.entities.get(i).x <= -(TILE_SIZE)) spawn.entities.remove(i--);
        }

        // player
        g2D.drawImage(player.sprite, (int)player.x, (int)player.y, player.width, player.height, null);
        g2D.setColor(Color.BLUE);
        g2D.drawRect(player.hitbox.x, player.hitbox.y, player.hitbox.width, player.hitbox.height);

        // texts
        g2D.setColor(Color.BLACK);
        g2D.setFont(new Font("Arial", Font.ITALIC, 36));
        g2D.drawString((player.hasCollided ? "Collision" : "No Collision"), SCREEN_WIDTH - (TILE_SIZE * 5), 50);
        g2D.drawString(String.valueOf(player.score), TILE_SIZE, 50);

        // start
        if(startCount > 0){
            g2D.drawString(String.valueOf(startCount), SCREEN_WIDTH_CENTER, SCREEN_HEIGHT_CENTER);
        }
        g2D.dispose();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        draw(g2D);
    }
}