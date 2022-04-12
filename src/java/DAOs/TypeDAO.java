package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Type;
import Exceptions.DAOException;

public class TypeDAO extends BaseDAO<Type>{

    public TypeDAO(Connection con) throws DAOException {
        if(con == null){
            throw new DAOException("Conexão nula ao criar TypeDAO");
        }
        
        this.con = con;
        this.tableName = "types";
        this.subject = "tipo";
        this.columns = new ArrayList<String>(){{
            add("name");
        }};
    }

    @Override
    protected void configureStatement(PreparedStatement stmt, Type type) throws SQLException {
        stmt.setString(1, type.getName());
    }

    @Override
    protected Type fillFromResultSet(ResultSet rs)
     throws SQLException {
        Type type = new Type();
        int id = rs.getInt("id");
        if(id != 0){
            type.setId(id);
        }

        type.setName(rs.getString("name"));

        return type;
    }
    
}
