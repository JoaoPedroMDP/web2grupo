package tests;

import java.util.LinkedHashMap;
import java.util.List;

import beans.City;
import daos.CityDAO;
import exceptions.DAOException;
import exceptions.NotFound;
import interfaces.Tests;
import utils.ConnectionFactory;

public class TestCity implements Tests{
    private Integer idToRetrieve;
    private Integer idToDelete;
    private Integer idToUpdate;
    private Integer generationAmount;

    public TestCity(){
        this.idToRetrieve = 1;
        this.idToUpdate = 2;
        this.idToDelete = 3;
        this.generationAmount = 3;
    }

    public void testInsertion() throws DAOException{
        CityDAO dao = new CityDAO(new ConnectionFactory().getConnection());
        for( Integer i = 0; i < this.generationAmount; i++){
            City city = new City();
            city.setName("Cidade " + i);
            city.setState_id(1);

            dao.insert(city);
        }
    }

    public void testGet() throws DAOException, NotFound {
        City city = new CityDAO(new ConnectionFactory().getConnection()).get(this.idToRetrieve);

        System.out.println(city.getName());
    }

    public void testIndex() throws DAOException {
        List<City> citys = new CityDAO(new ConnectionFactory().getConnection()).getAll();

        for(City city : citys){
            System.out.println(city.getName());
        }
    }

    public void testUpdate() throws DAOException, NotFound {
        CityDAO dao = new CityDAO(new ConnectionFactory().getConnection());

        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("name", "Cidade 0");

        LinkedHashMap<String, Object> newData = new LinkedHashMap<String, Object>();
        newData.put("name", "Cidade Alterada");
        dao.update(filters, newData);

        City city = dao.get(this.idToUpdate);
        city.setName("Tambem funfa");
        dao.update(city);
    }

    public void testDeletion() throws DAOException, NotFound {
        CityDAO dao = new CityDAO(new ConnectionFactory().getConnection());
        dao.delete(idToDelete);
    }

    public void testSelection() throws DAOException {
        CityDAO dao = new CityDAO(new ConnectionFactory().getConnection());
        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("state_id", 1);
        List<City> filtered = dao.select(filters);
        System.out.println(filtered);
    }
}
