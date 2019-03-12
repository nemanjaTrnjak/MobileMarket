/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.beans.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author neamanja
 */
@Entity
@Table(name = "kupovina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kupovina.findAll", query = "SELECT k FROM Kupovina k")
    , @NamedQuery(name = "Kupovina.findById", query = "SELECT k FROM Kupovina k WHERE k.id = :id")
    , @NamedQuery(name = "Kupovina.findByCena", query = "SELECT k FROM Kupovina k WHERE k.cena = :cena")
    , @NamedQuery(name = "Kupovina.findByBrojKartice", query = "SELECT k FROM Kupovina k WHERE k.brojKartice = :brojKartice")})
public class Kupovina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena")
    private int cena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "broj_kartice")
    private String brojKartice;
    @JoinColumn(name = "osoba_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Osoba osobaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kupovinaid")
    private List<KupovinaInfo> kupovinaInfoList;

    public Kupovina() {
    }

    public Kupovina(Integer id) {
        this.id = id;
    }

    public Kupovina(Integer id, int cena, String brojKartice) {
        this.id = id;
        this.cena = cena;
        this.brojKartice = brojKartice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getBrojKartice() {
        return brojKartice;
    }

    public void setBrojKartice(String brojKartice) {
        this.brojKartice = brojKartice;
    }

    public Osoba getOsobaId() {
        return osobaId;
    }

    public void setOsobaId(Osoba osobaId) {
        this.osobaId = osobaId;
    }

    @XmlTransient
    public List<KupovinaInfo> getKupovinaInfoList() {
        return kupovinaInfoList;
    }

    public void setKupovinaInfoList(List<KupovinaInfo> kupovinaInfoList) {
        this.kupovinaInfoList = kupovinaInfoList;
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
        if (!(object instanceof Kupovina)) {
            return false;
        }
        Kupovina other = (Kupovina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilemarket.beans.model.Kupovina[ id=" + id + " ]";
    }
    
}
