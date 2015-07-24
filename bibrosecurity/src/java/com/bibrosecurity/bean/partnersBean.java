/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibrosecurity.bean;



import com.bibrosecurity.DAO.partnersDAO;
import com.bibrosecurity.models.partners;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.FileUploadEvent;


/**
 *
 * @author mauricio
 */
@ManagedBean
@ViewScoped
@SessionScoped
public class partnersBean {
     private partners partnerss = new partners();
    private List<partners> lsPartner;
    private String imagenPartner;
    private HttpServletRequest httpServletRequest;
    private FacesMessage facesMessage;

    public partners getPartnerss() {
        return partnerss;
    }

    public void setPartnerss(partners partnerss) {
        this.partnerss = partnerss;
    }

    public String getImagenPartner() {
        return imagenPartner;
    }

    public void setImagenPartner(String imagenPartner) {
        this.imagenPartner = imagenPartner;
    }
    
    public partners getPartner() {
        return partnerss;
    }

    public void setPartner(partners partner) {
        this.partnerss = partner;
    }

    public List<partners> getLsPartner() {
        return lsPartner;
    }

    public void setLsPartner(List<partners> lsPartner) {
        this.lsPartner = lsPartner;
    }
public void eliminar (int pa ){
     partnersDAO dao;
        try {
            dao=new partnersDAO();
            dao.eliminar(pa);
            this.listar();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro Eliminado", "Registro Eliminado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso", "Error"+e ));
        }
    }
    public void actualizar() throws Exception{
    partnersDAO dao;
        try {
            dao=new partnersDAO();
            dao.actualizar(partnerss);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro Nuevo", "Registro Nuevo"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso", "Error"+e ));
        }
    }
    
   public void subirImagen (FileUploadEvent event){
       FacesMessage mensaje =new FacesMessage();
       try {
           partnerss.setImage(event.getFile().getContents());
   imagenPartner= partnersDAO.guardaBlobEnFicheroTemporal(partnerss.getImage(), event.getFile().getFileName());
       mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
       mensaje.setSummary("Imagen cargada ");
       } catch (Exception e) {
       mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
       mensaje.setSummary("Problemas al subir imagen");
       }
   
   }
    
    public void registrar() throws Exception{
    partnersDAO dao;
        try {
            dao=new partnersDAO();
            dao.registrar(partnerss);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro Nuevo", "Registro Nuevo"));
             
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso", "Error"+e ));
        }
    }
    
    public void listar() throws Exception{
    partnersDAO dao;
        try {
            dao=new partnersDAO();
            lsPartner=dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    public void mostrar() throws Exception{
    partnersDAO dao;
        try {
            dao=new partnersDAO();
            dao.Mostrar(partnerss);
            
        } catch (Exception e) {
            throw e;
        }
    }
    public void LeerId_Actualizar (int partner) throws Exception{
        partnersDAO dao;
        partners temp;
        try {
            dao=new partnersDAO();
           temp= dao.LeerID_Actualizar(partner);
           if(temp!=null){
            this.partnerss=temp;
               System.out.println(this.partnerss.getName());
           }
        } catch (Exception e) {
             throw e;
        }
    }
    public void LeerId (partners partner) throws Exception{
        partnersDAO dao;
        partners temp;
        try {
            dao=new partnersDAO();
           temp= dao.LeerID(partner);
           if(temp!=null){
            this.partnerss=temp;
               System.out.println(this.partnerss.getName());
           }
        } catch (Exception e) {
             throw e;
        }
    }
    public String recarga(partners partner) throws Exception{
         partnersDAO dao;
        partners temp;
        FacesContext faces = FacesContext.getCurrentInstance();
         httpServletRequest = (HttpServletRequest)faces.getExternalContext().getRequest();
         try {
            dao=new partnersDAO();
           temp= dao.LeerID(partner);
           if(temp!=null){
            this.partnerss=temp;
               System.out.println(this.partnerss.getName());
            
           }
           httpServletRequest.getSession().setAttribute("sessionPartner",temp.getIdPartner());
        } catch (Exception e) {
             throw e;
        }
    String pagina="/faces/Partners/Show.xhtml";
    return pagina;
    }
    public String recargaAgregar(){
    String pagina="/faces/Partners/Agregar.xhtml";
    return pagina;
    }
    public String recargarIndex(){
    String pagina="/faces/Partners/index.xhtml";
    return pagina;
    }
    public String recargaActualizar(){
    String pagina="/faces/Partners/Actualizar.xhtml";
    return pagina;
    }
    public String recargaEliminar(){
    String pagina="/faces/Partners/Eliminar.xhtml";
    return pagina;
    }
}
