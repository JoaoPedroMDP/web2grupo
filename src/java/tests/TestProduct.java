package tests;

import java.util.LinkedHashMap;
import java.util.List;

import beans.Product;
import daos.ProductDAO;
import exceptions.DAOException;
import exceptions.NotFound;
import interfaces.Tests;
import utils.ConnectionFactory;

public class TestProduct implements Tests{
    private Integer idToRetrieve;
    private Integer idToDelete;
    private Integer idToUpdate;
    private Integer generationAmount;

    public TestProduct(){
        this.idToRetrieve = 1;
        this.idToUpdate = 2;
        this.idToDelete = 3;
        this.generationAmount = 3;
    }

    public void testInsertion() throws DAOException{
        ProductDAO dao = new ProductDAO(new ConnectionFactory().getConnection());
        for( Integer i = 0; i < this.generationAmount; i++){
            Product product = new Product();
            product.setName("Produto " + i);
            product.setImage("Imagem");
            product.setWeight(Float.valueOf("45.3"));
            product.setCategory_id(1);

            dao.insert(product);
        }
    }

    public void testGet() throws DAOException, NotFound {
        Product product = new ProductDAO(new ConnectionFactory().getConnection()).get(this.idToRetrieve);

        System.out.println(product.getName());
    }

    public void testIndex() throws DAOException {
        List<Product> products = new ProductDAO(new ConnectionFactory().getConnection()).getAll();

        for(Product product : products){
            System.out.println(product.getName());
        }
    }

    public void testUpdate() throws DAOException, NotFound {
        ProductDAO dao = new ProductDAO(new ConnectionFactory().getConnection());

        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("name", "Produto 0");

        LinkedHashMap<String, Object> newData = new LinkedHashMap<String, Object>();
        newData.put("name", "Produto Alterado");
        dao.update(filters, newData);

        Product product = dao.get(this.idToUpdate);
        product.setName("Tambem funfa");
        dao.update(product);
    }

    public void testDeletion() throws DAOException, NotFound {
        ProductDAO dao = new ProductDAO(new ConnectionFactory().getConnection());
        dao.delete(idToDelete);
    }

    public void testSelection() throws DAOException {
        ProductDAO dao = new ProductDAO(new ConnectionFactory().getConnection());
        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("weight", 45.3);
        List<Product> filtered = dao.select(filters);
        System.out.println(filtered);
    }
}
