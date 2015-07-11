/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibrosecurity.DAO.auth;

import com.bibrosecurity.DAO.DAO;
import com.bibrosecurity.models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author taxque
 */
public class loginDAO extends DAO{
    
    public User login(String email, String password) throws Exception {
        ResultSet rs;
        User user = new User();
        try {
            this.connect();
            PreparedStatement st = this.getCon().prepareStatement(
                    "select * from user where email=? and password=? and activo=1;"
            );
            st.setString(1, email);
            st.setString(2, password);
            rs = st.executeQuery();
            while (rs.next()) {
                user.setNombre(rs.getString("nombre"));
                user.setApP(rs.getString("apP"));
                user.setApM(rs.getString("apM"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        return user;
    } 
   
}
