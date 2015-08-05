/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibrosecurity.DAO;

import com.bibrosecurity.models.products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author israov93
 */
public class productDAO extends DAO{
    public void registrar (products prod) throws Exception
    {
            this.connect();
            String query="INSERT INTO product(id,name,description,purchasePrice,salePrice,qtyAvailable,incomingQty,virtualAvailable,ean13,uom,category_id,active,partner_id) "
                    + "VALUES ("+0+",?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement st=this.getCon().prepareStatement(query);
            st.setString(1, prod.getName());
            st.setString(2, prod.getDescription());
            st.setDouble(3, prod.getPurchasePrice());
            st.setDouble(4, prod.getSalePrice());
            st.setDouble(5, prod.getQtyAvailable());
            st.setDouble(6, prod.getIncomingQty());
            st.setDouble(7, prod.getVirtualAvailable());
            st.setString(8, prod.getEan13());
            st.setString(9, prod.getUom());
            st.setInt(10, prod.getCategory_id());
            st.setInt(11, prod.getActive());
            st.setInt(12, prod.getPartner_id());
            st.executeUpdate();
            this.close();
   }
    
    
    public void modificar (products pro) throws Exception
    {
        try 
        {
            this.connect();
            String query="UPDATE product SET name=?, description=?, purchasePrice=?, "
                    + "salePrice=?, qtyAvailable=?, incomingQty=?,virtualAvailable=?, "
                    + "ean13=?, category_id=?, active=?, partner_id=? WHERE id=?;";
            PreparedStatement st =this.getCon().prepareStatement(query);
            st.setString(1, pro.getName());
            st.setString(2, pro.getDescription());
            st.setDouble(3, pro.getPurchasePrice());
            st.setDouble(4, pro.getSalePrice());
            st.setDouble(5, pro.getQtyAvailable());
            st.setDouble(6, pro.getIncomingQty());
            st.setDouble(7, pro.getVirtualAvailable());
            st.setString(8, pro.getEan13());
            st.setInt(9, pro.getCategory_id());
            st.setInt(10, pro.getActive());
            st.setInt(11, pro.getPartner_id());
            st.setInt(12, pro.getId());
            st.executeUpdate();
        } 
        catch (Exception e) 
        {
             throw e;
        }
        finally
        {
            this.close();
        }
    }
    public void eliminar (products pa) throws Exception{
        try {
            this.connect();
            String query="UPDATE product SET Active=2 WHERE id=?";//"delete from product where id= ?";
            PreparedStatement st =this.getCon().prepareStatement(query);
            st.setInt(1, pa.getId());
            st.executeUpdate();
        } catch (Exception e) {
             throw e;
        }finally{
            this.close();
   }
    
    }
   public List<products> listar() throws Exception
   {
   List<products> lista;
   ResultSet rs;
       try {
           this.connect();
           PreparedStatement st=this.getCon().prepareCall("select * from product WHERE Active=1;");
           rs=st.executeQuery();
           lista=new ArrayList();
           while(rs.next()){
           products part=new products();
            part.setId(rs.getInt("id"));
           part.setName(rs.getString("name"));
           part.setDescription(rs.getString("description"));
           part.setPurchasePrice(rs.getDouble("purchasePrice"));
           part.setSalePrice(rs.getDouble("salePrice"));
           part.setQtyAvailable(rs.getDouble("qtyAvailable"));
           part.setIncomingQty(rs.getDouble("incomingQty"));
           part.setVirtualAvailable(rs.getDouble("virtualAvailable"));
           part.setEan13(rs.getString("ean13"));
           part.setUom(rs.getString("uom"));
           part.setCategory_id(rs.getInt("category_id"));
           part.setActive(rs.getInt("active"));
           part.setPartner_id(rs.getInt("partner_id"));
           lista.add(part);
           }
       } catch (Exception e) {
           throw e;
       }finally{
           this.close();
       }
       return lista;
   }
    public products LeerID(products pa) throws Exception{
           products part=null;
           ResultSet rs;
           try {
           this.connect();
           PreparedStatement st=this.getCon().prepareStatement(""
           +"select * from product where id= ? ");
           st.setInt(1, pa.getId());
          rs=st.executeQuery();
          while(rs.next()){
          part=new products();
          part.setId(rs.getInt("id"));
           part.setName(rs.getString("name"));
           part.setId(rs.getInt("id"));
           part.setName(rs.getString("name"));
           part.setDescription(rs.getString("description"));
           part.setPurchasePrice(rs.getDouble("purchasePrice"));
           part.setSalePrice(rs.getDouble("salePrice"));
           part.setQtyAvailable(rs.getDouble("qtyAvailable"));
           part.setIncomingQty(rs.getDouble("incomingQty"));
           part.setVirtualAvailable(rs.getDouble("virtualAvailable"));
           part.setEan13(rs.getString("ean13"));
           part.setUom(rs.getString("uom"));
           part.setCategory_id(rs.getInt("category_id"));
           part.setActive(rs.getInt("active"));
           part.setPartner_id(rs.getInt("partner_id"));
          }
       } catch (Exception e) {
           throw e;
       }finally{
            this.close();
   }
        return part;
   }
   
    public List<products> Mostrar (products pa) throws Exception
   {
      List<products> lista;
   ResultSet rs;
       try {
           this.connect();
           PreparedStatement st=this.getCon().prepareCall("select * from product where id=?");
           rs=st.executeQuery();
           lista=new ArrayList();
           while(rs.next()){
           products part=new products();
           part.setId(rs.getInt("id"));
           part.setName(rs.getString("name"));
           part.setDescription(rs.getString("description"));
           part.setPurchasePrice(rs.getDouble("purchasePrice"));
           part.setSalePrice(rs.getDouble("salePrice"));
           part.setQtyAvailable(rs.getDouble("qtyAvailable"));
           part.setIncomingQty(rs.getDouble("incomingQty"));
           part.setVirtualAvailable(rs.getDouble("virtualAvailable"));
           part.setEan13(rs.getString("ean13"));
           part.setUom(rs.getString("uom"));
           part.setCategory_id(rs.getInt("category_id"));
           part.setActive(rs.getInt("active"));
           part.setPartner_id(rs.getInt("partner_id"));
           lista.add(part);
           }
       } catch (Exception e) {
           throw e;
       }finally{
           this.close();
       }
       return lista;
   } 
}