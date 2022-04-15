package Tests;

import java.util.LinkedHashMap;
import java.util.List;

import Beans.Product;
import DAOs.ProductDAO;
import Exceptions.DAOException;
import Exceptions.NotFound;
import Interfaces.Tests;
import Utils.ConnectionFactory;

public class TestProduct implements Tests{
    private int idToRetrieve;
    private int idToDelete;
    private int idToUpdate;
    private int generationAmount;

    public TestProduct(){
        this.idToRetrieve = 1;
        this.idToUpdate = 2;
        this.idToDelete = 3;
        this.generationAmount = 3;
    }

    public void testInsertion() throws DAOException{
        ProductDAO dao = new ProductDAO(new ConnectionFactory().getConnection());
        for( int i = 0; i < this.generationAmount; i++){
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
}
