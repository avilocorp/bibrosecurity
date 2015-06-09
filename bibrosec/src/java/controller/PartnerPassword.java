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
@Table(name = "partnerPassword")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerPassword.findAll", query = "SELECT p FROM PartnerPassword p"),
    @NamedQuery(name = "PartnerPassword.findById", query = "SELECT p FROM PartnerPassword p WHERE p.id = :id"),
    @NamedQuery(name = "PartnerPassword.findByPartnerId", query = "SELECT p FROM PartnerPassword p WHERE p.partnerId = :partnerId"),
    @NamedQuery(name = "PartnerPassword.findByPassword", query = "SELECT p FROM PartnerPassword p WHERE p.password = :password")})
public class PartnerPassword implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partner_id")
    private int partnerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;

    public PartnerPassword() {
    }

    public PartnerPassword(Integer id) {
        this.id = id;
    }

    public PartnerPassword(Integer id, int partnerId, String password) {
        this.id = id;
        this.partnerId = partnerId;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof PartnerPassword)) {
            return false;
        }
        PartnerPassword other = (PartnerPassword) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.PartnerPassword[ id=" + id + " ]";
    }
    
}
