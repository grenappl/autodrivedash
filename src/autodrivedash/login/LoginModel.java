package autodrivedash.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import autodrivedash.App;
import autodrivedash.Model;

public class LoginModel extends Model {
    public LoginModel(Connection conn){
        super(conn);
    }

    public ResultSet findByEmailAndPassword(String email, String password) throws SQLException {
        String nameCol = App.db.getUserTable().getColumn(1);
        String emailCol = App.db.getUserTable().getColumn(2);
        
        String query = "SELECT * FROM users WHERE " + nameCol + " = ? AND " + emailCol + " = ?";
        PreparedStatement stmt = getConn().prepareStatement(query);
        stmt.setString(0, email);
        stmt.setString(1, password);
        return stmt.executeQuery();
    }

    public int signup(String username, String email, String password) throws SQLException {
        String tableName =  App.db.getUserTable().getName();
        String nameCol = App.db.getUserTable().getColumn(1);
        String emailCol = App.db.getUserTable().getColumn(2);
        String pwCol = App.db.getUserTable().getColumn(3);

        String hashedPassword = null; // need to hash passwords

        String query = "INSERT INTO" + tableName +
            " (" + nameCol + ", " + emailCol + ", " + pwCol + ") VALUES (?, ?, ?)";
        PreparedStatement stmt = getConn().prepareStatement(query);
        stmt.setString(0, username);
        stmt.setString(1, email);
        stmt.setString(2, hashedPassword);
        return stmt.executeUpdate();
    }
}