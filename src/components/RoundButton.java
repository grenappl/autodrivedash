package components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class RoundButton extends JButton {
    public RoundButton(String label){
        super(label);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g.create();
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2D.setColor(getBackground());
        g2D.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);

        super.paintComponent(g2D);
        g2D.dispose();
    }
}