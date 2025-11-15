package autodrivedash.menu.signup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import autodrivedash.App;
import autodrivedash.db.Database;

public class Signup {
    public static void checkEmptyFields(String username, String email, String password, String confPassword)
            throws Exception {
        if (username.isBlank()) {
            throw new Exception("Username field cannot be empty!");
        } else if (email.isBlank()) {
            throw new Exception("Email field cannot be empty!");
        } else if (password.isBlank()) {
            throw new Exception("Password field cannot be empty!");
        } else if (confPassword.isBlank()) {
            throw new Exception("Confirm password field cannot be empty!");
        }
    }

    public static boolean confirmPasswords(String password, String confPassword) {
        return password.equals(confPassword) ? true : false;
    }

    public static ResultSet find(String email) throws SQLException {
        String emailCol = Database.getUserTable().getColumn(2);

        String query = "SELECT * FROM users WHERE " + emailCol + " = ?";
        PreparedStatement stmt = App.getDb().getConn().prepareStatement(query);
        stmt.setString(1, email);
        return stmt.executeQuery();
    }

    public static int register(String username, String email, String password) throws SQLException {
        String tableName = Database.getUserTable().getName();
        String nameCol = Database.getUserTable().getColumn(1);
        String emailCol = Database.getUserTable().getColumn(2);
        String pwCol = Database.getUserTable().getColumn(3);

        // String hashedPassword = null; // need to hash passwords maybe

        String query = "INSERT INTO " + tableName + " (" + nameCol + ", " + emailCol + ", " + pwCol + ") " +
                "VALUES (?, ?, ?)";
        PreparedStatement stmt = App.getDb().getConn().prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, email);
        stmt.setString(3, password);
        return stmt.executeUpdate();
    }

    public static void goLogin() {
        App.getMainMenu().displayLoginPage();
    }
}
