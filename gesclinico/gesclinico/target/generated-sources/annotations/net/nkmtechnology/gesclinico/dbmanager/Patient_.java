package net.nkmtechnology.gesclinico.dbmanager;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.nkmtechnology.gesclinico.dbmanager.Pattierspayant;
import net.nkmtechnology.gesclinico.dbmanager.Utilisateur;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-03T22:48:26", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile CollectionAttribute<Patient, Pattierspayant> pattierspayantCollection;
    public static volatile SingularAttribute<Patient, String> strPatemail;
    public static volatile SingularAttribute<Patient, Date> dtPatbirthday;
    public static volatile SingularAttribute<Patient, Date> dtPatcreated;
    public static volatile SingularAttribute<Patient, String> strPatlastname;
    public static volatile SingularAttribute<Patient, String> strPatreference;
    public static volatile SingularAttribute<Patient, Utilisateur> lgUtiupdated;
    public static volatile SingularAttribute<Patient, String> strPatphone;
    public static volatile SingularAttribute<Patient, String> lgPatid;
    public static volatile SingularAttribute<Patient, String> strPatfirstname;
    public static volatile SingularAttribute<Patient, String> strPatstatut;
    public static volatile SingularAttribute<Patient, Utilisateur> lgUticreated;
    public static volatile SingularAttribute<Patient, Date> dtPatupdated;

}