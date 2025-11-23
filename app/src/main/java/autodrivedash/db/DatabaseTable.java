package autodrivedash.db;

public class DatabaseTable {
    private String name;
    private String[] columns;

    public DatabaseTable(String name, String[] columns) {
        this.name = name;
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public String getColumn(int i) {
        if (i > 0)
            return columns[i - 1];
        else
            return "";
    }
}
