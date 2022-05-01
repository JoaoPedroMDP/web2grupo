package utils.frontHelpers.table;

public class Cell {
    private Object data;
    private Boolean isHeader;
    private Boolean haveActions;
    private Action[] actions;

    public Cell(Object data, Boolean isHeader) {
        this.data = data;
        this.isHeader = isHeader;
        this.haveActions = false;
    }

    public Cell(Object data, Boolean isHeader, Action[] actions) {
        this.data = data;
        this.isHeader = isHeader;
        this.haveActions = true;
        this.actions = actions;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getIsHeader() {
        return isHeader;
    }

    public void setIsHeader(Boolean isHeader) {
        this.isHeader = isHeader;
    }

    public Boolean getHaveActions() {
        return haveActions;
    }

    public void setHaveActions(Boolean haveActions) {
        this.haveActions = haveActions;
    }

    public Action[] getActions() {
        return actions;
    }

    public void setActions(Action[] actions) {
        this.actions = actions;
    }
    
}
