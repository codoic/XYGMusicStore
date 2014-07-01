/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import persistance.entity.Catalogue;
import session.stateless.CatalogueManagmentRemote;

/**
 *
 * @author Codoic
 */
@WebService(serviceName = "ExportCatalogue")
@Stateless()
public class ExportCatalogue {
    @EJB
    private CatalogueManagmentRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    //Export catalogue to Sydney so that they can have a look at current catalogue
    @WebMethod(operationName = "getCatalogue")
    public List<Catalogue> getCatalogue() {
        return ejbRef.getCatalogue();
    }
    
}
