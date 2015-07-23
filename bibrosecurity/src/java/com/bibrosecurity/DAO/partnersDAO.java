/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibrosecurity.DAO;

import com.bibrosecurity.bean.Conexion;
import com.bibrosecurity.models.partners;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;

/**
 *
 * @author mauricio
 */
public class partnersDAO extends Conexion{
    public void registrar (partners pa) throws Exception{
        try {
            this.Conectar();
            String query="insert into partner (name,lastname,street,noExt,noInt,colony,zip,locality,phone,mobile,email,customer,supplier,image,city_id,state_id,country_id,active)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
            PreparedStatement st=this.getCon().prepareStatement(query);
            st.setString(1, pa.getName());
            st.setString(2, pa.getLastName());
            st.setString(3, pa.getStreet());
            st.setString(4, pa.getNoExt());
            st.setString(5, pa.getNoInt());
            st.setString(6, pa.getColony());
            st.setString(7, pa.getZip());
            st.setString(8, pa.getLocality());
            st.setString(9, pa.getPhone());
            st.setString(10, pa.getMobile());
            st.setString(11, pa.getEmail());
            st.setBoolean(12, pa.getCustomer());
            st.setBoolean(13, pa.isSupplier());
            st.setBytes(14, pa.getImage());
            st.setInt(15, pa.getCity_id());
            st.setInt(16, pa.getState_id());
            st.setInt(17, pa.getCity_id());
            st.setInt(18,pa.getActive());
            st.executeUpdate();
        } catch (Exception e) {
             throw e;
        }finally{
            this.Cerrar();
   }
    
    }
    public void actualizar (partners pa) throws Exception{
        try {
            this.Conectar();
            System.out.println("Aqui vamos");
            String query="update partner set name=?, lastname=?, street=?, noExt=?, noInt=?, colony=?, zip=?, locality=?, phone=?, mobile=?, email=?, customer=? ,supplier=?, image=?,city_id=?,state_id=?,country_id=?,active=? where id=?";
     PreparedStatement st=this.getCon().prepareStatement(query);
           st.setString(1, pa.getName());
            st.setString(2, pa.getLastName());
            st.setString(3, pa.getStreet());
            st.setString(4, pa.getNoExt());
            st.setString(5, pa.getNoInt());
            st.setString(6, pa.getColony());
            st.setString(7, pa.getZip());
            st.setString(8, pa.getLocality());
            st.setString(9, pa.getPhone());
            st.setString(10, pa.getMobile());
            st.setString(11, pa.getEmail());
            st.setBoolean(12, pa.getCustomer());
            st.setBoolean(13, pa.isSupplier());
            st.setBytes(14, pa.getImage());
            st.setInt(15, pa.getCity_id());
            st.setInt(16, pa.getState_id());
            st.setInt(17, pa.getCity_id());
            st.setInt(18,pa.getActive());
            st.setInt(19, pa.getIdPartner());
            st.executeUpdate();
        } catch (Exception e) {
             throw e;
        }finally{
            
            this.Cerrar();
   }
    }
    public void eliminar (int  pa) throws Exception{
        try {
            this.Conectar();
             String query="delete from partner where id= ?";
            PreparedStatement st =this.getCon().prepareStatement(query);
            st.setInt(1, pa);
            st.executeUpdate();
        } catch (Exception e) {
             throw e;
        }finally{
            this.Cerrar();
   }
    
    }
    public static String guardaBlobEnFicheroTemporal(byte[] bytes,String nombreArchivo){
    
    String ubicacionImagen=null;
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    String path= servletContext.getRealPath("")+ File.separatorChar + "resources" + File.separatorChar + "img" + File.separatorChar + "tmp" + File.separatorChar + nombreArchivo;
    File f=null;
    InputStream in=null;
        try {
           f=new File(path);
           in=new ByteArrayInputStream(bytes);
           FileOutputStream out=new  FileOutputStream(f.getAbsolutePath());           
           int c=0;
           while((c=in.read())>=0){
           out.write(c);
           }
           out.flush();
           out.close();
           ubicacionImagen="../../resources/img/tmp" + nombreArchivo;
        } catch (Exception e) {
            System.err.println("No se pudo cargar la imagen");
        }
        return ubicacionImagen;
    }
    
    public List<partners> listar() throws Exception{
   List<partners> lista;
   ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st=this.getCon().prepareCall("select * from partner");
           rs=st.executeQuery();
           lista=new ArrayList();
           while(rs.next()){
           partners part=new partners();
        part.setIdPartner(rs.getInt("id"));
           part.setName(rs.getString("name"));
           part.setLastName(rs.getString("lastName"));
           part.setStreet(rs.getString("street"));
           part.setNoExt(rs.getString("noExt"));
           part.setNoInt(rs.getString("noInt"));
           part.setColony(rs.getString("Colony"));
           part.setZip(rs.getString("Zip"));
           part.setLocality(rs.getString("Locality"));
           part.setPhone(rs.getString("Phone"));
           part.setMobile(rs.getString("Mobile"));
           part.setEmail(rs.getString("Email"));
           part.setCustomer(rs.getBoolean("Customer"));
           part.setSupplier(rs.getBoolean("Supplier"));
           part.setImage(rs.getBytes("image"));
           part.setCity_id(rs.getInt("City_id"));
           part.setState_id(rs.getInt("State_id"));
           part.setCountry_id(rs.getInt("Country_id"));
           part.setActive(rs.getInt("active"));
           lista.add(part);
           }
       } catch (Exception e) {
           throw e;
       }finally{
           this.Cerrar();
       }
       return lista;
   }
    public partners LeerID(partners pa) throws Exception{
           partners part=null;
           ResultSet rs;
           try {
           this.Conectar();
           PreparedStatement st=this.getCon().prepareStatement(""
           +"select * from partner where id= ? ");
           st.setInt(1, pa.getIdPartner());
          rs=st.executeQuery();
          while(rs.next()){
          part=new partners();
          part.setIdPartner(rs.getInt("id"));
           part.setName(rs.getString("name"));
           part.setLastName(rs.getString("lastname"));
           part.setStreet(rs.getString("street"));
           part.setNoExt(rs.getString("noExt"));
           part.setNoInt(rs.getString("noInt"));
           part.setColony(rs.getString("Colony"));
           part.setZip(rs.getString("Zip"));
           part.setLocality(rs.getString("Locality"));
           part.setPhone(rs.getString("Phone"));
           part.setMobile(rs.getString("Mobile"));
           part.setCustomer(rs.getBoolean("Customer"));
           part.setSupplier(rs.getBoolean("Supplier"));
           part.setImage(rs.getBytes("image"));
           part.setCity_id(rs.getInt("City_id"));
           part.setState_id(rs.getInt("State_id"));
           part.setCountry_id(rs.getInt("Country_id"));
          }
       } catch (Exception e) {
           throw e;
       }finally{
            this.Cerrar();
   }
        return part;
   }
    
            public partners LeerID_Actualizar(int pa) throws Exception{
           partners part=null;
           ResultSet rs;
           try {
           this.Conectar();
           PreparedStatement st=this.getCon().prepareStatement(""
           +"select * from partner where id= ? ");
           st.setInt(1, pa);
          rs=st.executeQuery();
          while(rs.next()){
          part=new partners();
          part.setIdPartner(rs.getInt("id"));
           part.setName(rs.getString("name"));
           part.setLastName(rs.getString("lastname"));
           part.setStreet(rs.getString("street"));
           part.setNoExt(rs.getString("noExt"));
           part.setNoInt(rs.getString("noInt"));
           part.setColony(rs.getString("Colony"));
           part.setZip(rs.getString("Zip"));
           part.setLocality(rs.getString("Locality"));
           part.setPhone(rs.getString("Phone"));
           part.setMobile(rs.getString("Mobile"));
           part.setCustomer(rs.getBoolean("Customer"));
           part.setSupplier(rs.getBoolean("Supplier"));
           part.setImage(rs.getBytes("image"));
           part.setCity_id(rs.getInt("City_id"));
           part.setState_id(rs.getInt("State_id"));
           part.setCountry_id(rs.getInt("Country_id"));
          }
       } catch (Exception e) {
           throw e;
       }finally{
            this.Cerrar();
   }
        return part;
   }
   
    public List<partners> Mostrar (partners pa) throws Exception
   {
      List<partners> lista;
   ResultSet rs;
       try {
           this.Conectar();
           PreparedStatement st=this.getCon().prepareCall("select * from partner where id=?");
           rs=st.executeQuery();
           lista=new ArrayList();
           while(rs.next()){
           partners part=new partners();
           part.setIdPartner(rs.getInt("id"));
           part.setName(rs.getString("name"));
           part.setLastName(rs.getString("lastname"));
           part.setStreet(rs.getString("street"));
           part.setNoExt(rs.getString("noExt"));
           part.setNoInt(rs.getString("noInt"));
           part.setColony(rs.getString("Colony"));
           part.setZip(rs.getString("Zip"));
           part.setLocality(rs.getString("Locality"));
           part.setPhone(rs.getString("Phone"));
           part.setMobile(rs.getString("Mobile"));
           part.setCustomer(rs.getBoolean("Customer"));
           part.setSupplier(rs.getBoolean("Supplier"));
           part.setImage(rs.getBytes("image"));
           part.setCity_id(rs.getInt("City_id"));
           part.setState_id(rs.getInt("State_id"));
           part.setCountry_id(rs.getInt("Country_id"));
           lista.add(part);
           }
       } catch (Exception e) {
           throw e;
       }finally{
           this.Cerrar();
       }
       return lista;
   } 
}

