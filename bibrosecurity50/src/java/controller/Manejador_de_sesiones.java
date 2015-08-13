/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;


@ManagedBean

@ViewScoped

@SessionScoped

public class Manejador_de_sesiones {

    private String part;

       private final HttpServletRequest httpServletRequest;

    private  FacesMessage facesMessage;

    private final FacesContext faces;

    

    public Manejador_de_sesiones(){

    faces=FacesContext.getCurrentInstance();

   httpServletRequest=(HttpServletRequest)faces.getExternalContext().getRequest();

     if(httpServletRequest.getSession().getAttribute("session")!=null){

         part=httpServletRequest.getSession().getAttribute("session").toString();

          System.out.println("Si llego y llego bien");

          System.out.println(part);          

     }

    }

}
