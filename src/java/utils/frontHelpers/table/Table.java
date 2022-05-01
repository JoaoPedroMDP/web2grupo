package utils.frontHelpers.table;

public class Table {
    private Row[] rows;
    private Column[] columns;

    public Table(Column[] columns, Row[] rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public Row[] getRows() {
        return rows;
    }

    public void setRows(Row[] rows) {
        this.rows = rows;
    }

    public Column[] getColumns() {
        return columns;
    }

    public void setColumns(Column[] columns) {
        this.columns = columns;
    }
}