package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import models.LoginModel;
import utils.DatabaseTable;

public class Database {
    private final String URL = "jdbc:mysql://localhost:3306/car_game";
    private final String USER = "root";
    private final String PASSWORD = "";

    private final DatabaseTable USER_TABLE = new DatabaseTable(
        "users",
        new String[]{"username", "email", "password"}
    );

    public LoginModel users;

    public Database() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        users = new LoginModel(conn, USER_TABLE);
        System.out.println("Database connected successfully!");
    }

    public DatabaseTable getUserTable(){
        return this.USER_TABLE;
    }
}
