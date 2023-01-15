package net.nkmtechnology.gesclinico.dbmanager;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.nkmtechnology.gesclinico.dbmanager.Pattierspayant;
import net.nkmtechnology.gesclinico.dbmanager.Utilisateur;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-03T22:48:26", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Tierspayant.class)
public class Tierspayant_ { 

    public static volatile CollectionAttribute<Tierspayant, Pattierspayant> pattierspayantCollection;
    public static volatile SingularAttribute<Tierspayant, Utilisateur> lgUtiupdated;
    public static volatile SingularAttribute<Tierspayant, String> strTpastatut;
    public static volatile SingularAttribute<Tierspayant, String> strTpaname;
    public static volatile SingularAttribute<Tierspayant, Date> dtTpacreated;
    public static volatile SingularAttribute<Tierspayant, String> lgTpaid;
    public static volatile SingularAttribute<Tierspayant, Utilisateur> lgUticreated;
    public static volatile SingularAttribute<Tierspayant, Date> dtTpaupdated;

}