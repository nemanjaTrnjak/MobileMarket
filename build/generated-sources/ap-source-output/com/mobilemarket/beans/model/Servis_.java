package com.mobilemarket.beans.model;

import com.mobilemarket.beans.model.Osoba;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-10T04:49:37")
@StaticMetamodel(Servis.class)
public class Servis_ { 

    public static volatile SingularAttribute<Servis, Date> izlaz;
    public static volatile SingularAttribute<Servis, String> opisProblema;
    public static volatile SingularAttribute<Servis, String> imeKorisnika;
    public static volatile SingularAttribute<Servis, Integer> id;
    public static volatile SingularAttribute<Servis, Date> prijem;
    public static volatile SingularAttribute<Servis, String> kontaktTelefon;
    public static volatile SingularAttribute<Servis, String> email;
    public static volatile SingularAttribute<Servis, Osoba> osobaId;
    public static volatile SingularAttribute<Servis, String> mobilniTelefon;

}