
package com.mobilemarket.sessionBeans;


import com.mobilemarket.beans.model.Osoba;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author NemanjaTrnjak
 */
@Stateless
public class RegistrationBean implements RegistrationBeanLocal {

    
    @PersistenceContext(unitName = "MobileMarketPU")
    private EntityManager em;
    
    
    /*
    *  Metoda koja registruje novog korisnika u bazu
    */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean register(String userName, String password, String email, String name, String surname, String mobile) {
       
         Query query =  em.createNamedQuery("Osoba.findByKorisnickoIme");
         query.setParameter("korisnickoIme", userName);
         
         try {
             
             Osoba o = (Osoba) query.getSingleResult();
             
             if (o != null) {
                 return false;
             }
             } catch (NoResultException nre) {
             
             System.out.println("Osoba ne postoji");
             
            } catch (Exception e) {
             e.printStackTrace();
             return false;
            }
        
        
         Osoba noviKorisnik = new Osoba();
         noviKorisnik.setKorisnickoIme(userName);
         noviKorisnik.setLozinka(password);
         noviKorisnik.setEmail(email);
         noviKorisnik.setIme(name);
         noviKorisnik.setPrezime(surname);
         noviKorisnik.setMobilniTelefon(mobile);
         noviKorisnik.setPrivilegija("korisnik");
         em.persist(noviKorisnik);
         
         return true;
    }

    @Override
    public List<Osoba> getAllOsobe() {
      
        Query query = em.createNamedQuery("Osoba.findAll");
        List<Osoba> result = (List<Osoba>) query.getResultList();
       
        return result; 
        }
        
        
    }


