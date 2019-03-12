/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.Osoba;
import com.mobilemarket.beans.model.Servis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author neamanja
 */
@Local
public interface ServiceBeanLocal {
    
    
    // Metoda dodaje novi servis u bazu podataka
    public boolean addService (String name, String email, String mobile, String description, Osoba osoba ,String contact);
    
    
    // Metoda zavrsava zapoceti servis
    public void finishService(Servis service);
    
    
   
    
     // Metoda vraca sve servise
    public List<Servis> getAllServices();
    
    
}
