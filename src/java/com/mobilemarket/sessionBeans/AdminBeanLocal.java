/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.DodatnaOprema;
import com.mobilemarket.beans.model.Kupovina;
import com.mobilemarket.beans.model.KupovinaInfo;
import com.mobilemarket.beans.model.MobilniTelefon;
import com.mobilemarket.beans.model.Osoba;
import com.mobilemarket.beans.model.Poruke;
import com.mobilemarket.beans.model.Proizvod;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author neamanja
 */
@Local
public interface AdminBeanLocal {
    
      // Metoda vraca listu svih korisnika u bazi
    public List<Osoba> getAllOsobe();
    
    
 
    
    // Metoda brise osobu iz baze
    public void deleteUser(Osoba o);
    
    // Metoda menja informacije o korisniku
    public void editUser(Osoba o);
    
    // Metoda menja informacije o proizvodu
    public void editMobile(MobilniTelefon mt);
    
    
    // Metoda menja informacije o proizvodu
    public void deleteMobile(MobilniTelefon mt);
    
    // Metoda brise dodatnu opremu
   public void deleteOprema(DodatnaOprema dodatnaOprema);
   
   
   // Metoda menja informacije o opremi
   public void editOprema(DodatnaOprema dodatnaOprema);
   
    // Metoda upisuje odgovor korisnku u bazu podataka
   public boolean adminResponseMessage(Poruke message);
   
   public List<KupovinaInfo> getAllKupovinaInfo();
   
   
    
}
