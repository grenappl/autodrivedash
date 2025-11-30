package autodrivedash.menu.leaderboard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;
import autodrivedash.db.DatabaseTable;

public class Leaderboard {
    public static void setUserScore() {
        DatabaseTable leaderboardTable = App.getDb().getLeaderboardTable();
        String userIdCol = leaderboardTable.getColumn(1);
        String scoreCol = leaderboardTable.getColumn(2);

        String query = "INSERT INTO " + leaderboardTable.getName() + " (" + userIdCol + ", " + scoreCol + ") " +
                "VALUES (?, ?)";
        try {
            PreparedStatement stmt = App.getDb().getConn().prepareStatement(query);
            stmt.setInt(1, App.getLoggedUserId());
            stmt.setInt(2, (int) FXGL.getd("SCORE"));
            int affected = stmt.executeUpdate();
            System.out.println("leaderboard row: " + affected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getScoresOrdered() throws SQLException {
        Statement stmt = App.getDb().getConn().createStatement();
        String query = "SELECT ROW_NUMBER() OVER (ORDER BY score DESC) AS row_count, \r\n" + //
                "users.username, leaderboard.score FROM leaderboard\r\n" + //
                "JOIN users ON users.id = user_id\r\n" + //
                "ORDER BY score DESC LIMIT 10";
        return stmt.executeQuery(query);
    }

    public static ResultSet getUserBestScore(String email) throws SQLException {
        Statement stmt = App.getDb().getConn().createStatement();
        String query = "SELECT * FROM " +
                "(SELECT ROW_NUMBER() OVER (ORDER BY score DESC) AS row_count, " +
                "users.username, users.email, leaderboard.score FROM leaderboard " +
                "JOIN users ON users.id = user_id " +
                "ORDER BY score DESC) AS subtable " +
                " WHERE email = '" + email + "' LIMIT 1";
        return stmt.executeQuery(query);
    }
}
