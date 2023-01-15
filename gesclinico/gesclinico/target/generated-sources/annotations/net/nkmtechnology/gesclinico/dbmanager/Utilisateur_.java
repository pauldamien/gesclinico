package net.nkmtechnology.gesclinico.dbmanager;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.nkmtechnology.gesclinico.dbmanager.Patient;
import net.nkmtechnology.gesclinico.dbmanager.Pattierspayant;
import net.nkmtechnology.gesclinico.dbmanager.Tierspayant;
import net.nkmtechnology.gesclinico.dbmanager.Utilisateur;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-03T22:48:26", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile CollectionAttribute<Utilisateur, Pattierspayant> pattierspayantCollection;
    public static volatile CollectionAttribute<Utilisateur, Utilisateur> utilisateurCollection;
    public static volatile SingularAttribute<Utilisateur, String> lgUtiid;
    public static volatile CollectionAttribute<Utilisateur, Tierspayant> tierspayantCollection1;
    public static volatile SingularAttribute<Utilisateur, String> strUtilastname;
    public static volatile CollectionAttribute<Utilisateur, Patient> patientCollection;
    public static volatile SingularAttribute<Utilisateur, Date> dtUtiupdated;
    public static volatile SingularAttribute<Utilisateur, Utilisateur> lgUtiupdated;
    public static volatile SingularAttribute<Utilisateur, String> strUtistatut;
    public static volatile CollectionAttribute<Utilisateur, Patient> patientCollection1;
    public static volatile CollectionAttribute<Utilisateur, Pattierspayant> pattierspayantCollection1;
    public static volatile SingularAttribute<Utilisateur, String> strUtilogin;
    public static volatile SingularAttribute<Utilisateur, String> strUtitoken;
    public static volatile CollectionAttribute<Utilisateur, Tierspayant> tierspayantCollection;
    public static volatile SingularAttribute<Utilisateur, String> strUtipassword;
    public static volatile SingularAttribute<Utilisateur, Date> dtUticreated;
    public static volatile SingularAttribute<Utilisateur, String> strUtifirstname;
    public static volatile SingularAttribute<Utilisateur, Utilisateur> lgUticreated;
    public static volatile CollectionAttribute<Utilisateur, Utilisateur> utilisateurCollection1;

}