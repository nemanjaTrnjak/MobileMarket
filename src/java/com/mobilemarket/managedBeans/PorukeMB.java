/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.managedBeans;

import com.mobilemarket.beans.model.Poruke;
import com.mobilemarket.sessionBeans.PorukeBeanLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Nemanja Trnjak
 */
@ManagedBean(name = "porukeMb" , eager = true)
@ViewScoped
public class PorukeMB implements Serializable{
    
    
    private String userName;
    private String email;
    private String question;
    private String answer;
    
    private Poruke odabranaPoruka;

    
    
    @EJB
    private PorukeBeanLocal porukeBeanLocal;

    
    
    /*   Sa ovom metodom posetioc sajta,na pitanje.xhtml strani salje
    *   pitanje administratoru
    */
    public String userSendMessage(){
       if( porukeBeanLocal.userSendMessage(userName, email, question)){
        return "Success";
       }
       return "Failure";
    }
    
      // Metoda iscrtava na xhtml strani,Listu  poruka iz baze
    public List<Poruke> getAllPoruke(){
        return porukeBeanLocal.getAllPoruke();
    }
    
    
    
    

    
    public Poruke getOdabranaPoruka() {
        return odabranaPoruka;
    }

    public void setOdabranaPoruka(Poruke odabranaPoruka) {
        this.odabranaPoruka = odabranaPoruka;
    }

   
     
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
    
}
