
package com.mobilemarket.sessionBeans;


import com.mobilemarket.beans.model.Osoba;
import com.mobilemarket.model.ShoppingCartItem;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Nemanja Trnjak
 */
@Local
public interface PurchaseBeanLocal {
    
    // Metoda koja dodaje kupovinu u bazu podataka
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean addPurchase (Osoba osoba,List<ShoppingCartItem> korpaProizvodi , final String brojKartice);
}
