package beans;

import java.util.LinkedHashMap;

import interfaces.Mappable;
import interfaces.Tableable;

public class City extends BaseBean implements Mappable, Tableable{
    private Integer id;
    private String name;
    private Integer state_id;

    public City() {
        this.servlet = "CityServlet";
    }

    public City(Integer id, String name, Integer state_id) {
        this.setId(id);
        this.setName(name);
        this.setState_id(state_id);
        this.servlet = "CityServlet";
    }

    public City(String name, Integer state_id) {
        this.setName(name);
        this.setState_id(state_id);
        this.servlet = "CityServlet";
    }

    @Override
    public void fromMap(LinkedHashMap<String, Object> data) {
        this.setName((String) data.get("name"));
        this.setState_id( (Integer) data.get("state_id"));
    }

    @Override
    public LinkedHashMap<String, Object> toMap() {
        LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("name", this.getName());

        return data;
    }

    @Override
    public String[] getColumns() {
        String[] columns = {"Número", "Cidade", "Ações"};
        return columns;
    }

    @Override
    public LinkedHashMap<String, LinkedHashMap<String, Object>> toTable() {
        LinkedHashMap<String, LinkedHashMap<String, Object>> data = new LinkedHashMap<String, LinkedHashMap<String, Object>>();
        data.put("Número", this.wrapData(this.getId(), false));
        data.put("Cidade", this.wrapData(this.getName(), true));
        data.put("Ações", this.wrapData(this.getActions(), false, true));
        return data;
    }

    public Integer getState_id() {
        return state_id;
    }

    public void setState_id(Integer state_id) {
        this.state_id = state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = Integer.parseInt(state_id);
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
