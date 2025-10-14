package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.App;
import app.settings.Screen;
import components.BgPanel;

public class MenuPage extends JPanel implements Screen {
    private JLabel title;
    private JButton startBtn, optionsBtn, exitBtn;

    public MenuPage(){
        // super("assets/images/p.png");
        this.setLayout(new BorderLayout());
        JPanel topCtn, centerCtn, bottomCtn;

        topCtn = new JPanel();
        topCtn.setPreferredSize(new Dimension(0, 100));
        topCtn.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.add(topCtn, BorderLayout.NORTH);

        centerCtn = new JPanel(new GridBagLayout());
        this.add(centerCtn, BorderLayout.CENTER);

        bottomCtn = new JPanel();
        bottomCtn.setPreferredSize(new Dimension(40, 100));
        bottomCtn.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.add(bottomCtn, BorderLayout.SOUTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        title = new JLabel(App.NAME);
        title.setFont(new Font("Ink Free", Font.BOLD, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        title.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        centerCtn.add(title, gbc);

        JPanel btnsCtn = new JPanel(new GridLayout(3, 1, 5, 5));
        btnsCtn.setOpaque(false);
        btnsCtn.setPreferredSize(new Dimension(0, 200));

        startBtn = new JButton("Start");
        optionsBtn = new JButton("Options");
        exitBtn = new JButton("Exit");
        JButton[] btns = { startBtn, optionsBtn, exitBtn };
        for(JButton b : btns){
            b.setBackground(Color.GRAY);
            b.setFocusable(false);
            btnsCtn.add(b);
        }
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        btnsCtn.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        centerCtn.add(btnsCtn, gbc);
    }

    public JButton getStartBtn(){ return startBtn; }
    public JButton getOptionsBtn(){ return optionsBtn; }
    public JButton getExitBtn(){ return exitBtn; }
}
