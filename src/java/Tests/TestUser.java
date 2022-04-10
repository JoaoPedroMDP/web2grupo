package Tests;

import java.util.List;

import Beans.User;
import DAOs.UserDAO;
import Exceptions.DAOException;
import Exceptions.NotFound;
import Utils.ConnectionFactory;

public class TestUser {
    public void testInsertion() throws DAOException{
        User user = new User(){{
            setAddress_id(1);
            setCpf("123456789");
            setEmail("email@email.com");
            setName("Nome");
            setSurname("da Silva");
            setPassword("password");
            setPhone("44984235767");
            setRole("customer");
        }};

        UserDAO dao = new UserDAO(new ConnectionFactory().getConnection());
        dao.insert(user);
    }

    public void testGet() throws DAOException, NotFound {
        User user = new UserDAO(new ConnectionFactory().getConnection()).get(2);

        System.out.println(user.getName());
    }

    public void testIndex() throws DAOException {
        List<User> users = new UserDAO(new ConnectionFactory().getConnection()).getAll();

        for(User user : users){
            System.out.println(user.getName());
        }
    }
}
