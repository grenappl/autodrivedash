package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import models.db.Users;
import utils.DatabaseTable;

public class Database {
    private final String URL = "jdbc:mysql://localhost:3306/car_game";
    private final String USER = "root";
    private final String PASSWORD = "";

    private final DatabaseTable userTable = new DatabaseTable(
        "users",
        new String[]{"username", "email", "password"}
    );

    public Users users;

    public Database() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        users = new Users(conn, userTable);
        System.out.println("Database connected successfully.");
    }

    public DatabaseTable getUserTable(){
        return this.userTable;
    }
}
