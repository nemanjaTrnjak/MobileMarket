package com.mobilemarket.beans.model;

import com.mobilemarket.beans.model.KupovinaInfo;
import com.mobilemarket.beans.model.Osoba;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-10T04:49:37")
@StaticMetamodel(Kupovina.class)
public class Kupovina_ { 

    public static volatile SingularAttribute<Kupovina, String> brojKartice;
    public static volatile SingularAttribute<Kupovina, Integer> id;
    public static volatile SingularAttribute<Kupovina, Integer> cena;
    public static volatile SingularAttribute<Kupovina, Osoba> osobaId;
    public static volatile ListAttribute<Kupovina, KupovinaInfo> kupovinaInfoList;

}