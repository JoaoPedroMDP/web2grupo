package br.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufpr.tads.web2.bean.Category;
import br.ufpr.tads.web2.exception.DAOException;

public class CategoryDAO extends BaseDAO<Category> {

  private Connection con;
  private final String tableName;
  private ArrayList<String> columns;

  public CategoryDAO(Connection con) throws DAOException {
    if (con == null) {
      throw new DAOException("Conexão nula ao criar CategoryDAO");
    }

    this.con = con;
    this.tableName = "categories";
    //this.subject = "categoria";
    this.columns = new ArrayList<String>() {
      {
        add("name");
      }
    };
  }

  @Override
  protected void configureStatement(PreparedStatement stmt, Category category) throws SQLException {
    stmt.setString(1, category.getName());
  }

  protected Category fillFromResultSet(ResultSet rs)
          throws SQLException {
    Category category = new Category();
    Integer id = rs.getInt("id");
    if (id != 0) {
      category.setId(id);
    }

    category.setName(rs.getString("name"));

    return category;
  }

  @Override
  protected void configureStatement(PreparedStatement stmt, int id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  protected Category fillFromResultSet(ResultSet rs, Category t) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

}
