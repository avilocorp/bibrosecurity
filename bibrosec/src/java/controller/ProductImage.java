/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author taxque
 */
@Entity
@Table(name = "productImage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductImage.findAll", query = "SELECT p FROM ProductImage p"),
    @NamedQuery(name = "ProductImage.findById", query = "SELECT p FROM ProductImage p WHERE p.id = :id"),
    @NamedQuery(name = "ProductImage.findByProductId", query = "SELECT p FROM ProductImage p WHERE p.productId = :productId"),
    @NamedQuery(name = "ProductImage.findByImage", query = "SELECT p FROM ProductImage p WHERE p.image = :image"),
    @NamedQuery(name = "ProductImage.findByDescription", query = "SELECT p FROM ProductImage p WHERE p.description = :description")})
public class ProductImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "image")
    private String image;
    @Size(max = 250)
    @Column(name = "description")
    private String description;

    public ProductImage() {
    }

    public ProductImage(Integer id) {
        this.id = id;
    }

    public ProductImage(Integer id, int productId, String image) {
        this.id = id;
        this.productId = productId;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof ProductImage)) {
            return false;
        }
        ProductImage other = (ProductImage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.ProductImage[ id=" + id + " ]";
    }
    
}
