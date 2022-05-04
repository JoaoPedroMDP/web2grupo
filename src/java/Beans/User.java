package Beans;

import java.util.LinkedHashMap;

import Interfaces.Bean;
import Interfaces.Mappable;

public class User implements Mappable, Bean{
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private String role;
    private Integer address_id;

    public User() {}

    public User(Integer id, String name, String surname, String email, String password, String cpf, String phone, String role, Integer address_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.role = role;
        this.address_id = address_id;
    }

    public User(String name, String surname, String email, String password, String cpf, String phone, String role, Integer address_id) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.role = role;
        this.address_id = address_id;
    }
    
     public User(int id, String name, String surname, String email, String password, String cpf, String phone, int address_id) {
        this.id = id;
         this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.address_id = address_id;
    }
     
       public User(String name, String surname, String email, String password, String cpf, String phone) {
         this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
    }
       
       public User(String name, String surname, String password, String phone) {
         this.name = name;
        this.surname = surname;
        this.password = password;
        this.phone = phone;
    }
       
       public User(String name, String surname, String email, String password, String cpf, String phone, Integer address_id) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.address_id = address_id;
    }

    public void fromMap(LinkedHashMap<String, Object> data){
        this.setName((String) data.get("name"));
        this.setSurname((String) data.get("surname"));
        this.setEmail((String) data.get("email"));
        this.setPassword((String) data.get("password"));
        this.setCpf((String) data.get("cpf"));
        this.setPhone((String) data.get("phone"));
        this.setRole((String) data.get("role"));
        this.setAddress_id(Integer.parseInt( (String) data.get("address_id")));
    }

    public LinkedHashMap<String, Object> toMap() {
        LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("name", this.getName());
        data.put("surname", this.getSurname());
        data.put("email", this.getEmail());
        data.put("password", this.getPassword());
        data.put("cpf", this.getCpf());
        data.put("phone", this.getPhone());
        data.put("role", this.getRole());
        data.put("address_id", String.valueOf(getAddress_id()));
        return data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getAddress_id() {
        System.out.println("Inside beans: "+ address_id);
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = Integer.parseInt(address_id);
    }
}