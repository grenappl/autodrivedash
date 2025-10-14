package components;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BgPanel extends JPanel {
    private Image img;

    public BgPanel(String filePath) {
        this.img = new ImageIcon(filePath).getImage();
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}