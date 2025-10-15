package components;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import app.settings.Screen;

public class ImagePanel extends JPanel implements Screen {
    private Image img;

    public ImagePanel(String filePath) {
        if(filePath != null) this.img = new ImageIcon(filePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    public void fullScreen(){
        this.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}