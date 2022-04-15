package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Category;
import Exceptions.DAOException;

public class CategoryDAO extends BaseDAO<Category>{

    public CategoryDAO(Connection con) throws DAOException {
        if(con == null){
            throw new DAOException("Conexão nula ao criar CategoryDAO");
        }
        
        this.con = con;
        this.tableName = "categories";
        this.subject = "categoria";
        this.columns = new ArrayList<String>(){{
            add("name");
        }};
    }

    @Override
    protected void configureStatement(PreparedStatement stmt, Category category) throws SQLException {
        stmt.setString(1, category.getName());
    }

    @Override
    protected Category fillFromResultSet(ResultSet rs)
     throws SQLException {
        Category category = new Category();
        Integer id = rs.getInt("id");
        if(id != 0){
            category.setId(id);
        }

        category.setName(rs.getString("name"));

        return category;
    }
    
}
