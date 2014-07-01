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
import persistance.entity.CustomerOrder;

/**
 *
 * @author Codoic
 */
@Stateless
public class CustomerOrderFacade extends AbstractFacade<CustomerOrder> implements CustomerOrderFacadeLocal {
    @PersistenceContext(unitName = "XYG-Enterprise-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerOrderFacade() {
        super(CustomerOrder.class);
    }

    //add a new order
    @Override
    public CustomerOrder add(int custid, double cost) {
        CustomerOrder order=new CustomerOrder();
        order.setCustid(custid);
        order.setTotalamt(cost);
        create(order);
        
        return order;
    }

    //return all the order 
    @Override
    public List<CustomerOrder> getAllItems() {
        Query query=em.createNamedQuery("CustomerOrder.findAll");
        return (List<CustomerOrder>)query.getResultList();
    }
    
    
    
    
    
}
