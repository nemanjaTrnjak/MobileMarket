
package com.mobilemarket.managedBeans;

import com.mobilemarket.beans.model.DodatnaOprema;
import com.mobilemarket.beans.model.MobilniTelefon;
import com.mobilemarket.beans.model.Proizvod;
import com.mobilemarket.sessionBeans.ProductsBeanLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author NemanjaTrnjak
 */
@ManagedBean(name = "productsMb" , eager = true)
@SessionScoped
public class ProductsMB {
    
    
    private String naziv;
    private int cena;
    private int stanje;
    private String message;
   
    @EJB
    private ProductsBeanLocal pbl;
    
    
    // Dodaje novu dodatnu opremu u bazu
    public String addDodatnaOprema (){
        if(pbl.addDodatnuOpremu(naziv, cena, stanje)){
          return "Success";
        }
        message = "Greska";
        return "Failure";
    }
    
    
    
    // Dodaje novi mobilni ako ne postoji u bazi
     public String addMobilniTelefon(){
  
     if( pbl.addMobilniTelefon(naziv, cena, stanje)){
         return "Success";
     }
         message = "Greska";
         return "Failure";
 }
     
     // Vraca Listu mobilnih telefona proizvodjaca Huawei i ispisuje na xhtml strani
     public List<Proizvod> getAllHuawei (){
         
         return pbl.getAllHuawei();
     }
    
     // Vraca Listu mobilnih telefona proizvodjaca Samsung i ispisuje na xhtml strani
     public List<Proizvod> getAllSamsung (){
         
         return pbl.getAllSamsung();
     }
     
     // Vraca Listu mobilnih telefona proizvodjaca iPhone i ispisuje na xhtml strani
     public List<Proizvod> getAlliPhone  (){
         
         return pbl.getAlliPhone();
     }
     
     
     // Vraca Listu mobilnih telefona proizvodjaca Nokia i ispisuje na xhtml strani
      public List<Proizvod> getAllNokia(){
       
       return pbl.getAllNokia();
      }

      
      // Vraca Listu svih proizvoda iz baze i ispisuje na xhtml strani
      public List<Proizvod> getAllProducts (){
          
          return pbl.getAllProducts();
      }
      
      // Vraca Listu svih Mobilnih telefona iz baze i ispisuje na xhtml strani
      public List<MobilniTelefon> getAllMobilni(){
          
          return pbl.getAllMobilniTelefon();
      }
      
       // Vraca Listu proizvoda Dodatne opreme iz baze i ispisuje na xhtml strani
      public List<DodatnaOprema> getAllDodatnaOprema(){
          
          return pbl.getAllDodatnaOprema();
      }
      
      // Vraca listu svih baterija  i ispisuje na xhtml strani
     public List<Proizvod> getAllBaterije(){
         
         return pbl.getAllBaterije();
     }
      
     // Vraca listu svih maski iz baze i ispisuje na xhtml strani
     public List<Proizvod> getAllMaske(){
         
         return pbl.getAllMaske();
     }
     
     // Vraca listu svih punjaca iz baze i ispisuje na xhtml strani
     public List<Proizvod> getAllPunjaci (){
         
         return pbl.getAllPunjaci();
     }
      
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getStanje() {
        return stanje;
    }

    public void setStanje(int stanje) {
        this.stanje = stanje;
    }
    
    
    
    
    
}
