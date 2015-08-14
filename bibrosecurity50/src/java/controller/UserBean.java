/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOS.UserDAO;
import models.User;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author taxque
 */
@ManagedBean
@ViewScoped
public class UserBean{

        // Se manda a llamar la clase DAO para obtener los datos de los alumnos
    // y pasarlos a una propiedad mediante un servicio de paginación
    @ManagedProperty("#{UsuarioDAO}")
    private UserDAO service;
    private String message;
    private User usuario = new User();

    private List<User> lstUsuario;

    public UserDAO getService() {
        return service;
    }

    public void setService(UserDAO service) {
        this.service = service;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public List<User> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(List<User> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }
    /**
     * Creates a new instance of UsuarioBean
     */
    public UserBean() {
    }
    
    public String registrar() throws Exception {
        UserDAO dao;
        try {
            dao = new UserDAO();
            dao.registrar(usuario);
            this.message = "Registro exitoso de usuario";
            usuario = null; //Limpiamos los inputs principales
            // Actualizamos la tabla, al momento de registrar un alumno
            //this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (FacesMessage.SEVERITY_INFO,"Registro Nuevo","Registro Nuevo"));
            usuario = new User(); 
              //generamos de nuevo el objeto alumno
           
         } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Registro No Registrado","Registro No Registrado"));

        }
        return "/auth/login";
    }
    
 
}
