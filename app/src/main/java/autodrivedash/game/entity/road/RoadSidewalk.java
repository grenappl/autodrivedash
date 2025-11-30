package autodrivedash.game.entity.road;

import autodrivedash.game.entity.EntityTexture;

public class RoadSidewalk extends EntityTexture {
    public RoadSidewalk() {
        super("/images/sprites/road/sidewalk.png");
        this.setFitWidth(SCREEN_WIDTH + TILE_SIZE);
        this.setFitHeight(TILE_SIZE * 2);
    }
}
