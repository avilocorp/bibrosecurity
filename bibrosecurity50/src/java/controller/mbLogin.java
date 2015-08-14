/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOS.Logeo;
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
public class mbLogin {

    private String usuario;
    private String contrasenia;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    private User us;
    
    public mbLogin() 
    {
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
    }
    
    public String login()
    {
        Logeo log=new Logeo();
        if((usuario!=null || contrasenia!=null) || (usuario.length()>1 || contrasenia.length()>1))
        {
            setUs(log.checarUsuario(usuario, contrasenia));
            if(getUs()==null)
            {
                facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "USUARIO NO REGISTRADO", null);
                faceContext.addMessage(null, facesMessage);
                return "index";
            }
            
            else
            {
                if(getUs().getUserTypeid()==1)
                {
                    httpServletRequest.getSession().setAttribute("sessionUsuario", getUs());
                    facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "BIENVENIDO(A) AL SISTEMA "+getUs().getName()+" "+getUs().getLastName(), null);
                    faceContext.addMessage(null, facesMessage);
                      return "/admin/AdminIndex";
                }
                else if(getUs().getUserTypeid()==2)
                {
                    httpServletRequest.getSession().setAttribute("sessionUsuario", getUs());
                    facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN, "BIENVENIDO(A) AL SISTEMA "+getUs().getName()+" "+getUs().getLastName(), null);
                    faceContext.addMessage(null, facesMessage);
                    return "/shopping/List";
                }
            }
        }
        else
        {
            facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN, "LLENE LOS CAMPOS REQUERIDOS ANTES DE TRATAR DE INGRESAR", null);
            faceContext.addMessage(null, facesMessage);
            return "index";
        }
        return "index";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }    

    /**
     * @return the us
     */
    public User getUs() {
        return us;
    }

    /**
     * @param us the us to set
     */
    public void setUs(User us) {
        this.us = us;
    }

}