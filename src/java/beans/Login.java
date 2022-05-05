package beans;

/**
 * @author LucasRC
 */
public class Login {
  
  private int id;
  private String name;
  private String surname;
  private String email;
  private String password;
  private String cpf;
  private String phone;
  private String role;
  private int address_id;

  public Login() {
  }

  public Login(int id, String name, String surname, String email, String password, String cpf, String phone, String role, int address_id) {
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

  public Login(String name, String surname, String email, String password, String cpf, String phone, String role, int address_id) {
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.password = password;
    this.cpf = cpf;
    this.phone = phone;
    this.role = role;
    this.address_id = address_id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public int getAddress_id() {
    return address_id;
  }

  public void setAddress_id(int address_id) {
    this.address_id = address_id;
  }

  public void setAddress_id(String address_id) {
    this.address_id = Integer.parseInt(address_id);
  }

  @Override
  public String toString() {
    return "Login{" + 
            "id=" + id + 
            ", name=" + name + 
            ", surname=" + surname + 
            ", email=" + email + 
            ", password=" + password + 
            ", cpf=" + cpf + 
            ", phone=" + phone + 
            ", role=" + role + 
            ", address_id=" + address_id + '}';
  }
  
}