
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.DodatnaOprema;
import com.mobilemarket.beans.model.MobilniTelefon;
import com.mobilemarket.beans.model.Proizvod;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NemanjaTrnjak
 */
@Stateless
public class ProductsBean implements ProductsBeanLocal {

    @PersistenceContext(unitName = "MobileMarketPU")
    private EntityManager em;
    
   
    
    // Metoda vraca listu svih proizvoda iz baze,preko objekta EntityManager klase klase vrsimo upit ka bazi
    @Override
    public List<Proizvod> getAllProducts() {
       Query query = em.createNamedQuery("Proizvod.findAll");
       List<Proizvod> result = (List<Proizvod>) query.getResultList();
        
        
        return result;
    }

    // Metoda koja vraca sve Mobilne telefone u bazi ,preko objekta EntityManager klase vrsimo upit ka bazi
    @Override
    public List<MobilniTelefon> getAllMobilniTelefon() {
       
        Query query = em.createNamedQuery("MobilniTelefon.findAll");
       List<MobilniTelefon> result = (List<MobilniTelefon>) query.getResultList();
       
       return result;
        
    }

    
    /*
    *   Metoda koja dodaje novi mobilni telefon u bazu
    
        @param String
        @param int
        @param int
    */
    @Override
    public boolean addMobilniTelefon(String naziv, int cena, int stanje) {
        
        Proizvod pr = null;
        try {
            Query query = em.createNamedQuery("Proizvod.findByNaziv");
            query.setParameter("naziv", naziv);
            
            pr = (Proizvod) query.getSingleResult();
        } catch (NoResultException nre) {
            System.out.println("Nema rezultata, sve je OK...");
        } catch (NonUniqueResultException nue) {
            System.out.println("Ima vise proizvoda sa istim nazivom.");
            return  false;
        }
        
        
        if (pr != null) {
            System.out.println("Postoji proizvod sa ovim imenom!");
            return false;
        }
        
        Proizvod noviProizvod = new Proizvod();
        noviProizvod.setNaziv(naziv);
        noviProizvod.setCena(cena);
        noviProizvod.setStanje(stanje);
        
        MobilniTelefon mobilniTelefon = new MobilniTelefon();
        mobilniTelefon.setProizvodId(noviProizvod);
       
        em.persist(mobilniTelefon);
        
        return true;
         
    }

    // Metoda koja vraca listu sve dodatne opreme iz baze,preko objekta EntityManager klase  vrsimo upit ka bazi
    @Override
    public List<DodatnaOprema> getAllDodatnaOprema() {
       Query query = em.createNamedQuery("DodatnaOprema.findAll");
       List<DodatnaOprema> result = (List<DodatnaOprema>) query.getResultList();
       
       return result;
    }

    
    
    // Metoda koja dodaje novu dodatnu opremu u bazu
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean addDodatnuOpremu(String naziv, int cena, int stanje) {
          Proizvod pr = null;
        try {
            Query query = em.createNamedQuery("Proizvod.findByNaziv");
            query.setParameter("naziv", naziv);
            
            pr = (Proizvod) query.getSingleResult();
        } catch (NoResultException nre) {
            System.out.println("Nema rezultata, sve je OK...");
        } catch (NonUniqueResultException nue) {
            System.out.println("Ima vise proizvoda sa istim nazivom.");
            return  false;
        }
        
        
        if (pr != null) {
            System.out.println("Postoji proizvod sa ovim imenom!");
            return false;
        }
        
        Proizvod noviProizvod = new Proizvod();
        noviProizvod.setNaziv(naziv);
        noviProizvod.setCena(cena);
        noviProizvod.setStanje(stanje);
        
        DodatnaOprema dodatnaOprema = new DodatnaOprema();
        dodatnaOprema.setProizvodId(noviProizvod);
       
        em.persist(dodatnaOprema);
      
        return true;
    }

    
    
    
    // Metoda vraca sve mobilne telefone proizvodjaca Nokia,preko objekta EntityManager klase  vrsimo upit ka bazi
    @Override
    public List<Proizvod> getAllNokia() {
       Query query = em.createNamedQuery("Proizvod.findByNazivMobilni");
       query.setParameter("naziv","Nokia%");
       List<Proizvod> result= (List <Proizvod>) query.getResultList();
       return result;
    }

    // Metoda vraca sve mobilne telefone proizvodjaca Samsung,,preko objekta EntityManager klase  vrsimo upit ka bazi
    @Override
    public List<Proizvod> getAllSamsung() {
       Query query = em.createNamedQuery("Proizvod.findByNazivMobilni");
       query.setParameter("naziv","Samsung%");
       List<Proizvod> result= (List <Proizvod>) query.getResultList();
       return result;
    }

    // Metoda vraca Listu svih mobilnih telefona proizvodjaca iPhone iz baze podataka,preko objekta EntityManager klase  vrsimo upit ka bazi
    @Override
    public List<Proizvod> getAlliPhone() {
        
       Query query = em.createNamedQuery("Proizvod.findByNazivMobilni");
       query.setParameter("naziv","iPhone%");
       List<Proizvod> result= (List <Proizvod>) query.getResultList();
       return result;
        
    }

    // Metoda vraca sve mobilne telefone proizvodjaca Huawei,preko objekta EntityManager klase  vrsimo upit ka bazi
    @Override
    public List<Proizvod> getAllHuawei() {
        
        Query query = em.createNamedQuery("Proizvod.findByNazivMobilni");
        query.setParameter("naziv", "Huawei%");
        List<Proizvod> result = (List <Proizvod>) query.getResultList();
        return result;
        
    }

    // Metoda vraca listu svih Baterija,preko objekta EntityManager klase  vrsimo upit ka bazi
    @Override
    public List<Proizvod> getAllBaterije() {
       
        Query query =  em.createNamedQuery("Proizvod.findByNazivOprema");
        query.setParameter("naziv", "Baterija%");
        List<Proizvod> result = (List<Proizvod>) query.getResultList();
        return result;
        
   }
    // Metoda vraca listu svih maski,preko objekta EntityManager klase  vrsimo upit ka bazi
    @Override
    public List<Proizvod> getAllMaske() {
        
        Query query = em.createNamedQuery("Proizvod.findByNazivOprema");
        query.setParameter("naziv", "Maska%");
        List<Proizvod> result = (List<Proizvod>) query.getResultList();
        return result;
    }

     // Metoda vraca listu svih punjaca,preko objekta EntityManager klase  vrsimo upit ka bazi
    @Override
    public List<Proizvod> getAllPunjaci() {
        
        Query query = em.createNamedQuery("Proizvod.findByNazivOprema");
        query.setParameter("naziv", "Punjac%");
        List<Proizvod> result = (List<Proizvod>) query.getResultList();
        return result;
        
    }

    
}
