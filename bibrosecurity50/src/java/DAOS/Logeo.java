/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import models.User;

/**
 *
 * @author Israel
 */
public class Logeo extends DAO{
    private final FacesContext faceContext;
    
    public Logeo()
    {
        faceContext=FacesContext.getCurrentInstance();
    }
    
    public User checarUsuario(String user, String password)
    {
        //Object[] datos=null;
        User us=null;
        String consulta="SELECT * FROM USER WHERE email LIKE ?;";
        user=user.replace("'", "");
        this.connect();
        try
        {
            PreparedStatement pst=this.getCon().prepareCall(consulta);
            pst.setString(1, user);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next())
            {
                us=new User();
                /*datos=new Object[8];
                datos[0]=rs.getInt(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getInt(6);
                datos[6]=rs.getInt(7);
                datos[7]=rs.getInt(8);*/
                us.setId(rs.getInt(1));
                us.setName(rs.getString(2));
                us.setLastName(rs.getString(3));
                us.setEmail(rs.getString(4));
                us.setPassword(rs.getString(5));
                us.setPartnerId(rs.getInt(6));
                us.setActive(rs.getBoolean(7));
                us.setUserTypeid(rs.getInt(8));
                
                if(us!=null)
                {
                    if(!us.getActive())
                        us.setName("USUARIO NO ACTIVO");
                    if(!us.getPassword().equals(password))
                        us.setName("CONTRASEÑA ERRÓNEA");
                }
            }
            else
            {
                us=null;
            }
            return us;
        }
        catch(Exception ex)
        {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", ex.getMessage());
            faceContext.addMessage(null, facesMessage);
            return null;
        }
    }
    
}