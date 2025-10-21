package autodrivedash.menu;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;

import autodrivedash.game.GameMenu;

public class MenuFactory extends SceneFactory {
    @Override
    public FXGLMenu newMainMenu() {
        return new MainMenu(MenuType.MAIN_MENU);
    }
    @Override
    public FXGLMenu newGameMenu() {
        return new GameMenu(MenuType.GAME_MENU);
    }
}
