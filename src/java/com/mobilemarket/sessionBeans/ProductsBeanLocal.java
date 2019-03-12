/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.DodatnaOprema;
import com.mobilemarket.beans.model.MobilniTelefon;
import com.mobilemarket.beans.model.Proizvod;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author NemanjaTrnjak
 */
@Local
public interface ProductsBeanLocal {
    
    
    
     
    // Metoda vraca listu svih proizvoda
     public List<Proizvod> getAllProducts();
     
     //metoda koja vraca sve mobilne telefone u bazi
     public List<MobilniTelefon> getAllMobilniTelefon();
     
     
     
     /*
     *      Metoda koja dodaje nove mobilne telefone u bazu
     
        @param String
        @param int
        @param int 
     */
     @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
     public boolean addMobilniTelefon(String naziv ,int cena , int stanje);
     
     
     
     // Vraca sve proizvode koji se nalaze u tabeli dodatna oprema
     public List<DodatnaOprema> getAllDodatnaOprema();
     
     /*
     *   Metoda koja dodaje dodatnu opremu bazu
        @param String
        @param int
        @param int
     */
     @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
     public boolean addDodatnuOpremu(String naziv , int cena , int stanje);
     
     // Vraca sve mobilne telefone proizvodjaca Nokia
     public List<Proizvod> getAllNokia();
     
     // Metoda vraca sve mobilne telefone proizvodjaca Samsung
     public List<Proizvod> getAllSamsung();
     
     // Metoda vraca sve mobilne telefone proizvodjaca iPhone
     public List<Proizvod> getAlliPhone();
     
     // Metoda vraca sve mobilne telefone proizvodjaca Huawei
     public List<Proizvod> getAllHuawei();
     
     // Metoda vraca listu svih baterija
     public List<Proizvod> getAllBaterije();
     
     // Metoda vraca listu svih maski 
     public List<Proizvod> getAllMaske();
     
     // Metoda vraca listu svih punjaca
     public List<Proizvod> getAllPunjaci();
     
    
}
