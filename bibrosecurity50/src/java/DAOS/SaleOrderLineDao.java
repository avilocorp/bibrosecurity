/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.SaleOrder;
import models.SaleOrderLine;

/**
 *
 * @author taxque
 */
public class SaleOrderLineDao extends DAO{
    
    public SaleOrderLine wachById (int so) throws SQLException{
        this.connect();
        SaleOrderLine sol=new SaleOrderLine();
        ResultSet rs;
        String query="select * from SaleOrderLine where saleOrder_id=?";
        PreparedStatement st =(PreparedStatement) this.getCon().prepareCall(query);
        st.setInt(1,so);
        rs=st.executeQuery();
        while(rs.next()){
            sol.setId(rs.getInt("id"));
            sol.setSaleOrderid(rs.getInt("saleOrder_id"));
        }
        return sol;
    }
}
