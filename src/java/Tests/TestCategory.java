package Tests;

import java.util.LinkedHashMap;
import java.util.List;

import Beans.Category;
import DAOs.CategoryDAO;
import Exceptions.DAOException;
import Exceptions.NotFound;
import Utils.ConnectionFactory;

public class TestCategory {
    private int idToRetrieve;
    private int idToDelete;
    private int idToUpdate;
    private int generationAmount;

    public TestCategory(){
        this.idToRetrieve = 1;
        this.idToUpdate = 2;
        this.idToDelete = 3;
        this.generationAmount = 3;
    }

    public void testInsertion() throws DAOException{
        CategoryDAO dao = new CategoryDAO(new ConnectionFactory().getConnection());
        for( int i = 0; i < this.generationAmount; i++){
            Category category = new Category();
            category.setName("Categoria " + i);

            dao.insert(category);
        }
    }

    public void testGet() throws DAOException, NotFound {
        Category category = new CategoryDAO(new ConnectionFactory().getConnection()).get(this.idToRetrieve);

        System.out.println(category.getName());
    }

    public void testIndex() throws DAOException {
        List<Category> categorys = new CategoryDAO(new ConnectionFactory().getConnection()).getAll();

        for(Category category : categorys){
            System.out.println(category.getName());
        }
    }

    public void testUpdate() throws DAOException, NotFound {
        CategoryDAO dao = new CategoryDAO(new ConnectionFactory().getConnection());

        LinkedHashMap<String, String> filters = new LinkedHashMap<String, String>();
        filters.put("name", "Categoria 0");

        LinkedHashMap<String, String> newData = new LinkedHashMap<String, String>();
        newData.put("name", "Categoria Alterado");
        dao.update(filters, newData);

        Category category = dao.get(this.idToUpdate);
        category.setName("Tambem funfa");
        dao.update(category);
    }

    public void testDeletion() throws DAOException, NotFound {
        CategoryDAO dao = new CategoryDAO(new ConnectionFactory().getConnection());
        dao.delete(idToDelete);
    }
}
