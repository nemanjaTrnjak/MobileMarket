
package com.mobilemarket.managedBeans;


import com.mobilemarket.beans.model.Osoba;
import com.mobilemarket.sessionBeans.LoginBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author NemanjaTrnjak
 */
@ManagedBean(name = "loginMb" , eager = true)
@SessionScoped
public class LoginMB  implements Serializable{
    
    
    private String userName;
    private String password;
    
    private Osoba loggedInUser = null;
    
    @EJB
    private LoginBeanLocal loginBean;
    
    
    
    /* 
    *   Metoda  preko koje se korisnik prijavljuje na web sajt , vraca String,
    *    preko faces-config.xml se radi navigacija stranica
    * 
    */  
    public String login (){
        
        Osoba o = loginBean.login(userName, password);
        
        
        if(o != null){
           
            this.loggedInUser = o;
            
            if(o.getPrivilegija().equals("admin")){
                return "admin";
            }
            
            
            if(o.getPrivilegija().equals("korisnik")){
            return "Success";
            }
            
          
        }
        
            this.loggedInUser = null;
            return "Failure";
        
    }
    
    
    /*
     *   Metoda koja odjavljuje korisnika sa sajta i brise njegovu sesiju 
    */
    public void logout () {
        this.loggedInUser = null;
        userName = "";
        password = "";
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       
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

    public Osoba getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Osoba loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
    
    
    
    
}
