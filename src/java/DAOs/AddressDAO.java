package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Address;
import Exceptions.DAOException;

public class AddressDAO extends BaseDAO<Address>{
    public AddressDAO(Connection con) throws DAOException {
        if(con == null){
            throw new DAOException("Conexão nula ao criar AddressDAO");
        }
        
        this.con = con;
        this.tableName = "addresses";
        this.columns = new ArrayList<String>(){{
            add("street");
            add("number");
            add("complement");
            add("district");
            add("zip_code");
            add("city");
            add("state");
        }};
    }

    @Override
    protected void configureStatement(PreparedStatement stmt, Address address) throws SQLException {
        stmt.setString(1, address.getStreet());
        stmt.setString(2, address.getNumber());
        stmt.setString(3, address.getComplement());
        stmt.setString(4, address.getDistrict());
        stmt.setString(5, String.valueOf(address.getZip_code()));
        stmt.setString(6, address.getCity());
        stmt.setString(7, address.getState());
    }

    @Override
    protected Address fillFromResultSet(ResultSet rs) throws SQLException {
        Address address = new Address();
        int id = rs.getInt("id");
        if(id != 0){
            address.setId(id);
        }

        address.setStreet(rs.getString("street"));
        address.setNumber(rs.getString("number"));
        address.setComplement(rs.getString("complement"));
        address.setDistrict(rs.getString("district"));
        address.setZip_code(rs.getString("zip_code"));
        address.setCity(rs.getString("city"));
        address.setState(rs.getString("state"));

        return address;
    }
}
