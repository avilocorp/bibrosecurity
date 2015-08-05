/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibrosecurity.bean;


import com.bibrosecurity.DAO.productDAO;
import com.bibrosecurity.models.products;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author israov93
 */
@ManagedBean
@ViewScoped
public class productBean 
{
    private products product=new products();
    private List<products> lstProducts;
    
    public productBean (){
        
    }
    public void modificar() throws Exception
    {
        productDAO dao;
        try
        {
            dao=new productDAO();
            dao.modificar(product);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto actualizado", "Producto actualizado"));
        }
        catch(Exception ex)
        {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso", "Error"+ex));
        }
    }
    public void eliminar() throws Exception
    {
        productDAO dao;
        try
        {
            dao=new productDAO();
            dao.eliminar(product);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto eliminado", "Producto eliminado"));
        }
        catch(Exception ex)
        {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso", "Error"+ex));
        }
    }
    public void registrar() throws Exception
    {
        productDAO dao;
        try 
        {
            dao=new productDAO();
            product.setVirtualAvailable(product.getIncomingQty()+product.getQtyAvailable());
            dao.registrar(product);
            
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro Nuevo", "Registro Nuevo"));
        } 
        catch (Exception e) 
        {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso\nError: "+e.getMessage(), "Error: "+e.getMessage() ));
        }
    }
   
    public void listar() throws Exception
    {
        productDAO dao;
        try 
        {
            dao=new productDAO();
            setLstProducts(dao.listar());
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    public void mostrar() throws Exception
    {
        productDAO dao;
        try 
        {
            dao=new productDAO();
            dao.Mostrar(getProduct());
            
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    public void LeerId (products partner) throws Exception
    {
        productDAO dao;
        
        products temp;
        try 
        {
            dao=new productDAO();
            temp= dao.LeerID(partner);
            if(temp!=null)
            {
               this.setProduct(temp);
            }
        } 
        catch (Exception e) 
        {
             throw e;
        }
    }
    public String recarga(products partner) throws Exception
    {
        productDAO dao;
        products temp;
        try 
        {
            dao=new productDAO();
            temp= dao.LeerID(partner);
            if(temp!=null)
            {
               this.setProduct(temp);
            }
        } 
        catch (Exception e) 
        {
             throw e;
        }
        
        String pagina="/faces/Partners/Show.xhtml";
        return pagina;
    }
    public String recargaAgregar()
    {
        String pagina="/faces/Partners/Agregar.xhtml";
        return pagina;
    }
    public String recargaActualizar()
    {
        String pagina="/faces/Partners/Actualizar.xhtml";
        return pagina;
    }
    public String recargaEliminar()
    {
        String pagina="/faces/Partners/Eliminar.xhtml";
        return pagina;
    }

    /**
     * @return the product
     */
    public products getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(products product) {
        this.product = product;
    }

    /**
     * @return the lstProducts
     */
    public List<products> getLstProducts() {
        return lstProducts;
    }

    /**
     * @param lstProducts the lstProducts to set
     */
    public void setLstProducts(List<products> lstProducts) {
        this.lstProducts = lstProducts;
    }
}
