package autodrivedash.menu.start;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;
import autodrivedash.db.DatabaseTable;

public class Start {
    public static void showGame() {
        App.getGameSound().getMenuMusic().stop();
        App.getGameSound().setCurrentGameMusic();
        App.getGameSound().getCurrentGameMusic().play();
        App.getMainMenu().startGame();
    }

    public static void exitGame() {
        FXGL.getGameController().exit();
    }

    public static int changeUsername(String username) throws SQLException {
        DatabaseTable usersTable = App.getDb().getUserTable();
        String usernameCol = usersTable.getColumn(1);

        String query = "UPDATE " + usersTable.getName() + " " +
                "SET " + usernameCol + " = ? " +
                "WHERE id = ?";
        PreparedStatement stmt = App.getDb().getConn().prepareStatement(query);
        stmt.setString(1, username);
        stmt.setInt(2, App.getLoggedUserId());
        return stmt.executeUpdate();
    }
}
