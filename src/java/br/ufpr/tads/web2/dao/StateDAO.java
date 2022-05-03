package br.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufpr.tads.web2.bean.State;
import br.ufpr.tads.web2.exception.DAOException;

public class StateDAO extends BaseDAO<State> {

  private Connection con;
  private final String tableName;
  private ArrayList<String> columns;

  public StateDAO(Connection con) throws DAOException {
    if (con == null) {
      throw new DAOException("Conexão nula ao criar StateDAO");
    }

    this.con = con;
    this.tableName = "states";
    //this.subject = "estado";
    this.columns = new ArrayList<String>() {
      {
        add("name");
      }
    };
  }

  @Override
  protected void configureStatement(PreparedStatement stmt, State state) throws SQLException {
    stmt.setString(1, state.getName());
  }

  protected State fillFromResultSet(ResultSet rs) throws SQLException {
    State state = new State();
    Integer id = rs.getInt("id");
    if (id != 0) {
      state.setId(id);
    }

    state.setName(rs.getString("name"));

    return state;
  }

  @Override
  protected void configureStatement(PreparedStatement stmt, int id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  protected State fillFromResultSet(ResultSet rs, State t) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
}
