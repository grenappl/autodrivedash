package autodrivedash.game.entity.tile;

import static com.almasb.fxgl.dsl.FXGL.*;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

import autodrivedash.ScreenConstants;
import autodrivedash.game.entity.EntityType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TileSpawner implements EntityFactory, ScreenConstants {
    public final static String ROAD_KEY = "ROAD";
    public final static String ROAD_STRIPE_KEY = "STRIPE";
    public final static String SIDE_KEY = "SIDE";

    @Spawns(ROAD_KEY)
    public Entity newRoadTile(SpawnData data){
        return entityBuilder(data)
            .type(EntityType.ROAD)
            .view(FXGL.texture("../../images/tiles/road.png", TILE_SIZE, TILE_SIZE))
            .with(new TileMovement())
            .build();
    }

    @Spawns(ROAD_STRIPE_KEY)
    public Entity newRoadStripeTile(SpawnData data){
        return entityBuilder(data)
            .type(EntityType.ROAD)
            .view(FXGL.texture("../../images/tiles/road-stripe.png", TILE_SIZE, TILE_SIZE))
            .with(new TileMovement())
            .build();
    }

    @Spawns(SIDE_KEY)
    public Entity newSideTile(SpawnData data){
        return entityBuilder(data)
            .type(EntityType.SIDE)
            .view(new Rectangle(TILE_SIZE, TILE_SIZE, Color.LIGHTGRAY))
            .with(new TileMovement())
            .build();
    }
}
