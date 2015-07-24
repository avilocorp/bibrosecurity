/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibrosecurity.bean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mauricio
 */
public class Conexion {
       private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://"
                    + "localhost:3306/bibrosecurity?user=root"
                    + "&password=root");
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public void Cerrar(){
            try {
            if(con!=null){
                if(con.isClosed()==false){
                    con.close();
                }
            }
        } catch (Exception e) {
        }
        }
}
