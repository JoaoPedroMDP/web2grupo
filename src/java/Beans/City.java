package Beans;

import java.util.LinkedHashMap;

import Interfaces.Bean;
import Interfaces.Mappable;

public class City implements Mappable, Bean{
    private int id;
    private String name;
    private int state_id;

    public City() {}

    public City(int id, String name, int state_id) {
        this.setId(id);
        this.setName(name);
        this.setState_id(state_id);
    }

    public City(String name, int state_id) {
        this.setName(name);
        this.setState_id(state_id);
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

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
