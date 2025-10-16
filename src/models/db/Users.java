package models.db;

import utils.DatabaseTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import bases.DatabaseModel;

public class Users extends DatabaseModel {
    public Users(Connection conn, DatabaseTable table){
        super(conn, table);
    }

    public ResultSet findByEmailAndPassword(String email, String password){
        try {
            String emailCol = this.getTable().getColumns()[1];
            String passCol = this.getTable().getColumns()[2];
            return this.find()
                .where(emailCol).equal(email)
                .and(passCol).equal(password).get();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int createUser(String username, String email, String password) throws SQLException{
        String hashPassword; // need to hash passwords
        return this.insert().values(username, email, password).exec();
    }
}