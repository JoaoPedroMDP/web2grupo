package facades;

import java.util.List;

import beans.Ticket;
import daos.TicketDAO;
import utils.ConnectionFactory;
import utils.Tabler;
import utils.frontHelpers.table.Table;

public class TicketFacade {
    public TicketFacade(){}

    public Table listTickets() {
        String role = "admin";
        TicketDAO tDao = new TicketDAO(new ConnectionFactory().getConnection());
        List<Ticket> tickets = tDao.getAll();
        Tabler<Ticket> ticketTable = new Tabler<Ticket>(tickets.get(0).getColumns());
        ticketTable.wrapData(tickets.toArray(new Ticket[tickets.size()]));
        
        return ticketTable.tablefy();
    }
}
