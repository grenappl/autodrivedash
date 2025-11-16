package autodrivedash.menu.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import autodrivedash.App;
import autodrivedash.db.Database;
import autodrivedash.db.DatabaseTable;

public class Login {
    public static void checkEmptyFields(String email, String password) throws Exception {
        if (email.isBlank()) {
            throw new Exception("Email field cannot be empty!");
        } else if (password.isBlank()) {
            throw new Exception("Password field cannot be empty!");
        }
    }

    public static ResultSet find(String email, String password) throws SQLException {
        DatabaseTable userTable = App.getDb().getUserTable();
        String emailCol = userTable.getColumn(2);
        String passwordCol = userTable.getColumn(3);

        String query = "SELECT * FROM users WHERE " + emailCol + " = ? AND " + passwordCol + " = ?";
        PreparedStatement stmt = App.getDb().getConn().prepareStatement(query);
        stmt.setString(1, email);
        stmt.setString(2, password);
        return stmt.executeQuery();
    }

    public static void start(ResultSet result) throws SQLException {
        DatabaseTable userTable = App.getDb().getUserTable();
        System.out.println(result.getString(userTable.getColumn(1)));
        System.out.println(result.getString(userTable.getColumn(2)));
        System.out.println(result.getString(userTable.getColumn(3)));
        // add login details to start page
        App.getMainMenu().displayStartPage();
    }
}