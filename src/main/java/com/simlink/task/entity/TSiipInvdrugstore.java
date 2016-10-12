package com.simlink.task.entity;

// Generated 2016-10-3 9:10:20 by Hibernate Tools 3.2.2.GA

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlAccessType;  
import javax.xml.bind.annotation.XmlAccessorType;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlElementWrapper;  
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlType; 
import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings({ "restriction", "unused", "serial" })
@XmlRootElement(name = "row")
public class TSiipInvdrugstore implements java.io.Serializable {

	@XmlElement(name = "C_INVSTORECD")
	private String CInvstorecd;
	
	@XmlElement(name = "CREATORCD")
	private String creatorcd;
	
	@XmlElement(name = "CREATORNAME")
	private String creatorname;
	
	@XmlElement(name = "CREATETIME")
	private Date createtime;
	
	@XmlElement(name = "C_DRUGSTORECD")
	private String CDrugstorecd;
	
	@XmlElement(name = "C_DRUGSTORENAME")
	private String CDrugstorename;
	
	@XmlElement(name = "N_DEELSTATUS")
	private Integer NDeelstatus;
	
	@XmlElement(name = "N_SENDSTATUS")
	private Integer NSendstatus;
	
	@XmlElement(name = "D_INVSTORETIME")
	private Date DInvstoretime;
	
	@XmlElement(name = "N_BEFOREINVAMOUT")
	private Double NBeforeinvamout;
	
	@XmlElement(name = "N_AFTERINVAMOUNT")
	private Double NAfterinvamount;
	
	@XmlElement(name = "D_UPTDATETIME")
	private Date DUptdatetime;
	
	@XmlElement(name = "C_AUDITORNAME")
	private String CAuditorname;
	
	@XmlElement(name = "C_INVPERSONNAME")
	private String CInvpersonname;
	
	@XmlElement(name = "N_DRUGSCOUNT")
	private Integer NDrugscount;
	
	@XmlElement(name = "area")
	private String area;
	
	@XmlElement(name = "institution")
	private String institution;

	public TSiipInvdrugstore() {
		super();
	}

	public TSiipInvdrugstore(String CInvstorecd,
			String creatorcd, String creatorname, Date createtime,
			String CDrugstorecd, Integer NDeelstatus,
			Double NBeforeinvamout, String area, String institution) {
		this.CInvstorecd = CInvstorecd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CDrugstorecd = CDrugstorecd;
		this.NDeelstatus = NDeelstatus;
		this.NBeforeinvamout = NBeforeinvamout;
		this.area = area;
		this.institution = institution;
	}

	public TSiipInvdrugstore(String CInvstorecd,
			String creatorcd, String creatorname, Date createtime,
			String CDrugstorecd, String CDrugstorename,
			Integer NDeelstatus, Integer NSendstatus, Date DInvstoretime,
			Double NBeforeinvamout, Double NAfterinvamount,
			Date DUptdatetime, String CAuditorname,
			String CInvpersonname, Integer NDrugscount, String area,
			String institution) {
		this.CInvstorecd = CInvstorecd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CDrugstorecd = CDrugstorecd;
		this.CDrugstorename = CDrugstorename;
		this.NDeelstatus = NDeelstatus;
		this.NSendstatus = NSendstatus;
		this.DInvstoretime = DInvstoretime;
		this.NBeforeinvamout = NBeforeinvamout;
		this.NAfterinvamount = NAfterinvamount;
		this.DUptdatetime = DUptdatetime;
		this.CAuditorname = CAuditorname;
		this.CInvpersonname = CInvpersonname;
		this.NDrugscount = NDrugscount;
		this.area = area;
		this.institution = institution;
	}
	@XmlTransient
	public String getCInvstorecd() {
		return this.CInvstorecd;
	}

	public void setCInvstorecd(String CInvstorecd) {
		this.CInvstorecd = CInvstorecd;
	}
	@XmlTransient
	public String getCreatorcd() {
		return this.creatorcd;
	}

	public void setCreatorcd(String creatorcd) {
		this.creatorcd = creatorcd;
	}
	@XmlTransient
	public String getCreatorname() {
		return this.creatorname;
	}

	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}
	@XmlTransient
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@XmlTransient
	public String getCDrugstorecd() {
		return this.CDrugstorecd;
	}

	public void setCDrugstorecd(String CDrugstorecd) {
		this.CDrugstorecd = CDrugstorecd;
	}
	@XmlTransient
	public String getCDrugstorename() {
		return this.CDrugstorename;
	}

	public void setCDrugstorename(String CDrugstorename) {
		this.CDrugstorename = CDrugstorename;
	}
	@XmlTransient
	public Integer getNDeelstatus() {
		return this.NDeelstatus;
	}

	public void setNDeelstatus(Integer NDeelstatus) {
		this.NDeelstatus = NDeelstatus;
	}
	@XmlTransient
	public Integer getNSendstatus() {
		return this.NSendstatus;
	}

	public void setNSendstatus(Integer NSendstatus) {
		this.NSendstatus = NSendstatus;
	}
	@XmlTransient
	public Date getDInvstoretime() {
		return this.DInvstoretime;
	}

	public void setDInvstoretime(Date DInvstoretime) {
		this.DInvstoretime = DInvstoretime;
	}
	@XmlTransient
	public Double getNBeforeinvamout() {
		return this.NBeforeinvamout;
	}

	public void setNBeforeinvamout(Double NBeforeinvamout) {
		this.NBeforeinvamout = NBeforeinvamout;
	}
	@XmlTransient
	public Double getNAfterinvamount() {
		return this.NAfterinvamount;
	}

	public void setNAfterinvamount(Double NAfterinvamount) {
		this.NAfterinvamount = NAfterinvamount;
	}
	@XmlTransient
	public Date getDUptdatetime() {
		return this.DUptdatetime;
	}

	public void setDUptdatetime(Date DUptdatetime) {
		this.DUptdatetime = DUptdatetime;
	}
	@XmlTransient
	public String getCAuditorname() {
		return this.CAuditorname;
	}

	public void setCAuditorname(String CAuditorname) {
		this.CAuditorname = CAuditorname;
	}
	@XmlTransient
	public String getCInvpersonname() {
		return this.CInvpersonname;
	}

	public void setCInvpersonname(String CInvpersonname) {
		this.CInvpersonname = CInvpersonname;
	}
	@XmlTransient
	public Integer getNDrugscount() {
		return this.NDrugscount;
	}

	public void setNDrugscount(Integer NDrugscount) {
		this.NDrugscount = NDrugscount;
	}
	@XmlTransient
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	@XmlTransient
	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TSiipInvdrugstore))
			return false;
		TSiipInvdrugstore castOther = (TSiipInvdrugstore) other;

		return ((this.getCInvstorecd() == castOther.getCInvstorecd()) || (this
				.getCInvstorecd() != null && castOther.getCInvstorecd() != null && this
				.getCInvstorecd().equals(castOther.getCInvstorecd())))
				&& ((this.getCreatorcd() == castOther.getCreatorcd()) || (this
						.getCreatorcd() != null
						&& castOther.getCreatorcd() != null && this
						.getCreatorcd().equals(castOther.getCreatorcd())))
				&& ((this.getCreatorname() == castOther.getCreatorname()) || (this
						.getCreatorname() != null
						&& castOther.getCreatorname() != null && this
						.getCreatorname().equals(castOther.getCreatorname())))
				&& ((this.getCreatetime() == castOther.getCreatetime()) || (this
						.getCreatetime() != null
						&& castOther.getCreatetime() != null && this
						.getCreatetime().equals(castOther.getCreatetime())))
				&& ((this.getCDrugstorecd() == castOther.getCDrugstorecd()) || (this
						.getCDrugstorecd() != null
						&& castOther.getCDrugstorecd() != null && this
						.getCDrugstorecd().equals(castOther.getCDrugstorecd())))
				&& ((this.getCDrugstorename() == castOther.getCDrugstorename()) || (this
						.getCDrugstorename() != null
						&& castOther.getCDrugstorename() != null && this
						.getCDrugstorename().equals(
								castOther.getCDrugstorename())))
				&& (this.getNDeelstatus() == castOther.getNDeelstatus())
				&& ((this.getNSendstatus() == castOther.getNSendstatus()) || (this
						.getNSendstatus() != null
						&& castOther.getNSendstatus() != null && this
						.getNSendstatus().equals(castOther.getNSendstatus())))
				&& ((this.getDInvstoretime() == castOther.getDInvstoretime()) || (this
						.getDInvstoretime() != null
						&& castOther.getDInvstoretime() != null && this
						.getDInvstoretime()
						.equals(castOther.getDInvstoretime())))
				&& ((this.getNBeforeinvamout() == castOther
						.getNBeforeinvamout()) || (this.getNBeforeinvamout() != null
						&& castOther.getNBeforeinvamout() != null && this
						.getNBeforeinvamout().equals(
								castOther.getNBeforeinvamout())))
				&& ((this.getNAfterinvamount() == castOther
						.getNAfterinvamount()) || (this.getNAfterinvamount() != null
						&& castOther.getNAfterinvamount() != null && this
						.getNAfterinvamount().equals(
								castOther.getNAfterinvamount())))
				&& ((this.getDUptdatetime() == castOther.getDUptdatetime()) || (this
						.getDUptdatetime() != null
						&& castOther.getDUptdatetime() != null && this
						.getDUptdatetime().equals(castOther.getDUptdatetime())))
				&& ((this.getCAuditorname() == castOther.getCAuditorname()) || (this
						.getCAuditorname() != null
						&& castOther.getCAuditorname() != null && this
						.getCAuditorname().equals(castOther.getCAuditorname())))
				&& ((this.getCInvpersonname() == castOther.getCInvpersonname()) || (this
						.getCInvpersonname() != null
						&& castOther.getCInvpersonname() != null && this
						.getCInvpersonname().equals(
								castOther.getCInvpersonname())))
				&& ((this.getNDrugscount() == castOther.getNDrugscount()) || (this
						.getNDrugscount() != null
						&& castOther.getNDrugscount() != null && this
						.getNDrugscount().equals(castOther.getNDrugscount())))
				&& ((this.getArea() == castOther.getArea()) || (this.getArea() != null
						&& castOther.getArea() != null && this.getArea()
						.equals(castOther.getArea())))
				&& ((this.getInstitution() == castOther.getInstitution()) || (this
						.getInstitution() != null
						&& castOther.getInstitution() != null && this
						.getInstitution().equals(castOther.getInstitution())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCInvstorecd() == null ? 0 : this.getCInvstorecd()
						.hashCode());
		result = 37 * result
				+ (getCreatorcd() == null ? 0 : this.getCreatorcd().hashCode());
		result = 37
				* result
				+ (getCreatorname() == null ? 0 : this.getCreatorname()
						.hashCode());
		result = 37
				* result
				+ (getCreatetime() == null ? 0 : this.getCreatetime()
						.hashCode());
		result = 37
				* result
				+ (getCDrugstorecd() == null ? 0 : this.getCDrugstorecd()
						.hashCode());
		result = 37
				* result
				+ (getCDrugstorename() == null ? 0 : this.getCDrugstorename()
						.hashCode());
		result = 37 * result + this.getNDeelstatus();
		result = 37
				* result
				+ (getNSendstatus() == null ? 0 : this.getNSendstatus()
						.hashCode());
		result = 37
				* result
				+ (getDInvstoretime() == null ? 0 : this.getDInvstoretime()
						.hashCode());
		result = 37
				* result
				+ (getNBeforeinvamout() == null ? 0 : this.getNBeforeinvamout()
						.hashCode());
		result = 37
				* result
				+ (getNAfterinvamount() == null ? 0 : this.getNAfterinvamount()
						.hashCode());
		result = 37
				* result
				+ (getDUptdatetime() == null ? 0 : this.getDUptdatetime()
						.hashCode());
		result = 37
				* result
				+ (getCAuditorname() == null ? 0 : this.getCAuditorname()
						.hashCode());
		result = 37
				* result
				+ (getCInvpersonname() == null ? 0 : this.getCInvpersonname()
						.hashCode());
		result = 37
				* result
				+ (getNDrugscount() == null ? 0 : this.getNDrugscount()
						.hashCode());
		result = 37 * result
				+ (getArea() == null ? 0 : this.getArea().hashCode());
		result = 37
				* result
				+ (getInstitution() == null ? 0 : this.getInstitution()
						.hashCode());
		return result;
	}

}
