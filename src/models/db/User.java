package models.db;

import java.sql.Statement;

import interfaces.DatabaseActionable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User implements DatabaseActionable {
    private Connection conn;

    public User(Connection conn){
        this.conn = conn;
    }

    @Override
    public ResultSet find(Object... args) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM users WHERE user_id = ?");
            stmt.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResultSet findById(int id) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM users WHERE user_id = ?");
            prepStmt.setInt(1, id);
            ResultSet result = prepStmt.executeQuery();
            prepStmt.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int create(Object... args) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public int update(Object... args) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Object... args) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
