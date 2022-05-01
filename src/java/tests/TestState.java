package tests;

import java.util.LinkedHashMap;
import java.util.List;

import beans.State;
import daos.StateDAO;
import exceptions.DAOException;
import exceptions.NotFound;
import interfaces.Tests;
import utils.ConnectionFactory;

public class TestState implements Tests{
    private Integer idToRetrieve;
    private Integer idToDelete;
    private Integer idToUpdate;
    private Integer generationAmount;

    public TestState(){
        this.idToRetrieve = 1;
        this.idToUpdate = 2;
        this.idToDelete = 3;
        this.generationAmount = 3;
    }

    public void testInsertion() throws DAOException{
        StateDAO dao = new StateDAO(new ConnectionFactory().getConnection());
        for( Integer i = 0; i < this.generationAmount; i++){
            State state = new State();
            state.setName("Estado " + i);

            dao.insert(state);
        }
    }

    public void testGet() throws DAOException, NotFound {
        State state = new StateDAO(new ConnectionFactory().getConnection()).get(this.idToRetrieve);

        System.out.println(state.getName());
    }

    public void testIndex() throws DAOException {
        List<State> states = new StateDAO(new ConnectionFactory().getConnection()).getAll();

        for(State state : states){
            System.out.println(state.getName());
        }
    }

    public void testUpdate() throws DAOException, NotFound {
        StateDAO dao = new StateDAO(new ConnectionFactory().getConnection());

        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("name", "Estado 0");

        LinkedHashMap<String, Object> newData = new LinkedHashMap<String, Object>();
        newData.put("name", "Estado Alterado");
        dao.update(filters, newData);

        State state = dao.get(this.idToUpdate);
        state.setName("Tambem funfa");
        dao.update(state);
    }

    public void testDeletion() throws DAOException, NotFound {
        StateDAO dao = new StateDAO(new ConnectionFactory().getConnection());
        dao.delete(idToDelete);
    }
}
