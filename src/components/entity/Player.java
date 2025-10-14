package components.entity;

import java.util.ArrayList;

import app.settings.Screen;
import handlers.Movement;

public class Player extends Entity implements Screen {
    static final int HITBOX_POS_X = 4;
    static final int HITBOX_POS_Y = 20;
    static final int HITBOX_POS_WIDTH = -12;
    static final int HITBOX_POS_HEIGHT = -36;

    public double x, y;
    public Movement movement;
    public int score;

    public boolean hasCollided = false;
    public int scoreInterval = 10;
    double vx = 0, vy = 0;
    double ax = 0, ay = 0;
    double maxSpd;
    double accel = 0.2;
    double friction = 0.2;

    public Player(
            int x, int y, int width, int height, int spd, String filePath, 
            int up, int down, int left, int right){ 
        super(0, 0, width, height, spd, filePath);
        this.x = (double)x;
        this.y = (double)y;
        this.maxSpd = (double)spd;
        this.hitbox.y = SCREEN_HEIGHT_CENTER;
        this.movement = new Movement(up, down, left, right);
    }

    public void move(){
        if(this.x <= 0.0) this.x = 0.0;
        if(this.x + this.width >= SCREEN_WIDTH) this.x = SCREEN_WIDTH - this.width;

        if(movement.leftKeyPressed && this.x > 0.0) ax = -accel;
        else if(movement.rightKeyPressed) ax = accel;
        else ax = 0;

        if(this.hitbox.y <= TILE_SIZE * 2 + 2) 
            this.y = TILE_SIZE * 2 - HITBOX_POS_Y + 2;
        if(this.hitbox.y - HITBOX_POS_Y >= SCREEN_HEIGHT - TILE_SIZE * 3 + HITBOX_POS_Y - 8)
            this.y = SCREEN_HEIGHT - TILE_SIZE * 3 + HITBOX_POS_Y - 8;

        if(movement.upKeyPressed && this.hitbox.y > TILE_SIZE * 2) ay = -accel;
        else if(movement.downKeyPressed) ay = accel;
        else ay = 0;

        vx += ax;
        vy += ay;

        if(!movement.leftKeyPressed && !movement.rightKeyPressed){
            if(vx > 0) vx = Math.max(0, vx - friction);
            else if(vx < 0) vx = Math.min(0, vx + friction);
        }
        if(!movement.upKeyPressed && !movement.downKeyPressed){
            if(vy > 0) vy = Math.max(0, vy - friction);
            else if(vy < 0) vy = Math.min(0, vy + friction);
        }

        vx = Math.max(-maxSpd, Math.min(maxSpd, vx));
        vy = Math.max(-(maxSpd), Math.min(maxSpd, vy));

        x += vx;
        y += vy;

        hitbox.x = (int)(x + HITBOX_POS_X);
        hitbox.y = (int)(y + HITBOX_POS_Y);
    }

    public void checkCollision(ArrayList<Entity> entities){
        this.hasCollided = false;
        for(Entity entity : entities){
            if(this.hitbox.intersects(entity.hitbox)){
                this.hasCollided = true;
                break;
            }
        }
    }
}