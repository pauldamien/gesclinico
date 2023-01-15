package net.nkmtechnology.gesclinico.dbmanager;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.nkmtechnology.gesclinico.dbmanager.Patient;
import net.nkmtechnology.gesclinico.dbmanager.Tierspayant;
import net.nkmtechnology.gesclinico.dbmanager.Utilisateur;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-03T22:48:26", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Pattierspayant.class)
public class Pattierspayant_ { 

    public static volatile SingularAttribute<Pattierspayant, Utilisateur> lgUtiupdated;
    public static volatile SingularAttribute<Pattierspayant, Date> dtPtpcreated;
    public static volatile SingularAttribute<Pattierspayant, String> strTypepatient;
    public static volatile SingularAttribute<Pattierspayant, Double> dblPtptaux;
    public static volatile SingularAttribute<Pattierspayant, Date> dtPtpupdated;
    public static volatile SingularAttribute<Pattierspayant, Patient> lgPatid;
    public static volatile SingularAttribute<Pattierspayant, String> strPtpstatut;
    public static volatile SingularAttribute<Pattierspayant, String> lgPtpid;
    public static volatile SingularAttribute<Pattierspayant, Tierspayant> lgTpaid;
    public static volatile SingularAttribute<Pattierspayant, Utilisateur> lgUticreated;

}