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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neamanja
 */
@Entity
@Table(name = "kupovina_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KupovinaInfo.findAll", query = "SELECT k FROM KupovinaInfo k")
    , @NamedQuery(name = "KupovinaInfo.findById", query = "SELECT k FROM KupovinaInfo k WHERE k.id = :id")
    , @NamedQuery(name = "KupovinaInfo.findByKolicina", query = "SELECT k FROM KupovinaInfo k WHERE k.kolicina = :kolicina")})
public class KupovinaInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kolicina")
    private int kolicina;
    @JoinColumn(name = "Kupovina_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Kupovina kupovinaid;
    @JoinColumn(name = "Proizvod_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proizvod proizvodid;

    public KupovinaInfo() {
    }

    public KupovinaInfo(Integer id) {
        this.id = id;
    }

    public KupovinaInfo(Integer id, int kolicina) {
        this.id = id;
        this.kolicina = kolicina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Kupovina getKupovinaid() {
        return kupovinaid;
    }

    public void setKupovinaid(Kupovina kupovinaid) {
        this.kupovinaid = kupovinaid;
    }

    public Proizvod getProizvodid() {
        return proizvodid;
    }

    public void setProizvodid(Proizvod proizvodid) {
        this.proizvodid = proizvodid;
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
        if (!(object instanceof KupovinaInfo)) {
            return false;
        }
        KupovinaInfo other = (KupovinaInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilemarket.beans.model.KupovinaInfo[ id=" + id + " ]";
    }
    
}
