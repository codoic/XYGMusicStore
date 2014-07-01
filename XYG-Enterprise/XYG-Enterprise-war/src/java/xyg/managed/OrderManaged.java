/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xyg.managed;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import persistance.entity.CustomerOrder;
import persistance.entity.LineItems;
import session.stateless.OrderManagmentRemote;

/**
 *
 * @author Codoic
 */
@Named(value = "orderManaged")
@RequestScoped
public class OrderManaged {
    @EJB
    private OrderManagmentRemote orderManagment;

    List<CustomerOrder> order; 
    List<LineItems> items; 
    /**
     * Creates a new instance of OrderManaged
     */
    public OrderManaged() {
    }

    public List<CustomerOrder> getOrder() {
        if(order==null){
            order=orderManagment.getAllOrder();
        }
        return order;
    }

    public void setOrder(List<CustomerOrder> order) {
        this.order = order;
    }

    public List<LineItems> getItems() {
        if(items==null){
            items=orderManagment.getLineItems();
        }
        return items;
    }

    public void setItems(List<LineItems> items) {
        this.items = items;
    }
    
    
    
}
