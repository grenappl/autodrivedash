package interfaces;

import java.sql.ResultSet;

import bases.DatabaseModel;

public interface DatabaseActionable {
    public DatabaseModel find(String... cols);
    public DatabaseModel insert(String... cols);
    public DatabaseModel update();
    public DatabaseModel delete();

    public DatabaseModel where(String col);
    public DatabaseModel equal(Object val);
    public DatabaseModel notEqual(Object val);
    public DatabaseModel gt(Object val);
    public DatabaseModel lt(Object val);

    public DatabaseModel and(String... col);
    public DatabaseModel or(String... col);
    public DatabaseModel not(String... col);

    public ResultSet get() throws Exception;
    public int exec() throws Exception;
}