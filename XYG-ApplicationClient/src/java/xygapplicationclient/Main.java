/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xygapplicationclient;

import javax.xml.ws.WebServiceRef;
import web.service.ExportCatalogue_Service;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;



/**
 *
 * @author Codoic
 */
public class Main {
    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/ExportCatalogue/ExportCatalogue.wsdl")
    private static ExportCatalogue_Service service;
    public static void main(String[] args) {
        Main test=new Main();
       
    }

    private void getCatalogue() {
        QName portQName = new QName("http://service.web/", "ExportCataloguePort");
        String req = "<getCatalogue  xmlns=\"http://service.web/\"></getCatalogue>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = null;
            sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
            System.out.println(result); 
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
    
    
    
}
