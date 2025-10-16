package bases;

import java.awt.LayoutManager;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import app.settings.Screen;
import app.settings.Styles;
import views.components.ImagePanel;

public abstract class BasePage extends JLayeredPane implements Screen, Styles {
    protected JPanel mainCtn;

    protected BasePage(LayoutManager mainLayout, String filePath){
        this.setPreferredSize(SCREEN_DIMENSIONS);
        this.setLayout(null);

        ImagePanel bg = new ImagePanel(filePath);
        bg.fullScreen();
        this.add(bg, Integer.valueOf(0));

        mainCtn = new JPanel();
        mainCtn.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        mainCtn.setOpaque(false);
        mainCtn.setLayout(mainLayout);
        this.add(mainCtn, Integer.valueOf(1));
    }
}