package utils.frontHelpers.table;

public class Table {
    private Row[] rows;
    private Column[] columns;
    private String title;

    public Table(String title, Column[] columns, Row[] rows) {
        this.title = title;
        this.columns = columns;
        this.rows = rows;
    }

    public Row[] getRows() {
        return rows;
    }

    public void setRows(Row[] rows) {
        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Column[] getColumns() {
        return columns;
    }

    public void setColumns(Column[] columns) {
        this.columns = columns;
    }
}