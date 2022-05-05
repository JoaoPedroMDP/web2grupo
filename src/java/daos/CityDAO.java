package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.City;
import beans.User;
import exceptions.DAOException;
import utils.ConnectionFactory;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CityDAO extends BaseDAO<City>{

    public CityDAO(Connection con) throws DAOException {
        if(con == null){
            throw new DAOException("Conexão nula ao criar CityDAO");
        }

        this.con = con;
        this.tableName = "tb_cidade";
        this.subject = "nome_cidade";
        this.columns = new ArrayList<String>(){{
            add("name");
            add("state_id");
        }};
    }

    
    public static City readCity(String name) throws DAOException {

        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM tb_cidade WHERE nome_cidade = ?");
            stmt.setString(1, name);

            rs = stmt.executeQuery();
            if (rs.next()) {
                return new City(
                        rs.getInt("id_cidade"),
                        rs.getString("nome_cidade"),
                        rs.getInt("id_estado")
                        
);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            new ConnectionFactory().close();
        }
//
        return null;
    }

       
    @Override
    protected void configureStatement(PreparedStatement stmt, City city) throws SQLException {
        stmt.setString(1, city.getName());
        stmt.setInt(2, city.getState_id());
    }

    @Override
    protected City fillFromResultSet(ResultSet rs)
     throws SQLException {
        City city = new City();
        Integer id = rs.getInt("id_cidade");
        if(id != 0){
            city.setId(id);
        }

        city.setName(rs.getString("nome_cidade"));
        city.setState_id(rs.getString("id_estado"));

        return city;
    }
    
}
