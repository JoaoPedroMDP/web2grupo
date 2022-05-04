package tests;

import java.util.LinkedHashMap;
import java.util.List;

import beans.Category;
import daos.CategoryDAO;
import exceptions.DAOException;
import exceptions.NotFound;
import interfaces.Tests;
import utils.ConnectionFactory;

public class TestCategory implements Tests{
    private Integer idToRetrieve;
    private Integer idToDelete;
    private Integer idToUpdate;
    private Integer generationAmount;

    public TestCategory(){
        this.idToRetrieve = 1;
        this.idToUpdate = 2;
        this.idToDelete = 3;
        this.generationAmount = 3;
    }

    public void testInsertion() throws DAOException{
        CategoryDAO dao = new CategoryDAO(new ConnectionFactory().getConnection());
        for( Integer i = 0; i < this.generationAmount; i++){
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

        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("name", "Categoria 0");

        LinkedHashMap<String, Object> newData = new LinkedHashMap<String, Object>();
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

    public void testSelection() throws DAOException {
        CategoryDAO dao = new CategoryDAO(new ConnectionFactory().getConnection());
        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("name", "Categoria 1");
        List<Category> filtered = dao.select(filters);
        System.out.println(filtered);
    }
}
