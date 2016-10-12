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
public class TSiipSendlist implements java.io.Serializable {

	@XmlElement(name = "C_SENDLISTCD")
	private String CSendlistcd;
	
	@XmlElement(name = "CREATORCD")
	private String creatorcd;
	
	@XmlElement(name = "CREATORNAME")
	private String creatorname;
	
	@XmlElement(name = "CREATETIME")
	private Date createtime;
	
	@XmlElement(name = "C_SENDLISTCDHIS")
	private String CSendlistcdhis;
	
	@XmlElement(name = "C_WARDCD")
	private String CWardcd;
	
	@XmlElement(name = "C_WARDNAME")
	private String CWardname;
	
	@XmlElement(name = "N_DEELSTATUS")
	private Integer NDeelstatus;
	
	@XmlElement(name = "N_SENDSTATUS")
	private Integer NSendstatus;
	
	@XmlElement(name = "C_STORECD")
	private String CStorecd;
	
	@XmlElement(name = "C_STORENAME")
	private String CStorename;
	
	@XmlElement(name = "N_SENDTYPE")
	private boolean NSendtype;
	
	@XmlElement(name = "C_ENTEROPERCD")
	private String CEnteropercd;
	
	@XmlElement(name = "C_ENTEROPERNAME")
	private String CEnteropername;
	
	@XmlElement(name = "C_UPTOPERCD")
	private String CUptopercd;
	
	@XmlElement(name = "C_UPTOPERNAME")
	private String CUptopername;
	
	@XmlElement(name = "N_AMOUNT")
	private Double NAmount;
	
	@XmlElement(name = "D_ENTERTIME")
	private Date DEntertime;
	
	@XmlElement(name = "D_UPTDATETIME")
	private Date DUptdatetime;
	
	@XmlElement(name = "C_SENDTYPENAME")
	private String CSendtypename;
	
	@XmlElement(name = "area")
	private String area;
	
	@XmlElement(name = "institution")
	private String institution;

	public TSiipSendlist() {
		super();
	}

	public TSiipSendlist(String CSendlistcd, String creatorcd,
			String creatorname, Date createtime,
			String CSendlistcdhis, String CWardcd,
			String CWardname, Integer NDeelstatus, Integer NSendstatus,
			String CStorecd, String CStorename, boolean NSendtype,
			String CEnteropercd, String CEnteropername,
			Double NAmount, Date DEntertime, String CSendtypename,
			String area, String institution) {
		this.CSendlistcd = CSendlistcd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CSendlistcdhis = CSendlistcdhis;
		this.CWardcd = CWardcd;
		this.CWardname = CWardname;
		this.NDeelstatus = NDeelstatus;
		this.NSendstatus = NSendstatus;
		this.CStorecd = CStorecd;
		this.CStorename = CStorename;
		this.NSendtype = NSendtype;
		this.CEnteropercd = CEnteropercd;
		this.CEnteropername = CEnteropername;
		this.NAmount = NAmount;
		this.DEntertime = DEntertime;
		this.CSendtypename = CSendtypename;
		this.area = area;
		this.institution = institution;
	}

	public TSiipSendlist(String CSendlistcd, String creatorcd,
			String creatorname, Date createtime,
			String CSendlistcdhis, String CWardcd,
			String CWardname, Integer NDeelstatus, Integer NSendstatus,
			String CStorecd, String CStorename, boolean NSendtype,
			String CEnteropercd, String CEnteropername,
			String CUptopercd, String CUptopername,
			Double NAmount, Date DEntertime, Date DUptdatetime,
			String CSendtypename, String area, String institution) {
		this.CSendlistcd = CSendlistcd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CSendlistcdhis = CSendlistcdhis;
		this.CWardcd = CWardcd;
		this.CWardname = CWardname;
		this.NDeelstatus = NDeelstatus;
		this.NSendstatus = NSendstatus;
		this.CStorecd = CStorecd;
		this.CStorename = CStorename;
		this.NSendtype = NSendtype;
		this.CEnteropercd = CEnteropercd;
		this.CEnteropername = CEnteropername;
		this.CUptopercd = CUptopercd;
		this.CUptopername = CUptopername;
		this.NAmount = NAmount;
		this.DEntertime = DEntertime;
		this.DUptdatetime = DUptdatetime;
		this.CSendtypename = CSendtypename;
		this.area = area;
		this.institution = institution;
	}
	@XmlTransient
	public String getCSendlistcd() {
		return this.CSendlistcd;
	}

	public void setCSendlistcd(String CSendlistcd) {
		this.CSendlistcd = CSendlistcd;
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
	public String getCSendlistcdhis() {
		return this.CSendlistcdhis;
	}

	public void setCSendlistcdhis(String CSendlistcdhis) {
		this.CSendlistcdhis = CSendlistcdhis;
	}
	@XmlTransient
	public String getCWardcd() {
		return this.CWardcd;
	}

	public void setCWardcd(String CWardcd) {
		this.CWardcd = CWardcd;
	}
	@XmlTransient
	public String getCWardname() {
		return this.CWardname;
	}

	public void setCWardname(String CWardname) {
		this.CWardname = CWardname;
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
	public String getCStorecd() {
		return this.CStorecd;
	}

	public void setCStorecd(String CStorecd) {
		this.CStorecd = CStorecd;
	}
	@XmlTransient
	public String getCStorename() {
		return this.CStorename;
	}

	public void setCStorename(String CStorename) {
		this.CStorename = CStorename;
	}
	@XmlTransient
	public boolean isNSendtype() {
		return this.NSendtype;
	}

	public void setNSendtype(boolean NSendtype) {
		this.NSendtype = NSendtype;
	}
	@XmlTransient
	public String getCEnteropercd() {
		return this.CEnteropercd;
	}

	public void setCEnteropercd(String CEnteropercd) {
		this.CEnteropercd = CEnteropercd;
	}
	@XmlTransient
	public String getCEnteropername() {
		return this.CEnteropername;
	}

	public void setCEnteropername(String CEnteropername) {
		this.CEnteropername = CEnteropername;
	}
	@XmlTransient
	public String getCUptopercd() {
		return this.CUptopercd;
	}

	public void setCUptopercd(String CUptopercd) {
		this.CUptopercd = CUptopercd;
	}
	@XmlTransient
	public String getCUptopername() {
		return this.CUptopername;
	}

	public void setCUptopername(String CUptopername) {
		this.CUptopername = CUptopername;
	}
	@XmlTransient
	public Double getNAmount() {
		return this.NAmount;
	}

	public void setNAmount(Double NAmount) {
		this.NAmount = NAmount;
	}
	@XmlTransient
	public Date getDEntertime() {
		return this.DEntertime;
	}

	public void setDEntertime(Date DEntertime) {
		this.DEntertime = DEntertime;
	}
	@XmlTransient
	public Date getDUptdatetime() {
		return this.DUptdatetime;
	}

	public void setDUptdatetime(Date DUptdatetime) {
		this.DUptdatetime = DUptdatetime;
	}
	@XmlTransient
	public String getCSendtypename() {
		return this.CSendtypename;
	}

	public void setCSendtypename(String CSendtypename) {
		this.CSendtypename = CSendtypename;
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
		if (!(other instanceof TSiipSendlist))
			return false;
		TSiipSendlist castOther = (TSiipSendlist) other;

		return ((this.getCSendlistcd() == castOther.getCSendlistcd()) || (this
				.getCSendlistcd() != null && castOther.getCSendlistcd() != null && this
				.getCSendlistcd().equals(castOther.getCSendlistcd())))
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
				&& ((this.getCSendlistcdhis() == castOther.getCSendlistcdhis()) || (this
						.getCSendlistcdhis() != null
						&& castOther.getCSendlistcdhis() != null && this
						.getCSendlistcdhis().equals(
								castOther.getCSendlistcdhis())))
				&& ((this.getCWardcd() == castOther.getCWardcd()) || (this
						.getCWardcd() != null && castOther.getCWardcd() != null && this
						.getCWardcd().equals(castOther.getCWardcd())))
				&& ((this.getCWardname() == castOther.getCWardname()) || (this
						.getCWardname() != null
						&& castOther.getCWardname() != null && this
						.getCWardname().equals(castOther.getCWardname())))
				&& (this.getNDeelstatus() == castOther.getNDeelstatus())
				&& (this.getNSendstatus() == castOther.getNSendstatus())
				&& ((this.getCStorecd() == castOther.getCStorecd()) || (this
						.getCStorecd() != null
						&& castOther.getCStorecd() != null && this
						.getCStorecd().equals(castOther.getCStorecd())))
				&& ((this.getCStorename() == castOther.getCStorename()) || (this
						.getCStorename() != null
						&& castOther.getCStorename() != null && this
						.getCStorename().equals(castOther.getCStorename())))
				&& (this.isNSendtype() == castOther.isNSendtype())
				&& ((this.getCEnteropercd() == castOther.getCEnteropercd()) || (this
						.getCEnteropercd() != null
						&& castOther.getCEnteropercd() != null && this
						.getCEnteropercd().equals(castOther.getCEnteropercd())))
				&& ((this.getCEnteropername() == castOther.getCEnteropername()) || (this
						.getCEnteropername() != null
						&& castOther.getCEnteropername() != null && this
						.getCEnteropername().equals(
								castOther.getCEnteropername())))
				&& ((this.getCUptopercd() == castOther.getCUptopercd()) || (this
						.getCUptopercd() != null
						&& castOther.getCUptopercd() != null && this
						.getCUptopercd().equals(castOther.getCUptopercd())))
				&& ((this.getCUptopername() == castOther.getCUptopername()) || (this
						.getCUptopername() != null
						&& castOther.getCUptopername() != null && this
						.getCUptopername().equals(castOther.getCUptopername())))
				&& ((this.getNAmount() == castOther.getNAmount()) || (this
						.getNAmount() != null && castOther.getNAmount() != null && this
						.getNAmount().equals(castOther.getNAmount())))
				&& ((this.getDEntertime() == castOther.getDEntertime()) || (this
						.getDEntertime() != null
						&& castOther.getDEntertime() != null && this
						.getDEntertime().equals(castOther.getDEntertime())))
				&& ((this.getDUptdatetime() == castOther.getDUptdatetime()) || (this
						.getDUptdatetime() != null
						&& castOther.getDUptdatetime() != null && this
						.getDUptdatetime().equals(castOther.getDUptdatetime())))
				&& ((this.getCSendtypename() == castOther.getCSendtypename()) || (this
						.getCSendtypename() != null
						&& castOther.getCSendtypename() != null && this
						.getCSendtypename()
						.equals(castOther.getCSendtypename())))
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
				+ (getCSendlistcd() == null ? 0 : this.getCSendlistcd()
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
				+ (getCSendlistcdhis() == null ? 0 : this.getCSendlistcdhis()
						.hashCode());
		result = 37 * result
				+ (getCWardcd() == null ? 0 : this.getCWardcd().hashCode());
		result = 37 * result
				+ (getCWardname() == null ? 0 : this.getCWardname().hashCode());
		result = 37 * result + this.getNDeelstatus();
		result = 37 * result + this.getNSendstatus();
		result = 37 * result
				+ (getCStorecd() == null ? 0 : this.getCStorecd().hashCode());
		result = 37
				* result
				+ (getCStorename() == null ? 0 : this.getCStorename()
						.hashCode());
		result = 37 * result + (this.isNSendtype() ? 1 : 0);
		result = 37
				* result
				+ (getCEnteropercd() == null ? 0 : this.getCEnteropercd()
						.hashCode());
		result = 37
				* result
				+ (getCEnteropername() == null ? 0 : this.getCEnteropername()
						.hashCode());
		result = 37
				* result
				+ (getCUptopercd() == null ? 0 : this.getCUptopercd()
						.hashCode());
		result = 37
				* result
				+ (getCUptopername() == null ? 0 : this.getCUptopername()
						.hashCode());
		result = 37 * result
				+ (getNAmount() == null ? 0 : this.getNAmount().hashCode());
		result = 37
				* result
				+ (getDEntertime() == null ? 0 : this.getDEntertime()
						.hashCode());
		result = 37
				* result
				+ (getDUptdatetime() == null ? 0 : this.getDUptdatetime()
						.hashCode());
		result = 37
				* result
				+ (getCSendtypename() == null ? 0 : this.getCSendtypename()
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
