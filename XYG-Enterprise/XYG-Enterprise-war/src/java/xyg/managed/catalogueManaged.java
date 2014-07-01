/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xyg.managed;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import persistance.entity.Catalogue;
import session.stateless.CatalogueManagmentRemote;

/**
 *
 * @author Codoic
 */
@Named(value = "catalogueManaged")
@RequestScoped
public class catalogueManaged {

    @EJB
    private CatalogueManagmentRemote catalogueManagment;
    //items in catalogue
    String id;
    String type;
    String artist;
    String name;
    double price;
    int quantity;
    List<Catalogue> clist;

    /**
     * Creates a new instance of catalogueManaged
     */
    public catalogueManaged() {
       // clist = new ArrayList<Catalogue>();
        
        id = "";
        type = "";
        artist = "";
        name = "";
        price = 0;
        quantity = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //calls method to addItem in catalogue
    public String addItem() {
        String result = "failure";

        if (catalogueManagment.addStock(id, type, artist, name, price, quantity)) {
            result = "success";
        }
        return result;
    }

    public List<Catalogue> getClist() {
        if (clist == null) {
            clist = catalogueManagment.getCatalogue();
        }
        return clist;
    }

    public void setClist(List<Catalogue> clist) {
        this.clist = clist;
    }

    //method to getCatalogue 
    public List<Catalogue> getCatalogue() {
        clist = catalogueManagment.getCatalogue();
        return clist;
    }

    //edit 
    public void onEdit(RowEditEvent event) {

        FacesMessage msg = new FacesMessage("Item detail edited", ((Catalogue) event.getObject()).getCatalogueid());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        id = ((Catalogue) event.getObject()).getCatalogueid();
        type = ((Catalogue) event.getObject()).getType();
        artist = ((Catalogue) event.getObject()).getArtist();
        name = ((Catalogue) event.getObject()).getName();
        price = ((Catalogue) event.getObject()).getPrice();
        quantity = ((Catalogue) event.getObject()).getQuantity();
        catalogueManagment.updateStock(id, type, artist, name, price, quantity);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Catalogue) event.getObject()).getCatalogueid());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
       public void onDelete(String id) {
           System.out.println("Called delete"); 
           catalogueManagment.deleteStock(id);
    }
}
