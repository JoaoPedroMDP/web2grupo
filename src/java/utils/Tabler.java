package utils;

import java.util.LinkedHashMap;

import interfaces.Tableable;
import utils.frontHelpers.table.Action;
import utils.frontHelpers.table.Cell;
import utils.frontHelpers.table.Column;
import utils.frontHelpers.table.Row;
import utils.frontHelpers.table.Table;

public class Tabler<T extends Tableable> {
    private Column[] columns;
    private Row[] rows;
    private String permissionLevel;
    
    public Tabler(String[] columns, String permissionLevel) {
        this.columns = this.wrapColumns(columns);
        this.permissionLevel = permissionLevel;
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
        LinkedHashMap<String, LinkedHashMap<String, Object>> items = t.toTable();
        for (String column : t.getColumns()) {
            LinkedHashMap<String, Object> item = items.get(column);
            LinkedHashMap<String, Object> actions = (LinkedHashMap<String, Object>) item.get("actions");
            if (actions != null){
                newRow.addCell(
                    new Cell(
                        item.get("data"),
                        (Boolean) item.get("isHeader"),
                        this.filterActionsByRole(actions)
                    )
                );
            }else{
                newRow.addCell(
                    new Cell(
                        item.get("data"),
                        (Boolean) item.get("isHeader")
                    )
                );
            }
        }

        return newRow;
    }

    private Action[] filterActionsByRole(LinkedHashMap<String, Object> actions) {
        String[] levels = {"view", "edit", "delete"};
        Action[] allowedActions = new Action[levels.length];

        Integer permissionLevel = 0;
        if (this.permissionLevel.equals("admin")){
            permissionLevel = 2;
        }else if(this.permissionLevel.equals("employee")){
            permissionLevel = 1;
        }else{
            permissionLevel = 0;
        }

        for(int i = 0; i <= permissionLevel; i++){
            Action action = (Action) actions.get(levels[i]);
            if(action != null){
                allowedActions[i] = action;
            }
        }

         return allowedActions;   
    }

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
