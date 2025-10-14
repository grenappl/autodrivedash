package app;
import views.*;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    MenuPanel menu;
    GamePanel game;

    public Window(){
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        menu = new MenuPanel();
        game = new GamePanel();

        cardPanel.add(menu, "Menu");
        cardPanel.add(game, "Game");

        setMenuActions();

        this.add(cardPanel);
        this.setTitle(App.GAME_TITLE);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    void setMenuActions(){
        menu.getStartBtn().addActionListener(e -> {
            cardLayout.show(cardPanel, "Game");
            game.start(e);
        });
        menu.getOptionsBtn().addActionListener(e -> {
            cardLayout.show(cardPanel, "Game");
            game.start(e);
        });
        menu.getExitBtn().addActionListener(e -> System.exit(0));
    }
}