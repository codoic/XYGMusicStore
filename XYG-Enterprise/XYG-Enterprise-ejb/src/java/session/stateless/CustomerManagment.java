/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import customer.dto.CustomerDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import persistance.entity.Catalogue;
import persistance.entity.Customer;

/**
 *
 * @author Codoic
 * uses functionality provided by local session bean CustomerFacade.java
 * this session bean can be called remotely for Cutomer Management 
 */
@Stateless
public class CustomerManagment implements CustomerManagmentRemote {
    @EJB
    private CatalogueFacadeLocal catalogueFacade;//only to get catalogue
    @EJB
    private CustomerFacadeLocal customerFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

     /**
     * add a customer to the table only if email address provide is 
     * unique or else do not add a new record. 
     * @param name
     * @param addres
     * @param phone
     * @param password
     * @param secquest
     * @param secanswer
     * @param email
     * @return true if addition is successful, false otherwise
     */
    @Override
    public boolean signup(String name,String address, String phone, String password,
    String secquest, String secanswer, String email) {
        return customerFacade.addCustomer(name, address, phone, password, secquest, secanswer, email);
    }

    
      /**
     * checks if customer is new customer by their email  id 
     * @param email
     * @return true if record exist by checking email address in the table  
     */
    @Override
    public boolean chkOldCustomer(String email) {
        return customerFacade.chkOldCustomer(email);
    }

      /**
     * Authentication for the customer
     * @param email is unique email address of customer
     * @param password is the password of customer stored inside database
     * @return true if authentication is successfull or false  
     */
    @Override
    public boolean login(String email, String password) {
       return customerFacade.login(email, password);
    }

    @Override
    public List<Catalogue> getCatalogue() {
        return catalogueFacade.getAllItems();
    }

     /**
     * Returns CustomerDTO which includes all parameter except password
     * see CustomerDTO.java. Mainly to maintain confidential data password
     * @param email is unique email address of customer
     * @return CustomerDTO if authentication is successfull or false  
     */
    @Override
    public CustomerDTO customerDTO(String email) { 
        Customer cust=customerFacade.getCustomer(email); 
        CustomerDTO c=new CustomerDTO(cust.getName(),cust.getAddress(),cust.getPhone(),
                            cust.getSecquestion(),cust.getSecanswer(),cust.getEmail());
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
    public boolean updateCustomer(String name, String address, String phone, String secquestion, String secanswer, String email) {
        customerFacade.updateCustomer(name, address, phone, secquestion, secanswer, email);
        return true;
    }

    @Override
    public boolean changePassword(String email, String oldpass, String newpass) {
        if(customerFacade.changePassword(email, oldpass, newpass)){
            return true; 
        }
        return false;
    }
    
    
    
    
    
    

    
    
    
    
    

}
