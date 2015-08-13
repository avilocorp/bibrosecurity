/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOS.SaleOrderLineDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import models.SaleOrder;
import models.SaleOrderLine;

/**
 *
 * @author taxque
 */
@ManagedBean
@ViewScoped
public class SaleOrderLineBean {
  private SaleOrderLineDao service;
    private String message;
    private SaleOrderLine usuario = new SaleOrderLine();

    private List<SaleOrderLine> lstSaleOrderLine;  

    public SaleOrderLineDao getService() {
        return service;
    }

    public void setService(SaleOrderLineDao service) {
        this.service = service;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SaleOrderLine getUsuario() {
        return usuario;
    }

    public void setUsuario(SaleOrderLine usuario) {
        this.usuario = usuario;
    }

    public List<SaleOrderLine> getLstSaleOrderLine() {
        return lstSaleOrderLine;
    }

    public void setLstSaleOrderLine(List<SaleOrderLine> lstSaleOrderLine) {
        this.lstSaleOrderLine = lstSaleOrderLine;
    }
     public void verLineas(SaleOrder sol) throws Exception {
        SaleOrderLineDao dao;
        try {
            dao = new SaleOrderLineDao();
            dao.wachById(sol.getId());
            this.message = "Registro exitoso de usuario";
            usuario = null; //Limpiamos los inputs principales
            // Actualizamos la tabla, al momento de registrar un alumno
            //this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (FacesMessage.SEVERITY_INFO,"Registro Nuevo","Registro Nuevo"));
            usuario = new SaleOrderLine(); //generamos de nuevo el objeto alumno
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Registro No Registrado","Registro No Registrado"));

        }

    }
    
}
