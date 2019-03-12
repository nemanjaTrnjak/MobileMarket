package com.mobilemarket.beans.model;

import com.mobilemarket.beans.model.Kupovina;
import com.mobilemarket.beans.model.Servis;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-10T04:49:37")
@StaticMetamodel(Osoba.class)
public class Osoba_ { 

    public static volatile SingularAttribute<Osoba, String> ime;
    public static volatile SingularAttribute<Osoba, String> prezime;
    public static volatile SingularAttribute<Osoba, String> lozinka;
    public static volatile ListAttribute<Osoba, Kupovina> kupovinaList;
    public static volatile SingularAttribute<Osoba, String> privilegija;
    public static volatile ListAttribute<Osoba, Servis> servisList;
    public static volatile SingularAttribute<Osoba, Integer> id;
    public static volatile SingularAttribute<Osoba, String> korisnickoIme;
    public static volatile SingularAttribute<Osoba, String> email;
    public static volatile SingularAttribute<Osoba, String> mobilniTelefon;

}