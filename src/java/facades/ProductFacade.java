/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import beans.Product;
import daos.ProductDAO;
import exceptions.DAOException;
import exceptions.NotFound;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnectionFactory;
import utils.Tabler;
import utils.frontHelpers.table.Table;

/**
 *
 * @author Leo
 */
public class ProductFacade {
    List<Product> ProductList = new ArrayList<>();
    
    public void remover(Product c) {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ProductDAO dao = new ProductDAO(con);
            dao.delete(c);
        } catch (DAOException ex) {
            Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserir(Product c) {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ProductDAO dao = new ProductDAO(con);
            dao.insert(c);
        } catch (DAOException ex) {
            Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Product changes) {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ProductDAO dao = new ProductDAO(con);

            LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
            filters.put("id", changes.getId());
            LinkedHashMap<String, Object> newData = new LinkedHashMap<String, Object>();
            newData.put("name", changes.getName());
            dao.update(filters, newData);
        } catch (DAOException ex) {
            Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Product buscar(String ids) throws DAOException, NotFound {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        int id = Integer.parseInt(ids);
        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProductDAO c = new ProductDAO(con);
        Product escolhido = c.get(id);

        return escolhido;
    }
    public List<Product> buscarUm(String name) throws DAOException, NotFound {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProductDAO c = new ProductDAO(con);
        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
        filters.put("name", name);
        List<Product> escolhido = c.select(filters);

        return escolhido;
    }
    public Table buscarTodos(String role) throws DAOException, NotFound {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;

        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProductDAO c = new ProductDAO(con);        
        ProductList = c.getAll();  
        Tabler<Product> t = new Tabler<>(ProductList.get(0).getColumns(),role);
        t.wrapData(ProductList.toArray(new Product[ProductList.size()]));
        return t.tablefy();
    }
}
