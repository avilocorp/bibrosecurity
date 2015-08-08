/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author taxque
 */
@Entity
@Table(name = "saleOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaleOrder.findAll", query = "SELECT s FROM SaleOrder s"),
    @NamedQuery(name = "SaleOrder.findById", query = "SELECT s FROM SaleOrder s WHERE s.id = :id"),
    @NamedQuery(name = "SaleOrder.findByDatetimeCreate", query = "SELECT s FROM SaleOrder s WHERE s.datetimeCreate = :datetimeCreate"),
    @NamedQuery(name = "SaleOrder.findBySubTotal", query = "SELECT s FROM SaleOrder s WHERE s.subTotal = :subTotal"),
    @NamedQuery(name = "SaleOrder.findByDiscount", query = "SELECT s FROM SaleOrder s WHERE s.discount = :discount"),
    @NamedQuery(name = "SaleOrder.findByTotal", query = "SELECT s FROM SaleOrder s WHERE s.total = :total"),
    @NamedQuery(name = "SaleOrder.findByType", query = "SELECT s FROM SaleOrder s WHERE s.type = :type"),
    @NamedQuery(name = "SaleOrder.findByStatus", query = "SELECT s FROM SaleOrder s WHERE s.status = :status"),
    @NamedQuery(name = "SaleOrder.findByPartnerId", query = "SELECT s FROM SaleOrder s WHERE s.partnerId = :partnerId")})
public class SaleOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datetime_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subTotal")
    private double subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private double discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partner_id")
    private int partnerId;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "SaleOrder")
    private List<SaleOrderLine> pedidos;

    public List<SaleOrderLine> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<SaleOrderLine> pedidos) {
        this.pedidos = pedidos;
    }

    public SaleOrder() {
    }

    public SaleOrder(Integer id) {
        this.id = id;
    }
    
    public SaleOrder(Date datetimeCreate, String status){
        this.status = status;
        this.datetimeCreate = datetimeCreate;
    }

    public SaleOrder(Integer id, double subTotal, double discount, double total, String type, String status, int partnerId) {
        this.id = id;
        this.subTotal = subTotal;
        this.discount = discount;
        this.total = total;
        this.type = type;
        this.status = status;
        this.partnerId = partnerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatetimeCreate() {
        return datetimeCreate;
    }

    public void setDatetimeCreate(Date datetimeCreate) {
        this.datetimeCreate = datetimeCreate;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleOrder)) {
            return false;
        }
        SaleOrder other = (SaleOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.SaleOrder[ id=" + id + " ]";
    }
    
}
