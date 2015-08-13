/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Product;
import models.SaleOrder;
import models.SaleOrderLine;

/**
 *
 * @author taxque
 */
public class SaleOrderLineDao extends DAO{

    public Product wachProduct (int so) throws SQLException{
        this.connect();
        Product sol=null;
        ResultSet rs;
        Product prod=new Product();
        String query="select * from product where id=?";
        PreparedStatement st =(PreparedStatement) this.getCon().prepareCall(query);
        st.setInt(1,so);
        rs=st.executeQuery();
        while(rs.next()){
            prod.setName(rs.getString("name"));
        }
        return prod;
    }
    
    public List<SaleOrderLine> wachById (int so) throws SQLException{
        this.connect();
        SaleOrderLine sol=null;
        ResultSet rs;
        List<SaleOrderLine> list=new ArrayList();
        String query="select * from saleOrderLine where saleOrder_id=?;";
        PreparedStatement st =(PreparedStatement) this.getCon().prepareCall(query);
        st.setInt(1,so);
        rs=st.executeQuery();
        while(rs.next()){
            sol=new SaleOrderLine();
            sol.setId(rs.getInt("id"));
            sol.setSaleOrderid(rs.getInt("saleOrder_id"));
            sol.setQty(rs.getDouble("qty"));
            sol.setSubtotal(rs.getDouble("subtotal"));
           sol.setUnitPrice(rs.getDouble("unit_price"));
           sol.setProductId(Integer.parseInt(rs.getString("product_id")));
            list.add(sol);
        }
        return list;
    }
}
