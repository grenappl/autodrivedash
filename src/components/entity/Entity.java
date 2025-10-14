package components.entity; 

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Entity {
    public int x, y, width, height, spd;
    public Rectangle hitbox;
    public Image sprite;
    
    public Entity(int x, int y, int width, int height, int spd, String filePath){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.spd = spd;
        if(filePath == "images/p.png"){
            this.hitbox = new Rectangle(x + Player.HITBOX_POS_X, y + Player.HITBOX_POS_Y, width + Player.HITBOX_POS_WIDTH, height + Player.HITBOX_POS_HEIGHT);
            this.sprite = new ImageIcon(getClass().getResource("../../assets/" + filePath)).getImage();
        } else {
            this.hitbox = new Rectangle(x, y, width, height);
        }
    }

    public void move(){
        this.x -= this.spd;
        this.hitbox.x -= this.spd;
    }
}