/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.DodatnaOprema;
import com.mobilemarket.beans.model.KupovinaInfo;
import com.mobilemarket.beans.model.MobilniTelefon;
import com.mobilemarket.beans.model.Osoba;
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
public class AdminBean implements AdminBeanLocal {
  
    @PersistenceContext(unitName = "MobileMarketPU")
    private EntityManager em;
    
    
    
    // Metoda upisuje odgovor korisnku u bazu podataka
       /*
        * --------------NE RADI------------
        */
    @Override
   public boolean adminResponseMessage(Poruke message) {
        String odgovor  =message.getOdgovor();
       
        
        message.setOdgovor(odgovor);
        
        em.merge(message);
         return true;
       
    }

    
  // Metoda brise osobu iz baze,preko objekta EntityManager klase
    @Override
    public void deleteUser(Osoba o) {
        
        if(!em.contains(o)){
            o = em.merge(o);
        }
       em.remove(o);
    }

    
    // Metoda menja informacije o osobi,preko objekta EntityManager klase
      @Override
      public void editUser(Osoba o) {
    
        em.merge(o);
        
    }

      // Metoda vraca listu listu svih osoba iz baze
    @Override
    public List<Osoba> getAllOsobe() {
      
        Query query = em.createNamedQuery("Osoba.findAll");
        List<Osoba> result = (List<Osoba>) query.getResultList();
       
        return result; 
        }

    // Metoda menja informacije o mobilnom telefonu,preko objekta EntityManager klase
    @Override
    public void editMobile(MobilniTelefon mt) {
       em.merge(mt);
    }

    // Metoda brise mobilni telefon iz baze,preko objekta EntityManager klase
    @Override
    public void deleteMobile(MobilniTelefon mt) {
        if(!em.contains(mt)){
            mt = em.merge(mt);
        }
         em.remove(mt);
    }

    // Metoda brise dodatnu opremu iz baze,preko objekta EntityManager klase
    @Override
    public void deleteOprema(DodatnaOprema dodatnaOprema) {
       
        if(!em.contains(dodatnaOprema)){
            dodatnaOprema = em.merge(dodatnaOprema);
        }
        
        em.remove(dodatnaOprema);
    }

     // Metoda menja informacije o dodatnoj opremi,preko objekta EntityManager klase
    @Override
    public void editOprema(DodatnaOprema dodatnaOprema) {
        
        em.merge(dodatnaOprema);
        
    }

    
    // Vraca listu svih kupovina i proizvoda,tj tabelu kupovina info
    @Override
    public List<KupovinaInfo> getAllKupovinaInfo() {
        
        Query query = em.createNamedQuery("KupovinaInfo.findAll");
        List<KupovinaInfo> result =  query.getResultList();
        return result;
        
    }

   

    
    
}


