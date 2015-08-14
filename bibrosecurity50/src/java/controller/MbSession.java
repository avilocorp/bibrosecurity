/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
 
    private User usuario;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
     
    public MbSession()
    {
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            System.out.println(""+httpServletRequest.getSession().getAttribute("sessionUsuario"));
            usuario=(User) httpServletRequest.getSession().getAttribute("sessionUsuario");
        }
    }
     
   public String cerrarSession()
    {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, facesMessage);
        return "/auth/login";
    }
 
    public User getUsuario() {
        return usuario;
    }
 
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }    
}