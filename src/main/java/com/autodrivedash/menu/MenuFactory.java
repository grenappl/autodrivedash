package autodrivedash.menu;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;

import autodrivedash.App;
import autodrivedash.game.GameMenu;

public class MenuFactory extends SceneFactory {
    @Override
    public FXGLMenu newMainMenu() {
        App.setMainMenu(new MainMenu(MenuType.MAIN_MENU));
        return App.getMainMenu();
    }
    @Override
    public FXGLMenu newGameMenu() {
        App.setGameMenu(new GameMenu(MenuType.GAME_MENU));
        return App.getGameMenu();
    }
}
