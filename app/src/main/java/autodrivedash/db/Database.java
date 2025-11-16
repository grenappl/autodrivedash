package autodrivedash.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/autodrivedash";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection conn;

    public Connection getConn() {
        return this.conn;
    }

    private DatabaseTable userTable = new DatabaseTable(
            "users",
            new String[] { "username", "email", "password", "highest_score" });

    public DatabaseTable getUserTable() {
        return userTable;
    }

    public Database() {
        try {
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}
