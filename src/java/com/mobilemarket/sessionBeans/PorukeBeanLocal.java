/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.Poruke;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NemanjaTrnjak
 */
@Local
public interface PorukeBeanLocal {
    
    
    public List<Poruke> getAllPoruke();
    
    public boolean userSendMessage(String userName, String email, String question);
    
   
}
