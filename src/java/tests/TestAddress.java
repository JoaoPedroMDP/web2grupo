package tests;

import java.util.LinkedHashMap;
import java.util.List;

import beans.Address;
import daos.AddressDAO;
import exceptions.DAOException;
import exceptions.NotFound;
import interfaces.Tests;
import utils.ConnectionFactory;

public class TestAddress implements Tests{
    private Integer idToRetrieve;
    private Integer idToDelete;
    private Integer idToUpdate;
    private Integer generationAmount;

    public TestAddress(){
        this.idToRetrieve = 1;
        this.idToUpdate = 2;
        this.idToDelete = 3;
        this.generationAmount = 3;
    }

    public void testInsertion() throws DAOException{
        AddressDAO dao = new AddressDAO(new ConnectionFactory().getConnection());
        for( Integer i = 0; i < this.generationAmount; i++){
            Address address = new Address();
            address.setStreet("Rua");
            address.setNumber("Número");
            address.setComplement("Complemento");
            address.setDistrict("Bairro");
            address.setZip_code(8170160);
            address.setCity_id(1);

            dao.insert(address);
        }
    }

    public void testGet() throws DAOException, NotFound {
        Address address = new AddressDAO(new ConnectionFactory().getConnection()).get(this.idToRetrieve);

        System.out.println(address.getStreet());
    }

    public void testIndex() throws DAOException {
        List<Address> addresss = new AddressDAO(new ConnectionFactory().getConnection()).getAll();

        for(Address address : addresss){
            System.out.println(address.getStreet());
        }
    }

    public void testUpdate() throws DAOException, NotFound {
        AddressDAO dao = new AddressDAO(new ConnectionFactory().getConnection());

        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("street", "Rua 0");

        LinkedHashMap<String, Object> newData = new LinkedHashMap<String, Object>();
        newData.put("street", "Rua alterada");
        dao.update(filters, newData);

        Address address = dao.get(this.idToUpdate);
        address.setStreet("Tambem funfa");
        dao.update(address);
    }

    public void testDeletion() throws DAOException, NotFound {
        AddressDAO dao = new AddressDAO(new ConnectionFactory().getConnection());
        dao.delete(idToDelete);
    }

    public void testSelection() throws DAOException {
        AddressDAO dao = new AddressDAO(new ConnectionFactory().getConnection());
        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("city_id", 1);
        List<Address> filtered = dao.select(filters);
        System.out.println(filtered);
    }
}
