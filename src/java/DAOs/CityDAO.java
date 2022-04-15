package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.City;
import Exceptions.DAOException;

public class CityDAO extends BaseDAO<City>{

    public CityDAO(Connection con) throws DAOException {
        if(con == null){
            throw new DAOException("Conexão nula ao criar CityDAO");
        }

        this.con = con;
        this.tableName = "cities";
        this.subject = "cidades";
        this.columns = new ArrayList<String>(){{
            add("name");
            add("state_id");
        }};
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
        int id = rs.getInt("id");
        if(id != 0){
            city.setId(id);
        }

        city.setName(rs.getString("name"));
        city.setState_id(rs.getString("state_id"));

        return city;
    }
    
}
