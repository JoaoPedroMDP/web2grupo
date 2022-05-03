package beans;

import java.util.LinkedHashMap;

import interfaces.Bean;
import interfaces.Mappable;
import interfaces.Tableable;

public class Ticket implements Mappable, Bean, Tableable{
    private Integer id;
    private String description;
    private String state;
    private String solution;
    private Integer product_id;
    private Integer type_id;
    private Integer user_id;
    
    public Ticket() {}

    public Ticket(Integer id, String description, String state, String solution, Integer product_id, Integer type_id,
            Integer user_id) {
        this.setId(id);
        this.setDescription(description);
        this.setState(state);
        this.setSolution(solution);
        this.setProduct_id(product_id);
        this.setType_id(type_id);
        this.setUser_id(user_id);
    }

    public Ticket(String description, String state, String solution, Integer product_id, Integer type_id,
            Integer user_id) {
        this.setDescription(description);
        this.setState(state);
        this.setSolution(solution);
        this.setProduct_id(product_id);
        this.setType_id(type_id);
        this.setUser_id(user_id);
    }  

    @Override
    public void fromMap(LinkedHashMap<String, Object> data) {
        this.setDescription( (String) data.get("description"));
        this.setState( (String) data.get("state"));
        this.setSolution( (String) data.get("solution"));
        this.setProduct_id(Integer.parseInt( (String) data.get("product_id")));
        this.setType_id(Integer.parseInt( (String) data.get("type_id")));
        this.setUser_id(Integer.parseInt( (String) data.get("user_id")));
    }

    @Override
    public LinkedHashMap<String, Object> toMap() {
        LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("description", this.getDescription());
        data.put("state", this.getState());
        data.put("solution", this.getSolution());
        data.put("product_id", String.valueOf(this.getProduct_id()));
        data.put("type_id", String.valueOf(this.getType_id()));
        data.put("user_id", String.valueOf(this.getUser_id()));

        return data;
    }

    @Override
    public String[] getColumns() {
        String[] columns = {"Número", "Descrição", "Estado", "Solução"};
        return columns;
    }

    @Override
    public LinkedHashMap<String, Object> toTable() {
        LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("Número", this.getId());
        data.put("Descrição", this.getDescription());
        data.put("Estado", this.getState().equals("open") ? "Aberto" : "Fechado");
        data.put("Solução", this.getSolution());
        return data;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = Integer.valueOf(user_id);
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = Integer.valueOf(type_id);
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = Integer.valueOf(product_id);
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = Integer.valueOf(id);
    }
}
