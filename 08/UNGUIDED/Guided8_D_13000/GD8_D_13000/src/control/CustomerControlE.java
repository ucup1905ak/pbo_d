/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import dao.CustomerDAOE;
import java.util.List;
import model.CustomerE;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class CustomerControlE extends CustomerControl{
    CustomerDAOE cDao = new CustomerDAOE();
    
    public List<CustomerE> showListCustomer() {
        List<CustomerE> dataCustomer = cDao.IShowForDropdown();
        
        return dataCustomer;
    }
}
