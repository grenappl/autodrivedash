package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
    private JLabel title;
    private JButton startBtn;
    private JButton optionsBtn;
    private JButton exitBtn;

    static Dimension btnSize = new Dimension(300, 60);

    public MenuPanel(){
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new GridBagLayout());

        JPanel centerCtn = new JPanel(new FlowLayout());
        centerCtn.setBackground(null);
        centerCtn.setPreferredSize(new Dimension(400, 400));
        this.add(centerCtn);

        title = new JLabel("Java Game");
        title.setFont(new Font("Ink Free", Font.BOLD, 30));
        title.setBackground(null);
        centerCtn.add(title);

        JPanel menuCtn = new JPanel(new GridLayout(3, 1));
        menuCtn.setPreferredSize(new Dimension(400, 400));
        menuCtn.setBorder(BorderFactory.createEmptyBorder(0,0,50,0));
        centerCtn.add(menuCtn);

        JPanel box1 = new JPanel(new GridBagLayout());
        menuCtn.add(box1);
        startBtn = new JButton("Start");
        startBtn.setPreferredSize(btnSize);
        startBtn.setBackground(Color.GRAY);
        startBtn.setFocusable(false);
        box1.add(startBtn);

        JPanel box2 = new JPanel(new GridBagLayout());
        menuCtn.add(box2);
        optionsBtn = new JButton("Options");
        optionsBtn.setPreferredSize(btnSize);
        optionsBtn.setBackground(Color.GRAY);
        optionsBtn.setFocusable(false);
        box2.add(optionsBtn);

        JPanel box3 = new JPanel(new GridBagLayout());
        menuCtn.add(box3);
        exitBtn = new JButton("Exit");
        exitBtn.setPreferredSize(btnSize);
        exitBtn.setBackground(Color.GRAY);
        exitBtn.setFocusable(false);
        box3.add(exitBtn);
    }

    public JButton getStartBtn(){ return startBtn; }
    public JButton getOptionsBtn(){ return optionsBtn; }
    public JButton getExitBtn(){ return exitBtn; }
}
