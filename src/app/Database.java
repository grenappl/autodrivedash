package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import models.GameModel;
import models.LoginModel;
import models.SignupModel;
import utils.DatabaseTable;

public class Database {
    private Connection conn;
    private final String DB_URL = "jdbc:mysql://localhost:3306/car_game";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";

    private DatabaseTable userTable = new DatabaseTable(
        "users",
        new String[]{"username", "email", "password"}
    );

    public DatabaseTable getUserTable(){
        return this.userTable;
    }

    public Database() {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        App.window.getLoginController().setModel(new LoginModel(conn));
        App.window.getSignupController().setModel(new SignupModel(conn));
        App.window.getGameController().setModel(new GameModel(conn));
    }
}
