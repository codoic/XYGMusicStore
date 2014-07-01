
package web.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the web.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCatalogue_QNAME = new QName("http://service.web/", "getCatalogue");
    private final static QName _GetCatalogueResponse_QNAME = new QName("http://service.web/", "getCatalogueResponse");
    private final static QName _Catalogue_QNAME = new QName("http://service.web/", "catalogue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: web.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Catalogue }
     * 
     */
    public Catalogue createCatalogue() {
        return new Catalogue();
    }

    /**
     * Create an instance of {@link GetCatalogueResponse }
     * 
     */
    public GetCatalogueResponse createGetCatalogueResponse() {
        return new GetCatalogueResponse();
    }

    /**
     * Create an instance of {@link GetCatalogue }
     * 
     */
    public GetCatalogue createGetCatalogue() {
        return new GetCatalogue();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web/", name = "getCatalogue")
    public JAXBElement<GetCatalogue> createGetCatalogue(GetCatalogue value) {
        return new JAXBElement<GetCatalogue>(_GetCatalogue_QNAME, GetCatalogue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web/", name = "getCatalogueResponse")
    public JAXBElement<GetCatalogueResponse> createGetCatalogueResponse(GetCatalogueResponse value) {
        return new JAXBElement<GetCatalogueResponse>(_GetCatalogueResponse_QNAME, GetCatalogueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Catalogue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web/", name = "catalogue")
    public JAXBElement<Catalogue> createCatalogue(Catalogue value) {
        return new JAXBElement<Catalogue>(_Catalogue_QNAME, Catalogue.class, null, value);
    }

}
