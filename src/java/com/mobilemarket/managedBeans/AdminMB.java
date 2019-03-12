/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.managedBeans;

import com.mobilemarket.beans.model.DodatnaOprema;
import com.mobilemarket.beans.model.KupovinaInfo;
import com.mobilemarket.beans.model.MobilniTelefon;
import com.mobilemarket.beans.model.Osoba;
import com.mobilemarket.beans.model.Poruke;
import com.mobilemarket.sessionBeans.AdminBeanLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author NemanjaTrnjak
 */
@ManagedBean(name = "adminMb" , eager = true)
@SessionScoped
public class AdminMB  implements Serializable{
    
    
       @EJB
    private AdminBeanLocal abl;
    
            
    private Osoba odabranaOsoba;
    
    private MobilniTelefon odabraniMobilni;
    
    private DodatnaOprema odabranaOprema;

 
    private Poruke odabranaPoruka;
    
      // Metoda ispisuje listu svih korisnika u bazi na admin.xhtml strani
    public List<Osoba> getAllOsobe(){
          
          return abl.getAllOsobe();
      }
      
    /*
    *  Metoda menja informacije o korisniku izabranom iz tabele,vraca String
    *  preko faces-config.xml se radi navigacija
    */
     public String editUser() {
        abl.editUser(odabranaOsoba);
        return "Success";
    }
    
    // Metoda brise izabranu osobu
    public void deleteUser(Osoba osoba){
      this.odabranaOsoba = osoba;  
      
     abl.deleteUser(this.odabranaOsoba);
    }
    
    // Metoda brise izabrani mobilni
    public void deleteMobile(MobilniTelefon mt){
        this.odabraniMobilni = mt;
        
        abl.deleteMobile(this.odabraniMobilni);
    }
    
    // Metoda brise dodatnu opremu iz tabele
    public void deleteOprema(DodatnaOprema dodatnaOprema){
        this.odabranaOprema = dodatnaOprema;
        abl.deleteOprema(this.odabranaOprema);
    }
    
    
   /*
    *  Metoda menja informacije o mobilnom telefonomn izabranom iz tabele
    *  preko faces-config.xml se radi navigacija
    */
    public String editMobile(){
       abl.editMobile(odabraniMobilni);
       return "Success";
    }
    
    /*
    *  Metoda menja informacije o opremi izabranoj iz tabele,metoda vraca 
    *  String pa se  preko faces-config.xml  radi navigacija
    */
    public String editOprema(){
       abl.editOprema(odabranaOprema);
           return "Success";
       
    }
    
    // Metoda iscrtava na xhtml strani,Listu  kupovina info iz baze
    public List<KupovinaInfo> getAllKupovinaInfo(){
    
        return abl.getAllKupovinaInfo();
    }

    
    /*
    * ----------  Ne radi ----------
    *   
    *  
    */
     public String adminResponseMessage(Poruke p) {
         
         if(abl.adminResponseMessage(p))    {
         
        return  "Success";
         }
             return "Failure";
         }
    
  
       public Poruke getOdabranaPoruka() {
        return odabranaPoruka;
    }

    public void setOdabranaPoruka(Poruke odabranaPoruka) {
        this.odabranaPoruka = odabranaPoruka;
    }

    
    public MobilniTelefon getOdabraniMobilni() {
        return odabraniMobilni;
    }

    public void setOdabraniMobilni(MobilniTelefon odabraniMobilni) {
        this.odabraniMobilni = odabraniMobilni;
    }
    
 
    
    
    public Osoba getOdabranaOsoba() {
        return odabranaOsoba;
    }

    public void setOdabranaOsoba(Osoba odabranaOsoba) {
        this.odabranaOsoba = odabranaOsoba;
    }
    
    public AdminBeanLocal getAbl() {
        return abl;
    }

    public void setAbl(AdminBeanLocal abl) {
        this.abl = abl;
    }

    public DodatnaOprema getOdabranaOprema() {
        return odabranaOprema;
    }

    public void setOdabranaOprema(DodatnaOprema odabranaOprema) {
        this.odabranaOprema = odabranaOprema;
    }
    
}
