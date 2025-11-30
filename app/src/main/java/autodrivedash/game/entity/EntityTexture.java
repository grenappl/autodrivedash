package autodrivedash.game.entity;

import com.almasb.fxgl.texture.Texture;

import autodrivedash.ScreenConstants;
import javafx.scene.image.Image;

public abstract class EntityTexture extends Texture implements ScreenConstants {
    public EntityTexture(String filePath) {
        Image img = new Image(getClass().getResourceAsStream(filePath));
        this.setImage(img);
    }
}
