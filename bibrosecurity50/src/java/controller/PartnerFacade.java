/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author taxque
 */
@Stateless
public class PartnerFacade extends AbstractFacade<Partner> {
    @PersistenceContext(unitName = "bibrosecurity50PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartnerFacade() {
        super(Partner.class);
    }
    
}