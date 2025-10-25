package autodrivedash.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/car_game";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection conn;
    public static Connection getConn(){ return conn; }

    private static DatabaseTable userTable = new DatabaseTable(
        "users",
        new String[]{"username", "email", "password"}
    );
    public static DatabaseTable getUserTable(){ return userTable; }

    public Database() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
