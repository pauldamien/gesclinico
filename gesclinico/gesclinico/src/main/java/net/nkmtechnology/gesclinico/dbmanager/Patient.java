/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.nkmtechnology.gesclinico.dbmanager;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lezekie
 */
@Entity
@Table(name = "patient")
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByLgPatid", query = "SELECT p FROM Patient p WHERE p.lgPatid = :lgPatid"),
    @NamedQuery(name = "Patient.findByStrPatfirstname", query = "SELECT p FROM Patient p WHERE p.strPatfirstname = :strPatfirstname"),
    @NamedQuery(name = "Patient.findByStrPatlastname", query = "SELECT p FROM Patient p WHERE p.strPatlastname = :strPatlastname"),
    @NamedQuery(name = "Patient.findByDtPatbirthday", query = "SELECT p FROM Patient p WHERE p.dtPatbirthday = :dtPatbirthday"),
    @NamedQuery(name = "Patient.findByStrPatphone", query = "SELECT p FROM Patient p WHERE p.strPatphone = :strPatphone"),
    @NamedQuery(name = "Patient.findByStrPatemail", query = "SELECT p FROM Patient p WHERE p.strPatemail = :strPatemail"),
    @NamedQuery(name = "Patient.findByStrPatreference", query = "SELECT p FROM Patient p WHERE p.strPatreference = :strPatreference"),
    @NamedQuery(name = "Patient.findByStrPatstatut", query = "SELECT p FROM Patient p WHERE p.strPatstatut = :strPatstatut"),
    @NamedQuery(name = "Patient.findByDtPatcreated", query = "SELECT p FROM Patient p WHERE p.dtPatcreated = :dtPatcreated"),
    @NamedQuery(name = "Patient.findByDtPatupdated", query = "SELECT p FROM Patient p WHERE p.dtPatupdated = :dtPatupdated")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_patid", nullable = false, length = 40)
    private String lgPatid;
    @Basic(optional = false)
    @Column(name = "str_patfirstname", nullable = false, length = 100)
    private String strPatfirstname;
    @Basic(optional = false)
    @Column(name = "str_patlastname", nullable = false, length = 100)
    private String strPatlastname;
    @Column(name = "dt_patbirthday")
    @Temporal(TemporalType.DATE)
    private Date dtPatbirthday;
    @Column(name = "str_patphone", length = 40)
    private String strPatphone;
    @Column(name = "str_patemail", length = 150)
    private String strPatemail;
    @Column(name = "str_patreference", length = 20)
    private String strPatreference;
    @Column(name = "str_patstatut", length = 20)
    private String strPatstatut;
    @Column(name = "dt_patcreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPatcreated;
    @Column(name = "dt_patupdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPatupdated;
    @OneToMany(mappedBy = "lgPatid")
    private Collection<Pattierspayant> pattierspayantCollection;
    @JoinColumn(name = "lg_uticreated", referencedColumnName = "lg_utiid", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur lgUticreated;
    @JoinColumn(name = "lg_utiupdated", referencedColumnName = "lg_utiid", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur lgUtiupdated;

    public Patient() {
    }

    public Patient(String lgPatid) {
        this.lgPatid = lgPatid;
    }

    public Patient(String lgPatid, String strPatfirstname, String strPatlastname) {
        this.lgPatid = lgPatid;
        this.strPatfirstname = strPatfirstname;
        this.strPatlastname = strPatlastname;
    }

    public String getLgPatid() {
        return lgPatid;
    }

    public void setLgPatid(String lgPatid) {
        this.lgPatid = lgPatid;
    }

    public String getStrPatfirstname() {
        return strPatfirstname;
    }

    public void setStrPatfirstname(String strPatfirstname) {
        this.strPatfirstname = strPatfirstname;
    }

    public String getStrPatlastname() {
        return strPatlastname;
    }

    public void setStrPatlastname(String strPatlastname) {
        this.strPatlastname = strPatlastname;
    }

    public Date getDtPatbirthday() {
        return dtPatbirthday;
    }

    public void setDtPatbirthday(Date dtPatbirthday) {
        this.dtPatbirthday = dtPatbirthday;
    }

    public String getStrPatphone() {
        return strPatphone;
    }

    public void setStrPatphone(String strPatphone) {
        this.strPatphone = strPatphone;
    }

    public String getStrPatemail() {
        return strPatemail;
    }

    public void setStrPatemail(String strPatemail) {
        this.strPatemail = strPatemail;
    }

    public String getStrPatreference() {
        return strPatreference;
    }

    public void setStrPatreference(String strPatreference) {
        this.strPatreference = strPatreference;
    }

    public String getStrPatstatut() {
        return strPatstatut;
    }

    public void setStrPatstatut(String strPatstatut) {
        this.strPatstatut = strPatstatut;
    }

    public Date getDtPatcreated() {
        return dtPatcreated;
    }

    public void setDtPatcreated(Date dtPatcreated) {
        this.dtPatcreated = dtPatcreated;
    }

    public Date getDtPatupdated() {
        return dtPatupdated;
    }

    public void setDtPatupdated(Date dtPatupdated) {
        this.dtPatupdated = dtPatupdated;
    }

    public Collection<Pattierspayant> getPattierspayantCollection() {
        return pattierspayantCollection;
    }

    public void setPattierspayantCollection(Collection<Pattierspayant> pattierspayantCollection) {
        this.pattierspayantCollection = pattierspayantCollection;
    }

    public Utilisateur getLgUticreated() {
        return lgUticreated;
    }

    public void setLgUticreated(Utilisateur lgUticreated) {
        this.lgUticreated = lgUticreated;
    }

    public Utilisateur getLgUtiupdated() {
        return lgUtiupdated;
    }

    public void setLgUtiupdated(Utilisateur lgUtiupdated) {
        this.lgUtiupdated = lgUtiupdated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgPatid != null ? lgPatid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.lgPatid == null && other.lgPatid != null) || (this.lgPatid != null && !this.lgPatid.equals(other.lgPatid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.nkmtechnology.gesclinico.dbmanager.Patient[ lgPatid=" + lgPatid + " ]";
    }
    
}
