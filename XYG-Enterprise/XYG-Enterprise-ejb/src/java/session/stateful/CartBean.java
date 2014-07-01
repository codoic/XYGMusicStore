/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateful;

import cart.item.CartItem;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import persistance.entity.Catalogue;
import persistance.entity.Customer;
import persistance.entity.CustomerOrder;
import session.stateless.CatalogueFacadeLocal;
import session.stateless.CustomerFacadeLocal;
import session.stateless.CustomerOrderFacadeLocal;
import session.stateless.LineItemsFacadeLocal;

/**
 *
 * @author Codoic
 */
@Stateful
public class CartBean implements CartBeanRemote {
    @EJB
    private CustomerFacadeLocal customerFacade;
    @EJB
    private LineItemsFacadeLocal lineItemsFacade;
    @EJB
    private CustomerOrderFacadeLocal customerOrderFacade;

    @EJB
    private CatalogueFacadeLocal catalogueFacade;
    private ArrayList<CartItem> cart;

    public CartBean() {
        cart = new ArrayList<CartItem>();
    }

    @Override
    public boolean addCart(String id, int quantity) {
        boolean result = false;
        Catalogue item = catalogueFacade.find(id);
        if (item == null) {
            System.out.print("Incorrect id provided to enter in cart!");
            return false;
        }
//check if object already exists inside cart 
//if already exist just increment the quantity and update the price for that object        
        for (CartItem c : cart) {
            if (c.getId().equals(id)) {
                c.setQuantity(c.getQuantity() + quantity);
                double value = c.getCost() + item.getPrice();
                c.setCost(Math.round(value * 100) / 100.00);//change to decimal 
                return true;
            }
        }
        //create a new cartItem
        CartItem cItem = new CartItem(id, item.getName(), item.getPrice(), quantity);
        result = cart.add(cItem);
        System.out.println("Item added to cart sucessfully!");

        return result;
    }

    @Override
    public ArrayList<CartItem> getCart() {
        return cart;
    }

    @Override
    public double cartTotal() {
        double total=0;
        for(CartItem c:cart){
            total+=Math.round(c.getCost()*100)/100.00;
        }
        return total; 
    }
    
    //empty cart
    @Override
    public boolean emptyCart() {
        cart.clear();
        return true;
    }
    
    //method to checkout if shopping is finished 
    @Override
    public boolean checkout(String email) {
        Customer customer=customerFacade.getCustomer(email);
        
        CustomerOrder order=customerOrderFacade.add(customer.getCustid(), cartTotal());
         for(CartItem c:cart){
            lineItemsFacade.add(c.getId(), c.getQuantity(), order);
        }
        emptyCart();
        return true;
    }

    @Remove
    public void remove() {
        cart = null;
    }

   
}
