package Tests;

import java.util.LinkedHashMap;
import java.util.List;

import Beans.Ticket;
import DAOs.TicketDAO;
import Exceptions.DAOException;
import Exceptions.NotFound;
import Interfaces.Tests;
import Utils.ConnectionFactory;

public class TestTicket implements Tests{
    private int idToRetrieve;
    private int idToDelete;
    private int idToUpdate;
    private int generationAmount;

    public TestTicket(){
        this.idToRetrieve = 1;
        this.idToUpdate = 2;
        this.idToDelete = 3;
        this.generationAmount = 3;
    }

    public void testInsertion() throws DAOException{
        TicketDAO dao = new TicketDAO(new ConnectionFactory().getConnection());
        for( int i = 0; i < this.generationAmount; i++){
            Ticket ticket = new Ticket();
            ticket.setDescription("Ticket " + i);
            ticket.setState("open");
            ticket.setSolution("Solução " + i);
            ticket.setProduct_id(1);
            ticket.setType_id(1);
            ticket.setUser_id(1);

            dao.insert(ticket);
        }
    }

    public void testGet() throws DAOException, NotFound {
        Ticket ticket = new TicketDAO(new ConnectionFactory().getConnection()).get(this.idToRetrieve);

        System.out.println(ticket.getDescription());
    }

    public void testIndex() throws DAOException {
        List<Ticket> tickets = new TicketDAO(new ConnectionFactory().getConnection()).getAll();

        for(Ticket ticket : tickets){
            System.out.println(ticket.getDescription());
        }
    }

    public void testUpdate() throws DAOException, NotFound {
        TicketDAO dao = new TicketDAO(new ConnectionFactory().getConnection());

        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("description", "Ticket 0");

        LinkedHashMap<String, Object> newData = new LinkedHashMap<String, Object>();
        newData.put("description", "Ticket Alterado");
        dao.update(filters, newData);

        Ticket ticket = dao.get(this.idToUpdate);
        ticket.setDescription("Tambem funfa");
        dao.update(ticket);
    }

    public void testDeletion() throws DAOException, NotFound {
        TicketDAO dao = new TicketDAO(new ConnectionFactory().getConnection());
        dao.delete(idToDelete);
    }
}
