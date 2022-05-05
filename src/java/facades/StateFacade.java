/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import beans.State;
import daos.StateDAO;
import exceptions.DAOException;
import utils.ConnectionFactory;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Leo
 */
public class StateFacade {
    public List<State> searchList() throws DAOException{
        ConnectionFactory conFac = new ConnectionFactory();
        Connection con = null;
        con = conFac.getConnection();
        StateDAO d = new StateDAO(con);
        List<State> list = d.getAll();
        return list;
    }
}