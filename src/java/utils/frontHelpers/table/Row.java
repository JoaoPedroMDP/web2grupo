package utils.frontHelpers.table;

public class Row {
    private Cell[] cells;

    public Row() {
        this.cells = new Cell[0];
    }

    public Row(Cell[] cells) {
        this.cells = cells;
    }

    public Cell[] getCells() {
        return cells;
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

    public void addCell(Cell cell) {
        Cell[] newCells = new Cell[this.cells.length + 1];
        for(int i = 0; i < this.cells.length; i++) {
            newCells[i] = this.cells[i];
        }

        newCells[newCells.length - 1] = cell;
        this.cells = newCells;
    }
}
