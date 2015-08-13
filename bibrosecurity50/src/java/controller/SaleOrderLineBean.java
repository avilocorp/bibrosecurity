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
import javax.servlet.http.HttpServletRequest;
import models.Product;
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
    private HttpServletRequest httpServletRequest;

    private List<SaleOrderLine> lstSaleOrderLine;
     private List<Product> lstProduct;
     
     

    public SaleOrderLineDao getService() {
        return service;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public List<Product> getLstProduct() {
        return lstProduct;
    }

    public void setLstProduct(List<Product> lstProduct) {
        this.lstProduct = lstProduct;
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
    
    public List<SaleOrderLine> verLineas(String sol) throws Exception {
        SaleOrderLineDao dao;
        try {
             System.out.println(sol);
            dao = new SaleOrderLineDao();
            lstSaleOrderLine=dao.wachById(Integer.parseInt(sol));
            
            this.message = "Informacion enviada";
            usuario = null; 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (FacesMessage.SEVERITY_INFO,"Registro Nuevo","Registro Nuevo"));
            usuario = new SaleOrderLine(); //generamos de nuevo el objeto alumno
            httpServletRequest.getSession().setAttribute("session",usuario.getId());
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Registro No Registrado","Registro No Registrado"));

        }
        return lstSaleOrderLine;
    }
    
    public Product wachProduct(int product_id) throws Exception {
        SaleOrderLineDao dao;
        Product product= null;
        try {
            dao = new SaleOrderLineDao();
            product=dao.wachProduct(product_id);
            
            this.message = "Informacion enviada";
            usuario = null; 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (FacesMessage.SEVERITY_INFO,"Registro Nuevo","Registro Nuevo"));
            usuario = new SaleOrderLine(); //generamos de nuevo el objeto alumno
            httpServletRequest.getSession().setAttribute("session",usuario.getId());
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Registro No Registrado","Registro No Registrado"));

        }
        return product;
    }
    
}
