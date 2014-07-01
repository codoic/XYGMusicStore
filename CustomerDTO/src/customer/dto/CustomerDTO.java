/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customer.dto;

import java.io.Serializable;

/**
 *CustomerDTO. This returns all field except password
 * @author nitesh
 */
public class CustomerDTO implements Serializable {
    String name;
    String address;
    String phone;
    String secquest;
    String secanswer;
    String email;

    public CustomerDTO(String name, String address, String phone, String secquest, String secanswer, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.secquest = secquest;
        this.secanswer = secanswer;
        this.email = email;
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
    
    
    
}
