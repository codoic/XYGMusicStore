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
import persistance.entity.LineItems;

/**
 *
 * @author Codoic
 */
@Stateless
public class LineItemsFacade extends AbstractFacade<LineItems> implements LineItemsFacadeLocal {
    @PersistenceContext(unitName = "XYG-Enterprise-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineItemsFacade() {
        super(LineItems.class);
    }

    @Override
    public boolean add(String itemid,int quantity, CustomerOrder order) {
        LineItems item=new LineItems(); 
        
        item.setItemid(itemid);
        item.setQuantity(quantity);
        item.setOrderId(order);
        
        create(item);
        
        return true;
    }

    //get all LineItems
    @Override
    public List<LineItems> getLineItems() {
         Query query=em.createNamedQuery("LineItems.findAll");
        return (List<LineItems>)query.getResultList();
    }
    
    //get line itemsby id 
    
    
    
    
    
}
