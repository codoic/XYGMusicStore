/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xyg.managed;

import cart.item.CartItem;
import customer.dto.CustomerDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import persistance.entity.Catalogue;
import session.stateful.CartBeanRemote;
import session.stateless.CustomerManagmentRemote;

/**
 *
 * @author Codoic
 */
@Named(value = "customerManaged")
@SessionScoped
public class customerManaged implements Serializable {
    @EJB
    private CartBeanRemote cartBean;
    @EJB
    private CustomerManagmentRemote customerManagment;
    String name;
    String address;
    String phone;
    String password;
    String secquestion;
    String secanswer;
    String email; 
    
    //for password change
    String oldpass;
    String newpass;
    
    List<Catalogue> clist;
    ArrayList<CartItem> cart;
    double cartTotal;
    
    public customerManaged() {
        email="";
        password="";
        clist=null;
        cart=null;
        cartTotal=0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(int cartTotal) {
        this.cartTotal = cartTotal;
    }

    public ArrayList<CartItem> getCart() {
        return cart;
    }

    public void setCart(ArrayList<CartItem> cart) {
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecquestion() {
        return secquestion;
    }

    public void setSecquestion(String secquestion) {
        this.secquestion = secquestion;
    }

    public String getSecanswer() {
        return secanswer;
    }

    public void setSecanswer(String secanswer) {
        this.secanswer = secanswer;
    }

    public String getOldpass() {
        return oldpass;
    }

    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }
    
    
 
     /**
     * Authentication. Call CustomerManagment session bean 
     * @param email is unique email address of customer
     * @param password is the password of customer stored inside database
     * @return true if authentication is successfull or false  
     */
    public String login(){
        String result="failure";
        if(customerManagment.login(email, password)){
            setCustomerDetails();
            result="success";
        }
        return result; 
    }
   //method to getCatalogue 
    public List<Catalogue> getCatalogue(){
        clist=customerManagment.getCatalogue();
        return clist;
    }
    
    //adds an item to cart
    public boolean addCart(String id){
        System.out.println("Called this");
        if(cartBean.addCart(id, 1)){
            cartItems();
            return true;
        } 
        return false; 
    }
    
    public double cartTotal(){
        cartTotal=cartBean.cartTotal();
        return cartTotal;
        
    }
    
    public void cartItems(){
        cart=cartBean.getCart();
        for (CartItem c: cart){
            System.out.println(c.getName());
        }
    }
    //empty cart
    public boolean emptyCart(){
        cartBean.emptyCart();
        cart=cartBean.getCart();
        return true; 
    }
    
    //facility for checkout.
    //at this stage the order will be persistant into to CustomerOrder and 
    //LineItems.
    //Need to confirm payment before doing this. Not implemented
    public String checkout(){
        String result="success"; 
        cartBean.checkout(email);
        return result; 
    }
    
    //method to set customer details from CustomerManagment after logged in 
    public void setCustomerDetails(){
        CustomerDTO cust=customerManagment.customerDTO(email);
        name=cust.getName();
        address=cust.getAddress();
        phone=cust.getPhone();
        secquestion=cust.getSecquest();
        secanswer=cust.getSecanswer();
        email=cust.getEmail();
    }
    
    //method to change personal details from CustomerManagment
    public String updateDetails(){
        String result="failure";
        if(customerManagment.updateCustomer(name, address, phone, secquestion, secanswer, email)){
            setCustomerDetails();
            result="success";
        }
        return result; 
    }
    
    //method to change the password
    public String changePassword(){
        String result="failure";
        
        if(customerManagment.changePassword(email, oldpass, newpass)){
            result="success";
        }
        return result; 
    }
    
}
