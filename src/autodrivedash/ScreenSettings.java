package autodrivedash;

import java.awt.Dimension;

public interface ScreenSettings {
    final int ORIGIN_TILE_SIZE = 16;
    final int SCALE = 3;
    public final int TILE_SIZE = ORIGIN_TILE_SIZE * SCALE;
    public final int TILE_MAX_COL = 16;
    public final int TILE_MAX_ROW = 13;
    public final int SCREEN_WIDTH = TILE_SIZE * TILE_MAX_COL;
    public final int SCREEN_HEIGHT = TILE_SIZE * TILE_MAX_ROW;
    public final Dimension SCREEN_DIMENSIONS = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);

    public final int SCREEN_WIDTH_CENTER = SCREEN_WIDTH / 2 - (TILE_SIZE / 2);
    public final int SCREEN_HEIGHT_CENTER = SCREEN_HEIGHT / 2 - (TILE_SIZE / 2);
}