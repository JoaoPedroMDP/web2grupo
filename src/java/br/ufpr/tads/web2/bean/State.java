package br.ufpr.tads.web2.bean;

import java.util.LinkedHashMap;

import br.ufpr.tads.web2.interfaces.Bean;
import br.ufpr.tads.web2.interfaces.Mappable;

public class State implements Mappable, Bean {

  private Integer id;
  private String name;

  public State() {
  }

  public State(Integer id, String name) {
    this.setId(id);
    this.setName(name);
  }

  public State(String name) {
    this.setName(name);
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
  public void fromMap(LinkedHashMap<String, String> data) {
    this.setName((String) data.get("name"));

  }

  @Override
  public LinkedHashMap<String, String> toMap() {
    LinkedHashMap<String, String> data = new LinkedHashMap<>();
    data.put("name", this.getName());
    return data;
  }

  @Override
  public LinkedHashMap<String, String> toMap(Boolean allString) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
}
