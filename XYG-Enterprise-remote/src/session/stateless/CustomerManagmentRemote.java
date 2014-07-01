/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import customer.dto.CustomerDTO;
import java.util.List;
import javax.ejb.Remote;
import persistance.entity.Catalogue;

/**
 *
 * @author Codoic
 */
@Remote
public interface CustomerManagmentRemote {

    boolean signup(String name, String address, String phone, String password, String secquest, String secanswer, String email);

    boolean chkOldCustomer(String email);

    boolean login(String email, String password);

    List<Catalogue> getCatalogue();

    CustomerDTO customerDTO(String email);

    boolean updateCustomer(String name, String address, String phone, String secquestion, String secanswer, String email);

    boolean changePassword(String email, String oldpass, String newpass);

      
}
