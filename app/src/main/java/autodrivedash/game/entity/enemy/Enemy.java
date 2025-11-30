package autodrivedash.game.entity.enemy;

import autodrivedash.game.entity.EntityTexture;

public abstract class Enemy extends EntityTexture {
    public EnemyMovement movement;

    public Enemy(String filePath) {
        super(filePath);
    }
}
