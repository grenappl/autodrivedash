package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import app.settings.Database;

public class App implements Database {
    public static final String GAME_TITLE = "Auto Drive Dash";

    public static Connection dbConn;
    public static Window window;

    public App(){
        try {
            dbConn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            // System.exit(1);
        }
        window = new Window();
    }
}