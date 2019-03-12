package com.mobilemarket.beans.model;

import com.mobilemarket.beans.model.DodatnaOprema;
import com.mobilemarket.beans.model.KupovinaInfo;
import com.mobilemarket.beans.model.MobilniTelefon;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-10T04:49:37")
@StaticMetamodel(Proizvod.class)
public class Proizvod_ { 

    public static volatile ListAttribute<Proizvod, DodatnaOprema> dodatnaOpremaList;
    public static volatile SingularAttribute<Proizvod, Integer> stanje;
    public static volatile SingularAttribute<Proizvod, String> naziv;
    public static volatile SingularAttribute<Proizvod, Integer> id;
    public static volatile SingularAttribute<Proizvod, Integer> cena;
    public static volatile ListAttribute<Proizvod, MobilniTelefon> mobilniTelefonList;
    public static volatile ListAttribute<Proizvod, KupovinaInfo> kupovinaInfoList;

}