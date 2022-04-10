package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.User;
import Exceptions.DAOException;

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
        int id = rs.getInt("id");
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
}
