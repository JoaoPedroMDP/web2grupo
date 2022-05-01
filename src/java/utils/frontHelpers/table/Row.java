package utils.frontHelpers.table;

public class Row {
    private Cell[] cells;

    public Row(Cell[] cells) {
        this.cells = cells;
    }

    public Cell[] getCells() {
        return cells;
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }
}
