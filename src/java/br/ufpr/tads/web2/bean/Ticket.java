package br.ufpr.tads.web2.bean;

import java.util.LinkedHashMap;

import br.ufpr.tads.web2.interfaces.Bean;
import br.ufpr.tads.web2.interfaces.Mappable;

public class Ticket implements Mappable, Bean {

  private Integer id;
  private String description;
  private String state;
  private String solution;
  private Integer product_id;
  private Integer type_id;
  private Integer user_id;

  public Ticket() {
  }

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

  @Override
  public void fromMap(LinkedHashMap<String, String> data) {
    this.setDescription((String) data.get("description"));
    this.setState((String) data.get("state"));
    this.setSolution((String) data.get("solution"));
    this.setProduct_id(Integer.parseInt((String) data.get("product_id")));
    this.setType_id(Integer.parseInt((String) data.get("type_id")));
    this.setUser_id(Integer.parseInt((String) data.get("user_id")));
  }

  @Override
  public LinkedHashMap<String, String> toMap() {
    LinkedHashMap<String, String> data = new LinkedHashMap<>();
    data.put("description", this.getDescription());
    data.put("state", this.getState());
    data.put("solution", this.getSolution());
    data.put("product_id", String.valueOf(this.getProduct_id()));
    data.put("type_id", String.valueOf(this.getType_id()));
    data.put("user_id", String.valueOf(this.getUser_id()));

    return data;
  }

  @Override
  public LinkedHashMap<String, String> toMap(Boolean allString) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
}
