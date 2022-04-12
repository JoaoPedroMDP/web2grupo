package Beans;

import java.util.LinkedHashMap;

import Interfaces.Bean;
import Interfaces.Mappable;

public class Type implements Mappable, Bean{
    private int id;
    private String name;

    public Type() {}

    public Type(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Type(String name) {
        this.setName(name);
    }

    @Override
    public void fromMap(LinkedHashMap<String, String> data) {
        this.setName((String) data.get("name"));
        
    }

    @Override
    public LinkedHashMap<String, String> toMap() {
        LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
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
