/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateful;

import cart.item.CartItem;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Codoic
 */
@Remote
public interface CartBeanRemote {

    boolean addCart(String id, int quantity);

    ArrayList<CartItem> getCart();

    double cartTotal();

    boolean emptyCart();

    boolean checkout(String email);
    
}
