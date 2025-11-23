package autodrivedash.game.tile;

import com.almasb.fxgl.texture.Texture;

import autodrivedash.ScreenConstants;
import javafx.scene.image.Image;

public class Tile extends Texture implements ScreenConstants {
    public Tile(String imgFile) {
        String imgPath = "/images/sprites/tile/" + imgFile;
        Image img = new Image(getClass().getResourceAsStream(imgPath));
        this.setImage(img);
        this.setFitWidth(TILE_SIZE);
        this.setFitHeight(TILE_SIZE);
    }
}
