
package com.mobilemarket.sessionBeans;

import com.mobilemarket.beans.model.Osoba;
import javax.ejb.Local;

@Local
public interface LoginBeanLocal {
    
    
    public Osoba login(String userName ,String password);
    
}
