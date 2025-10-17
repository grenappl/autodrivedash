package models;

import utils.DatabaseTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bases.DatabaseModel;

public class LoginModel extends DatabaseModel {
    public LoginModel(Connection conn, DatabaseTable table){
        super(conn, table);
    }

    public ResultSet findByEmailAndPassword(String email, String password) throws SQLException {
        String nameCol = getTable().getColumn(1);
        String emailCol = getTable().getColumn(2);
        
        String query = "SELECT * FROM users WHERE " + nameCol + " = ? AND " + emailCol + " = ?";
        PreparedStatement stmt = getConn().prepareStatement(query);
        stmt.setString(0, email);
        stmt.setString(1, password);
        return stmt.executeQuery();
    }

    public int signup(String username, String email, String password) throws SQLException {
        String nameCol = getTable().getColumn(1);
        String emailCol = getTable().getColumn(2);
        String pwCol = getTable().getColumn(3);

        String hashedPassword = null; // need to hash passwords

        String query = "INSERT INTO" + getTable().getName() +
            " (" + nameCol + ", " + emailCol + ", " + pwCol + ") VALUES (?, ?, ?)";
        PreparedStatement stmt = getConn().prepareStatement(query);
        stmt.setString(0, username);
        stmt.setString(1, email);
        stmt.setString(2, hashedPassword);
        return stmt.executeUpdate();
    }
}