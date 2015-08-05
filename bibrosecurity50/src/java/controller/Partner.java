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
@Table(name = "partner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p"),
    @NamedQuery(name = "Partner.findById", query = "SELECT p FROM Partner p WHERE p.id = :id"),
    @NamedQuery(name = "Partner.findByName", query = "SELECT p FROM Partner p WHERE p.name = :name"),
    @NamedQuery(name = "Partner.findByLastName", query = "SELECT p FROM Partner p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Partner.findByStreet", query = "SELECT p FROM Partner p WHERE p.street = :street"),
    @NamedQuery(name = "Partner.findByNoExt", query = "SELECT p FROM Partner p WHERE p.noExt = :noExt"),
    @NamedQuery(name = "Partner.findByNoInt", query = "SELECT p FROM Partner p WHERE p.noInt = :noInt"),
    @NamedQuery(name = "Partner.findByColony", query = "SELECT p FROM Partner p WHERE p.colony = :colony"),
    @NamedQuery(name = "Partner.findByZip", query = "SELECT p FROM Partner p WHERE p.zip = :zip"),
    @NamedQuery(name = "Partner.findByLocality", query = "SELECT p FROM Partner p WHERE p.locality = :locality"),
    @NamedQuery(name = "Partner.findByPhone", query = "SELECT p FROM Partner p WHERE p.phone = :phone"),
    @NamedQuery(name = "Partner.findByMobile", query = "SELECT p FROM Partner p WHERE p.mobile = :mobile"),
    @NamedQuery(name = "Partner.findByEmail", query = "SELECT p FROM Partner p WHERE p.email = :email"),
    @NamedQuery(name = "Partner.findByCustomer", query = "SELECT p FROM Partner p WHERE p.customer = :customer"),
    @NamedQuery(name = "Partner.findBySupplier", query = "SELECT p FROM Partner p WHERE p.supplier = :supplier"),
    @NamedQuery(name = "Partner.findByImage", query = "SELECT p FROM Partner p WHERE p.image = :image"),
    @NamedQuery(name = "Partner.findByCityId", query = "SELECT p FROM Partner p WHERE p.cityId = :cityId"),
    @NamedQuery(name = "Partner.findByStateId", query = "SELECT p FROM Partner p WHERE p.stateId = :stateId"),
    @NamedQuery(name = "Partner.findByCountryId", query = "SELECT p FROM Partner p WHERE p.countryId = :countryId"),
    @NamedQuery(name = "Partner.findByActive", query = "SELECT p FROM Partner p WHERE p.active = :active")})
public class Partner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 45)
    @Column(name = "street")
    private String street;
    @Size(max = 45)
    @Column(name = "noExt")
    private String noExt;
    @Size(max = 45)
    @Column(name = "noInt")
    private String noInt;
    @Size(max = 45)
    @Column(name = "colony")
    private String colony;
    @Size(max = 10)
    @Column(name = "zip")
    private String zip;
    @Size(max = 60)
    @Column(name = "locality")
    private String locality;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "phone")
    private String phone;
    @Size(max = 45)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Column(name = "customer")
    private Boolean customer;
    @Column(name = "supplier")
    private Boolean supplier;
    @Size(max = 1000)
    @Column(name = "image")
    private String image;
    @Column(name = "city_id")
    private Integer cityId;
    @Column(name = "state_id")
    private Integer stateId;
    @Column(name = "country_id")
    private Integer countryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;

    public Partner() {
    }

    public Partner(Integer id) {
        this.id = id;
    }

    public Partner(Integer id, String name, String lastName, String email, boolean active) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNoExt() {
        return noExt;
    }

    public void setNoExt(String noExt) {
        this.noExt = noExt;
    }

    public String getNoInt() {
        return noInt;
    }

    public void setNoInt(String noInt) {
        this.noInt = noInt;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getCustomer() {
        return customer;
    }

    public void setCustomer(Boolean customer) {
        this.customer = customer;
    }

    public Boolean getSupplier() {
        return supplier;
    }

    public void setSupplier(Boolean supplier) {
        this.supplier = supplier;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
        if (!(object instanceof Partner)) {
            return false;
        }
        Partner other = (Partner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.Partner[ id=" + id + " ]";
    }
    
}
