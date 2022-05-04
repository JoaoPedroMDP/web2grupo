package beans;

import java.util.LinkedHashMap;

import interfaces.Bean;
import interfaces.Mappable;

public class Type implements Mappable, Bean{
    private Integer id;
    private String name;

    public Type() {}

    public Type(Integer id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Type(String name) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
