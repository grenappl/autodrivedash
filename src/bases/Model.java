package bases;

import java.sql.Connection;

public abstract class Model {
    private Connection conn;

    public Connection getConn() {
        return this.conn;
    }
    public Model(Connection conn){
        this.conn = conn;

    }
}
