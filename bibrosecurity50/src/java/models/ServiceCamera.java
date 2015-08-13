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
@Table(name = "serviceCamera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceCamera.findAll", query = "SELECT s FROM ServiceCamera s"),
    @NamedQuery(name = "ServiceCamera.findById", query = "SELECT s FROM ServiceCamera s WHERE s.id = :id"),
    @NamedQuery(name = "ServiceCamera.findByServiceId", query = "SELECT s FROM ServiceCamera s WHERE s.serviceId = :serviceId"),
    @NamedQuery(name = "ServiceCamera.findByCameraId", query = "SELECT s FROM ServiceCamera s WHERE s.cameraId = :cameraId")})
public class ServiceCamera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "service_id")
    private int serviceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "camera_id")
    private int cameraId;

    public ServiceCamera() {
    }

    public ServiceCamera(Integer id) {
        this.id = id;
    }

    public ServiceCamera(Integer id, int serviceId, int cameraId) {
        this.id = id;
        this.serviceId = serviceId;
        this.cameraId = cameraId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getCameraId() {
        return cameraId;
    }

    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
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
        if (!(object instanceof ServiceCamera)) {
            return false;
        }
        ServiceCamera other = (ServiceCamera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.ServiceCamera[ id=" + id + " ]";
    }
    
}
