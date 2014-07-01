/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import javax.ejb.Remote;

/**
 *
 * @author Codoic
 */
@Remote
public interface OrderTestRemote {

    void doTest();
    
}
