/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.nkmtechnology.gesclinico.interfacemanager;

import java.util.Date;
import java.util.List;
import net.nkmtechnology.gesclinico.dbmanager.Patient;
import net.nkmtechnology.gesclinico.dbmanager.Pattierspayant;
import net.nkmtechnology.gesclinico.dbmanager.Tierspayant;
import net.nkmtechnology.gesclinico.dbmanager.Utilisateur;

/**
 *
 * @author lezekie
 */
public interface PatientInterface {
    
    /* ************ gestion du patient ************** */
    
    public boolean createPatient(String STR_PATFIRSTNAME, String STR_PATLASTNAME, Date DT_PATBIRTHDAY, String STR_PATPHONE, String STR_PATEMAIL, Utilisateur OUtilisateur);

    public boolean updatePatient(String LG_PATID, String STR_PATFIRSTNAME, String STR_PATLASTNAME, Date DT_PATBIRTHDAY, String STR_PATPHONE, String STR_PATEMAIL, Utilisateur OUtilisateur);

    public boolean deletePatient(String LG_PATID, Utilisateur OUtilisateur);

    public Patient getPatient(String LG_PATID);

    public List<Patient> showAllOrOnePatient(String search_value);
    
    /* ************ fin gestion du patient *********** */
    
    /* ************ gestion du tiers payant ********** */
    
    public boolean createTierspayant(String STR_TPANAME, Utilisateur OUtilisateur);

    public boolean updateTierspayant(String LG_TPAID, String STR_TPANAME, Utilisateur OUtilisateur);

    public boolean deleteTierspayant(String LG_TPAID, Utilisateur OUtilisateur);

    public Tierspayant getTierspayant(String LG_TPAID);

    public List<Tierspayant> showAllOrOneTierspayant(String search_value);
    
    /* ************ fin gestion tiers payant ********* */
    
    
    /* ************ gestion du patient sur le tiers payant ******** */
    
    public boolean createPattierspayant(Utilisateur OUtilisateur, Patient OPatient, Tierspayant OTierspayant, String STR_PTPTYPEPATIENT, double DBL_PTPTAUX);

    public boolean updatePattierspayant(String LG_PTPID, Utilisateur OUtilisateur, Patient OPatient, Tierspayant OTierspayant, String STR_PTPTYPEPATIENT, double DBL_PTPTAUX);

    public boolean deletePattierspayant(String LG_PTPID, Utilisateur OUtilisateur);

    public Pattierspayant getPattierspayant(String LG_PTPID);

    public List<Pattierspayant> showAllOrOnePattierspayant(String search_value, String LG_PATID, String LG_TPAID);
    
    /* ************ fin gestion du patient sur le tiers payant ****** */
    
    /* ************ gestion des utilisateurs ************** */
    
    public Utilisateur getUtilisateur(String STR_UTITOKEN);
    
    /* ************ fin gestion des utilisateurs ********** */
}
