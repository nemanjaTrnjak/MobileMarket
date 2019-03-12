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
@Table(name = "proizvod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proizvod.findAll", query = "SELECT p FROM Proizvod p")
    , @NamedQuery(name = "Proizvod.findById", query = "SELECT p FROM Proizvod p WHERE p.id = :id")
    , @NamedQuery(name = "Proizvod.findByCena", query = "SELECT p FROM Proizvod p WHERE p.cena = :cena")
    , @NamedQuery(name = "Proizvod.findByNaziv", query = "SELECT p FROM Proizvod p WHERE p.naziv = :naziv")
    , @NamedQuery(name = "Proizvod.findByNazivMobilni", query = "SELECT p FROM Proizvod p WHERE p.naziv like :naziv")
    , @NamedQuery(name = "Proizvod.findByNazivOprema", query = "SELECT p FROM Proizvod p WHERE p.naziv like :naziv")
    , @NamedQuery(name = "Proizvod.findByStanje", query = "SELECT p FROM Proizvod p WHERE p.stanje = :stanje")})
public class Proizvod implements Serializable {

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
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stanje")
    private int stanje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proizvodId")
    private List<DodatnaOprema> dodatnaOpremaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proizvodid")
    private List<KupovinaInfo> kupovinaInfoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proizvodId")
    private List<MobilniTelefon> mobilniTelefonList;

    public Proizvod() {
    }

    public Proizvod(Integer id) {
        this.id = id;
    }

    public Proizvod(Integer id, int cena, String naziv, int stanje) {
        this.id = id;
        this.cena = cena;
        this.naziv = naziv;
        this.stanje = stanje;
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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getStanje() {
        return stanje;
    }

    public void setStanje(int stanje) {
        this.stanje = stanje;
    }

    @XmlTransient
    public List<DodatnaOprema> getDodatnaOpremaList() {
        return dodatnaOpremaList;
    }

    public void setDodatnaOpremaList(List<DodatnaOprema> dodatnaOpremaList) {
        this.dodatnaOpremaList = dodatnaOpremaList;
    }

    @XmlTransient
    public List<KupovinaInfo> getKupovinaInfoList() {
        return kupovinaInfoList;
    }

    public void setKupovinaInfoList(List<KupovinaInfo> kupovinaInfoList) {
        this.kupovinaInfoList = kupovinaInfoList;
    }

    @XmlTransient
    public List<MobilniTelefon> getMobilniTelefonList() {
        return mobilniTelefonList;
    }

    public void setMobilniTelefonList(List<MobilniTelefon> mobilniTelefonList) {
        this.mobilniTelefonList = mobilniTelefonList;
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
        if (!(object instanceof Proizvod)) {
            return false;
        }
        Proizvod other = (Proizvod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilemarket.beans.model.Proizvod[ id=" + id + " ]";
    }
    
}
