package interfaces;

import java.sql.ResultSet;

public interface DatabaseActionable {
    public ResultSet find(Object... args);
    public ResultSet findById(int id);
    public int create(Object... args);
    public int update(Object... args);
    public int delete(Object... args);
}