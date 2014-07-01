/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Codoic
 */
@Entity
@Table(name = "XYG_CUSTOMERORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerOrder.findAll", query = "SELECT c FROM CustomerOrder c"),
    @NamedQuery(name = "CustomerOrder.findByOrderId", query = "SELECT c FROM CustomerOrder c WHERE c.orderId = :orderId"),
    @NamedQuery(name = "CustomerOrder.findByCustid", query = "SELECT c FROM CustomerOrder c WHERE c.custid = :custid"),
    @NamedQuery(name = "CustomerOrder.findByTotalamt", query = "SELECT c FROM CustomerOrder c WHERE c.totalamt = :totalamt")})
public class CustomerOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTID")
    private int custid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALAMT")
    private Double totalamt;
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "orderId")
    private Collection<LineItems> lineItemsCollection;

    public CustomerOrder() {
    }

    public CustomerOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public CustomerOrder(Integer orderId, int custid) {
        this.orderId = orderId;
        this.custid = custid;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public Double getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(Double totalamt) {
        this.totalamt = totalamt;
    }

    @XmlTransient
    public Collection<LineItems> getLineItemsCollection() {
        return lineItemsCollection;
    }

    public void setLineItemsCollection(Collection<LineItems> lineItemsCollection) {
        this.lineItemsCollection = lineItemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return orderId.toString();
    }
    
}
