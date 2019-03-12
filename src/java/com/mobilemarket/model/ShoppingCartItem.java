/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.model;

import com.mobilemarket.beans.model.Proizvod;
import java.io.Serializable;

/**
 *
 * @author NemanjaTrnjak
 */
public class ShoppingCartItem implements Serializable{
    
    private Proizvod  product;
    private int productNum;
    
    
    public int getTotalPrice (){
        
        return productNum*product.getCena();
    }

    public Proizvod getProduct() {
        return product;
    }

    public void setProduct(Proizvod product) {
        this.product = product;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
    
    
    
}
