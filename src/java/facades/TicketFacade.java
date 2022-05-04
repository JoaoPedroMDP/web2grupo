package facades;

import java.util.List;

import beans.Ticket;
import daos.TicketDAO;
import exceptions.DAOException;
import utils.ConnectionFactory;
import utils.Tabler;
import utils.frontHelpers.table.Table;

public class TicketFacade {
    public TicketFacade(){}

    public Table listTickets(String role) throws DAOException{
        TicketDAO tDao = new TicketDAO(new ConnectionFactory().getConnection());
        List<Ticket> tickets = tDao.getAll();
        Tabler<Ticket> ticketTable = new Tabler<Ticket>(tickets.get(0).getColumns(), role);
        ticketTable.wrapData(tickets.toArray(new Ticket[tickets.size()]));
        
        return ticketTable.tablefy();
    }

    public void deleteTicket(String id) throws DAOException{
        TicketDAO tDao = new TicketDAO(new ConnectionFactory().getConnection());
        tDao.delete(id);
    }
}
