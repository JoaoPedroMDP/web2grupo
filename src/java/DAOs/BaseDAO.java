package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import Exceptions.DAOException;
import Exceptions.NotFound;
import Interfaces.Mappable;
import Interfaces.Bean;
import Interfaces.DAO;
import Utils.QueryFactory;

public abstract class BaseDAO <T extends Mappable & Bean> extends QueryFactory implements DAO<T>{
    protected Connection con;
    protected String tableName;
    protected ArrayList<String> columns;
    protected String subject;

    public void finalize(){
        this.closeConnection();
    }

    @Override
    public void closeConnection() {
        try {
            this.con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão (BaseDAO): " + e.getMessage());
        }
    }

    public final T get(int id) throws DAOException, NotFound {
        LinkedHashMap<String, String> filters = new LinkedHashMap<String, String>();
        filters.put("id", String.valueOf(id));
        String query = mount_select(tableName, filters);
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return this.fillFromResultSet(rs);
            }else{
                throw new NotFound(this.subject + " não encontrado");
            }
        }catch(SQLException e){
            throw new DAOException("Erro ao buscar " + this.subject + " " + id +": " + e.getMessage(), e);
        }
    }

    public final List<T> getAll() throws DAOException {
        List<T> results = new ArrayList<>();
        String query = mount_select(tableName);
        try(PreparedStatement stmt = con.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                results.add(this.fillFromResultSet(rs));
            }
        }catch(SQLException e){
            throw new DAOException("Erro ao buscar todos os " + this.subject + "s "+ e.getMessage(), e);
        }

        return results;
    }

    public void insert(T t) throws DAOException {
        String query = mount_insert(tableName, columns);

        try (PreparedStatement stmt = con.prepareStatement(query)){
            this.configureStatement(stmt, t);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Erro ao inserir " + this.subject + ": " + e.getMessage(), e);
        }
    }

    public void update(T t) throws DAOException {
        LinkedHashMap<String, String> filters = new LinkedHashMap<String, String>() {
            {
                this.put("id", String.valueOf(t.getId()));
            }
        };

        String query = mount_update(tableName, t.toMap(), filters);
        try (PreparedStatement stmt = con.prepareStatement(query)){
            int nextReplacement = 1;
            nextReplacement = this.configureStatement(stmt, nextReplacement, t.toMap());
            nextReplacement = this.configureStatement(stmt, nextReplacement, filters);

            stmt.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Erro ao atualizar " + this.subject + ": " + e.getMessage(), e);
        }
    }

    public void update(LinkedHashMap<String, String> filters, LinkedHashMap<String, String> newData) throws DAOException {
        String query = mount_update(tableName, newData, filters);
        try (PreparedStatement stmt = con.prepareStatement(query)){
            System.out.println(query);
            int nextReplacement = 1;
            nextReplacement = this.configureStatement(stmt, nextReplacement, newData);
            nextReplacement = this.configureStatement(stmt, nextReplacement, filters);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Erro ao atualizar " + this.subject + ": " + e.getMessage(), e);
        }
    }

    public void delete(T t) throws DAOException {
        String id = String.valueOf(t.getId());
        LinkedHashMap<String, String> filter = new LinkedHashMap<String, String>() {
            {
                this.put("id", id);
            }
        };

        String query = mount_delete(tableName, filter);

        try (PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setInt(1, t.getId());
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Erro ao deletar usuário: " + e.getMessage(), e);
        }
    }

    public void delete(int id) throws DAOException {
        String stringifiedId = String.valueOf(id);
        LinkedHashMap<String, String> filter = new LinkedHashMap<String, String>() {
            {
                this.put("id", stringifiedId);
            }
        };

        String query = mount_delete(tableName, filter);

        try (PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Erro ao deletar" + this.subject + ": " + e.getMessage(), e);
        }
    }

    protected int configureStatement(PreparedStatement stmt, int nextReplacement, LinkedHashMap<String, String> data) throws SQLException {
        Object keys[] = data.keySet().toArray();
        for( int i = 0; i < data.size(); i++){
            stmt.setString(nextReplacement, data.get(keys[i]));
            nextReplacement++;
        }
        
        return nextReplacement;
    }

    protected abstract void configureStatement(PreparedStatement stmt, T t) throws SQLException;
    protected abstract T fillFromResultSet(ResultSet rs) throws SQLException;
}
