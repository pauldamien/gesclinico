/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.nkmtechnology.gesclinico.dbmanager;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "utilisateur")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByLgUtiid", query = "SELECT u FROM Utilisateur u WHERE u.lgUtiid = :lgUtiid"),
    @NamedQuery(name = "Utilisateur.findByStrUtifirstname", query = "SELECT u FROM Utilisateur u WHERE u.strUtifirstname = :strUtifirstname"),
    @NamedQuery(name = "Utilisateur.findByStrUtilastname", query = "SELECT u FROM Utilisateur u WHERE u.strUtilastname = :strUtilastname"),
    @NamedQuery(name = "Utilisateur.findByStrUtilogin", query = "SELECT u FROM Utilisateur u WHERE u.strUtilogin = :strUtilogin"),
    @NamedQuery(name = "Utilisateur.findByStrUtipassword", query = "SELECT u FROM Utilisateur u WHERE u.strUtipassword = :strUtipassword"),
    @NamedQuery(name = "Utilisateur.findByStrUtitoken", query = "SELECT u FROM Utilisateur u WHERE u.strUtitoken = :strUtitoken"),
    @NamedQuery(name = "Utilisateur.findByStrUtistatut", query = "SELECT u FROM Utilisateur u WHERE u.strUtistatut = :strUtistatut"),
    @NamedQuery(name = "Utilisateur.findByDtUticreated", query = "SELECT u FROM Utilisateur u WHERE u.dtUticreated = :dtUticreated"),
    @NamedQuery(name = "Utilisateur.findByDtUtiupdated", query = "SELECT u FROM Utilisateur u WHERE u.dtUtiupdated = :dtUtiupdated")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_utiid", nullable = false, length = 40)
    private String lgUtiid;
    @Basic(optional = false)
    @Column(name = "str_utifirstname", nullable = false, length = 100)
    private String strUtifirstname;
    @Basic(optional = false)
    @Column(name = "str_utilastname", nullable = false, length = 100)
    private String strUtilastname;
    @Column(name = "str_utilogin", length = 20)
    private String strUtilogin;
    @Column(name = "str_utipassword", length = 255)
    private String strUtipassword;
    @Column(name = "str_utitoken", length = 20)
    private String strUtitoken;
    @Column(name = "str_utistatut", length = 20)
    private String strUtistatut;
    @Column(name = "dt_uticreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUticreated;
    @Column(name = "dt_utiupdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUtiupdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgUticreated")
    private Collection<Pattierspayant> pattierspayantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgUtiupdated")
    private Collection<Pattierspayant> pattierspayantCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgUticreated")
    private Collection<Tierspayant> tierspayantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgUtiupdated")
    private Collection<Tierspayant> tierspayantCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgUticreated")
    private Collection<Utilisateur> utilisateurCollection;
    @JoinColumn(name = "lg_uticreated", referencedColumnName = "lg_utiid", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur lgUticreated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgUtiupdated")
    private Collection<Utilisateur> utilisateurCollection1;
    @JoinColumn(name = "lg_utiupdated", referencedColumnName = "lg_utiid", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur lgUtiupdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgUticreated")
    private Collection<Patient> patientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgUtiupdated")
    private Collection<Patient> patientCollection1;

    public Utilisateur() {
    }

    public Utilisateur(String lgUtiid) {
        this.lgUtiid = lgUtiid;
    }

    public Utilisateur(String lgUtiid, String strUtifirstname, String strUtilastname) {
        this.lgUtiid = lgUtiid;
        this.strUtifirstname = strUtifirstname;
        this.strUtilastname = strUtilastname;
    }

    public String getLgUtiid() {
        return lgUtiid;
    }

    public void setLgUtiid(String lgUtiid) {
        this.lgUtiid = lgUtiid;
    }

    public String getStrUtifirstname() {
        return strUtifirstname;
    }

    public void setStrUtifirstname(String strUtifirstname) {
        this.strUtifirstname = strUtifirstname;
    }

    public String getStrUtilastname() {
        return strUtilastname;
    }

    public void setStrUtilastname(String strUtilastname) {
        this.strUtilastname = strUtilastname;
    }

    public String getStrUtilogin() {
        return strUtilogin;
    }

    public void setStrUtilogin(String strUtilogin) {
        this.strUtilogin = strUtilogin;
    }

    public String getStrUtipassword() {
        return strUtipassword;
    }

    public void setStrUtipassword(String strUtipassword) {
        this.strUtipassword = strUtipassword;
    }

    public String getStrUtitoken() {
        return strUtitoken;
    }

    public void setStrUtitoken(String strUtitoken) {
        this.strUtitoken = strUtitoken;
    }

    public String getStrUtistatut() {
        return strUtistatut;
    }

    public void setStrUtistatut(String strUtistatut) {
        this.strUtistatut = strUtistatut;
    }

    public Date getDtUticreated() {
        return dtUticreated;
    }

    public void setDtUticreated(Date dtUticreated) {
        this.dtUticreated = dtUticreated;
    }

    public Date getDtUtiupdated() {
        return dtUtiupdated;
    }

    public void setDtUtiupdated(Date dtUtiupdated) {
        this.dtUtiupdated = dtUtiupdated;
    }

    public Collection<Pattierspayant> getPattierspayantCollection() {
        return pattierspayantCollection;
    }

    public void setPattierspayantCollection(Collection<Pattierspayant> pattierspayantCollection) {
        this.pattierspayantCollection = pattierspayantCollection;
    }

    public Collection<Pattierspayant> getPattierspayantCollection1() {
        return pattierspayantCollection1;
    }

    public void setPattierspayantCollection1(Collection<Pattierspayant> pattierspayantCollection1) {
        this.pattierspayantCollection1 = pattierspayantCollection1;
    }

    public Collection<Tierspayant> getTierspayantCollection() {
        return tierspayantCollection;
    }

    public void setTierspayantCollection(Collection<Tierspayant> tierspayantCollection) {
        this.tierspayantCollection = tierspayantCollection;
    }

    public Collection<Tierspayant> getTierspayantCollection1() {
        return tierspayantCollection1;
    }

    public void setTierspayantCollection1(Collection<Tierspayant> tierspayantCollection1) {
        this.tierspayantCollection1 = tierspayantCollection1;
    }

    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    public Utilisateur getLgUticreated() {
        return lgUticreated;
    }

    public void setLgUticreated(Utilisateur lgUticreated) {
        this.lgUticreated = lgUticreated;
    }

    public Collection<Utilisateur> getUtilisateurCollection1() {
        return utilisateurCollection1;
    }

    public void setUtilisateurCollection1(Collection<Utilisateur> utilisateurCollection1) {
        this.utilisateurCollection1 = utilisateurCollection1;
    }

    public Utilisateur getLgUtiupdated() {
        return lgUtiupdated;
    }

    public void setLgUtiupdated(Utilisateur lgUtiupdated) {
        this.lgUtiupdated = lgUtiupdated;
    }

    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    public Collection<Patient> getPatientCollection1() {
        return patientCollection1;
    }

    public void setPatientCollection1(Collection<Patient> patientCollection1) {
        this.patientCollection1 = patientCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgUtiid != null ? lgUtiid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.lgUtiid == null && other.lgUtiid != null) || (this.lgUtiid != null && !this.lgUtiid.equals(other.lgUtiid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.nkmtechnology.gesclinico.dbmanager.Utilisateur[ lgUtiid=" + lgUtiid + " ]";
    }
    
}
