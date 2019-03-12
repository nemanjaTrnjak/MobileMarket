
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.Osoba;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author NemanjaTrnjak
 */
@Local
public interface RegistrationBeanLocal {
    
    /*
    *       Metoda koja registruje novog korisnika u bazu
    */
   
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean register(String userName ,String password ,String email ,String name ,String surname ,String mobile );
    
    
    // Metoda vraca listu svih korisnika u bazi
    public List<Osoba> getAllOsobe();
}
