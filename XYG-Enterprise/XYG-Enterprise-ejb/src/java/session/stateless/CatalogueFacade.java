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
import persistance.entity.Catalogue;

/**
 *
 * @author Codoic
 */
@Stateless
public class CatalogueFacade extends AbstractFacade<Catalogue> implements CatalogueFacadeLocal {

    @PersistenceContext(unitName = "XYG-Enterprise-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogueFacade() {
        super(Catalogue.class);
    }

    /**
     * checks whether the stock exist using d
     *
     * @param id
     * @return true if exist, false otherwise
     */
    @Override
    public boolean hasStock(String id) {
        Catalogue item = find(id);
        if (item != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * add a new stock to Catalogue
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
        //Check if same id stock as already been added 
        Catalogue c = find(id);
        if (c != null) {
            //cannot not add 
            return false;
        }
        Catalogue item= new Catalogue();
        item.setCatalogueid(id);
        item.setType(type);
        item.setArtist(artist);
        item.setName(name);
        item.setPrice(price);
        item.setQuantity(quantity);
        create(item);
        System.out.println("New item sucessully added in Catalogue!");
        return true;
    }

     /**
     * update a new stock to Catalogue
     * @param id
     * @param type
     * @param artist
     * @param name
     * @param price
     * @param quantity
     * @return true if addition is successful, false otherwise
     */
    @Override
    public boolean updateStock(String id, String type, String artist, String name, double price, int quantity) {
        //Check if same id stock as already been added 
        Query query = em.createNamedQuery("Catalogue.findByCatalogueid").setParameter("catalogueid", id);
        System.out.println("ID"+id);
        System.out.println("Type"+type); 
        System.out.println("Request for"+name);
        System.out.println("Request for"+price); 
        System.out.println("Request for"+quantity); 
        List<Catalogue> items = query.getResultList();
        Catalogue c = items.get(0);
        System.out.println("Request for"+c.toString()); 
        if (c == null) {
            //cannot not add 
            return false;
        }
       c.setType(type);
       c.setArtist(artist);;
       c.setName(name);
       c.setPrice(price);
       c.setQuantity(quantity);
       return true;
    }

       /**
     * delete a stock from Catalogue
     * @param id
     * @return true if removed, false otherwise
     */
    @Override
    public boolean deleteStock(String id) {
        Catalogue c=find(id); 
        if (c==null){
            return false;
        }
        remove(c);
        return true; 
    }

     /**
     * get an item from Catalogue
     * @param id
     * @return Catalogue c if found , else null 
     */
    @Override
    public Catalogue getItem(String id) {
        Catalogue c=find(id);
        if(c==null){
            //not found no such item in catalogue
            return null; 
        }
        return c;
    }

    /**
     * get all item from Catalogue
     * @return List<Catalogue> is the catalogue
     */
    @Override
    public List<Catalogue> getAllItems() {
        Query query=em.createNamedQuery("Catalogue.findAll");
        return (List<Catalogue>)query.getResultList();
    }
    
    
    
    
    
    
}
