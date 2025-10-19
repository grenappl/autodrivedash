package autodrivedash.signup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import autodrivedash.App;

public class SignupController {
    private SignupModel signupModel;
    public void setModel(SignupModel model) {
        this.signupModel = model;
    }

    // public SignupController(SignupPage signupPage){
    //     super(signupPage);
    //     getSignupPage().getSignupBtn().addMouseListener(handleSignupBtnActions());
    //     getSignupPage().getGoToLoginBtn().addActionListener(showLogin());
    // }

    // public MouseListener handleSignupBtnActions(){
    //     SignupPage sp = this.getSignupPage();
    //     Color origColor = sp.getSignupBtn().getBackground();

    //     return new MouseListener() {
    //         @Override
    //         public void mouseEntered(MouseEvent e) {
    //             sp.getSignupBtn().setBackground(Color.GRAY);
    //         }
    //         @Override
    //         public void mouseExited(MouseEvent e) {
    //             sp.getSignupBtn().setBackground(origColor);
    //         }
    //         @Override
    //         public void mouseClicked(MouseEvent e) {
    //             String username = sp.getUsernameField().getText();
    //             String email = sp.getEmailField().getText();
    //             String password = String.valueOf(sp.getPasswordField().getPassword());
    //             String confPassword = String.valueOf(sp.getConfirmPasswordField().getPassword());

    //             System.out.println(
    //                 username + " | " +
    //                 email + " | " +
    //                 password + " | " +
    //                 confPassword);
    //             if(password.equals(confPassword)){
    //                 try {
    //                     int result = AutoDriveDash.db.users.signup(username, email, password);
    //                     System.out.println(result);
    //                 } catch (SQLException e1) {
    //                     e1.printStackTrace();
    //                 }
    //             } else {
    //                 System.out.println("Passwords don't match!");
    //             }
    //         }

    //         @Override
    //         public void mousePressed(MouseEvent e) {}
    //         @Override
    //         public void mouseReleased(MouseEvent e) {}
    //     };
    // }
    // public ActionListener showLogin(){
    //     return new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             AutoDriveDash.window.display(AutoDriveDash.window.LOGIN_KEY);
    //         }
    //     };
    // }
}
