/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import persistance.entity.CustomerOrder;
import persistance.entity.LineItems;

/**
 *
 * @author Codoic
 */
@Stateless
public class OrderManagment implements OrderManagmentRemote {
    @EJB
    private LineItemsFacadeLocal lineItemsFacade;
    @EJB
    private CustomerOrderFacadeLocal customerOrderFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

   //get all the order items 
    @Override
    public List<CustomerOrder> getAllOrder() {
        return customerOrderFacade.getAllItems();
    }

    //get the line items 
    @Override
    public List<LineItems> getLineItems() {
        return lineItemsFacade.getLineItems();
    }
    
    

}
