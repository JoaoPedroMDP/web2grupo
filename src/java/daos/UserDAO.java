package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.User;
import exceptions.DAOException;
import utils.ConnectionFactory;
import utils.Security;

public class UserDAO extends BaseDAO<User> {

    public UserDAO(Connection con) throws DAOException {
        if(con == null){
            throw new DAOException("Conexão nula ao criar UserDAO");
        }
        
        this.con = con;
        this.tableName = "users";
        this.subject = "usuário";
        this.columns = new ArrayList<String>(){{
            add("name");
            add("surname");
            add("email");
            add("password");
            add("cpf");
            add("phone");
            add("role");
            add("address_id");
        }};
    }

    @Override
    protected void configureStatement(PreparedStatement stmt, User user) throws SQLException {
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getSurname());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getCpf());
        stmt.setString(6, user.getPhone());
        stmt.setString(7, user.getRole());
        stmt.setString(8, String.valueOf(user.getAddress_id()));    
    }

    @Override
    protected User fillFromResultSet(ResultSet rs)
     throws SQLException {
        User user = new User();
        Integer id = rs.getInt("id");
        if(id != 0){
            user.setId(id);
        }

        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setCpf(rs.getString("cpf"));
        user.setPhone(rs.getString("phone"));
        user.setRole(rs.getString("role"));
        user.setAddress_id(rs.getString("address_id"));

        return user;
    }

    protected User fillFromResultSet(ResultSet rs, User user) throws SQLException {
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setCpf(rs.getString("cpf"));
        user.setPhone(rs.getString("phone"));
        user.setRole(rs.getString("role"));
        user.setAddress_id(rs.getString("address_id"));
    
        return user;
      }

    public static void create(User c) {
        Connection con = null;
        try {
          con = new ConnectionFactory().getConnection();
        } catch (DAOException ex) {
          Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement stmt = null;
        System.out.println("HERE IT IS" + c.getAddress_id());
    
        try {
          stmt = con.prepareStatement("INSERT INTO user (name, surname, email, password, cpf, phone, role, address_id  ) VALUES (?,?,?, ?,?,?, 'user', ? );");
          stmt.setString(1, c.getName());
          stmt.setString(2, c.getSurname());
          stmt.setString(3, c.getEmail());
          String pass = Security.encryptPassword(c.getPassword());
          stmt.setString(4, pass);
          stmt.setString(5, c.getCpf());
          stmt.setString(6, c.getPhone());
          stmt.setInt(7, c.getAddress_id());
          stmt.executeUpdate();
        } catch (SQLException ex) {
          ex.printStackTrace();
        } finally {
          new ConnectionFactory().close();
        }
      }
    
    public static User readOne(int id) {
        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM user WHERE id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
            return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("cpf"),
                rs.getString("phone"),
                rs.getInt("address_id")
            );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            new ConnectionFactory().close();
        }

        return null;
    }

    public static void update(int id, User c) {
        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE user SET name = ?, surname = ?, email = ?, password= ?, cpf=?,phone=? WHERE id = ?");
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getSurname());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getPassword());
            stmt.setString(5, c.getCpf());
            stmt.setString(6, c.getPhone());
            stmt.setInt(7, id);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void delete(int id) {
        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM user WHERE id = ?");
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            new ConnectionFactory().close();
        }
    }

    public boolean existLogin(String email) throws DAOException {
        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("email", email);
        String query = mount_select(tableName, filters);
        try ( PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            return true;
            } else {
            return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public User validationLogin(String email, String password) throws DAOException {
        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("email", email);
        filters.put("password", password);
        String query = mount_select(tableName, filters);
        try ( PreparedStatement stmt = con.prepareStatement(query)) {
          stmt.setString(1, email);
          stmt.setString(2, password);
          ResultSet rs = stmt.executeQuery();
          if (rs.next()) {
            User user = new User();
            user = this.fillFromResultSet(rs, user);
            return user;
          } else {
            return null;
          }
        } catch (SQLException e) {
          throw new RuntimeException(e.getMessage());
        }
      }
}
