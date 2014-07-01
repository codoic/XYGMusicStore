/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Codoic
 */
@Entity
@Table(name = "XYG_CATALOGUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogue.findAll", query = "SELECT c FROM Catalogue c"),
    @NamedQuery(name = "Catalogue.findByCatalogueid", query = "SELECT c FROM Catalogue c WHERE c.catalogueid = :catalogueid"),
    @NamedQuery(name = "Catalogue.findByType", query = "SELECT c FROM Catalogue c WHERE c.type = :type"),
    @NamedQuery(name = "Catalogue.findByArtist", query = "SELECT c FROM Catalogue c WHERE c.artist = :artist"),
    @NamedQuery(name = "Catalogue.findByName", query = "SELECT c FROM Catalogue c WHERE c.name = :name"),
    @NamedQuery(name = "Catalogue.findByPrice", query = "SELECT c FROM Catalogue c WHERE c.price = :price"),
    @NamedQuery(name = "Catalogue.findByQuantity", query = "SELECT c FROM Catalogue c WHERE c.quantity = :quantity")})
public class Catalogue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CATALOGUEID")
    private String catalogueid;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "ARTIST")
    private String artist;
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "QUANTITY")
    private Integer quantity;

    public Catalogue() {
    }

    public Catalogue(String catalogueid) {
        this.catalogueid = catalogueid;
    }

    public String getCatalogueid() {
        return catalogueid;
    }

    public void setCatalogueid(String catalogueid) {
        this.catalogueid = catalogueid;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catalogueid != null ? catalogueid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogue)) {
            return false;
        }
        Catalogue other = (Catalogue) object;
        if ((this.catalogueid == null && other.catalogueid != null) || (this.catalogueid != null && !this.catalogueid.equals(other.catalogueid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item id: "+catalogueid+" Type: "+type+" Artist: "+artist+ " Name: "+name+" Price:"+price+" Quantity: "+quantity;
    }
    
}
