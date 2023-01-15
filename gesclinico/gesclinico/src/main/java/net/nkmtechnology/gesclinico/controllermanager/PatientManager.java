/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.nkmtechnology.gesclinico.controllermanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import net.nkmtechnology.gesclinico.dbmanager.Patient;
import net.nkmtechnology.gesclinico.dbmanager.Pattierspayant;
import net.nkmtechnology.gesclinico.dbmanager.Tierspayant;
import net.nkmtechnology.gesclinico.dbmanager.Utilisateur;
import net.nkmtechnology.gesclinico.interfacemanager.PatientInterface;
import org.springframework.stereotype.Service;

/**
 *
 * @author lezekie
 */
@Service
public class PatientManager implements PatientInterface {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public boolean createPatient(String STR_PATFIRSTNAME, String STR_PATLASTNAME, Date DT_PATBIRTHDAY, String STR_PATPHONE, String STR_PATEMAIL, Utilisateur OUtilisateur) {
        boolean result = false;
        try {
            if (OUtilisateur == null) {
                System.out.println("votre session est terminé");
                return result;
            }
            Patient OPatient = new Patient();
            OPatient.setLgPatid("1");//id user
            OPatient.setStrPatfirstname(STR_PATFIRSTNAME);
            OPatient.setStrPatlastname(STR_PATLASTNAME);
            OPatient.setDtPatbirthday(DT_PATBIRTHDAY);
            OPatient.setStrPatphone(STR_PATPHONE);
            OPatient.setStrPatemail(STR_PATEMAIL);
            OPatient.setStrPatstatut("enable");
            OPatient.setDtPatcreated(new Date());
            OPatient.setLgUticreated(OUtilisateur);
            em.persist(OPatient);
            result = true;
            System.out.println("succès de la creation");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("une erreur est survenue, veuillez contacter votre administrateur!");
        }

        return result;
    }

    @Override
    @Transactional
    public boolean updatePatient(String LG_PATID, String STR_PATFIRSTNAME, String STR_PATLASTNAME, Date DT_PATBIRTHDAY, String STR_PATPHONE, String STR_PATEMAIL, Utilisateur OUtilisateur) {
        boolean result = false;
        Patient OPatient = null;
        try {
            OPatient = this.getPatient(LG_PATID);
            if (OUtilisateur == null) {
                System.out.println("utilisateur inexistant");
                return result;
            }
            if (OPatient == null) {
                System.out.println("patient inexistant");
                return result;
            }
            OPatient.setStrPatfirstname(STR_PATFIRSTNAME);
            OPatient.setStrPatlastname(STR_PATLASTNAME);
            OPatient.setDtPatbirthday(DT_PATBIRTHDAY);
            OPatient.setStrPatphone(STR_PATPHONE);
            OPatient.setStrPatemail(STR_PATEMAIL);
            OPatient.setLgUtiupdated(OUtilisateur);
            OPatient.setDtPatupdated(new Date());
            em.merge(OPatient);
            result = true;
            System.out.println("Mise à jour du patient reussite");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("une erreur est survenue, veuillez contacter votre administrateur!");
        }
        return result;
    }

    @Override
    @Transactional
    public boolean deletePatient(String LG_PATID, Utilisateur OUtilisateur) {
        boolean result = false;
        Patient OPatient = null;
        try {
            OPatient = this.getPatient(LG_PATID);
            if (OUtilisateur == null) {
                System.out.println("Utilisateur inexistant");
                return result;
            }
            if (OPatient == null) {
                System.out.println("patient inexistant");
                return result;
            }
            OPatient.setStrPatstatut("delete");
            OPatient.setLgUtiupdated(OUtilisateur);
            OPatient.setDtPatupdated(new Date());
            em.merge(OPatient);
            result = true;
            System.out.println("Patient supprimé");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("une erreur est survenue, veuillez contacter votre administrateur!");
        }
        return result;
    }

    @Override
    public Patient getPatient(String LG_PATID) {
        Patient OPatient = null;
        try {
            Query q = em.createQuery("select p from Patient p where p.lgPatid =: ?1 and p.strPatstatut =: ?2")
                    .setParameter(1, LG_PATID)
                    .setParameter(2, "enable");
            if (q.getResultList().size() > 0) {
                OPatient = (Patient) q.getSingleResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("une erreur est survenue, veuillez contacter votre administrateur!");
        }
        return OPatient;
    }

    @Override
    public List<Patient> showAllOrOnePatient(String search_value) {
        List<Patient> patientList = new ArrayList<Patient>();
        try {
            Query q = em.createQuery("select p from Patient p where (p.strPatfirstname LIKE ?1 or p.strPatlastname LIKE ?1 or p.strPatphone LIKE ?1 or p.strPatemail LIKE ?1) and p.strPatstatut =: ?2")
                    .setParameter(1, search_value).
                    setParameter(2, "enable");
            patientList = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("une erreur est survenue, veuillez contacter votre administrateur!");
        }
        return patientList;
    }

    @Override
    @Transactional
    public boolean createPattierspayant(Utilisateur OUtilisateur, Patient OPatient, Tierspayant OTierspayant, String STR_PTPTYPEPATIENT, double DBL_PTPTAUX) {
        boolean result = false;
        try {
            if (OUtilisateur == null || OPatient == null || OTierspayant == null) {
                System.out.println("il y a un problème sur l'un des objets passé en paramètre de la fonction createPattierspayant()");
                return result;
            }
            Pattierspayant OPattierspayant = new Pattierspayant();
            OPattierspayant.setLgPtpid("1");
            OPattierspayant.setStrTypepatient(STR_PTPTYPEPATIENT);
            OPattierspayant.setDblPtptaux(DBL_PTPTAUX);
            OPattierspayant.setStrPtpstatut("enable");
            OPattierspayant.setLgPatid(OPatient);
            OPattierspayant.setLgTpaid(OTierspayant);
            OPattierspayant.setDtPtpcreated(new Date());
            OPattierspayant.setLgUticreated(OUtilisateur);
            em.persist(OPattierspayant);
            result = true;
            System.out.println("création reussite");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("une erreur est survenue, veuillez contacter votre administrateur!");
        }
        return result;
    }

    @Override
    @Transactional
    public boolean updatePattierspayant(String LG_PTPID, Utilisateur OUtilisateur, Patient OPatient, Tierspayant OTierspayant, String STR_PTPTYPEPATIENT, double DBL_PTPTAUX) {
        boolean result = false;
        Pattierspayant OPattierspayant = null;
        try {
            OPattierspayant = this.getPattierspayant(LG_PTPID);
            if (OPattierspayant == null) {
                System.out.println(" pattierspayant introuvable");
                return result;
            }
            if (OUtilisateur == null || OPatient == null || OTierspayant == null) {
                System.out.println("il y a un problème sur l'un des objets passé en paramètre de la fonction createPattierspayant()");
                return result;
            }
            OPattierspayant.setStrTypepatient(STR_PTPTYPEPATIENT);
            OPattierspayant.setDblPtptaux(DBL_PTPTAUX);
            OPattierspayant.setLgPatid(OPatient);
            OPattierspayant.setLgTpaid(OTierspayant);
            OPattierspayant.setDtPtpupdated(new Date());
            OPattierspayant.setLgUtiupdated(OUtilisateur);
            em.merge(OPattierspayant);
            result = true;
            System.out.println("Mise à jour reussite");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("une erreur est survenue, veuillez contacter votre administrateur!");
        }
        return result;
    }

    @Override
    @Transactional
    public boolean deletePattierspayant(String LG_PTPID, Utilisateur OUtilisateur) {
        boolean result = false;
        Pattierspayant OPattierspayant = null;
        try {
            OPattierspayant = this.getPattierspayant(LG_PTPID);
            if (OPattierspayant == null) {
                System.out.println("pattierspayant introuvable");
                return result;
            }
            if (OUtilisateur == null) {
                System.out.println("Il y a un objet qui a pour valeur null, vérifier l'utilisateur ou le pattierspayant");
                return result;
            }
            OPattierspayant.setStrPtpstatut("delete");
            OPattierspayant.setDtPtpupdated(new Date());
            OPattierspayant.setLgUtiupdated(OUtilisateur);
            em.merge(OPattierspayant);
            result = true;
            System.out.println("Suppression reussite!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("une erreur est survenue, veuillez contacter votre administrateur!");
        }
        return result;
    }

    @Override
    public Pattierspayant getPattierspayant(String LG_PTPID) {
        Pattierspayant OPattierspayant = null;
        try {
            Query q = em.createQuery("select t from Pattierspayant t where t.lgPtpid = ?1 and t.strPtpstatut = ?2")
                    .setParameter(1, LG_PTPID)
                    .setParameter(2, "enable");
            if (q.getResultList().size() > 0) {
                OPattierspayant = (Pattierspayant) q.getSingleResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("une erreur est survenue, veuillez contacter votre administrateur!");
        }
        return OPattierspayant;
    }

    @Override
    public List<Pattierspayant> showAllOrOnePattierspayant(String search_value, String LG_PATID, String LG_TPAID) {
        List<Pattierspayant> pattierspayantList = new ArrayList<>();
        try {
            Query q = em.createQuery("select t from Pattierspayant t where (t.lgPatid.strPatfirstname LIKE ?1 or t.lgPatid.strPatlastname LIKE ?1 or t.lgPatid.strPatphone LIKE ?1 or t.lgPatid.strPatreference LIKE ?1 or t.lgTpaid.strTpaname LIKE ?1 or CONCAT(t.lgPatid.strPatfirstname,t.lgPatid.strPatlastname) LIKE ?1 and t.lgPatid LIKE ?2 and t.lgTpaid LIKE ?3 and t.strPtpstatut = ?4 ORDER BY t.lgPatid.strPatfirstname")
                    .setParameter(1, search_value + "%").setParameter(2, LG_PATID).setParameter(3, LG_TPAID).setParameter(4, "enable");
            pattierspayantList = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("une erreur est survenue, veuillez contacter votre administrateur!");
        }
        return pattierspayantList;
    }

    @Override
    @Transactional
    public boolean createTierspayant(String STR_TPANAME, Utilisateur OUtilisateur) {
        boolean result = false;
        try {
            if (OUtilisateur == null) {
                System.out.println("Utilisateur inexistant");
                return result;
            }
            Tierspayant OTierspayant = new Tierspayant();
            OTierspayant.setLgTpaid("1");
            OTierspayant.setStrTpaname(STR_TPANAME);
            OTierspayant.setDtTpacreated(new Date());
            OTierspayant.setLgUticreated(OUtilisateur);
            OTierspayant.setStrTpastatut("enable");
            em.persist(OTierspayant);
            result = true;
            System.out.println("Tierspayant crée");
        } catch (Exception e) {
            System.out.println("erreur de création du tierspayant");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public boolean updateTierspayant(String LG_TPAID, String STR_TPANAME, Utilisateur OUtilisateur) {
        boolean result = false;
        Tierspayant OTierspayant = null;
        try {
            OTierspayant = this.getTierspayant(LG_TPAID);
            if (OTierspayant == null) {
                System.out.println("Tierspayant Inexistant");
                return result;
            }
            OTierspayant.setStrTpaname(STR_TPANAME);
            OTierspayant.setDtTpaupdated(new Date());
            OTierspayant.setLgUtiupdated(OUtilisateur);
            em.merge(OTierspayant);
            result = true;
            System.out.println("Mise à jour reussite");
        } catch (Exception e) {
            System.out.println("echec de mise à jour, veuillez contacter votre admin");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public boolean deleteTierspayant(String LG_TPAID, Utilisateur OUtilisateur) {
        boolean result = false;
        Tierspayant OTierspayant = null;
        try {
            OTierspayant = this.getTierspayant(LG_TPAID);
            if (OTierspayant == null) {
                System.out.println("Tierspayant Inexistant");
                return result;
            }
            OTierspayant.setStrTpastatut("delete");
            OTierspayant.setDtTpaupdated(new Date());
            OTierspayant.setLgUtiupdated(OUtilisateur);
            em.merge(OTierspayant);
            result = true;
            System.out.println("suppression reussite");
        } catch (Exception e) {
            System.out.println("echec de suppression");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Tierspayant getTierspayant(String LG_TPAID) {
        Tierspayant OTierspayant = null;
        try {
            Query q = em.createQuery("select t from Tierspayant t where t.lgTpaid = ?1 and t.strTpastatut = ?2")
                    .setParameter(1, LG_TPAID)
                    .setParameter(2, "enable");
            if (q.getResultList().size() > 0) {
                OTierspayant = (Tierspayant) q.getSingleResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OTierspayant;
    }

    @Override
    public List<Tierspayant> showAllOrOneTierspayant(String search_value) {
        List<Tierspayant> tierspayantList = new ArrayList<>();
        try {
            Query q = em.createQuery("select t from Tierspayant t where t.strTpaname LIKE ?1 and t.strTpastatut = ?2")
                    .setParameter(1, search_value)
                    .setParameter(2, "enable");
            tierspayantList = q.getResultList();
            System.out.println("succès");
        } catch (Exception e) {
            System.out.println("ehec de demande de la liste des tierspayants");
            e.printStackTrace();
        }
        return tierspayantList;
    }

    @Override
    public Utilisateur getUtilisateur(String STR_UTITOKEN) {
        Utilisateur OUtilisateur = null;
        try {
            System.out.println("la token que je reçois est : " + STR_UTITOKEN);
            Query q = em.createQuery("SELECT u FROM Utilisateur u WHERE u.strUtitoken = ?1 AND u.strUtistatut = ?2 ")
                    .setParameter(1, STR_UTITOKEN)
                    .setParameter(2, "enable");
            System.out.println("la taille de ma liste est : " + q.getResultList().size());
            // OUtilisateur = (Utilisateur) q.getSingleResult();
            if (q.getResultList().size() > 0) {
                OUtilisateur = (Utilisateur) q.getSingleResult();
            }
        } catch (Exception e) {
            System.out.println("une erreur est survenue dans le getUser");
            e.printStackTrace();
        }

        return OUtilisateur;
    }

}
