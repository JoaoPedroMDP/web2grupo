package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import exceptions.DAOException;
import exceptions.NotFound;
import interfaces.Bean;
import interfaces.DAO;
import interfaces.Mappable;
import utils.QueryFactory;

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

    public final T get(Integer id) throws DAOException, NotFound {
        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
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
        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>() {
            {
                this.put("id", String.valueOf(t.getId()));
            }
        };

        String query = mount_update(tableName, t.toMap(), filters);
        try (PreparedStatement stmt = con.prepareStatement(query)){
            Integer nextReplacement = 1;
            nextReplacement = this.configureStatement(stmt, nextReplacement, t.toMap());
            nextReplacement = this.configureStatement(stmt, nextReplacement, filters);

            stmt.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Erro ao atualizar " + this.subject + ": " + e.getMessage(), e);
        }
    }

    public void update(LinkedHashMap<String, Object> filters, LinkedHashMap<String, Object> newData) throws DAOException {
        String query = mount_update(tableName, newData, filters);
        try (PreparedStatement stmt = con.prepareStatement(query)){
            Integer nextReplacement = 1;
            nextReplacement = this.configureStatement(stmt, nextReplacement, newData);
            nextReplacement = this.configureStatement(stmt, nextReplacement, filters);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Erro ao atualizar " + this.subject + ": " + e.getMessage(), e);
        }
    }

    public void delete(T t) throws DAOException {
        String id = String.valueOf(t.getId());
        LinkedHashMap<String, Object> filter = new LinkedHashMap<String, Object>() {
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

    public void delete(Integer id) throws DAOException {
        String stringifiedId = String.valueOf(id);
        LinkedHashMap<String, Object> filter = new LinkedHashMap<String, Object>() {
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

    public final List<T> select(LinkedHashMap<String, Object> filters) throws DAOException {
        List<T> results = new ArrayList<>();
        String query = mount_select(tableName, filters);
        try (PreparedStatement stmt = con.prepareStatement(query)){
            Integer nextReplacement = 1;
            this.configureStatement(stmt, nextReplacement, filters);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                results.add(this.fillFromResultSet(rs));
            }
        }catch(SQLException e){
            throw new DAOException("Erro ao selecionar " + this.subject + ": " + e.getMessage(), e);
        }
        return results;
    }

    protected Integer configureStatement(PreparedStatement stmt, Integer nextReplacement, LinkedHashMap<String, Object> data) throws DAOException {
        Object keys[] = data.keySet().toArray();
        for( Integer i = 0; i < data.size(); i++){
            Object item = data.get(keys[i]);

            try{
                this.setStatementBasedOnType(stmt, item, nextReplacement);
            }catch(SQLException e){
                throw new DAOException(e.getMessage(), e);
            }

            nextReplacement++;
        }
        
        return nextReplacement;
    }

    protected void setStatementBasedOnType(PreparedStatement stmt, Object item, Integer replacementePosition) throws SQLException, DAOException{
        if(item instanceof java.util.Date){
            stmt.setDate(replacementePosition, (java.sql.Date) item);
        }else if (item instanceof Integer){
            stmt.setInt(replacementePosition, (Integer) item);
        }else if(item instanceof String){
            stmt.setString(replacementePosition, (String) item);
        }else if(item instanceof Float){
            stmt.setFloat(replacementePosition, (Float) item);
        }else if(item instanceof Double){
            stmt.setDouble(replacementePosition, (Double) item);
        }else if(item instanceof Boolean){
            stmt.setBoolean(replacementePosition, (Boolean) item);
        }else{
            throw new DAOException("Tipo não suportado: " + item.getClass().getName());
        }
    }

    protected abstract void configureStatement(PreparedStatement stmt, T t) throws SQLException;
    protected abstract T fillFromResultSet(ResultSet rs) throws SQLException;
}
