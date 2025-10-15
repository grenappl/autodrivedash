package app;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

public class App {
    public static final String NAME = "Auto Drive Dash";

    public static Database db;
    public static Window window;

    public App(){
        // try {
        //     db = new Database();
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        SwingUtilities.invokeLater(() -> {
            window = new Window();
            window.setVisible(true);
        });
    }
}