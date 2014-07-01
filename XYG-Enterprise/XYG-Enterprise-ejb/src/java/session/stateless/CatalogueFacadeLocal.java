/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import java.util.List;
import javax.ejb.Local;
import persistance.entity.Catalogue;

/**
 *
 * @author Codoic
 */
@Local
public interface CatalogueFacadeLocal {

    void create(Catalogue catalogue);

    void edit(Catalogue catalogue);

    void remove(Catalogue catalogue);

    Catalogue find(Object id);

    List<Catalogue> findAll();

    List<Catalogue> findRange(int[] range);

    int count();

    boolean hasStock(String id);

    boolean addStock(String id, String type, String artist, String name, double price, int quantity);

    boolean updateStock(String id, String type, String artist, String name, double price, int quantity);

    boolean deleteStock(String id);

    Catalogue getItem(String id);

    List<Catalogue> getAllItems();
    
}
