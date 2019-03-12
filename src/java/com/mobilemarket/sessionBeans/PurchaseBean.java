
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.Kupovina;
import com.mobilemarket.beans.model.KupovinaInfo;
import com.mobilemarket.beans.model.Osoba;
import com.mobilemarket.model.ShoppingCartItem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NemanjaTrnjak
 */
@Stateless
public class PurchaseBean implements PurchaseBeanLocal {

    @PersistenceContext(unitName = "MobileMarketPU")
    private EntityManager em;
    
    private String message;
    
    
    /*
     *  Metoda koja obavlja kupovinu proizvoda i upisuje u bazu 
     *   informacije o kupovini
     */        
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean addPurchase(Osoba osoba, List<ShoppingCartItem> korpaProizvodi, String brojKartice) {
       

        if(osoba == null || korpaProizvodi == null || korpaProizvodi.isEmpty()) {
            message ="Greska ,pokusajte ponovo";
            return false;
        }
    
        
        Kupovina novaKupovina = new Kupovina();
        novaKupovina.setBrojKartice(brojKartice);
        novaKupovina.setOsobaId(osoba);
        
        
        List<KupovinaInfo> kupovinaList =  new ArrayList<>();
        
        
        int ukupnaCena = 0;
        
        for(ShoppingCartItem item : korpaProizvodi) {
            
            KupovinaInfo kInfo =  new KupovinaInfo();
            kInfo.setProizvodid(item.getProduct());
            kInfo.setKolicina(item.getProductNum());
            kInfo.setKupovinaid(novaKupovina);
            
             item.getProduct().setStanje(item.getProduct().getStanje()-item.getProductNum());
            em.merge(item.getProduct());
         
            
            
            ukupnaCena +=  (item.getProductNum() * item.getProduct().getCena());
           
            kupovinaList.add(kInfo);
            
            
        }
        
        
        novaKupovina.setKupovinaInfoList(kupovinaList);
        novaKupovina.setCena(ukupnaCena);
        
        
       
        
        
        try {
            
            em.persist(novaKupovina);
            
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    
}
}