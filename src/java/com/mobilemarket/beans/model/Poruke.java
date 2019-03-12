/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.beans.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neamanja
 */
@Entity
@Table(name = "poruke")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poruke.findAll", query = "SELECT p FROM Poruke p")
    , @NamedQuery(name = "Poruke.findById", query = "SELECT p FROM Poruke p WHERE p.id = :id")
    , @NamedQuery(name = "Poruke.findByIme", query = "SELECT p FROM Poruke p WHERE p.ime = :ime")
    , @NamedQuery(name = "Poruke.findByEmail", query = "SELECT p FROM Poruke p WHERE p.email = :email")
    , @NamedQuery(name = "Poruke.findByPitanje", query = "SELECT p FROM Poruke p WHERE p.pitanje = :pitanje")
    , @NamedQuery(name = "Poruke.findByOdgovor", query = "SELECT p FROM Poruke p WHERE p.odgovor = :odgovor")})
public class Poruke implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ime")
    private String ime;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "pitanje")
    private String pitanje;
    @Size(max = 45)
    @Column(name = "odgovor")
    private String odgovor;

    public Poruke() {
    }

    public Poruke(Integer id) {
        this.id = id;
    }

    public Poruke(Integer id, String ime, String email) {
        this.id = id;
        this.ime = ime;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poruke)) {
            return false;
        }
        Poruke other = (Poruke) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilemarket.beans.model.Poruke[ id=" + id + " ]";
    }
    
}
