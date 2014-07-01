/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import persistance.entity.Customer;

/**
 *
 * @author Codoic
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {

    @PersistenceContext(unitName = "XYG-Enterprise-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    /**
     * add a customer to the table only if email address provide is unique or
     * else do not add a new record.
     *
     * @param name
     * @param addres
     * @param phone
     * @param password
     * @param secquest
     * @param secanswer
     * @return true if addition is successful, false otherwise
     */
    @Override
    public boolean addCustomer(String name, String address, String phone,
            String password, String secquest, String secanswer, String email) {
        if (!chkOldCustomer(email)) {
            Customer nCust = new Customer();
            nCust.setName(name);
            nCust.setAddress(address);
            nCust.setPhone(phone);
            nCust.setPassword(password);
            nCust.setSecquestion(secquest);
            nCust.setSecanswer(secanswer);
            nCust.setEmail(email);
            create(nCust);
            System.out.println("Successfully created a new customer!");
            return true;
        } else {
            System.out.println("This is an old customer.Ask them to login instead");
            return false;
        }


    }

    /**
     * checks if customer is new customer by their email id
     *
     * @param email
     * @return true if record exist by checking email address in the table
     */
    @Override
    public boolean chkOldCustomer(String email) {
        Query query = em.createNamedQuery("Customer.findByEmail").setParameter("email", email);
        List<Customer> customers = query.getResultList();

        if (customers.isEmpty()) {
            System.out.println("No items in the list");
            return false;
        }

        Customer c = customers.get(0);
        if (c == null) {
            return false;
        }
        if (c.getEmail().equals(email)) {
            return true;
        }
        return false;
    }

    /**
     * Authentication for the customer
     *
     * @param email is unique email address of customer
     * @param password is the password of customer stored inside database
     * @return true if authentication is successfull or false
     */
    @Override
    public boolean login(String email, String password) {
        Query query = em.createNamedQuery("Customer.findByEmail").setParameter("email", email);
        List<Customer> customers = query.getResultList();

        if (customers.isEmpty()) {
            System.out.println("No record found for this email address.Ask to signup");
            return false;
        }

        Customer c = customers.get(0);
        if (c == null) {
            return false;
        }

        if ((c.getEmail().equals(email)) && (c.getPassword().equals(password))) {
            System.out.println("Authetication approved for this customer");
            return true;
        }
        return false;
    }

     /**
     * Get the customer object
     *
     * @param email is unique email address of customer
     * @return Customer c
     */
    @Override
    public Customer getCustomer(String email) {
        Query query = em.createNamedQuery("Customer.findByEmail").setParameter("email", email);
        List<Customer> customers = query.getResultList();

        Customer c = customers.get(0);
        return c;
    }

     /**
     * Update the customer details
     *customer cannot update custid, email for this project:)
     * @param name is the new name
     * @param address is the new address
     * @param phone is the new phone
     * @param secquestion is the new securityquestion
     * @param secanswer is the new secanswer
     * @param email is the email add for searching inside record. Sorry customer have to contact admin to change this. 
     * @return true after update is done
     */
    @Override
    public boolean updateCustomer(String name, String address,String phone, String secquestion, String secanswer, String email) {
        Query query = em.createNamedQuery("Customer.findByEmail").setParameter("email", email);
        List<Customer> customers = query.getResultList();
        Customer c = customers.get(0);
        c.setName(name);
        c.setAddress(address);
        c.setPhone(phone);
        c.setSecquestion(secquestion);
        c.setSecanswer(secanswer);
        return true;
    }

     /**
     * Change customer password
     * @param email is the email address
     * @param oldpass is the old password of customer
     * @param newpass is the new phone
     * @return true if password is changed or else false
     */
    @Override
    public boolean changePassword(String email, String oldpass, String newpass) {
         Query query = em.createNamedQuery("Customer.findByEmail").setParameter("email", email);
        List<Customer> customers = query.getResultList();
        Customer c = customers.get(0);
        
        if(c.getPassword().equals(oldpass)){
            c.setPassword(newpass);
            return true; 
        }
        return false;
    }
    
    
    
    
}
