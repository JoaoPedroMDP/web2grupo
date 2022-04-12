package Beans;

import java.util.LinkedHashMap;

import Interfaces.Bean;
import Interfaces.Mappable;

public class Ticket implements Mappable, Bean{
    private int id;
    private String description;
    private String state;
    private String solution;
    private int product_id;
    private int type_id;
    private int user_id;
    
    public Ticket() {}

    public Ticket(int id, String description, String state, String solution, int product_id, int type_id,
            int user_id) {
        this.setId(id);
        this.setDescription(description);
        this.setState(state);
        this.setSolution(solution);
        this.setProduct_id(product_id);
        this.setType_id(type_id);
        this.setUser_id(user_id);
    }

    public Ticket(String description, String state, String solution, int product_id, int type_id,
            int user_id) {
        this.setDescription(description);
        this.setState(state);
        this.setSolution(solution);
        this.setProduct_id(product_id);
        this.setType_id(type_id);
        this.setUser_id(user_id);
    }  

    @Override
    public void fromMap(LinkedHashMap<String, String> data) {
        this.setDescription(data.get("description"));
        this.setState(data.get("state"));
        this.setSolution(data.get("solution"));
        this.setProduct_id(Integer.parseInt(data.get("product_id")));
        this.setType_id(Integer.parseInt(data.get("type_id")));
        this.setUser_id(Integer.parseInt(data.get("user_id")));
    }

    @Override
    public LinkedHashMap<String, String> toMap() {
        LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
        data.put("description", this.getDescription());
        data.put("state", this.getState());
        data.put("solution", this.getSolution());
        data.put("product_id", String.valueOf(this.getProduct_id()));
        data.put("type_id", String.valueOf(this.getType_id()));
        data.put("user_id", String.valueOf(this.getUser_id()));

        return data;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = Integer.valueOf(user_id);
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = Integer.valueOf(type_id);
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = Integer.valueOf(id);
    }
}
