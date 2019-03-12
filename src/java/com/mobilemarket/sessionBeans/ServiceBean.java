    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.Osoba;
import com.mobilemarket.beans.model.Servis;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NemanjaTrnjak
 */
@Stateless
public class ServiceBean implements ServiceBeanLocal {

    
    @PersistenceContext(unitName = "MobileMarketPU")
    private EntityManager em;
    
     
 
    
    private String message;
    
    
    // Metoda dodaje novi servis u bazu ,preko objekta EntityManager klase
    @Override
    public boolean addService(String name, String email, String mobile, String description, Osoba osoba ,String contact) {
       
        Servis newService = new Servis();
        newService.setImeKorisnika(name);
        newService.setEmail(email);
        newService.setMobilniTelefon(mobile);
        newService.setOpisProblema(description);
        newService.setOsobaId(osoba);
        newService.setKontaktTelefon(contact);
        Date d =  new Date();
        newService.setPrijem(d);
        
        
        try {
            
            em.persist(newService);
             return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        message ="Greska";
        return false;
    }

    // Metoda koja prikazuje vreme zavrsenog servisa
    
    @Override
    public void finishService(Servis service) {
        
        Date date =  new Date();
        service.setIzlaz(date);
        em.merge(service);
       
    }

    // Metoda koja vraca listu svih servisa iz baze,preko objekta EntityManager klase  vrsimo upit ka bazi
    @Override
    public List<Servis> getAllServices() {
         Query query = em.createNamedQuery("Servis.findAll");
        List<Servis> result = (List<Servis>) query.getResultList();
        return result;
    }

   
    
    
}
