/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import Beans.Address;
import DAOs.AddressDAO;
import Exceptions.DAOException;

/**
 *
 * @author Ludimilla
 */
public class AddressFacade {
          public static void CreateAddress(Address address) throws DAOException{
          AddressDAO.create(address);
    }
    
    public static void UpdateAddress(int id, Address address) throws DAOException {
        AddressDAO.update(id, address);
    }
    
    public static Address serchAddress(int id) throws DAOException{
        return AddressDAO.readOne(id);
    }
    
     public static Address serchAddressByZipCode(int zip_code, String number) throws DAOException{
        return AddressDAO.readZipCode(zip_code, number);
    }

    
    public static void DeleteAddress(int id) throws DAOException {
        AddressDAO.delete(id);
    }
}
