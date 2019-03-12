/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilemarket.beans.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author neamanja
 */
@Entity
@Table(name = "servis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servis.findAll", query = "SELECT s FROM Servis s")
    , @NamedQuery(name = "Servis.findById", query = "SELECT s FROM Servis s WHERE s.id = :id")
    , @NamedQuery(name = "Servis.findByOpisProblema", query = "SELECT s FROM Servis s WHERE s.opisProblema = :opisProblema")
    , @NamedQuery(name = "Servis.findByPrijem", query = "SELECT s FROM Servis s WHERE s.prijem = :prijem")
    , @NamedQuery(name = "Servis.findByIzlaz", query = "SELECT s FROM Servis s WHERE s.izlaz = :izlaz")
    , @NamedQuery(name = "Servis.findByMobilniTelefon", query = "SELECT s FROM Servis s WHERE s.mobilniTelefon = :mobilniTelefon")
    , @NamedQuery(name = "Servis.findByImeKorisnika", query = "SELECT s FROM Servis s WHERE s.imeKorisnika = :imeKorisnika")
    , @NamedQuery(name = "Servis.findByEmail", query = "SELECT s FROM Servis s WHERE s.email = :email")
    , @NamedQuery(name = "Servis.findByKontaktTelefon", query = "SELECT s FROM Servis s WHERE s.kontaktTelefon = :kontaktTelefon")})
public class Servis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "opis_problema")
    private String opisProblema;
    @Column(name = "prijem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prijem;
    @Column(name = "izlaz")
    @Temporal(TemporalType.TIMESTAMP)
    private Date izlaz;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mobilni_telefon")
    private String mobilniTelefon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ime_korisnika")
    private String imeKorisnika;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "kontakt_telefon")
    private String kontaktTelefon;
    @JoinColumn(name = "osoba_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Osoba osobaId;

    public Servis() {
    }

    public Servis(Integer id) {
        this.id = id;
    }

    public Servis(Integer id, String mobilniTelefon, String imeKorisnika, String email, String kontaktTelefon) {
        this.id = id;
        this.mobilniTelefon = mobilniTelefon;
        this.imeKorisnika = imeKorisnika;
        this.email = email;
        this.kontaktTelefon = kontaktTelefon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpisProblema() {
        return opisProblema;
    }

    public void setOpisProblema(String opisProblema) {
        this.opisProblema = opisProblema;
    }

    public Date getPrijem() {
        return prijem;
    }

    public void setPrijem(Date prijem) {
        this.prijem = prijem;
    }

    public Date getIzlaz() {
        return izlaz;
    }

    public void setIzlaz(Date izlaz) {
        this.izlaz = izlaz;
    }

    public String getMobilniTelefon() {
        return mobilniTelefon;
    }

    public void setMobilniTelefon(String mobilniTelefon) {
        this.mobilniTelefon = mobilniTelefon;
    }

    public String getImeKorisnika() {
        return imeKorisnika;
    }

    public void setImeKorisnika(String imeKorisnika) {
        this.imeKorisnika = imeKorisnika;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public Osoba getOsobaId() {
        return osobaId;
    }

    public void setOsobaId(Osoba osobaId) {
        this.osobaId = osobaId;
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
        if (!(object instanceof Servis)) {
            return false;
        }
        Servis other = (Servis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilemarket.beans.model.Servis[ id=" + id + " ]";
    }
    
}
