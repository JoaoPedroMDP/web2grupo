package Tests;

import java.util.LinkedHashMap;
import java.util.List;

import Beans.User;
import DAOs.UserDAO;
import Exceptions.DAOException;
import Exceptions.NotFound;
import Utils.ConnectionFactory;

public class TestUser {
    private int idToRetrieve;
    private int idToDelete;
    private int idToUpdate;
    private int generationAmount;

    public TestUser(){
        this.idToRetrieve = 1;
        this.idToUpdate = 2;
        this.idToDelete = 3;
        this.generationAmount = 3;
    }

    public void testInsertion() throws DAOException{
        UserDAO dao = new UserDAO(new ConnectionFactory().getConnection());
        for( int i = 0; i < this.generationAmount; i++){
            User user = new User();
            user.setName("Nome " + i);
            user.setAddress_id(1);
            user.setCpf("123456789");
            user.setEmail("email@email.com");
            user.setSurname("da Silva");
            user.setPassword("password");
            user.setPhone("44984235767");
            user.setRole("customer");

            dao.insert(user);
        }
    }

    public void testGet() throws DAOException, NotFound {
        User user = new UserDAO(new ConnectionFactory().getConnection()).get(this.idToRetrieve);

        System.out.println(user.getName());
    }

    public void testIndex() throws DAOException {
        List<User> users = new UserDAO(new ConnectionFactory().getConnection()).getAll();

        for(User user : users){
            System.out.println(user.getName());
        }
    }

    public void testUpdate() throws DAOException, NotFound {
        UserDAO dao = new UserDAO(new ConnectionFactory().getConnection());

        LinkedHashMap<String, String> filters = new LinkedHashMap<String, String>();
        filters.put("name", "Nome 0");

        LinkedHashMap<String, String> newData = new LinkedHashMap<String, String>();
        newData.put("name", "Nome Alterado");
        dao.update(filters, newData);

        User user = dao.get(this.idToUpdate);
        user.setName("Tambem funfa");
        dao.update(user);
    }

    public void testDeletion() throws DAOException, NotFound {
        UserDAO dao = new UserDAO(new ConnectionFactory().getConnection());
        dao.delete(idToDelete);
    }
}
