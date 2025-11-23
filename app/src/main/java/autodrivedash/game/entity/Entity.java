package autodrivedash.game.entity;

import com.almasb.fxgl.texture.Texture;

import javafx.scene.image.Image;

public abstract class Entity extends Texture {
    public Entity(String filePath) {
        Image img = new Image(getClass().getResourceAsStream(filePath));
        this.setImage(img);
    }
}
