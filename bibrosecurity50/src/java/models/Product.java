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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author taxque
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByPurchasePrice", query = "SELECT p FROM Product p WHERE p.purchasePrice = :purchasePrice"),
    @NamedQuery(name = "Product.findBySalePrice", query = "SELECT p FROM Product p WHERE p.salePrice = :salePrice"),
    @NamedQuery(name = "Product.findByQtyAvailable", query = "SELECT p FROM Product p WHERE p.qtyAvailable = :qtyAvailable"),
    @NamedQuery(name = "Product.findByIncomingQty", query = "SELECT p FROM Product p WHERE p.incomingQty = :incomingQty"),
    @NamedQuery(name = "Product.findByVirtualAvailable", query = "SELECT p FROM Product p WHERE p.virtualAvailable = :virtualAvailable"),
    @NamedQuery(name = "Product.findByEan13", query = "SELECT p FROM Product p WHERE p.ean13 = :ean13"),
    @NamedQuery(name = "Product.findByUom", query = "SELECT p FROM Product p WHERE p.uom = :uom"),
    @NamedQuery(name = "Product.findByCategoryId", query = "SELECT p FROM Product p WHERE p.categoryId = :categoryId"),
    @NamedQuery(name = "Product.findByActive", query = "SELECT p FROM Product p WHERE p.active = :active"),
    @NamedQuery(name = "Product.findByPartnerId", query = "SELECT p FROM Product p WHERE p.partnerId = :partnerId")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 1000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchasePrice")
    private double purchasePrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salePrice")
    private double salePrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtyAvailable")
    private double qtyAvailable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "incomingQty")
    private double incomingQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "virtualAvailable")
    private double virtualAvailable;
    @Size(max = 45)
    @Column(name = "ean13")
    private String ean13;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "uom")
    private String uom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private int categoryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partner_id")
    private int partnerId;
    
    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, double purchasePrice, double salePrice, double qtyAvailable, double incomingQty, double virtualAvailable, String uom, int categoryId, boolean active, int partnerId) {
        this.id = id;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.qtyAvailable = qtyAvailable;
        this.incomingQty = incomingQty;
        this.virtualAvailable = virtualAvailable;
        this.uom = uom;
        this.categoryId = categoryId;
        this.active = active;
        this.partnerId = partnerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getQtyAvailable() {
        return qtyAvailable;
    }

    public void setQtyAvailable(double qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
    }

    public double getIncomingQty() {
        return incomingQty;
    }

    public void setIncomingQty(double incomingQty) {
        this.incomingQty = incomingQty;
    }

    public double getVirtualAvailable() {
        return virtualAvailable;
    }

    public void setVirtualAvailable(double virtualAvailable) {
        this.virtualAvailable = virtualAvailable;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.Product[ id=" + id + " ]";
    }
    
}
