package views;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import app.settings.Screen;

public class LoginPage extends JPanel implements Screen {
    public LoginPage(){
        setLayout(new GridBagLayout());
        JButton btn = new JButton("Login");
        this.add(btn);
    }
}
// btn.setBorder(BorderFactory.createLineBorder(Color.RED));