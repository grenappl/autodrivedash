package utils;

public class DatabaseTable {
    private String name;
    private String[] columns;

    public DatabaseTable(String name, String[] columns){
        setName(name);
        setColumns(columns);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }
}
