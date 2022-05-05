/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import beans.Category;
import daos.CategoryDAO;
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
public class CategoryFacade {
    List<Category> CategoryList = new ArrayList<>();
    
    public void remover(Category c) {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            CategoryDAO dao = new CategoryDAO(con);
            dao.delete(c);
        } catch (DAOException ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserir(Category c) {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            CategoryDAO dao = new CategoryDAO(con);
            dao.insert(c);
        } catch (DAOException ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Category changes) {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            CategoryDAO dao = new CategoryDAO(con);

            LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object>();
            filters.put("id", changes.getId());
            LinkedHashMap<String, Object> newData = new LinkedHashMap<String, Object>();
            newData.put("name", changes.getName());
            dao.update(filters, newData);
        } catch (DAOException ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public Category buscar(Category c) throws DAOException, NotFound {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        CategoryDAO cd = new CategoryDAO(con);
        Category escolhido = cd.get(c.getId());

        return escolhido;
    }
    public Category buscar(String ids) throws DAOException, NotFound {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        int id = Integer.parseInt(ids);
        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        CategoryDAO c = new CategoryDAO(con);
        Category escolhido = c.get(id);

        return escolhido;
    }

    public Table buscarTodos(String role) throws DAOException, NotFound {
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;

        try {
            con = conFac.getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(CategoryFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        CategoryDAO c = new CategoryDAO(con);        
        CategoryList = c.getAll();  
        Tabler<Category> t = new Tabler<>(CategoryList.get(0).getColumns(),role);
        t.wrapData(CategoryList.toArray(new Category[CategoryList.size()]));
        return t.tablefy();
    }
}
