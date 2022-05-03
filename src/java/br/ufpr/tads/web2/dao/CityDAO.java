package br.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufpr.tads.web2.bean.City;
import br.ufpr.tads.web2.exception.DAOException;

public class CityDAO extends BaseDAO<City> {

  private Connection con;
  private final String tableName;
  private ArrayList<String> columns;

  public CityDAO(Connection con) throws DAOException {
    if (con == null) {
      throw new DAOException("Conexão nula ao criar CityDAO");
    }

    this.con = con;
    this.tableName = "cities";
    //this.subject = "cidades";
    this.columns = new ArrayList<String>() {
      {
        add("name");
        add("state_id");
      }
    };
  }

  @Override
  protected void configureStatement(PreparedStatement stmt, City city) throws SQLException {
    stmt.setString(1, city.getName());
    stmt.setInt(2, city.getState_id());
  }

  protected City fillFromResultSet(ResultSet rs) throws SQLException {
    City city = new City();
    Integer id = rs.getInt("id");
    if (id != 0) {
      city.setId(id);
    }

    city.setName(rs.getString("name"));
    city.setState_id(rs.getString("state_id"));

    return city;
  }

  @Override
  protected void configureStatement(PreparedStatement stmt, int id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  protected City fillFromResultSet(ResultSet rs, City t) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

}
