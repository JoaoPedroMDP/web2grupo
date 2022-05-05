package facades;

import java.util.LinkedHashMap;
import java.util.List;

import beans.Ticket;
import daos.TicketDAO;
import exceptions.DAOException;
import exceptions.NotFound;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnectionFactory;
import utils.Tabler;
import utils.frontHelpers.table.Table;

public class TicketFacade {
    public TicketFacade(){}

    public Table listTickets(String role) throws DAOException{
        TicketDAO tDao = new TicketDAO(new ConnectionFactory().getConnection());
        if(role.equals("admin") || role.equals("employee")){
            LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
            filters.put("state", "open");
            List<Ticket> tickets = tDao.select(filters);
            Tabler<Ticket> ticketTable = new Tabler<Ticket>(tickets.get(0).getColumns(), role);
            ticketTable.wrapData(tickets.toArray(new Ticket[tickets.size()]));

            return ticketTable.tablefy();
        }else{
            List<Ticket> tickets = tDao.getAll();
            Tabler<Ticket> ticketTable = new Tabler<Ticket>(tickets.get(0).getColumns(), role);
            ticketTable.wrapData(tickets.toArray(new Ticket[tickets.size()]));
            
            return ticketTable.tablefy();
        }
    }

    public void deleteTicket(String id) throws DAOException{
        TicketDAO tDao = new TicketDAO(new ConnectionFactory().getConnection());
        tDao.delete(id);
    }

    public Ticket getTicket(int id) throws DAOException{
        TicketDAO tDao = new TicketDAO(new ConnectionFactory().getConnection());
        Ticket ticket = null;
        try {
            ticket = tDao.get(id);
        } catch (NotFound ex) {
            Logger.getLogger(TicketFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ticket;
    }

    public boolean updateTicket(Ticket ticketUpdate)throws DAOException{
        TicketDAO tDao = new TicketDAO(new ConnectionFactory().getConnection());
        tDao.update(ticketUpdate);
        return true;
    }
}
