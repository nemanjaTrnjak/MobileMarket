
package com.mobilemarket.managedBeans;

import com.mobilemarket.beans.model.Proizvod;
import com.mobilemarket.model.ShoppingCartItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author NemanjaTrnjak
 */
@ManagedBean(name = "shopCartMb" , eager = true)
@SessionScoped
public class ShoppingCartMB implements Serializable{
    
    
    // Kolekcija koja je po tipu Lista ,i predstavlja listu proizvoda u korpi
    private List<ShoppingCartItem> cartItems = new ArrayList<>();
    
    
    private int productNum;

    
    // Metoda prikazuje ukupnu cenu proizvoda u korpi
     public int totalPrice () {
         int total = 0;
         
         for (ShoppingCartItem item : cartItems ){
             total += item.getTotalPrice();
             
         }
         return total;
     }
    
    
    
    // Metoda koja prazni korpu
    public void emptyCart(){
        cartItems = new  ArrayList<>();
    }
   
    /* 
    *  Metoda koja dodaje proizvod u korpu
    *
    * @param Proizvod product 
    */     
    public void addCartItem(Proizvod product ){
        
        
        /* 
        * Prolazimo kroz proizvode u korpi,i ako postoji proizvod sa istim ID-em
        * tj isti proizvod,dodajemo na postojecu kolicinu
        * 
        */   
        for (ShoppingCartItem item : cartItems){
            if(item.getProduct().getId().intValue() == product.getId().intValue()){
                item.setProductNum(item.getProductNum() + 1);
                return;
            }
        }
        /*
         * Ako nema tog proizvoda u korpi ,pravimo novu stavku ,i
            dodajeme je u korpu
        */
        ShoppingCartItem newItem = new ShoppingCartItem();
        newItem.setProduct(product);
        newItem.setProductNum(1);
        cartItems.add(newItem);
    } 
    
    
    
       // Metoda koja izbacuje proizvod iz korpe
    public void removeCartItems(Proizvod product){
        
        for(ShoppingCartItem item : cartItems){
            if(item.getProductNum() < 1){
                
          
           cartItems.remove(item);
           
            }else {
               if(item.getProduct().getId().intValue() == product.getId().intValue()){
                   
                item.setProductNum(item.getProductNum() - 1);
                return;
               
            }
        }
        
        }
    }
    
    
    
     public List<ShoppingCartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
    
}
