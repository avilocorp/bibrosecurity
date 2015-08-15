/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import models.User;

/**
 *
 * @author Israel
 */
@ManagedBean
@RequestScoped
public class MbSession {
 
    private static User usuario;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
     
    public MbSession()
    {
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            usuario=(User) httpServletRequest.getSession().getAttribute("sessionUsuario");
        }
        else
        {
            usuario=null;
        }
    }
     
    public void buscarSesionAdmin()
    {
        if(usuario==null || usuario.getUserTypeid()!=1)
        {
            try
            {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/auth/login.xhtml");
            }
            catch(Exception ex)
            {
                facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR BUSCANDO SESIONES PARA ADMIN", ex.getMessage());
                faceContext.addMessage(null, facesMessage);
            }
        }
    }
    
    public void buscarSesionCliente()
    {
        if(usuario==null || usuario.getUserTypeid()!=2)
        {
            try
            {
                faceContext.getExternalContext().redirect("/auth/login.xhtml");
            }
            catch(Exception ex){}
        }
    }
    
    public String cerrarSession()
    {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, facesMessage);
        return "/bibrosecurity50/auth/login";
    }
 
    public User getUsuario() {
        return usuario;
    }
 
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }    
}