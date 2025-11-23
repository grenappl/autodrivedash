package autodrivedash.menu.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import autodrivedash.App;
import autodrivedash.db.DatabaseTable;
import autodrivedash.menu.start.StartController;

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

    public static void setUser(ResultSet result) throws SQLException {
        DatabaseTable userTable = App.getDb().getUserTable();
        StartController startCtrl = App.getMainMenu().getStartController();
        startCtrl.getUsernameLabel().setText(result.getString(userTable.getColumn(1)));
        startCtrl.getEmailLabel().setText(result.getString(userTable.getColumn(2)));
        startCtrl.getHighestScoreLabel().setText(String.valueOf(result.getInt(userTable.getColumn(4))));
    }
}