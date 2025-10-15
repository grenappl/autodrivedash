package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import models.db.User;

public class Database {
    private final String DB_URL = "jdbc:mysql://localhost:3306/car_game"; 
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";

    public User users;

    public Database() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        users = new User(conn);
    }
}
