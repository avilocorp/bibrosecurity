/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibrosecurity.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author israov93
 */
@ManagedBean
@ViewScoped
public class products {
    
    private int id;
    private String name;
    private String description;
    private double purchasePrice;
    private double salePrice;
    private double qtyAvailable;
    private double incomingQty;
    private double virtualAvailable;
    private String ean13;
    private String uom;
    private int category_id;
    private int active;
    private int partner_id;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the purchasePrice
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * @param purchasePrice the purchasePrice to set
     */
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * @return the salePrice
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice the salePrice to set
     */
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * @return the qtyAvailable
     */
    public double getQtyAvailable() {
        return qtyAvailable;
    }

    /**
     * @param qtyAvailable the qtyAvailable to set
     */
    public void setQtyAvailable(double qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
    }

    /**
     * @return the incomingQty
     */
    public double getIncomingQty() {
        return incomingQty;
    }

    /**
     * @param incomingQty the incomingQty to set
     */
    public void setIncomingQty(double incomingQty) {
        this.incomingQty = incomingQty;
    }

    /**
     * @return the virtualAvailable
     */
    public double getVirtualAvailable() {
        return virtualAvailable;
    }

    /**
     * @param virtualAvailable the virtualAvailable to set
     */
    public void setVirtualAvailable(double virtualAvailable) {
        this.virtualAvailable = virtualAvailable;
    }

    /**
     * @return the ean13
     */
    public String getEan13() {
        return ean13;
    }

    /**
     * @param ean13 the ean13 to set
     */
    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    /**
     * @return the uom
     */
    public String getUom() {
        return uom;
    }

    /**
     * @param uom the uom to set
     */
    public void setUom(String uom) {
        this.uom = uom;
    }

    /**
     * @return the category_id
     */
    public int getCategory_id() {
        return category_id;
    }

    /**
     * @param category_id the category_id to set
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    /**
     * @return the active
     */
    public int getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(int active) {
        this.active = active;
    }

    /**
     * @return the partner_id
     */
    public int getPartner_id() {
        return partner_id;
    }

    /**
     * @param partner_id the partner_id to set
     */
    public void setPartner_id(int partner_id) {
        this.partner_id = partner_id;
    }
    
    
}
