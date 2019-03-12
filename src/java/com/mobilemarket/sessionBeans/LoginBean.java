
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.Osoba;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NemanjaTrnjak
 */
@Stateless
public class LoginBean implements LoginBeanLocal {
    
    
    
    @PersistenceContext(unitName = "MobileMarketPU")
    private EntityManager em;
    
    
    
    @Override
    public Osoba login(String userName, String password) {
       
        Query query = em.createNamedQuery("Osoba.findByKorisnickoImeLozinka");
        query.setParameter("korisnickoIme" , userName);
        query.setParameter("lozinka", password);
        
        try {
            
            Osoba osoba = (Osoba) query.getSingleResult();
            return osoba;
        }catch (Exception e) {
            
            e.printStackTrace();
            return null;
        }
    }

   
}
