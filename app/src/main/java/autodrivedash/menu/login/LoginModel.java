package autodrivedash.menu.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import autodrivedash.App;
import autodrivedash.db.Database;

public class LoginModel {
    public ResultSet findByEmailAndPassword(String email, String password) throws SQLException {
        String nameCol = Database.getUserTable().getColumn(1);
        String emailCol = Database.getUserTable().getColumn(2);
        
        String query = "SELECT * FROM users WHERE " + nameCol + " = ? AND " + emailCol + " = ?";
        PreparedStatement stmt = Database.getConn().prepareStatement(query);
        stmt.setString(0, email);
        stmt.setString(1, password);
        return stmt.executeQuery();
    }

    public int signup(String username, String email, String password) throws SQLException {
        String tableName =  Database.getUserTable().getName();
        String nameCol = Database.getUserTable().getColumn(1);
        String emailCol = Database.getUserTable().getColumn(2);
        String pwCol = Database.getUserTable().getColumn(3);

        String hashedPassword = null; // need to hash passwords

        String query = "INSERT INTO" + tableName +
            " (" + nameCol + ", " + emailCol + ", " + pwCol + ") VALUES (?, ?, ?)";
        PreparedStatement stmt = Database.getConn().prepareStatement(query);
        stmt.setString(0, username);
        stmt.setString(1, email);
        stmt.setString(2, hashedPassword);
        return stmt.executeUpdate();
    }
}