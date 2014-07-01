/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import java.util.List;
import javax.ejb.Local;
import persistance.entity.Customer;

/**
 *
 * @author Codoic
 */
@Local
public interface CustomerFacadeLocal {

    void create(Customer customer);

    void edit(Customer customer);

    void remove(Customer customer);

    Customer find(Object id);

    List<Customer> findAll();

    List<Customer> findRange(int[] range);

    int count();

    boolean addCustomer(String name, String address, String phone, String password, String secquest, String secanswer, String email);

    boolean chkOldCustomer(String email);

    boolean login(String email, String password);

    Customer getCustomer(String email);

    boolean updateCustomer(String name, String address,String phone, String secquestion, String secanswer, String email);

    boolean changePassword(String email, String oldpass, String newpass);
    
}
