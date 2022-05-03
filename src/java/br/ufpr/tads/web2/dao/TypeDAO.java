package br.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufpr.tads.web2.bean.Type;
import br.ufpr.tads.web2.exception.DAOException;

public class TypeDAO extends BaseDAO<Type> {

  private Connection con;
  private final String tableName;
  private ArrayList<String> columns;

  public TypeDAO(Connection con) throws DAOException {
    if (con == null) {
      throw new DAOException("Conexão nula ao criar TypeDAO");
    }

    this.con = con;
    this.tableName = "types";
    //this.subject = "tipo";
    this.columns = new ArrayList<String>() {
      {
        add("name");
      }
    };
  }

  @Override
  protected void configureStatement(PreparedStatement stmt, Type type) throws SQLException {
    stmt.setString(1, type.getName());
  }

  protected Type fillFromResultSet(ResultSet rs) throws SQLException {
    Type type = new Type();
    Integer id = rs.getInt("id");
    if (id != 0) {
      type.setId(id);
    }

    type.setName(rs.getString("name"));

    return type;
  }

  @Override
  protected void configureStatement(PreparedStatement stmt, int id) throws SQLException {

  }

  @Override
  protected Type fillFromResultSet(ResultSet rs, Type t) throws SQLException {

    return null;

  }

}
