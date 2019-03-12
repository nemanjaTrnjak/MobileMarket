/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.beans.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neamanja
 */
@Entity
@Table(name = "dodatna_oprema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DodatnaOprema.findAll", query = "SELECT d FROM DodatnaOprema d")
    , @NamedQuery(name = "DodatnaOprema.findById", query = "SELECT d FROM DodatnaOprema d WHERE d.id = :id")})
public class DodatnaOprema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "proizvod_id", referencedColumnName = "id")
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    private Proizvod proizvodId;

    public DodatnaOprema() {
    }

    public DodatnaOprema(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proizvod getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(Proizvod proizvodId) {
        this.proizvodId = proizvodId;
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
        if (!(object instanceof DodatnaOprema)) {
            return false;
        }
        DodatnaOprema other = (DodatnaOprema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilemarket.beans.model.DodatnaOprema[ id=" + id + " ]";
    }
    
}
