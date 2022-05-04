package beans;

import java.util.LinkedHashMap;

import interfaces.Mappable;
import interfaces.Tableable;

public class Category extends BaseBean implements Mappable, Tableable{
    private Integer id;
    private String name;

    public Category() {
        this.servlet = "CategoryServlet";
    }

    public Category(Integer id, String name) {
        this.setId(id);
        this.setName(name);
        this.servlet = "CategoryServlet";
    }

    public Category(String name) {
        this.setName(name);
        this.servlet = "CategoryServlet";
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
        String[] columns = {"Número", "Categoria", "Ações"};
        return columns;
    }

    @Override
    public LinkedHashMap<String, LinkedHashMap<String, Object>> toTable() {
        LinkedHashMap<String, String> actions = new LinkedHashMap<String, String>(){{
            put("edit", "Editar");
            put("delete", "Excluir");
        }};

        LinkedHashMap<String, LinkedHashMap<String, Object>> data = new LinkedHashMap<String, LinkedHashMap<String, Object>>();
        data.put("Número", this.wrapData(this.getId(), false));
        data.put("Categoria", this.wrapData(this.getName(), true));
        data.put("Ações", this.wrapData(this.getActions(actions), false, true));
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
