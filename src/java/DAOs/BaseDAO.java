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
import Utils.QueryFactory;

public abstract class BaseDAO <T> extends QueryFactory{
    protected Connection con;
    protected String tableName;
    protected ArrayList<String> columns;
    protected String subject;
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
                throw new NotFound("Not found");
            }
        }catch(SQLException e){
            throw new DAOException("Erro ao buscar "+this.subject+" " + id +": " + e.getMessage(), e);
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
            throw new DAOException("Erro ao buscar todos os "+this.subject+"s "+ e.getMessage(), e);
        }

        return results;
    }

    public void insert(T t) throws DAOException {
        String query = mount_insert(tableName, columns);

        try (PreparedStatement stmt = con.prepareStatement(query)){
            this.configureStatement(stmt, t);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new DAOException("Erro ao inserir "+this.subject+": " + e.getMessage(), e);
        }
    }

    protected abstract void configureStatement(PreparedStatement stmt, T t) throws SQLException;
    protected abstract void configureStatement(PreparedStatement stmt, int id) throws SQLException;
    protected abstract T fillFromResultSet(ResultSet rs) throws SQLException;
}
