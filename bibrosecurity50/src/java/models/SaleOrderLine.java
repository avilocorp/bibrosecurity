/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author taxque
 */
@Entity
@Table(name = "saleOrderLine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaleOrderLine.findAll", query = "SELECT s FROM SaleOrderLine s"),
    @NamedQuery(name = "SaleOrderLine.findById", query = "SELECT s FROM SaleOrderLine s WHERE s.id = :id"),
    @NamedQuery(name = "SaleOrderLine.findBySaleOrderid", query = "SELECT s FROM SaleOrderLine s WHERE s.saleOrderid = :saleOrderid"),
    @NamedQuery(name = "SaleOrderLine.findByQty", query = "SELECT s FROM SaleOrderLine s WHERE s.qty = :qty"),
    @NamedQuery(name = "SaleOrderLine.findByUnitPrice", query = "SELECT s FROM SaleOrderLine s WHERE s.unitPrice = :unitPrice"),
    @NamedQuery(name = "SaleOrderLine.findBySubtotal", query = "SELECT s FROM SaleOrderLine s WHERE s.subtotal = :subtotal"),
    @NamedQuery(name = "SaleOrderLine.findByProductId", query = "SELECT s FROM SaleOrderLine s WHERE s.productId = :productId")})
public class SaleOrderLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saleOrder_id")
    private int saleOrderid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "subtotal")
    private Double subtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;

    public SaleOrderLine() {
    }

    public SaleOrderLine(Integer id) {
        this.id = id;
    }

    public SaleOrderLine(Integer id, int saleOrderid, int productId) {
        this.id = id;
        this.saleOrderid = saleOrderid;
        this.productId = productId;
    }
    
    public SaleOrderLine(int saleOrderid, int productId, 
                        double  qty, double  unitPrice,
                        double subtotal) {
        this.saleOrderid = saleOrderid;
        this.productId = productId;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSaleOrderid() {
        return saleOrderid;
    }

    public void setSaleOrderid(int saleOrderid) {
        this.saleOrderid = saleOrderid;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        if (!(object instanceof SaleOrderLine)) {
            return false;
        }
        SaleOrderLine other = (SaleOrderLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.SaleOrderLine[ id=" + id + " ]";
    }
    
}
