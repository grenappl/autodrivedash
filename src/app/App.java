package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

public class App {
    public static final String NAME = "Auto Drive Dash";

    private final String DB_URL = "jdbc:mysql://localhost:3306/car_game"; 
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";

    public static Connection dbConn;
    public static Window window;

    public App(){
        // try {
        //     dbConn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        SwingUtilities.invokeLater(() -> {
            window = new Window();
        });
    }
}