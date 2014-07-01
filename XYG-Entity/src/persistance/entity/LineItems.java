/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Codoic
 */
@Entity
@Table(name = "XYG_LINEITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineItems.findAll", query = "SELECT l FROM LineItems l"),
    @NamedQuery(name = "LineItems.findByLineId", query = "SELECT l FROM LineItems l WHERE l.lineId = :lineId"),
    @NamedQuery(name = "LineItems.findByItemid", query = "SELECT l FROM LineItems l WHERE l.itemid = :itemid"),
    @NamedQuery(name = "LineItems.findByQuantity", query = "SELECT l FROM LineItems l WHERE l.quantity = :quantity")})
public class LineItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LINE_ID")
    private Integer lineId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ITEMID")
    private String itemid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    @ManyToOne(optional = false)
    private CustomerOrder orderId;

    public LineItems() {
    }

    public LineItems(Integer lineId) {
        this.lineId = lineId;
    }

    public LineItems(Integer lineId, String itemid, int quantity) {
        this.lineId = lineId;
        this.itemid = itemid;
        this.quantity = quantity;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CustomerOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(CustomerOrder orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineId != null ? lineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineItems)) {
            return false;
        }
        LineItems other = (LineItems) object;
        if ((this.lineId == null && other.lineId != null) || (this.lineId != null && !this.lineId.equals(other.lineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistance.entity.LineItems[ lineId=" + lineId + " ]";
    }
    
}
