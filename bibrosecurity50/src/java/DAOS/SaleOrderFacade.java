/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.sql.PreparedStatement;
import models.SaleOrder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author taxque
 */
@Stateless
public class SaleOrderFacade extends AbstractFacade<SaleOrder> {
    @PersistenceContext(unitName = "bibrosecurity50PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaleOrderFacade() {
        super(SaleOrder.class);
    }
    
    }
    

