package autodrivedash.game.entity.enemy;

import autodrivedash.game.entity.Entity;

public abstract class Enemy extends Entity {
    public EnemyMovement movement;

    public Enemy(String filePath) {
        super(filePath);
    }
}
