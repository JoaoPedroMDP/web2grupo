package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Product;
import Exceptions.DAOException;

public class ProductDAO extends BaseDAO<Product>{

    public ProductDAO(Connection con) throws DAOException {
        if(con == null){
            throw new DAOException("Conexão nula ao criar ProductDAO");
        }
        
        this.con = con;
        this.tableName = "products";
        this.subject = "produto";
        this.columns = new ArrayList<String>(){{
            add("name");
            add("image");
            add("weight");
            add("category_id");
        }};
    }

    @Override
    protected void configureStatement(PreparedStatement stmt, Product product) throws SQLException {
        stmt.setString(1, product.getName());
        stmt.setString(2, product.getImage());
        stmt.setString(3, String.valueOf(product.getWeight()));
        stmt.setString(4, String.valueOf(product.getCategory_id()));
    }

    @Override
    protected Product fillFromResultSet(ResultSet rs)
     throws SQLException {
        Product product = new Product();
        Integer id = rs.getInt("id");
        if(id != 0){
            product.setId(id);
        }

        product.setName(rs.getString("name"));
        product.setImage(rs.getString("image"));
        product.setWeight(rs.getString("weight"));
        product.setCategory_id(rs.getString("category_id"));

        return product;
    }
    
}
