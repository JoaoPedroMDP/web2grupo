package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Exceptions.DAOException;

public class ConnectionFactory implements AutoCloseable {
    private String DRIVER = "com.mysql.cj.jdbc.Driver";
    private String URL;
    private String LOGIN;
    private String PASSWORD;
    private Connection con = null;

    public ConnectionFactory() {
        Config config = new Config();
        this.URL = "jdbc:mysql://" + config.host + ":" + config.port + "/" + config.database + "?useSSL=false";
        this.LOGIN = config.user;
        this.PASSWORD = config.password;
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
            } catch (Exception e) {
                throw new DAOException("Erro inesperado ao conectar no Banco de Dados: " + e.getMessage(), e);
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

