package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Address;
import beans.User;
import exceptions.DAOException;
import Utils.ConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddressDAO extends BaseDAO<Address> {

    public AddressDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar AddressDAO");
        }

        this.con = con;
        this.tableName = "addresses";
        this.subject = "endereço";
        this.columns = new ArrayList<String>() {
            {
                add("street");
                add("number");
                add("complement");
                add("district");
                add("zip_code");
                add("city_id");
            }
        };
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
        if (id != 0) {
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

    public static void create(Address c) throws DAOException {
        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO address (street, number, complement, district, zip_code) VALUES (?,?,?, ?,?);");
            stmt.setString(1, c.getStreet());
            stmt.setString(2, c.getNumber());
            stmt.setString(3, c.getComplement());
            stmt.setString(4, c.getDistrict());
            stmt.setInt(5, c.getZip_code());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            new ConnectionFactory().close();
        }
    }

    public static Address readOne(int id) throws DAOException {

        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM address WHERE id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return new Address(
                        rs.getInt("id"),
                        rs.getString("street"),
                        rs.getString("number"),
                        rs.getString("complement"),
                        rs.getString("district"),
                        rs.getInt("zip_code")
                //                        rs.getString("cidade_cliente"),
                //                        rs.getString("uf_cliente"),
                //                        rs.getInt("id_cidade")

                //                check = true;
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

    public static Address readZipCode(int zip_code, String number) throws DAOException {

        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM address WHERE zip_code = ? and number = ?");
            stmt.setInt(1, zip_code);
            stmt.setString(2, number);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                return new Address(
                        rs.getInt("id"),
                        rs.getString("street"),
                        rs.getString("number"),
                        rs.getString("complement"),
                        rs.getString("district"),
                        rs.getInt("zip_code")
                //                        rs.getString("cidade_cliente"),
                //                        rs.getString("uf_cliente"),
                //                        rs.getInt("id_cidade")

                //                check = true;
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

    public static void update(int id, Address c) throws DAOException {

        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE address SET street = ?, number = ?, complement = ?, district= ?, zip_code=? WHERE id = ?");
            stmt.setString(1, c.getStreet());
            stmt.setString(2, c.getNumber());
            stmt.setString(3, c.getComplement());
            stmt.setString(4, c.getDistrict());
            stmt.setInt(5, c.getZip_code());
            stmt.setInt(6, id);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void delete(int id) throws DAOException {

        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM address WHERE id = ?");
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            new ConnectionFactory().close();
        }

    }
}
