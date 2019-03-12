/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.Poruke;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NemanjaTrnjak
 */
@Stateless
public class PorukeBean implements PorukeBeanLocal {

    
        @PersistenceContext(unitName = "MobileMarketPU")
        private EntityManager em;
    
    
    
    
    @Override
    public List<Poruke> getAllPoruke() {
       
        Query query = em.createNamedQuery("Poruke.findAll");
        List<Poruke> result = (List<Poruke>)query.getResultList();
        return result;
    }

  
 
    
    // Metoda cuva poruku koju je posetilac poslao sa pitanje.xhtml,preko objekta EntityManager klase
    @Override
    public boolean userSendMessage(String userName, String email, String question) {
        
        
        Poruke novaPoruka = new Poruke();
        novaPoruka.setIme(userName);
        novaPoruka.setEmail(email);
        novaPoruka.setPitanje(question);
          
        try {
            
            em.persist(novaPoruka);
            return true;
        
        
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
        
    }

    
    
}
