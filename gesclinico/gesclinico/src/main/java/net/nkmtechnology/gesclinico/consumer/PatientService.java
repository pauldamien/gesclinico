/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.nkmtechnology.gesclinico.consumer;

import java.util.ArrayList;
import java.util.List;
import net.nkmtechnology.gesclinico.dbmanager.Patient;
import net.nkmtechnology.gesclinico.dbmanager.Pattierspayant;
import net.nkmtechnology.gesclinico.dbmanager.Tierspayant;
import net.nkmtechnology.gesclinico.dbmanager.Utilisateur;
import net.nkmtechnology.gesclinico.interfacemanager.PatientInterface;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lezekie
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/PatientManager")
public class PatientService {
    @Autowired
    private PatientInterface OPatientInterface;
    
    @GetMapping("/sayHello")
    public String sayHello(@RequestParam(name="name", defaultValue = "ezekiel") String name) {
        JSONObject json = new JSONObject();
        try {
            json.put("name", "Hello " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return json.toString();
    }
    
    @PostMapping("/createPattierspayant")
    public String createPattierspayant(@RequestParam("STR_UTITOKEN") String STR_UTITOKEN,
            @RequestParam("LG_PATID") String LG_PATID,
            @RequestParam("LG_TPAID") String LG_TPAID,
            @RequestParam("STR_PTPTYPEPATIENT") String STR_PTPTYPEPATIENT,
            @RequestParam("DBL_PTPTAUX") double DBL_PTPTAUX) {
        
        Utilisateur OUtilisateur = null;
        Patient OPatient = null;
        Tierspayant OTierspayant = null;
        JSONObject json = new JSONObject();
        boolean result = false;
        try {
            OUtilisateur = OPatientInterface.getUtilisateur(STR_UTITOKEN);
            OPatient = OPatientInterface.getPatient(LG_PATID);
            OTierspayant = OPatientInterface.getTierspayant(LG_TPAID);
            result = OPatientInterface.createPattierspayant(OUtilisateur, OPatient, OTierspayant, STR_PTPTYPEPATIENT, DBL_PTPTAUX);
            json.put("statutCode", (result == true) ? 1 : 0);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("statutCode", 0);
        }
        
        return json.toString();
    }
    
//    @GetMapping("/GiveMePattierspayant")
//    public String getPattierspayant(@RequestParam("STR_PTPCANCATVALUE") String STR_PTPCONCATVALUE) {
//        String result = "";
//        Pattierspayant OPattierspayant = null;
//        try {
//            OPatientInterface.getPattierspayant(STR_PTPCONCATVALUE);
//            if(OPattierspayant == null) {
//                System.out.println("Pattierspayant introuvable");
//                return result;
//            }
//            System.out.println("pattierspayant retrouvé avec succès");
//            result = "found";
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("une erreur lors de la recherche");
//        }
//        return result;
//    }
    
//    @GetMapping("/GiveMePattierspayantList")
//    public String getPattierspayantList(@RequestParam("search_value") String search_value,
//            @RequestParam("STR_PATREFERENCE") String STR_PATREFERENCE,
//            @RequestParam("STR_TPANAME") String STR_TPANAME) {
//        String result = "";
//        Patient OPatient = null;
//        Tierspayant OTierspayant = null;
//        List<Pattierspayant> pattierspayantList = new ArrayList<>();
//        JSONObject json = new JSONObject();
//        try {
//            OPatient = OPatientInterface.getPatient(STR_PATREFERENCE);
//            OTierspayant = OPatientInterface.getTierspayant(STR_TPANAME);
//            pattierspayantList = OPatientInterface.showAllOrOnePattierspayant(search_value, STR_PATREFERENCE, STR_TPANAME);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        return result;
//    }
    
    @PostMapping("/updatePattierspayant")
    public String updatePattierspayant(
            @RequestParam("LG_PTPID") String LG_PTPID,
            @RequestParam("LG_PATID") String LG_PATID,
            @RequestParam("LG_TPAID") String LG_TPAID,
            @RequestParam("STR_PTPTYPEPATIENT") String STR_PTPTYPEPATIENT,
            @RequestParam("DBL_PTPTAUX") double DBL_PTPTAUX,
            @RequestParam("STR_UTITOKEN") String STR_UTITOKEN) {
        Patient OPatient = null;
        Tierspayant OTierspayant = null;
        Pattierspayant OPattierspayant = null;
        Utilisateur OUtilisateur = null;
        boolean result;
        JSONObject json = new JSONObject();
        try {
            OUtilisateur = OPatientInterface.getUtilisateur(STR_UTITOKEN);
            OPatient = OPatientInterface.getPatient(LG_PATID);
            OTierspayant = OPatientInterface.getTierspayant(LG_TPAID);
            result = OPatientInterface.updatePattierspayant(LG_PTPID, OUtilisateur, OPatient, OTierspayant, STR_PTPTYPEPATIENT, DBL_PTPTAUX);
            json.put("statutCode", (result == true) ? 1 : 0);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("statutCode", 0);
        }
        
        return json.toString();
    }
    
    @PostMapping("/deletePattierspayant")
    public String deletePattierspayant(
            @RequestParam("STR_UTITOKEN") String STR_UTITOKEN,
            @RequestParam("LG_PTPID") String LG_PTPID) {
        Utilisateur OUtilisateur = null;
        JSONObject json = new JSONObject();
        boolean result = false;
        
        try {
            OUtilisateur = OPatientInterface.getUtilisateur(STR_UTITOKEN);
            result = OPatientInterface.deletePattierspayant(LG_PTPID, OUtilisateur);
            json.put("StatutCode", (result == true) ? 1 : 0);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("StatutCode", 0);
        }
        return json.toString();
    }
    
    @PostMapping("/showAllOrOnePattierspayant")
    public String showAllOrOnePattierspayant(@RequestParam("search_value") String search_value,
            @RequestParam(name="LG_PATID", defaultValue = "%") String LG_PATID,
            @RequestParam(name="LG_TPAID", defaultValue = "%") String LG_TPAID) {
        JSONObject json = null;
        JSONArray jsonArray = new JSONArray();
        List<Pattierspayant> listPattierspayant = new ArrayList<Pattierspayant>();
        
        try {
            listPattierspayant = OPatientInterface.showAllOrOnePattierspayant(search_value, LG_PATID, LG_TPAID);
            for(Pattierspayant p : listPattierspayant) {
                json = new JSONObject();
                json.put("LG_PTPID", p.getLgPtpid());
                json.put("STR_PATFIRSTNAME", p.getLgPatid().getStrPatfirstname());
                json.put("STR_PATLASTNAME", p.getLgPatid().getStrPatlastname());
                json.put("STR_TPANAME", p.getLgTpaid().getStrTpaname());
                json.put("STR_PTPTYPEPATIENT", p.getStrTypepatient());
                json.put("DBL_PTPTAUX", p.getDblPtptaux());
                jsonArray.put(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return jsonArray.toString();
    }
    
    @GetMapping("/getUsers")
    public String getUsers(@RequestParam("STR_UTITOKEN") String STR_UTITOKEN) {
        JSONObject json = new JSONObject();
        Utilisateur OUtilsateur = null;
        try {
            OUtilsateur = OPatientInterface.getUtilisateur(STR_UTITOKEN);
            json.put("StatutCode", (OUtilsateur == null) ? 0 : 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return json.toString();
    }
    
}
