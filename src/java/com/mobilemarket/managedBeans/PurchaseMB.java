
package com.mobilemarket.managedBeans;

import com.mobilemarket.model.ShoppingCartItem;
import com.mobilemarket.sessionBeans.PurchaseBeanLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author NemanjaTrnjak
 */
@ManagedBean(name = "purchaseMb" , eager = true)
@ViewScoped
public class PurchaseMB implements Serializable{

    
    
    @ManagedProperty(value = "#{loginMb}")
    private LoginMB lmb;
    
    @ManagedProperty(value = "#{shopCartMb}")
    private ShoppingCartMB shoppingCartMB;
    
    @EJB
    private PurchaseBeanLocal pbl;
    
    private String brojKartice;
    
    
    /*  Metoda koja obavlja kupovinu proizvoda i koja vraca String,
    *   preko faces-config.xml radi se navigacija stranica
    
    */
        public String submitPurchase (){
        
        if (pbl.addPurchase(lmb.getLoggedInUser(), shoppingCartMB.getCartItems(), brojKartice)){
            shoppingCartMB.emptyCart();
            return "Success";
        }else{
            return "Failure";
        }
    
   }
    
     /* Metoda pokazuje proizvode spremne za kupovinu
    *   na kupovina.xhtml stranici
     */
        public String getProductList (){
        
        String result = "";
        List<ShoppingCartItem> items = shoppingCartMB.getCartItems();
        
        for (ShoppingCartItem item : items){
            if(item.getProductNum() == 0 || item.getProduct() == null){
                return null;
            }
            result += (item.getProductNum() + "x");
            result += (item.getProduct().getNaziv());
            result += ",\n\r";
        }
        return result;
    }
    
    
    
    
    public LoginMB getLmb() {
        return lmb;
    }

    public void setLmb(LoginMB lmb) {
        this.lmb = lmb;
    }

    public ShoppingCartMB getShoppingCartMB() {
        return shoppingCartMB;
    }

    public void setShoppingCartMB(ShoppingCartMB shoppingCartMB) {
        this.shoppingCartMB = shoppingCartMB;
    }

    public PurchaseBeanLocal getPbl() {
        return pbl;
    }

    public void setPbl(PurchaseBeanLocal pbl) {
        this.pbl = pbl;
    }

    public String getBrojKartice() {
        return brojKartice;
    }

    public void setBrojKartice(String brojKartice) {
        this.brojKartice = brojKartice;
    }
    
  
}