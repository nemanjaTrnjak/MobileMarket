
package com.mobilemarket.managedBeans;


import com.mobilemarket.beans.model.Osoba;
import com.mobilemarket.sessionBeans.RegistrationBeanLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author NemanjaTrnjak
 */
@ManagedBean(name = "registerMb" , eager = true)
@ViewScoped
public class RegistrationMB implements Serializable{
    
 
    private String userName;
    private String password;
    private String email;
    private String name;
    private String surName;
    private String mobile;
    
            
    @EJB
    private RegistrationBeanLocal rbl;
    
        /* 
         *   Metoda registruje korisnika u bazu,preko faces-config.xhml
         *   radimo navigaciju stranica
         *
        */       
            
      public String register (){
        if(rbl.register(userName, password, email, name, surName, mobile)) {
        
        return "Success" ;
        }
        return "Failure";
    }
    
      
      
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    
    public RegistrationBeanLocal getRbl() {
        return rbl;
    }

    public void setRbl(RegistrationBeanLocal rbl) {
        this.rbl = rbl;
    }
    
    
    
}
