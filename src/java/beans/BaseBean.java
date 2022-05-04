package beans;

import java.util.LinkedHashMap;

import interfaces.Bean;
import utils.frontHelpers.table.Action;

public abstract class BaseBean implements Bean{
    protected String servlet;
    
    protected LinkedHashMap<String, Object> wrapData(Object data, boolean isHeader) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("data", data);
        result.put("isHeader", isHeader);
        return result;
    }

    protected LinkedHashMap<String, Object> wrapData(Object data, boolean isHeader, boolean haveActions) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("isHeader", isHeader);
        result.put("actions", data);
        return result;
    }

    public LinkedHashMap<String, Object> getActions() {
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("edit", new Action("Editar", this.servlet + "?action=edit&id=" + this.getId(), false));
        result.put("view", new Action("Visualizar", this.servlet + "?action=view&id=" + this.getId(), false));
        result.put("delete", new Action("Remover", this.servlet + "?action=delete&id=" + this.getId(), false));
        return result;
    }
}
