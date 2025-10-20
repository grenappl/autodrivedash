package test.app;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.entity.Entity;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.*;

public class App extends GameApplication {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setSceneFactory(new SceneFactory());
        settings.setTitle("Basic Game App");
    }

    @Override
    protected void initGame() {
        // Create a blue box in the center of the screen
        Entity player = entityBuilder()
            .at(400, 300)
            .viewWithBBox(new Rectangle(100, 100, Color.BLUE))
            .buildAndAttach();
    }
}
