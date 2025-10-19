package bases; 

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import models.Player;

public abstract class Entity {
    public double x, y, spd;
    public int width, height;
    public Rectangle hitbox;
    public Image sprite;
    
    protected Entity(double x, double y, int width, int height, double spd, String filePath){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.spd = spd;
        if(filePath != null){
            // this.hitbox = new Rectangle((int)x + Player.HITBOX_POS_X, (int)y + Player.HITBOX_POS_Y, width + Player.HITBOX_POS_WIDTH, height + Player.HITBOX_POS_HEIGHT);
            this.sprite = new ImageIcon(filePath).getImage();
        } else {
            this.hitbox = new Rectangle((int)x, (int)y, width, height);
        }
    }

    public void move(){
        this.x -= this.spd;
        this.hitbox.x -= (int)this.spd;
    }
}