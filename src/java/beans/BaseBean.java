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

    public LinkedHashMap<String, Object> getActions(LinkedHashMap<String, String> requiredActions) {
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
        if(requiredActions != null){
            for(String actionName : requiredActions.keySet()){
                result.put(actionName, new Action(requiredActions.get(actionName), this.servlet, actionName, this.getId(), true));
            }
        }

        return result;
    }

    public LinkedHashMap<String, Object> getActions() {
        LinkedHashMap<String, String> actions = new LinkedHashMap<String, String>(){{
            put("edit", "Editar");
            put("delete", "Excluir");
            put("view", "Visualizar");
        }};
        return this.getActions(actions);
    }
}
