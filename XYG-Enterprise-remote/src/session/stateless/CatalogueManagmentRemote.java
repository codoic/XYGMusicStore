/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import java.util.List;
import javax.ejb.Remote;
import persistance.entity.Catalogue;

/**
 *
 * @author Codoic
 */
@Remote
public interface CatalogueManagmentRemote {

    boolean addStock(String id, String type, String artist, String name, double price, int quantity);

    boolean updateStock(String id, String type, String artist, String name, double price, int quantity);

    boolean deleteStock(String id);

    Catalogue getItem(String id);

    List<Catalogue> getCatalogue();
    
}
