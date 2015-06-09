/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "purchaseOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrder.findAll", query = "SELECT p FROM PurchaseOrder p"),
    @NamedQuery(name = "PurchaseOrder.findById", query = "SELECT p FROM PurchaseOrder p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseOrder.findByDatetimeCreate", query = "SELECT p FROM PurchaseOrder p WHERE p.datetimeCreate = :datetimeCreate"),
    @NamedQuery(name = "PurchaseOrder.findBySubtotal", query = "SELECT p FROM PurchaseOrder p WHERE p.subtotal = :subtotal"),
    @NamedQuery(name = "PurchaseOrder.findByTotal", query = "SELECT p FROM PurchaseOrder p WHERE p.total = :total"),
    @NamedQuery(name = "PurchaseOrder.findByStatus", query = "SELECT p FROM PurchaseOrder p WHERE p.status = :status"),
    @NamedQuery(name = "PurchaseOrder.findByPartnerId", query = "SELECT p FROM PurchaseOrder p WHERE p.partnerId = :partnerId")})
public class PurchaseOrder implements Serializable {
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
    @Column(name = "subtotal")
    private double subtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partner_id")
    private int partnerId;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer id) {
        this.id = id;
    }

    public PurchaseOrder(Integer id, double subtotal, double total, int partnerId) {
        this.id = id;
        this.subtotal = subtotal;
        this.total = total;
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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.PurchaseOrder[ id=" + id + " ]";
    }
    
}
