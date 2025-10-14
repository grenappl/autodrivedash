package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import app.settings.Screen;

public class SignupPage extends JPanel implements Screen {
    public SignupPage(){
        setLayout(new GridBagLayout());
        JButton btn = new JButton("Signup");
        this.add(btn);
    }
}
