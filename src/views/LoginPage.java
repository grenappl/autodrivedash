package views;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import app.settings.Screen;
import controllers.LoginController;

public class LoginPage extends JPanel implements Screen {
    private LoginController ctrl = new LoginController();
    private JButton loginBtn, goSignupBtn;

    public LoginPage(){
        this.setLayout(new GridBagLayout());
        goSignupBtn = new JButton("Create an Account!");
        goSignupBtn.addActionListener(ctrl.switchToSignupPage());
        this.add(goSignupBtn);
    }
}
// btn.setBorder(BorderFactory.createLineBorder(Color.RED));