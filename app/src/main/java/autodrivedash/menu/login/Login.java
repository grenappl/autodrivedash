package autodrivedash.menu.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import autodrivedash.App;
import autodrivedash.db.Database;

public class Login {
    public static void checkEmptyFields(String email, String password) throws Exception {
        if (email.isBlank()) {
            throw new Exception("Email field cannot be empty!");
        } else if (password.isBlank()) {
            throw new Exception("Password field cannot be empty!");
        }
    }

    public static ResultSet find(String email, String password) throws SQLException {
        String emailCol = Database.getUserTable().getColumn(2);
        String passwordCol = Database.getUserTable().getColumn(3);

        String query = "SELECT * FROM users WHERE " + emailCol + " = ? AND " + passwordCol + " = ?";
        PreparedStatement stmt = App.getDb().getConn().prepareStatement(query);
        stmt.setString(1, email);
        stmt.setString(2, password);
        return stmt.executeQuery();
    }

    public static void goStart(ResultSet result) throws SQLException {
        System.out.println(result.getString("username"));
        System.out.println(result.getString("email"));
        System.out.println(result.getString("password"));
        // add login details to start page
        App.getMainMenu().displayStartPage();
    }
}