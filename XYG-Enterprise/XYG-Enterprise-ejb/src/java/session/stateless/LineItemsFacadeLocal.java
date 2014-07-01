/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import java.util.List;
import javax.ejb.Local;
import persistance.entity.CustomerOrder;
import persistance.entity.LineItems;

/**
 *
 * @author Codoic
 */
@Local
public interface LineItemsFacadeLocal {

    void create(LineItems lineItems);

    void edit(LineItems lineItems);

    void remove(LineItems lineItems);

    LineItems find(Object id);

    List<LineItems> findAll();

    List<LineItems> findRange(int[] range);

    int count();

    boolean add(String itemid, int quantity,CustomerOrder order);

    List<LineItems> getLineItems();
    
}
