/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import java.util.List;
import javax.ejb.Remote;
import persistance.entity.CustomerOrder;
import persistance.entity.LineItems;

/**
 *
 * @author Codoic
 */
@Remote
public interface OrderManagmentRemote {

    List<CustomerOrder> getAllOrder();

    List<LineItems> getLineItems();
    
}
