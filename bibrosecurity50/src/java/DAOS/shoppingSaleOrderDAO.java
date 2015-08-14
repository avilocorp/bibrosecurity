/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import models.Item;
import models.SaleOrder;
import models.SaleOrderLine;
import java.util.Date;

/**
 *
 * @author taxque
 */
@ManagedBean
@RequestScoped
public class shoppingSaleOrderDAO extends DAO{

    /**
     * Creates a new instance of shoppingSaleOrderDAO
     */
    
    Date fecha = new Date();
    public shoppingSaleOrderDAO() {
    }
    
    public int registrarSaleOrder (SaleOrder so) throws Exception{
        int last_inserted_id =0;
        //java.sql.RowId sale=null;
        try {
            this.connect();
            String query="insert into saleOrder ( subTotal, discount, total, type, partner_id)"
                    + "values (?,?,?,?,?); ";
            PreparedStatement st=this.getCon().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setDouble(1, so.getSubTotal());
            st.setDouble(2, so.getDiscount());
            st.setDouble(3, so.getTotal());
            st.setString(4, so.getType());
            st.setInt(5, so.getPartnerId());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next())
            {
                last_inserted_id = rs.getInt(1);
            }           
        } catch (Exception e) {
             throw e;
        }finally{
            this.close();
        } 
        
        return last_inserted_id;
    }
        
    public void registrarSaleOrderLine (Item item, int sale_order) throws Exception{
        try {
            this.connect();
            String query="insert into saleOrderLine (saleOrder_id, qty, unit_price, subtotal, product_id)"
                    + "values (?,?,?,?,?); ";
            PreparedStatement st=this.getCon().prepareStatement(query);
            st.setInt(1, sale_order);
            st.setInt(2, item.getQuantity());
            st.setDouble(3, item.getP().getPurchasePrice());
            st.setDouble(4, item.getSubtotal());
            st.setInt(5, item.getP().getId());

            st.executeUpdate();
        } catch (Exception e) {
             throw e;
        }finally{
            this.close();
        } 
    }
    
}
