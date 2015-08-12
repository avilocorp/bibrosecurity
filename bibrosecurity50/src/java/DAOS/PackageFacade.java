/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import models.Package;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author taxque
 */
@Stateless
public class PackageFacade extends AbstractFacade<Package> {
    @PersistenceContext(unitName = "bibrosecurity50PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PackageFacade() {
        super(Package.class);
    }
    
}
