package autodrivedash;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;

import autodrivedash.game.gameMenu.GameMenu;
import autodrivedash.menu.Menu;

public class AppSceneFactory extends SceneFactory {
    // main menu
    @Override
    public FXGLMenu newMainMenu() {
        App.setMainMenu(new Menu(MenuType.MAIN_MENU));
        return App.getMainMenu();
    }

    // game menu
    @Override
    public FXGLMenu newGameMenu() {
        App.setGameMenu(new GameMenu(MenuType.GAME_MENU));
        return App.getGameMenu();
    }
}
