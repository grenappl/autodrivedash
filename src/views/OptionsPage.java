package views;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import app.settings.Screen;

public class OptionsPage extends JPanel implements Screen {
    public OptionsPage(){
        // setPreferredSize(SCREEN_DIMENSIONS);
        setLayout(new GridBagLayout());
        JButton btn = new JButton("Options");
        this.add(btn);
    }
}
