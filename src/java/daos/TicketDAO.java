package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Ticket;
import exceptions.DAOException;

public class TicketDAO extends BaseDAO<Ticket>{
    public TicketDAO(Connection con) throws DAOException {
        if(con == null){
            throw new DAOException("Conexão nula ao criar UserDAO");
        }
        
        this.con = con;
        this.tableName = "tickets";
        this.subject = "ticket";
        this.columns = new ArrayList<String>(){{
            add("description");
            add("state");
            add("solution");
            add("product_id");
            add("type_id");
            add("user_id");
        }};
    }

    @Override
    protected void configureStatement(PreparedStatement stmt, Ticket ticket) throws SQLException {
        stmt.setString(1, ticket.getDescription());
        stmt.setString(2, ticket.getState());
        stmt.setString(3, ticket.getSolution());
        stmt.setString(4, String.valueOf(ticket.getProduct_id()));
        stmt.setString(5, String.valueOf(ticket.getType_id()));
        stmt.setString(6, String.valueOf(ticket.getUser_id()));
        
    }

    @Override
    protected Ticket fillFromResultSet(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        Integer id = rs.getInt("id");
        if(id != 0){
            ticket.setId(id);
        }

        ticket.setDescription(rs.getString("description"));
        ticket.setState(rs.getString("state"));
        ticket.setSolution(rs.getString("solution"));
        ticket.setProduct_id(rs.getString("product_id"));
        ticket.setType_id(rs.getString("type_id"));
        ticket.setUser_id(rs.getString("user_id"));

        return ticket;
    }
}
