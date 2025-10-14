package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import app.settings.Screen;
import controllers.SignupController;

public class SignupPage extends JPanel implements Screen {
    private SignupController ctrl = new SignupController();
    private JButton signupBtn, goLoginBtn;

    public SignupPage(){
        this.setLayout(new GridBagLayout());
        goLoginBtn = new JButton("Sign in to your Account!");
        goLoginBtn.addActionListener(ctrl.switchToLoginPage());
        this.add(goLoginBtn);
    }
}
