package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import app.settings.Screen;
import bases.BasePage;

public class SignupPage extends BasePage {
    private JButton signupBtn, goToLoginBtn;

    public JButton getGoToLoginBtn(){ return goToLoginBtn; }

    public SignupPage(){
        super(new GridBagLayout(), null);
        goToLoginBtn = new JButton("Sign in to your Account!");
        mainCtn.add(goToLoginBtn);
    }
}
