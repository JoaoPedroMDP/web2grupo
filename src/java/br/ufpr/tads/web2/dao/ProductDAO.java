package br.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufpr.tads.web2.bean.Product;
import br.ufpr.tads.web2.exception.DAOException;

public class ProductDAO extends BaseDAO<Product> {

  private Connection con;
  private final String tableName;
  private ArrayList<String> columns;

  public ProductDAO(Connection con) throws DAOException {
    if (con == null) {
      throw new DAOException("Conexão nula ao criar ProductDAO");
    }

    this.con = con;
    this.tableName = "products";
    //this.subject = "produto";
    this.columns = new ArrayList<String>() {
      {
        add("name");
        add("image");
        add("weight");
        add("category_id");
      }
    };
  }

  @Override
  protected void configureStatement(PreparedStatement stmt, Product product) throws SQLException {
    stmt.setString(1, product.getName());
    stmt.setString(2, product.getImage());
    stmt.setString(3, String.valueOf(product.getWeight()));
    stmt.setString(4, String.valueOf(product.getCategory_id()));
  }

  protected Product fillFromResultSet(ResultSet rs) throws SQLException {
    Product product = new Product();
    Integer id = rs.getInt("id");
    if (id != 0) {
      product.setId(id);
    }

    product.setName(rs.getString("name"));
    product.setImage(rs.getString("image"));
    product.setWeight(rs.getString("weight"));
    product.setCategory_id(rs.getString("category_id"));

    return product;
  }

  @Override
  protected void configureStatement(PreparedStatement stmt, int id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  protected Product fillFromResultSet(ResultSet rs, Product t) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

}
