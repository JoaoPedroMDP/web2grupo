package utils;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import interfaces.Tableable;
import utils.frontHelpers.table.Cell;
import utils.frontHelpers.table.Column;
import utils.frontHelpers.table.Row;
import utils.frontHelpers.table.Table;

public class Tabler<T extends Tableable> {
    private Column[] columns;
    private Row[] rows;
    
    public Tabler(String[] columns) {
        this.columns = this.wrapColumns(columns);
    }

    private Column[] wrapColumns(String[] columns){
        Column[] columnsWrapped = new Column[columns.length];
        for(int i = 0; i < columns.length; i++){
            columnsWrapped[i] = new Column(columns[i]);
        }
        return columnsWrapped;
    }

    public void wrapData(T[] data){
        Row[] wrappedRows = new Row[data.length];
        for(int i = 0; i < data.length; i++){
            wrappedRows[i] = this.wrapObjectInRow(data[i]);
        }
        this.rows = wrappedRows;
    }

    private Row wrapObjectInRow(T t) {
        Row newRow = new Row();
        LinkedHashMap<String, Object> items = t.toTable();
        for (String column : t.getColumns()) {
            newRow.addCell(new Cell(items.get(column), false));
        }

        return newRow;
    }

    // public void insertActions() {
    //     for(Row row : this.rows){

    //     }
    // }

    public Table tablefy() {
        return new Table(this.columns, this.rows);
    }

    public Column[] getColumns() {
        return columns;
    }

    public void setColumns(Column[] columns) {
        this.columns = columns;
    }

    public Row[] getRows() {
        return rows;
    }

    public void setRows(Row[] rows) {
        this.rows = rows;
    }
}
