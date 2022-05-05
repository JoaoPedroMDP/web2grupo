/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import beans.City;
import daos.CityDAO;
import exceptions.DAOException;
import utils.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
/**
 *
 * @author Leo
 */
public class CityFacade {
    public List<City> searchList(String id) throws DAOException{
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        con = conFac.getConnection();
        CityDAO d = new CityDAO(con);
        LinkedHashMap<String, Object> filters = new LinkedHashMap<String, Object> ();
        filters.put("id_estado", id);
        List<City> list = d.select(filters);
        return list;
    }
    
    public static City serchCityId(String name) throws DAOException{
        return CityDAO.readCity(name);
    }
    
}