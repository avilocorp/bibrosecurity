/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author taxque
 */
public class UserDAO extends DAO{
    
    public User login(String email, String password) throws Exception {
        ResultSet rs;
        User user = new User();
        try {
            this.connect();
            PreparedStatement st = this.getCon().prepareStatement(
                    "select * from user where email=? and password=? and active=1;"            );
            st.setString(1, email);
            st.setString(2, password);
            rs = st.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUserTypeid(rs.getInt("userType_id"));
                user.setActive(rs.getBoolean("active"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        return user;
    }
    
    public void registrar(User user) throws Exception {
        try {
            this.connect();
            PreparedStatement st = this.getCon().prepareStatement("insert into user (name, lastName, email, password, userType_id) values(?,?,?,?,?)");
            st.setString(1, user.getName()); 
            st.setString(2, user.getLastName());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setInt(5, 2);
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }
            
}
