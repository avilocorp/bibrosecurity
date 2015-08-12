/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
@Table(name = "saleOrderPackage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaleOrderPackage.findAll", query = "SELECT s FROM SaleOrderPackage s"),
    @NamedQuery(name = "SaleOrderPackage.findById", query = "SELECT s FROM SaleOrderPackage s WHERE s.id = :id"),
    @NamedQuery(name = "SaleOrderPackage.findByPackageId", query = "SELECT s FROM SaleOrderPackage s WHERE s.packageId = :packageId"),
    @NamedQuery(name = "SaleOrderPackage.findBySaleOrderid", query = "SELECT s FROM SaleOrderPackage s WHERE s.saleOrderid = :saleOrderid"),
    @NamedQuery(name = "SaleOrderPackage.findByGuideNumber", query = "SELECT s FROM SaleOrderPackage s WHERE s.guideNumber = :guideNumber"),
    @NamedQuery(name = "SaleOrderPackage.findBySendingDate", query = "SELECT s FROM SaleOrderPackage s WHERE s.sendingDate = :sendingDate"),
    @NamedQuery(name = "SaleOrderPackage.findByArrivalDate", query = "SELECT s FROM SaleOrderPackage s WHERE s.arrivalDate = :arrivalDate"),
    @NamedQuery(name = "SaleOrderPackage.findByStatus", query = "SELECT s FROM SaleOrderPackage s WHERE s.status = :status")})
public class SaleOrderPackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "package_id")
    private int packageId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saleOrder_id")
    private int saleOrderid;
    @Size(max = 100)
    @Column(name = "guide_number")
    private String guideNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sending_date")
    @Temporal(TemporalType.DATE)
    private Date sendingDate;
    @Column(name = "arrival_date")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;

    public SaleOrderPackage() {
    }

    public SaleOrderPackage(Integer id) {
        this.id = id;
    }

    public SaleOrderPackage(Integer id, int packageId, int saleOrderid, Date sendingDate, String status) {
        this.id = id;
        this.packageId = packageId;
        this.saleOrderid = saleOrderid;
        this.sendingDate = sendingDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public int getSaleOrderid() {
        return saleOrderid;
    }

    public void setSaleOrderid(int saleOrderid) {
        this.saleOrderid = saleOrderid;
    }

    public String getGuideNumber() {
        return guideNumber;
    }

    public void setGuideNumber(String guideNumber) {
        this.guideNumber = guideNumber;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof SaleOrderPackage)) {
            return false;
        }
        SaleOrderPackage other = (SaleOrderPackage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.SaleOrderPackage[ id=" + id + " ]";
    }
    
}
