package br.ufpr.tads.web2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufpr.tads.web2.util.QueryFactory;

  public abstract class BaseDAO<T> extends QueryFactory {

  protected abstract void configureStatement(PreparedStatement stmt, T t) throws SQLException;

  protected abstract void configureStatement(PreparedStatement stmt, int id) throws SQLException;

  protected abstract T fillFromResultSet(ResultSet rs, T t) throws SQLException;
  
}
