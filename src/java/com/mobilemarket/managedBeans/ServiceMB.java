
package com.mobilemarket.managedBeans;

import com.mobilemarket.beans.model.Servis;
import com.mobilemarket.sessionBeans.ServiceBeanLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author NemanjaTrnjak
 */
@ManagedBean(name = "serviceMb" ,eager = true)
@SessionScoped
public class ServiceMB implements  Serializable{
    
    
    
        private String name;
        private String email;
        private String mobile;
        private String description;
        private String contact;

       private Servis odabraniServis;
        
        @EJB
        private ServiceBeanLocal sbl;

        
        
        @ManagedProperty(value = "#{loginMb}")
        private LoginMB lmb;
        
        
        
        /*
        *  Metoda dodaje novi servis u tabelu servis,preko faces-config.xml se radi navigacija stranica
        */
     public String addService(){
         if(sbl.addService(name, email, mobile, description,lmb.getLoggedInUser(),contact)){
             return "Success";
         }
         
         return "Failure";
     }   

     public boolean finishService(Servis s){
         this.odabraniServis = s;
         sbl.finishService(this.odabraniServis);
         return true;
     }
     
     
     // Metoda iscrtava na xhtml strani,Listu svih servisa iz baze
       public List<Servis> getAllServices() {
        
     return    sbl.getAllServices();
    }
  

    public Servis getOdabraniServis() {
        return odabraniServis;
    }

    public void setOdabraniServis(Servis odabraniServis) {
        this.odabraniServis = odabraniServis;
    }
     
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

 
      public ServiceBeanLocal getSbl() {
        return sbl;
    }

    public void setSbl(ServiceBeanLocal sbl) {
        this.sbl = sbl;
    }

    public LoginMB getLmb() {
        return lmb;
    }

    public void setLmb(LoginMB lmb) {
        this.lmb = lmb;
    }
        
        
    
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
        
}
