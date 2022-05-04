/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import Beans.User;
import DAOs.UserDAO;
import Exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ludimilla
 */
public class UserFacade {
      public static void CreateUser(User user) throws DAOException{
          UserDAO.create(user);
    }
    
    public static void UpdateUser(int id, User user) throws DAOException {
        UserDAO.update(id, user);
    }
    
    public static User serchUser(int id) throws DAOException{
        return UserDAO.readOne(id);
    }

    
    public static void DeleteUser(int id) throws DAOException {
        UserDAO.delete(id);
    }
}
