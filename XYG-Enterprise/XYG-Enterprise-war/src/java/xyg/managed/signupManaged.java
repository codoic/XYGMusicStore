/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xyg.managed;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import session.stateless.CustomerManagmentRemote;

/**
 *
 * @author Codoic
 */
@Named(value = "signupManaged")
@RequestScoped
public class signupManaged {
    @EJB
    private CustomerManagmentRemote customerManagment;
String name;
String address;
String phone;
String password;
String secquest;
String secanswer;
String email; 

    /**
     * Creates a new instance of signupManaged
     */
    public signupManaged() {
        name="";
        address="";
        phone="";
        password="";
        secquest="";
        secanswer="";
        email="";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecquest() {
        return secquest;
    }

    public void setSecquest(String secquest) {
        this.secquest = secquest;
    }

    public String getSecanswer() {
        return secanswer;
    }

    public void setSecanswer(String secanswer) {
        this.secanswer = secanswer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //call signup from customerManagment session bean to signup 
    public String signup(){
        String result="failure"; 
        
        if(customerManagment.signup(name, address, phone, password, secquest, secanswer, email)){
            result="success";
        }
        return result; 
        
    }
    
}
