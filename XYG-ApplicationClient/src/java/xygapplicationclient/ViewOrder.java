/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xygapplicationclient;

import java.util.List;
import javax.ejb.EJB;
import persistance.entity.CustomerOrder;
import persistance.entity.LineItems;
import session.stateless.OrderManagmentRemote;

/**
 * Class to view all order This part is not completed effectively in JSF
 */
public class ViewOrder {

    @EJB
    private static OrderManagmentRemote orderManagment;

    public void displayOrder() {
        List<CustomerOrder> list = orderManagment.getAllOrder();
        for (CustomerOrder c : list) {
            System.out.println(c.getOrderId());
            for (LineItems l : c.getLineItemsCollection()) {
                System.out.println(l.getItemid());
            }
        }

    }
}
