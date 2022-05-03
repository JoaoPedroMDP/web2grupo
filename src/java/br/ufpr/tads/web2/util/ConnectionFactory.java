package br.ufpr.tads.web2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.ufpr.tads.web2.exception.DAOException;

public class ConnectionFactory implements AutoCloseable {

  private static String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static String URL = "jdbc:mysql://localhost:3306/beibe?useSSL=false";
  private static String LOGIN = "root";
  private static String PASSWORD = "1234567";
  private Connection con = null;

  public ConnectionFactory() {
  }

  public Connection getConnection() throws DAOException {
    if (this.con == null) {
      try {
        Class.forName(DRIVER);
        this.con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
      } catch (ClassNotFoundException e) {
        throw new DAOException("Erro ao carregar o driver", e);
      } catch (SQLException e) {
        throw new DAOException("Erro ao conectar no Banco de Dados: " + e.getMessage(), e);
      }
    }

    return this.con;
  }

  public void close() {
    if (this.con != null) {
      try {
        this.con.close();
      } catch (SQLException e) {
        System.out.println("Erro ao fechar conexão (ConnectionFactory): " + e.getMessage());
      }
    }
  }
}
