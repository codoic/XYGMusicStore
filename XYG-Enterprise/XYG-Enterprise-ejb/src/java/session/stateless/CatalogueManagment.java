/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;
import persistance.entity.Catalogue;

/**
 *
 * @author Codoic
 */
@Stateless
public class CatalogueManagment implements CatalogueManagmentRemote {

    @EJB
    private CatalogueFacadeLocal catalogueFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /**
     * add a new stock to Catalogue
     *
     * @param id
     * @param type
     * @param artist
     * @param name
     * @param price
     * @param quantity
     * @return true if addition is successful, false otherwise
     */
    @Override
    public boolean addStock(String id, String type, String artist, String name, double price, int quantity) {
        return catalogueFacade.addStock(id, type, artist, name, price, quantity);
    }

    /**
     * update a new stock to Catalogue
     *
     * @param id
     * @param type
     * @param artist
     * @param name
     * @param price
     * @param quantity
     * @return true if update is successful, false otherwise
     */
    @Override
    public boolean updateStock(String id, String type, String artist, String name, double price, int quantity) {
        return catalogueFacade.updateStock(id, type, artist, name, price, quantity);
    }

    /**
     * delete a stock from Catalogue
     *
     * @param id
     * @return true if removed, false otherwise
     */
    @Override
    public boolean deleteStock(String id) {
        return catalogueFacade.deleteStock(id);
    }

    @Override
    public Catalogue getItem(String id) {
        return catalogueFacade.getItem(id);
    }

    /**
     * get current Catalogue in case admin people want to have a look  
     * @return List<Catalogue> is the catalogue
     */
    @Override
    public List<Catalogue> getCatalogue() {
       return catalogueFacade.getAllItems();
        
    }
    
    
}
