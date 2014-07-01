/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import java.util.List;
import javax.ejb.Local;
import persistance.entity.CustomerOrder;

/**
 *
 * @author Codoic
 */
@Local
public interface CustomerOrderFacadeLocal {

    void create(CustomerOrder customerOrder);

    void edit(CustomerOrder customerOrder);

    void remove(CustomerOrder customerOrder);

    CustomerOrder find(Object id);

    List<CustomerOrder> findAll();

    List<CustomerOrder> findRange(int[] range);

    int count();

    CustomerOrder add(int name, double cost);

    List<CustomerOrder> getAllItems();
    
}
