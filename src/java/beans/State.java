package beans;

import java.util.LinkedHashMap;

import interfaces.Mappable;
import interfaces.Tableable;

public class State extends BaseBean implements Mappable, Tableable{
    private Integer id;
    private String name;

    public State() {
        this.servlet = "StateServlet";
    }

    public State(Integer id, String name) {
        this.setId(id);
        this.setName(name);
        this.servlet = "ProductServlet";
    }

    public State(String name) {
        this.setName(name);
        this.servlet = "ProductServlet";
    }

    @Override
    public void fromMap(LinkedHashMap<String, Object> data) {
        this.setName((String) data.get("name"));
        
    }

    @Override
    public LinkedHashMap<String, Object> toMap() {
        LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("name", this.getName());

        return data;
    }

    @Override
    public String[] getColumns() {
        String[] columns = {"Número", "Estado", "Ações"};
        return columns;
    }

    @Override
    public LinkedHashMap<String, LinkedHashMap<String, Object>> toTable() {
        LinkedHashMap<String, LinkedHashMap<String, Object>> data = new LinkedHashMap<String, LinkedHashMap<String, Object>>();
        data.put("Número", this.wrapData(this.getId(), false));
        data.put("Estado", this.wrapData(this.getName(), true));
        data.put("Ações", this.wrapData(this.getActions(), false, true));
        return data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
