/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.nkmtechnology.gesclinico.dbmanager;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lezekie
 */
@Entity
@Table(name = "pattierspayant")
@NamedQueries({
    @NamedQuery(name = "Pattierspayant.findAll", query = "SELECT p FROM Pattierspayant p"),
    @NamedQuery(name = "Pattierspayant.findByLgPtpid", query = "SELECT p FROM Pattierspayant p WHERE p.lgPtpid = :lgPtpid"),
    @NamedQuery(name = "Pattierspayant.findByStrTypepatient", query = "SELECT p FROM Pattierspayant p WHERE p.strTypepatient = :strTypepatient"),
    @NamedQuery(name = "Pattierspayant.findByDblPtptaux", query = "SELECT p FROM Pattierspayant p WHERE p.dblPtptaux = :dblPtptaux"),
    @NamedQuery(name = "Pattierspayant.findByStrPtpstatut", query = "SELECT p FROM Pattierspayant p WHERE p.strPtpstatut = :strPtpstatut"),
    @NamedQuery(name = "Pattierspayant.findByDtPtpcreated", query = "SELECT p FROM Pattierspayant p WHERE p.dtPtpcreated = :dtPtpcreated"),
    @NamedQuery(name = "Pattierspayant.findByDtPtpupdated", query = "SELECT p FROM Pattierspayant p WHERE p.dtPtpupdated = :dtPtpupdated")})
public class Pattierspayant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_ptpid", nullable = false, length = 40)
    private String lgPtpid;
    @Column(name = "str_typepatient", length = 50)
    private String strTypepatient;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dbl_ptptaux", precision = 22, scale = 0)
    private Double dblPtptaux;
    @Column(name = "str_ptpstatut", length = 20)
    private String strPtpstatut;
    @Column(name = "dt_ptpcreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPtpcreated;
    @Column(name = "dt_ptpupdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPtpupdated;
    @JoinColumn(name = "lg_patid", referencedColumnName = "lg_patid")
    @ManyToOne
    private Patient lgPatid;
    @JoinColumn(name = "lg_tpaid", referencedColumnName = "lg_tpaid")
    @ManyToOne
    private Tierspayant lgTpaid;
    @JoinColumn(name = "lg_uticreated", referencedColumnName = "lg_utiid", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur lgUticreated;
    @JoinColumn(name = "lg_utiupdated", referencedColumnName = "lg_utiid", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur lgUtiupdated;

    public Pattierspayant() {
    }

    public Pattierspayant(String lgPtpid) {
        this.lgPtpid = lgPtpid;
    }

    public String getLgPtpid() {
        return lgPtpid;
    }

    public void setLgPtpid(String lgPtpid) {
        this.lgPtpid = lgPtpid;
    }

    public String getStrTypepatient() {
        return strTypepatient;
    }

    public void setStrTypepatient(String strTypepatient) {
        this.strTypepatient = strTypepatient;
    }

    public Double getDblPtptaux() {
        return dblPtptaux;
    }

    public void setDblPtptaux(Double dblPtptaux) {
        this.dblPtptaux = dblPtptaux;
    }

    public String getStrPtpstatut() {
        return strPtpstatut;
    }

    public void setStrPtpstatut(String strPtpstatut) {
        this.strPtpstatut = strPtpstatut;
    }

    public Date getDtPtpcreated() {
        return dtPtpcreated;
    }

    public void setDtPtpcreated(Date dtPtpcreated) {
        this.dtPtpcreated = dtPtpcreated;
    }

    public Date getDtPtpupdated() {
        return dtPtpupdated;
    }

    public void setDtPtpupdated(Date dtPtpupdated) {
        this.dtPtpupdated = dtPtpupdated;
    }

    public Patient getLgPatid() {
        return lgPatid;
    }

    public void setLgPatid(Patient lgPatid) {
        this.lgPatid = lgPatid;
    }

    public Tierspayant getLgTpaid() {
        return lgTpaid;
    }

    public void setLgTpaid(Tierspayant lgTpaid) {
        this.lgTpaid = lgTpaid;
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
        hash += (lgPtpid != null ? lgPtpid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pattierspayant)) {
            return false;
        }
        Pattierspayant other = (Pattierspayant) object;
        if ((this.lgPtpid == null && other.lgPtpid != null) || (this.lgPtpid != null && !this.lgPtpid.equals(other.lgPtpid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.nkmtechnology.gesclinico.dbmanager.Pattierspayant[ lgPtpid=" + lgPtpid + " ]";
    }
    
}
