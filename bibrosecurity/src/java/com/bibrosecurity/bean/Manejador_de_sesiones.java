/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibrosecurity.bean;

import com.bibrosecurity.models.partners;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mauricio
 */
@ManagedBean
@ViewScoped
@SessionScoped
public class Manejador_de_sesiones {
    private String part;
    private partners pa;
    private final HttpServletRequest httpServletRequest;
    private  FacesMessage facesMessage;
    private final FacesContext faces;
    
    public Manejador_de_sesiones(){
    faces=FacesContext.getCurrentInstance();
   httpServletRequest=(HttpServletRequest)faces.getExternalContext().getRequest();
     if(httpServletRequest.getSession().getAttribute("sessionPartner")!=null){
         part=httpServletRequest.getSession().getAttribute("sessionPartner").toString();
          System.out.println("Si llego y llego bien");
          System.out.println(part);          
     }
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public partners getPa() {
        return pa;
    }

    public void setPa(partners pa) {
        this.pa = pa;
    }
    
    
}
