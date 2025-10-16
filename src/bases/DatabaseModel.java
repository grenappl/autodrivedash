package bases;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DatabaseActionable;
import utils.QueryBuilder;
import utils.DatabaseTable;

public abstract class DatabaseModel implements DatabaseActionable {
    private Connection conn;
    private DatabaseTable table;
    private QueryBuilder qb;

    public DatabaseTable getTable() {
        return this.table;
    }

    protected DatabaseModel(Connection conn, DatabaseTable table){
        this.conn = conn;
        this.table = table;
        qb = new QueryBuilder();
    }

    public DatabaseModel find(String... cols){
        qb.formatSelect(table.getName(), cols); return this;
    }
    
    public DatabaseModel insert(String... cols){
        qb.formatInsert(table.getName(), cols); return this;
    }
    public DatabaseModel values(Object... vals){
        qb.formatValues(vals); return this;
    }
    
    public DatabaseModel update(){
        qb.getQuery().add("UPDATE " + table.getName() + " SET"); return this;
    }
    public DatabaseModel set(String col){
        qb.getQuery().add(col); return this;
    }

    public DatabaseModel delete(){
        qb.getQuery().add("DELETE FROM " + table.getName()); return this;
    }

    public DatabaseModel where(String col){
        qb.getQuery().add("WHERE " + col); return this;
    }

    public DatabaseModel equal(Object val){
        qb.getQuery().add("= ?");
        qb.getParams().add(val); return this;
    }

    public DatabaseModel notEqual(Object val) {
        qb.getQuery().add("!= ?");
        qb.getParams().add(val); return this;
    }

    public DatabaseModel gt(Object val) {
        qb.getQuery().add("> ?");
        qb.getParams().add(val); return this;
    }
    public DatabaseModel lt(Object val) {
        qb.getQuery().add("< ?");
        qb.getParams().add(val); return this;
    }

    public DatabaseModel and(String... col) {
        qb.getQuery().add("AND " + col); return this;
    }
    public DatabaseModel or(String... col) {
        qb.getQuery().add("OR " + col); return this;
    }
    public DatabaseModel not(String... col) {
        qb.getQuery().add("NOT " + col); return this;
    }

    public ResultSet get() throws SQLException {
        PreparedStatement stmt = qb.build(this.conn);
        return stmt.executeQuery();
    }
    public int exec() throws SQLException {
        PreparedStatement stmt = qb.build(this.conn);
        return stmt.executeUpdate();
    }
}
