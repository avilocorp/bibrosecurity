/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibrosecurity.DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author taxque
 */
public class DAO {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "bibrosecurity?user=root&password=root");
        } catch (Exception e) {
            
        }
    }
    
    public void close(){
        try {
            if(con != null){
                if(con.isClosed()==false){
                    con.close();
                }
            }
        } catch (Exception e) {
        }
    }
}
