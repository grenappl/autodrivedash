package autodrivedash.game.entity.road;

import autodrivedash.game.entity.EntityTexture;

public class Road extends EntityTexture {
    public Road() {
        super("/images/sprites/road/road.png");
        this.setFitWidth(SCREEN_WIDTH + (TILE_SIZE * 2));
        this.setFitHeight(TILE_SIZE * 9);
    }
}
