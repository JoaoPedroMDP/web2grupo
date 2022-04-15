package Tests;

import java.util.LinkedHashMap;
import java.util.List;

import Beans.Type;
import DAOs.TypeDAO;
import Exceptions.DAOException;
import Exceptions.NotFound;
import Interfaces.Tests;
import Utils.ConnectionFactory;

public class TestType implements Tests{
    private Integer idToRetrieve;
    private Integer idToDelete;
    private Integer idToUpdate;
    private Integer generationAmount;

    public TestType(){
        this.idToRetrieve = 1;
        this.idToUpdate = 2;
        this.idToDelete = 3;
        this.generationAmount = 3;
    }

    public void testInsertion() throws DAOException{
        TypeDAO dao = new TypeDAO(new ConnectionFactory().getConnection());
        for( Integer i = 0; i < this.generationAmount; i++){
            Type type = new Type();
            type.setName("Tipo " + i);

            dao.insert(type);
        }
    }

    public void testGet() throws DAOException, NotFound {
        Type type = new TypeDAO(new ConnectionFactory().getConnection()).get(this.idToRetrieve);

        System.out.println(type.getName());
    }

    public void testIndex() throws DAOException {
        List<Type> types = new TypeDAO(new ConnectionFactory().getConnection()).getAll();

        for(Type type : types){
            System.out.println(type.getName());
        }
    }

    public void testUpdate() throws DAOException, NotFound {
        TypeDAO dao = new TypeDAO(new ConnectionFactory().getConnection());

        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("name", "Tipo 0");

        LinkedHashMap<String, Object> newData = new LinkedHashMap<String, Object>();
        newData.put("name", "Tipo Alterado");
        dao.update(filters, newData);

        Type type = dao.get(this.idToUpdate);
        type.setName("Tambem funfa");
        dao.update(type);
    }

    public void testDeletion() throws DAOException, NotFound {
        TypeDAO dao = new TypeDAO(new ConnectionFactory().getConnection());
        dao.delete(idToDelete);
    }
}
