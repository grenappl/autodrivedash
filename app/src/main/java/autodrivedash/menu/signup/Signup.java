package autodrivedash.menu.signup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import autodrivedash.App;
import autodrivedash.db.Database;
import autodrivedash.db.DatabaseTable;

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

    public static boolean isFound(String email) throws SQLException {
        String emailCol = App.getDb().getUserTable().getColumn(2);

        String query = "SELECT * FROM users WHERE " + emailCol + " = ?";
        PreparedStatement stmt = App.getDb().getConn().prepareStatement(query);
        stmt.setString(1, email);
        ResultSet result = stmt.executeQuery();
        return (result.next()) ? true : false;
    }

    public static int register(String username, String email, String password) throws SQLException {
        DatabaseTable userTable = App.getDb().getUserTable();
        String tableName = userTable.getName();
        String nameCol = userTable.getColumn(1);
        String emailCol = userTable.getColumn(2);
        String pwCol = userTable.getColumn(3);

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
        // show popup of successful registration in login here
        App.getMainMenu().displayLoginPage();
    }
}
