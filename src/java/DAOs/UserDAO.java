package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import Beans.User;
import Exceptions.DAOException;
import Exceptions.NotFound;
import Exceptions.User.UserNotFound;
import Interfaces.DAO;

public class UserDAO extends BaseDAO<User> implements DAO<User> {

    private Connection con;
    private final String tableName;
    private ArrayList<String> columns;

    public UserDAO(Connection con) throws DAOException {
        if(con == null){
            throw new DAOException("Conexão nula ao criar UserDAO");
        }
        
        this.con = con;
        this.tableName = "users";
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
    public User get(int id) throws DAOException, NotFound {
        LinkedHashMap<String, String> filters = new LinkedHashMap<String, String>();
        filters.put("id", String.valueOf(id));
        String query = mount_select(tableName, filters);
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                User user = new User();
                user = this.fillFromResultSet(rs, user);
                return user;
            }else{
                throw new UserNotFound();
            }
        }catch(SQLException e){
            throw new DAOException("Erro ao buscar usuário " + id +": " + e.getMessage(), e);
        }
    }

    @Override
    public List<User> getAll() throws DAOException {
        List<User> results = new ArrayList<>();
        String query = mount_select(tableName);
        try(PreparedStatement stmt = con.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                User user = new User();
                user = this.fillFromResultSet(rs, user);
                results.add(user);
            }
        }catch(SQLException e){
            throw new DAOException("Erro ao buscar todos os usuários: "+ e.getMessage(), e);
        }

        return results;
    }

    @Override
    public void insert(User user) throws DAOException {
        String query = mount_insert(tableName, columns);

        try (PreparedStatement stmt = con.prepareStatement(query)){
            this.configureStatement(stmt, user);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Erro ao inserir usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(User user) throws DAOException {
        LinkedHashMap<String, String> filter = new LinkedHashMap<String, String>() {
            {
                this.put("id", String.valueOf(user.getId()));
            }
        };

        String query = mount_update(tableName, user.toMap(), filter);

        try (PreparedStatement stmt = con.prepareStatement(query)){
            this.configureStatement(stmt, user);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Erro ao atualizar usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(User user) throws DAOException {
        String id = String.valueOf(user.getId());
        LinkedHashMap<String, String> filter = new LinkedHashMap<String, String>() {
            {
                this.put("id", id);
            }
        };

        String query = mount_delete(tableName, filter);

        try (PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Erro ao deletar usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public void closeConnection() {
        try {
            this.con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão (UserDAO): " + e.getMessage());
        }
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
    protected void configureStatement(PreparedStatement stmt, int id) throws SQLException {
        stmt.setInt(1, id);
    }

    @Override
    protected User fillFromResultSet(ResultSet rs,  User user) throws SQLException {
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
