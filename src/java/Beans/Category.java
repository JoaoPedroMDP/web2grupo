package Beans;

import java.util.LinkedHashMap;

import Interfaces.Bean;
import Interfaces.Mappable;

public class Category implements Mappable, Bean{
    private int id;
    private String name;

    public Category() {}

    public Category(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Category(String name) {
        this.setName(name);
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
