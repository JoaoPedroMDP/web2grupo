package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Address;
import exceptions.DAOException;

public class AddressDAO extends BaseDAO<Address>{
    public AddressDAO(Connection con) throws DAOException {
        if(con == null){
            throw new DAOException("Conexão nula ao criar AddressDAO");
        }
        
        this.con = con;
        this.tableName = "addresses";
        this.subject = "endereço";
        this.columns = new ArrayList<String>(){{
            add("street");
            add("number");
            add("complement");
            add("district");
            add("zip_code");
            add("city_id");
        }};
    }

    @Override
    protected void configureStatement(PreparedStatement stmt, Address address) throws SQLException {
        stmt.setString(1, address.getStreet());
        stmt.setString(2, address.getNumber());
        stmt.setString(3, address.getComplement());
        stmt.setString(4, address.getDistrict());
        stmt.setInt(5, address.getZip_code());
        stmt.setInt(6, address.getCity_id());
    }

    @Override
    protected Address fillFromResultSet(ResultSet rs) throws SQLException {
        Address address = new Address();
        Integer id = rs.getInt("id");
        if(id != 0){
            address.setId(id);
        }

        address.setStreet(rs.getString("street"));
        address.setNumber(rs.getString("number"));
        address.setComplement(rs.getString("complement"));
        address.setDistrict(rs.getString("district"));
        address.setZip_code(rs.getString("zip_code"));
        address.setCity_id(rs.getString("city_id"));
        return address;
    }
}
