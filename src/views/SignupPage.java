package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bases.BasePage;
import views.components.RoundButton;

public class SignupPage extends BasePage {
    private JTextField usernameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton signupBtn, goToLoginBtn;
    private JPanel popupCtn;

    public JTextField getUsernameField() { return usernameField; }
    public JTextField getEmailField() {  return emailField; }
    public JPasswordField getPasswordField() {  return passwordField; }
    public JPasswordField getConfirmPasswordField() { return confirmPasswordField; }

    public JButton getSignupBtn() {  return signupBtn;}
    public JButton getGoToLoginBtn(){ return goToLoginBtn; }

    public SignupPage(){
        super(new GridBagLayout(), null);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel headerLb = new JLabel("Sign Up");
        headerLb.setFont(new Font(FONT_HEADER, Font.PLAIN, TEXT_LG));
        headerLb.setPreferredSize(new Dimension(300, 50));
        headerLb.setHorizontalAlignment(JLabel.CENTER);
        mainCtn.add(headerLb, gbc);

        JPanel fieldsCtn = new JPanel();
        fieldsCtn.setLayout(new BoxLayout(fieldsCtn, BoxLayout.Y_AXIS));
        fieldsCtn.setPreferredSize(new Dimension(300, 200));
        fieldsCtn.setOpaque(false);
        gbc.gridy = 1;
        mainCtn.add(fieldsCtn, gbc);

        JLabel usernameLb = new JLabel("Username");
        usernameLb.setFont(new Font(FONT_MAIN, Font.PLAIN, TEXT_SM));
        usernameLb.setAlignmentX(LEFT_ALIGNMENT);
        fieldsCtn.add(usernameLb);

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(0, 10));
        fieldsCtn.add(usernameField);

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

        JLabel confirmPasswordLb = new JLabel("Confirm Password");
        confirmPasswordLb.setFont(new Font(FONT_MAIN, Font.PLAIN, TEXT_SM));
        confirmPasswordLb.setAlignmentX(LEFT_ALIGNMENT);
        fieldsCtn.add(confirmPasswordLb);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setPreferredSize(new Dimension(0, 10));
        fieldsCtn.add(confirmPasswordField);

        signupBtn = new RoundButton("Sign Up");
        signupBtn.setFocusable(false);
        signupBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signupBtn.setPreferredSize(new Dimension(0, 50));
        signupBtn.setBackground(Color.LIGHT_GRAY);
        gbc.gridy = 3;
        mainCtn.add(signupBtn, gbc);

        goToLoginBtn = new JButton("Log in to your Account!");
        goToLoginBtn.setFocusable(false);
        goToLoginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        goToLoginBtn.setForeground(Color.BLUE);
        goToLoginBtn.setContentAreaFilled(false);
        goToLoginBtn.setBorderPainted(false);
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        mainCtn.add(goToLoginBtn, gbc);

        popupCtn = new JPanel();
        popupCtn.setBounds(50, 50, SCREEN_WIDTH, SCREEN_HEIGHT);
        popupCtn.setBackground(new Color(0, 0, 0, 25));
        popupCtn.setLayout(new GridBagLayout());
        popupCtn.setVisible(false);
        this.add(popupCtn, Integer.valueOf(2));
    }
}
