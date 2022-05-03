package br.ufpr.tads.web2.bean;

import java.util.LinkedHashMap;

import br.ufpr.tads.web2.interfaces.Bean;
import br.ufpr.tads.web2.interfaces.Mappable;

public class City implements Mappable, Bean {

  private Integer id;
  private String name;
  private Integer state_id;

  public City() {
  }

  public City(Integer id, String name, Integer state_id) {
    this.setId(id);
    this.setName(name);
    this.setState_id(state_id);
  }

  public City(String name, Integer state_id) {
    this.setName(name);
    this.setState_id(state_id);
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

  @Override
  public LinkedHashMap<String, String> toMap(Boolean allString) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public void fromMap(LinkedHashMap<String, String> data) {
    this.setName((String) data.get("name"));
    this.setState_id(Integer.parseInt(data.get("state_id")));
  }

  @Override
  public LinkedHashMap<String, String> toMap() {
    LinkedHashMap<String, String> data = new LinkedHashMap<>();
    data.put("name", this.getName());
    return data;
  }
}
