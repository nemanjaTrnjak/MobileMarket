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
@Table(name = "osoba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Osoba.findAll", query = "SELECT o FROM Osoba o")
    , @NamedQuery(name = "Osoba.findById", query = "SELECT o FROM Osoba o WHERE o.id = :id")
    , @NamedQuery(name = "Osoba.findByKorisnickoIme", query = "SELECT o FROM Osoba o WHERE o.korisnickoIme = :korisnickoIme")
    , @NamedQuery(name = "Osoba.findByKorisnickoImeLozinka", query = "SELECT o FROM Osoba o WHERE o.korisnickoIme = :korisnickoIme and o.lozinka = :lozinka")
    , @NamedQuery(name = "Osoba.findByLozinka", query = "SELECT o FROM Osoba o WHERE o.lozinka = :lozinka")
    , @NamedQuery(name = "Osoba.findByEmail", query = "SELECT o FROM Osoba o WHERE o.email = :email")
    , @NamedQuery(name = "Osoba.findByIme", query = "SELECT o FROM Osoba o WHERE o.ime = :ime")
    , @NamedQuery(name = "Osoba.findByPrezime", query = "SELECT o FROM Osoba o WHERE o.prezime = :prezime")
    , @NamedQuery(name = "Osoba.findByMobilniTelefon", query = "SELECT o FROM Osoba o WHERE o.mobilniTelefon = :mobilniTelefon")
    , @NamedQuery(name = "Osoba.findByPrivilegija", query = "SELECT o FROM Osoba o WHERE o.privilegija = :privilegija")})
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "korisnicko_ime")
    private String korisnickoIme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "lozinka")
    private String lozinka;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "mobilni_telefon")
    private String mobilniTelefon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "privilegija")
    private String privilegija;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osobaId")
    private List<Servis> servisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osobaId")
    private List<Kupovina> kupovinaList;

    public Osoba() {
    }

    public Osoba(Integer id) {
        this.id = id;
    }

    public Osoba(Integer id, String korisnickoIme, String lozinka, String email, String ime, String prezime, String mobilniTelefon, String privilegija) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.mobilniTelefon = mobilniTelefon;
        this.privilegija = privilegija;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getMobilniTelefon() {
        return mobilniTelefon;
    }

    public void setMobilniTelefon(String mobilniTelefon) {
        this.mobilniTelefon = mobilniTelefon;
    }

    public String getPrivilegija() {
        return privilegija;
    }

    public void setPrivilegija(String privilegija) {
        this.privilegija = privilegija;
    }

    @XmlTransient
    public List<Servis> getServisList() {
        return servisList;
    }

    public void setServisList(List<Servis> servisList) {
        this.servisList = servisList;
    }

    @XmlTransient
    public List<Kupovina> getKupovinaList() {
        return kupovinaList;
    }

    public void setKupovinaList(List<Kupovina> kupovinaList) {
        this.kupovinaList = kupovinaList;
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
        if (!(object instanceof Osoba)) {
            return false;
        }
        Osoba other = (Osoba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilemarket.beans.model.Osoba[ id=" + id + " ]";
    }
    
}
