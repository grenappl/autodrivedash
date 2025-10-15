package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import bases.BasePage;
import models.game.*;

public class GamePage extends BasePage {
    private int tilePos;
    private Player player;
    private ArrayList<Entity> entities;

    private int scrollSpd = 6;
    public int startCount = 3;

    public void setTilePos(int newTilePos){
        this.tilePos = (tilePos < TILE_SIZE * 2 - scrollSpd) ? newTilePos : 0;
    }
    public void setPlayer(Player player){ 
        this.player = player;
    }
    public void setEntities(ArrayList<Entity> entities){ 
        this.entities = entities;
    }

    public GamePage(){
        super(null ,null);
        this.setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        drawBg(g2D);
        if(startCount <= 0) drawEntities(g2D);
        drawPlayer(g2D);
        drawUI(g2D);
        if(startCount > 0) drawCountDown(g2D);
        g2D.dispose();
    }

    private void drawBg(Graphics2D g2D){
        for(int i = 2; i < TILE_MAX_ROW - 2; i++){
            for(int j = 0; j < TILE_MAX_COL + 2; j++){
                g2D.setColor(g2D.getColor() == PRIMARY_ROAD && (i == 5 || i == 9)? PRIMARY_YELLOW : PRIMARY_ROAD);
                g2D.fillRect(TILE_SIZE * j - tilePos, TILE_SIZE * i, TILE_SIZE, TILE_SIZE);
            }
        }
        setTilePos(tilePos + scrollSpd);
    }

    private void drawEntities(Graphics2D g2D){
        g2D.setColor(Color.WHITE);
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).move();
            g2D.drawRect(entities.get(i).hitbox.x,  entities.get(i).hitbox.y, entities.get(i).hitbox.width, entities.get(i).hitbox.height);
            if(entities.get(i).x <= -(TILE_SIZE)) entities.remove(i--);
        }
    }

    private void drawPlayer(Graphics2D g2D){
        g2D.drawImage(player.sprite, (int)player.x, (int)player.y, player.width, player.height, null);
        g2D.setColor(Color.BLUE);
        g2D.drawRect(player.hitbox.x, player.hitbox.y, player.hitbox.width, player.hitbox.height);
    }

    private void drawUI(Graphics2D g2D){
        g2D.setColor(Color.BLACK);
        g2D.setFont(new Font("Arial", Font.ITALIC, 36));
        g2D.drawString((player.hasCollided ? "Collision" : "No Collision"), SCREEN_WIDTH - (TILE_SIZE * 5), 50);
        g2D.drawString(String.valueOf(player.score), TILE_SIZE, 50);
    }

    private void drawCountDown(Graphics2D g2D){
        g2D.setColor(new Color(0, 0, 0, 100));
        g2D.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        g2D.setColor(Color.WHITE);
        g2D.setFont(new Font("Arial", Font.BOLD, 100));
        String countStr = String.valueOf(startCount);
        int strWidth = g2D.getFontMetrics().stringWidth(countStr);
        g2D.drawString(countStr, (SCREEN_WIDTH - strWidth) / 2, SCREEN_HEIGHT / 2);
    }
}