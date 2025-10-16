package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import bases.BasePage;
import views.components.RoundButton;

public class LoginPage extends BasePage {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginBtn, goToSignupBtn;
    private JPanel popupCtn;

    public JTextField getEmailField(){ return emailField; }
    public JPasswordField getPasswordField(){ return passwordField; }
    public JButton getLoginBtn(){ return loginBtn; }
    public JButton getGoToSignUpBtn(){ return goToSignupBtn; }

    public LoginPage(){
        super(new GridBagLayout(), null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel headerLb = new JLabel("Log in");
        headerLb.setFont(new Font(FONT_HEADER, Font.PLAIN, TEXT_LG));
        headerLb.setPreferredSize(new Dimension(300, 50));
        headerLb.setHorizontalAlignment(JLabel.CENTER);
        mainCtn.add(headerLb, gbc);

        JPanel fieldsCtn = new JPanel();
        fieldsCtn.setLayout(new BoxLayout(fieldsCtn, BoxLayout.Y_AXIS));
        fieldsCtn.setPreferredSize(new Dimension(300, 100));
        fieldsCtn.setOpaque(false);
        gbc.gridy = 1;
        mainCtn.add(fieldsCtn, gbc);

        JLabel emailLb = new JLabel("Email");
        emailLb.setFont(new Font(FONT_MAIN, Font.PLAIN, TEXT_SM));
        emailLb.setAlignmentX(LEFT_ALIGNMENT);
        fieldsCtn.add(emailLb);

        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(0, 10));
        fieldsCtn.add(emailField);

        JLabel passwordLb = new JLabel("Password");
        passwordLb.setFont(new Font(FONT_MAIN, Font.PLAIN, TEXT_SM));
        passwordLb.setDisplayedMnemonic('P');
        fieldsCtn.add(passwordLb);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(0, 10));
        fieldsCtn.add(passwordField);

        loginBtn = new RoundButton("login");
        loginBtn.setFocusable(false);
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtn.setPreferredSize(new Dimension(0, 50));
        loginBtn.setBackground(Color.LIGHT_GRAY);
        gbc.gridy = 3;
        mainCtn.add(loginBtn, gbc);

        goToSignupBtn = new JButton("Create an Account!");
        goToSignupBtn.setFocusable(false);
        goToSignupBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        goToSignupBtn.setForeground(Color.BLUE);
        goToSignupBtn.setContentAreaFilled(false);
        goToSignupBtn.setBorderPainted(false);
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        mainCtn.add(goToSignupBtn, gbc);

        popupCtn = new JPanel();
        popupCtn.setBounds(50, 50, SCREEN_WIDTH, SCREEN_HEIGHT);
        popupCtn.setBackground(new Color(0, 0, 0, 25));
        popupCtn.setLayout(new GridBagLayout());
        popupCtn.setVisible(false);
        this.add(popupCtn, Integer.valueOf(2));
    }
}