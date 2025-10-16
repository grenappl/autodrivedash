package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    private List<String> query = new ArrayList<>();
    private List<Object> params = new ArrayList<>();

    public void setQuery(List<String> query) {
        this.query = query;
    }
    public void setParams(List<Object> params) {
        this.params = params;
    }

    public List<Object> getParams() {
        return params;
    }
    public List<String> getQuery() {
        return query;
    }

    public void formatSelect(String tableName, String... cols){
        this.getQuery().add("SELECT");
        if(cols.length == 0) this.getQuery().add("*");
        else {
            this.getQuery().add("(" + String.join(", ", cols) + ")");
        }
        this.getQuery().add("FROM " + tableName); 
    }

    public void formatInsert(String tableName, String... cols){
        this.getQuery().add("INSERT INTO " + tableName + " (");
        if(cols.length == 0) this.getQuery().add(String.join(", ", tableName) + ")");
        else {
            this.getQuery().add(String.join(", ", cols) + " )");
        }
    }
    public void formatValues(Object... vals){
        this.getQuery().add("VALUES (");
        List<String> temp = new ArrayList<>();
        for(Object val : vals){
            temp.add("?");
            this.getParams().add(val);
        }
        this.getQuery().add(String.join(", ", temp) + " )");
    }

    public PreparedStatement build(Connection conn) throws SQLException {
        String sql = null;
        if(!query.isEmpty()) sql = String.join(" ", query);
        PreparedStatement stmt = conn.prepareStatement(sql);
        for (int i = 0; i < params.size(); i++) {
            stmt.setObject(i + 1, params.get(i));
        }
        System.out.println(sql);
        clearLists();
        return stmt;
    }

    private void clearLists(){
        query.clear();
        params.clear();
    }
}
