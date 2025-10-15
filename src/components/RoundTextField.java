package components;

import java.awt.Graphics;

import javax.swing.JTextField;

public class RoundTextField extends JTextField {

    public RoundTextField(int size){
        super(size);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
