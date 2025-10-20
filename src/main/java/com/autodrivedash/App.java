package autodrivedash;

import java.io.IOException;

import autodrivedash.db.Database;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private static String name = "Auto Drive Dash";
    public static Database db;
    public static Window window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            window = new Window();
            // db = new Database();
            window.setTitle(name);
            window.show();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}