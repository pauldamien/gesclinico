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
@Table(name = "tierspayant")
@NamedQueries({
    @NamedQuery(name = "Tierspayant.findAll", query = "SELECT t FROM Tierspayant t"),
    @NamedQuery(name = "Tierspayant.findByLgTpaid", query = "SELECT t FROM Tierspayant t WHERE t.lgTpaid = :lgTpaid"),
    @NamedQuery(name = "Tierspayant.findByStrTpaname", query = "SELECT t FROM Tierspayant t WHERE t.strTpaname = :strTpaname"),
    @NamedQuery(name = "Tierspayant.findByStrTpastatut", query = "SELECT t FROM Tierspayant t WHERE t.strTpastatut = :strTpastatut"),
    @NamedQuery(name = "Tierspayant.findByDtTpacreated", query = "SELECT t FROM Tierspayant t WHERE t.dtTpacreated = :dtTpacreated"),
    @NamedQuery(name = "Tierspayant.findByDtTpaupdated", query = "SELECT t FROM Tierspayant t WHERE t.dtTpaupdated = :dtTpaupdated")})
public class Tierspayant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_tpaid", nullable = false, length = 40)
    private String lgTpaid;
    @Column(name = "str_tpaname", length = 100)
    private String strTpaname;
    @Column(name = "str_tpastatut", length = 50)
    private String strTpastatut;
    @Column(name = "dt_tpacreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtTpacreated;
    @Column(name = "dt_tpaupdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtTpaupdated;
    @OneToMany(mappedBy = "lgTpaid")
    private Collection<Pattierspayant> pattierspayantCollection;
    @JoinColumn(name = "lg_uticreated", referencedColumnName = "lg_utiid", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur lgUticreated;
    @JoinColumn(name = "lg_utiupdated", referencedColumnName = "lg_utiid", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur lgUtiupdated;

    public Tierspayant() {
    }

    public Tierspayant(String lgTpaid) {
        this.lgTpaid = lgTpaid;
    }

    public String getLgTpaid() {
        return lgTpaid;
    }

    public void setLgTpaid(String lgTpaid) {
        this.lgTpaid = lgTpaid;
    }

    public String getStrTpaname() {
        return strTpaname;
    }

    public void setStrTpaname(String strTpaname) {
        this.strTpaname = strTpaname;
    }

    public String getStrTpastatut() {
        return strTpastatut;
    }

    public void setStrTpastatut(String strTpastatut) {
        this.strTpastatut = strTpastatut;
    }

    public Date getDtTpacreated() {
        return dtTpacreated;
    }

    public void setDtTpacreated(Date dtTpacreated) {
        this.dtTpacreated = dtTpacreated;
    }

    public Date getDtTpaupdated() {
        return dtTpaupdated;
    }

    public void setDtTpaupdated(Date dtTpaupdated) {
        this.dtTpaupdated = dtTpaupdated;
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
        hash += (lgTpaid != null ? lgTpaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tierspayant)) {
            return false;
        }
        Tierspayant other = (Tierspayant) object;
        if ((this.lgTpaid == null && other.lgTpaid != null) || (this.lgTpaid != null && !this.lgTpaid.equals(other.lgTpaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.nkmtechnology.gesclinico.dbmanager.Tierspayant[ lgTpaid=" + lgTpaid + " ]";
    }
    
}
