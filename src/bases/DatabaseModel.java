package bases;

import java.sql.Connection;
import utils.DatabaseTable;

public abstract class DatabaseModel {
    private Connection conn;
    private DatabaseTable table;

    public Connection getConn() {
        return this.conn;
    }
    public DatabaseTable getTable() {
        return this.table;
    }

    protected DatabaseModel(Connection conn, DatabaseTable table){
        this.conn = conn;
        this.table = table;
    }
}
