package app;

import views.*;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app.settings.Screen;

public class Window extends JFrame {
    private CardLayout pageController = new CardLayout();
    private JPanel pages = new JPanel(pageController);

    private LoginPage loginPage = new LoginPage();
    private SignupPage signupPage = new SignupPage();
    private MenuPage menuPage = new MenuPage();
    private OptionsPage optionsPage = new OptionsPage();
    private GamePage gamePage = new GamePage();

    public Window(){
        pages.add(loginPage, "Login");
        pages.add(signupPage, "Signup");
        pages.add(menuPage, "Menu");
        pages.add(optionsPage, "Options");
        pages.add(gamePage, "Game");

        setMenuActions();

        this.add(pages);
        this.setTitle(App.NAME);
        this.setSize(Screen.SCREEN_DIMENSIONS);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public CardLayout getPageController() { return pageController; }
    public JPanel getPages() { return pages; }

    public LoginPage getLoginPage() { return loginPage; }
    public SignupPage getSignupPage() { return signupPage; }
    public MenuPage getMenuPage() { return menuPage; }
    public OptionsPage getOptionsPage() { return optionsPage; }
    public GamePage getGamePage() { return gamePage; }

    void setMenuActions(){
        menuPage.getStartBtn().addActionListener(e -> {
            pageController.show(pages, "Game");
            gamePage.start(e);
        });
        menuPage.getOptionsBtn().addActionListener(_ -> {
            pageController.show(pages, "Options");
        });
        menuPage.getExitBtn().addActionListener(_ -> System.exit(0));
    }
    void setOptionsActions(){
    
    }
    void setGameActions(){

    }
}