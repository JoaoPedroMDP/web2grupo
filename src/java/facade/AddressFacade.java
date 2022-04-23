/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import Beans.Address;
import DAOs.AddressDAO;

/**
 *
 * @author Ludimilla
 */
public class AddressFacade {
          public static void CreateAddress(Address address){
          AddressDAO.create(address);
    }
    
    public static void UpdateAddress(int id, Address address) {
        AddressDAO.update(id, address);
    }
    
    public static Address serchAddress(int id){
        return AddressDAO.readOne(id);
    }
    
     public static Address serchAddressByZipCode(int zip_code){
        return AddressDAO.readZipCode(zip_code);
    }

    
    public static void DeleteAddress(int id) {
        AddressDAO.delete(id);
    }
}
