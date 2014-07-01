/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cart.item;

import java.io.Serializable;

/**
 *jave POJO to hold cartItem 
 * @author Codoic
 */
public class CartItem implements Serializable {

    String id;
    String name;
    double cost;
    int quantity;
    
    public CartItem(String id, String name, double cost, int quantity){
        this.id=id;
        this.name=name;
        this.cost=cost;
        this.quantity=quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
