package autodrivedash.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String URL = "jdbc:mysql://localhost:3306/car_game";
    private final String USER = "root";
    private final String PASSWORD = "";

    private Connection conn;
    public Connection getConn(){ return this.conn; }

    private DatabaseTable userTable = new DatabaseTable(
        "users",
        new String[]{"username", "email", "password"}
    );
    public DatabaseTable getUserTable(){ return this.userTable; }

    public Database() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
