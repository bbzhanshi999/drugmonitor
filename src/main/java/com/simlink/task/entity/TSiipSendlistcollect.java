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
public class TSiipSendlistcollect implements java.io.Serializable {

	@XmlElement(name = "N_COLLECTID")
	private String NCollectid;
	
	@XmlElement(name = "CREATORCD")
	private String creatorcd;
	
	@XmlElement(name = "CREATORNAME")
	private String creatorname;
	
	@XmlElement(name = "CREATETIME")
	private Date createtime;
	
	@XmlElement(name = "C_DRUGCD")
	private String CDrugcd;
	
	@XmlElement(name = "C_COMMONNAME")
	private String CCommonname;
	
	@XmlElement(name = "C_TRADENAME")
	private String CTradename;
	
	@XmlElement(name = "C_DRUGSPEC")
	private String CDrugspec;
	
	@XmlElement(name = "C_FIGURENAME")
	private String CFigurename;
	
	@XmlElement(name = "C_FACTORYNAME")
	private String CFactoryname;
	
	@XmlElement(name = "C_DRUGSTORENAME")
	private String CDrugstorename;
	
	@XmlElement(name = "C_DRUGSTORECD")
	private String CDrugstorecd;
	
	@XmlElement(name = "N_DEELSTATUS")
	private Integer NDeelstatus;
	
	@XmlElement(name = "C_DRUGPACKUNITCD")
	private String CDrugpackunitcd;
	
	@XmlElement(name = "C_DRUGPACKUNITNAME")
	private String CDrugpackunitname;
	
	@XmlElement(name = "C_DRUGPACKUNITPRICE")
	private Double CDrugpackunitprice;
	
	@XmlElement(name = "C_USEUNITCD")
	private String CUseunitcd;
	
	@XmlElement(name = "C_USEUNITNAME")
	private String CUseunitname;
	
	@XmlElement(name = "N_USEUNITPRICE")
	private Double NUseunitprice;
	
	@XmlElement(name = "C_SENDUNITCD")
	private String CSendunitcd;
	
	@XmlElement(name = "C_SENDUNITNAME")
	private String CSendunitname;
	
	@XmlElement(name = "N_SENDUNITPRICE")
	private Double NSendunitprice;
	
	@XmlElement(name = "N_DRUGNUMBER")
	private Double NDrugnumber;
	
	@XmlElement(name = "N_DRUGAMOUNT")
	private Double NDrugamount;
	
	@XmlElement(name = "C_PACKTOTAL")
	private String CPacktotal;
	
	@XmlElement(name = "C_REALSTOCK")
	private String CRealstock;
	
	@XmlElement(name = "C_USETOTAL")
	private String CUsetotal;
	
	@XmlElement(name = "area")
	private String area;
	
	@XmlElement(name = "institution")
	private String institution;

	public TSiipSendlistcollect() {
		super();
	}

	public TSiipSendlistcollect(String NCollectid,
			String creatorcd, String creatorname, Date createtime,
			String CDrugcd, String CCommonname,
			String CTradename, String CDrugspec,
			String CFigurename, String CFactoryname,
			String CDrugstorename, String CDrugstorecd,
			Integer NDeelstatus, String CDrugpackunitcd,
			String CDrugpackunitname, Double CDrugpackunitprice,
			String CUseunitcd, String CUseunitname,
			Double NUseunitprice, String CSendunitcd,
			String CSendunitname, Double NSendunitprice,
			Double NDrugnumber, Double NDrugamount, String area,
			String institution) {
		this.NCollectid = NCollectid;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CDrugcd = CDrugcd;
		this.CCommonname = CCommonname;
		this.CTradename = CTradename;
		this.CDrugspec = CDrugspec;
		this.CFigurename = CFigurename;
		this.CFactoryname = CFactoryname;
		this.CDrugstorename = CDrugstorename;
		this.CDrugstorecd = CDrugstorecd;
		this.NDeelstatus = NDeelstatus;
		this.CDrugpackunitcd = CDrugpackunitcd;
		this.CDrugpackunitname = CDrugpackunitname;
		this.CDrugpackunitprice = CDrugpackunitprice;
		this.CUseunitcd = CUseunitcd;
		this.CUseunitname = CUseunitname;
		this.NUseunitprice = NUseunitprice;
		this.CSendunitcd = CSendunitcd;
		this.CSendunitname = CSendunitname;
		this.NSendunitprice = NSendunitprice;
		this.NDrugnumber = NDrugnumber;
		this.NDrugamount = NDrugamount;
		this.area = area;
		this.institution = institution;
	}

	public TSiipSendlistcollect(String NCollectid,
			String creatorcd, String creatorname, Date createtime,
			String CDrugcd, String CCommonname,
			String CTradename, String CDrugspec,
			String CFigurename, String CFactoryname,
			String CDrugstorename, String CDrugstorecd,
			Integer NDeelstatus, String CDrugpackunitcd,
			String CDrugpackunitname, Double CDrugpackunitprice,
			String CUseunitcd, String CUseunitname,
			Double NUseunitprice, String CSendunitcd,
			String CSendunitname, Double NSendunitprice,
			Double NDrugnumber, Double NDrugamount,
			String CPacktotal, String CRealstock,
			String CUsetotal, String area, String institution) {
		this.NCollectid = NCollectid;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CDrugcd = CDrugcd;
		this.CCommonname = CCommonname;
		this.CTradename = CTradename;
		this.CDrugspec = CDrugspec;
		this.CFigurename = CFigurename;
		this.CFactoryname = CFactoryname;
		this.CDrugstorename = CDrugstorename;
		this.CDrugstorecd = CDrugstorecd;
		this.NDeelstatus = NDeelstatus;
		this.CDrugpackunitcd = CDrugpackunitcd;
		this.CDrugpackunitname = CDrugpackunitname;
		this.CDrugpackunitprice = CDrugpackunitprice;
		this.CUseunitcd = CUseunitcd;
		this.CUseunitname = CUseunitname;
		this.NUseunitprice = NUseunitprice;
		this.CSendunitcd = CSendunitcd;
		this.CSendunitname = CSendunitname;
		this.NSendunitprice = NSendunitprice;
		this.NDrugnumber = NDrugnumber;
		this.NDrugamount = NDrugamount;
		this.CPacktotal = CPacktotal;
		this.CRealstock = CRealstock;
		this.CUsetotal = CUsetotal;
		this.area = area;
		this.institution = institution;
	}
	@XmlTransient
	public String getNCollectid() {
		return this.NCollectid;
	}

	public void setNCollectid(String NCollectid) {
		this.NCollectid = NCollectid;
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
	public String getCDrugcd() {
		return this.CDrugcd;
	}

	public void setCDrugcd(String CDrugcd) {
		this.CDrugcd = CDrugcd;
	}
	@XmlTransient
	public String getCCommonname() {
		return this.CCommonname;
	}

	public void setCCommonname(String CCommonname) {
		this.CCommonname = CCommonname;
	}
	@XmlTransient
	public String getCTradename() {
		return this.CTradename;
	}

	public void setCTradename(String CTradename) {
		this.CTradename = CTradename;
	}
	@XmlTransient
	public String getCDrugspec() {
		return this.CDrugspec;
	}

	public void setCDrugspec(String CDrugspec) {
		this.CDrugspec = CDrugspec;
	}
	@XmlTransient
	public String getCFigurename() {
		return this.CFigurename;
	}

	public void setCFigurename(String CFigurename) {
		this.CFigurename = CFigurename;
	}
	@XmlTransient
	public String getCFactoryname() {
		return this.CFactoryname;
	}

	public void setCFactoryname(String CFactoryname) {
		this.CFactoryname = CFactoryname;
	}
	@XmlTransient
	public String getCDrugstorename() {
		return this.CDrugstorename;
	}

	public void setCDrugstorename(String CDrugstorename) {
		this.CDrugstorename = CDrugstorename;
	}
	@XmlTransient
	public String getCDrugstorecd() {
		return this.CDrugstorecd;
	}

	public void setCDrugstorecd(String CDrugstorecd) {
		this.CDrugstorecd = CDrugstorecd;
	}
	@XmlTransient
	public Integer getNDeelstatus() {
		return this.NDeelstatus;
	}

	public void setNDeelstatus(Integer NDeelstatus) {
		this.NDeelstatus = NDeelstatus;
	}
	@XmlTransient
	public String getCDrugpackunitcd() {
		return this.CDrugpackunitcd;
	}

	public void setCDrugpackunitcd(String CDrugpackunitcd) {
		this.CDrugpackunitcd = CDrugpackunitcd;
	}
	@XmlTransient
	public String getCDrugpackunitname() {
		return this.CDrugpackunitname;
	}

	public void setCDrugpackunitname(String CDrugpackunitname) {
		this.CDrugpackunitname = CDrugpackunitname;
	}
	@XmlTransient
	public Double getCDrugpackunitprice() {
		return this.CDrugpackunitprice;
	}

	public void setCDrugpackunitprice(Double CDrugpackunitprice) {
		this.CDrugpackunitprice = CDrugpackunitprice;
	}
	@XmlTransient
	public String getCUseunitcd() {
		return this.CUseunitcd;
	}

	public void setCUseunitcd(String CUseunitcd) {
		this.CUseunitcd = CUseunitcd;
	}
	@XmlTransient
	public String getCUseunitname() {
		return this.CUseunitname;
	}

	public void setCUseunitname(String CUseunitname) {
		this.CUseunitname = CUseunitname;
	}
	@XmlTransient
	public Double getNUseunitprice() {
		return this.NUseunitprice;
	}

	public void setNUseunitprice(Double NUseunitprice) {
		this.NUseunitprice = NUseunitprice;
	}
	@XmlTransient
	public String getCSendunitcd() {
		return this.CSendunitcd;
	}

	public void setCSendunitcd(String CSendunitcd) {
		this.CSendunitcd = CSendunitcd;
	}
	@XmlTransient
	public String getCSendunitname() {
		return this.CSendunitname;
	}

	public void setCSendunitname(String CSendunitname) {
		this.CSendunitname = CSendunitname;
	}
	@XmlTransient
	public Double getNSendunitprice() {
		return this.NSendunitprice;
	}

	public void setNSendunitprice(Double NSendunitprice) {
		this.NSendunitprice = NSendunitprice;
	}
	@XmlTransient
	public Double getNDrugnumber() {
		return this.NDrugnumber;
	}

	public void setNDrugnumber(Double NDrugnumber) {
		this.NDrugnumber = NDrugnumber;
	}
	@XmlTransient
	public Double getNDrugamount() {
		return this.NDrugamount;
	}

	public void setNDrugamount(Double NDrugamount) {
		this.NDrugamount = NDrugamount;
	}
	@XmlTransient
	public String getCPacktotal() {
		return this.CPacktotal;
	}

	public void setCPacktotal(String CPacktotal) {
		this.CPacktotal = CPacktotal;
	}
	@XmlTransient
	public String getCRealstock() {
		return this.CRealstock;
	}

	public void setCRealstock(String CRealstock) {
		this.CRealstock = CRealstock;
	}
	@XmlTransient
	public String getCUsetotal() {
		return this.CUsetotal;
	}

	public void setCUsetotal(String CUsetotal) {
		this.CUsetotal = CUsetotal;
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
		if (!(other instanceof TSiipSendlistcollect))
			return false;
		TSiipSendlistcollect castOther = (TSiipSendlistcollect) other;

		return ((this.getNCollectid() == castOther.getNCollectid()) || (this
				.getNCollectid() != null && castOther.getNCollectid() != null && this
				.getNCollectid().equals(castOther.getNCollectid())))
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
				&& ((this.getCDrugcd() == castOther.getCDrugcd()) || (this
						.getCDrugcd() != null && castOther.getCDrugcd() != null && this
						.getCDrugcd().equals(castOther.getCDrugcd())))
				&& ((this.getCCommonname() == castOther.getCCommonname()) || (this
						.getCCommonname() != null
						&& castOther.getCCommonname() != null && this
						.getCCommonname().equals(castOther.getCCommonname())))
				&& ((this.getCTradename() == castOther.getCTradename()) || (this
						.getCTradename() != null
						&& castOther.getCTradename() != null && this
						.getCTradename().equals(castOther.getCTradename())))
				&& ((this.getCDrugspec() == castOther.getCDrugspec()) || (this
						.getCDrugspec() != null
						&& castOther.getCDrugspec() != null && this
						.getCDrugspec().equals(castOther.getCDrugspec())))
				&& ((this.getCFigurename() == castOther.getCFigurename()) || (this
						.getCFigurename() != null
						&& castOther.getCFigurename() != null && this
						.getCFigurename().equals(castOther.getCFigurename())))
				&& ((this.getCFactoryname() == castOther.getCFactoryname()) || (this
						.getCFactoryname() != null
						&& castOther.getCFactoryname() != null && this
						.getCFactoryname().equals(castOther.getCFactoryname())))
				&& ((this.getCDrugstorename() == castOther.getCDrugstorename()) || (this
						.getCDrugstorename() != null
						&& castOther.getCDrugstorename() != null && this
						.getCDrugstorename().equals(
								castOther.getCDrugstorename())))
				&& ((this.getCDrugstorecd() == castOther.getCDrugstorecd()) || (this
						.getCDrugstorecd() != null
						&& castOther.getCDrugstorecd() != null && this
						.getCDrugstorecd().equals(castOther.getCDrugstorecd())))
				&& (this.getNDeelstatus() == castOther.getNDeelstatus())
				&& ((this.getCDrugpackunitcd() == castOther
						.getCDrugpackunitcd()) || (this.getCDrugpackunitcd() != null
						&& castOther.getCDrugpackunitcd() != null && this
						.getCDrugpackunitcd().equals(
								castOther.getCDrugpackunitcd())))
				&& ((this.getCDrugpackunitname() == castOther
						.getCDrugpackunitname()) || (this
						.getCDrugpackunitname() != null
						&& castOther.getCDrugpackunitname() != null && this
						.getCDrugpackunitname().equals(
								castOther.getCDrugpackunitname())))
				&& ((this.getCDrugpackunitprice() == castOther
						.getCDrugpackunitprice()) || (this
						.getCDrugpackunitprice() != null
						&& castOther.getCDrugpackunitprice() != null && this
						.getCDrugpackunitprice().equals(
								castOther.getCDrugpackunitprice())))
				&& ((this.getCUseunitcd() == castOther.getCUseunitcd()) || (this
						.getCUseunitcd() != null
						&& castOther.getCUseunitcd() != null && this
						.getCUseunitcd().equals(castOther.getCUseunitcd())))
				&& ((this.getCUseunitname() == castOther.getCUseunitname()) || (this
						.getCUseunitname() != null
						&& castOther.getCUseunitname() != null && this
						.getCUseunitname().equals(castOther.getCUseunitname())))
				&& ((this.getNUseunitprice() == castOther.getNUseunitprice()) || (this
						.getNUseunitprice() != null
						&& castOther.getNUseunitprice() != null && this
						.getNUseunitprice()
						.equals(castOther.getNUseunitprice())))
				&& ((this.getCSendunitcd() == castOther.getCSendunitcd()) || (this
						.getCSendunitcd() != null
						&& castOther.getCSendunitcd() != null && this
						.getCSendunitcd().equals(castOther.getCSendunitcd())))
				&& ((this.getCSendunitname() == castOther.getCSendunitname()) || (this
						.getCSendunitname() != null
						&& castOther.getCSendunitname() != null && this
						.getCSendunitname()
						.equals(castOther.getCSendunitname())))
				&& ((this.getNSendunitprice() == castOther.getNSendunitprice()) || (this
						.getNSendunitprice() != null
						&& castOther.getNSendunitprice() != null && this
						.getNSendunitprice().equals(
								castOther.getNSendunitprice())))
				&& ((this.getNDrugnumber() == castOther.getNDrugnumber()) || (this
						.getNDrugnumber() != null
						&& castOther.getNDrugnumber() != null && this
						.getNDrugnumber().equals(castOther.getNDrugnumber())))
				&& ((this.getNDrugamount() == castOther.getNDrugamount()) || (this
						.getNDrugamount() != null
						&& castOther.getNDrugamount() != null && this
						.getNDrugamount().equals(castOther.getNDrugamount())))
				&& ((this.getCPacktotal() == castOther.getCPacktotal()) || (this
						.getCPacktotal() != null
						&& castOther.getCPacktotal() != null && this
						.getCPacktotal().equals(castOther.getCPacktotal())))
				&& ((this.getCRealstock() == castOther.getCRealstock()) || (this
						.getCRealstock() != null
						&& castOther.getCRealstock() != null && this
						.getCRealstock().equals(castOther.getCRealstock())))
				&& ((this.getCUsetotal() == castOther.getCUsetotal()) || (this
						.getCUsetotal() != null
						&& castOther.getCUsetotal() != null && this
						.getCUsetotal().equals(castOther.getCUsetotal())))
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
				+ (getNCollectid() == null ? 0 : this.getNCollectid()
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
		result = 37 * result
				+ (getCDrugcd() == null ? 0 : this.getCDrugcd().hashCode());
		result = 37
				* result
				+ (getCCommonname() == null ? 0 : this.getCCommonname()
						.hashCode());
		result = 37
				* result
				+ (getCTradename() == null ? 0 : this.getCTradename()
						.hashCode());
		result = 37 * result
				+ (getCDrugspec() == null ? 0 : this.getCDrugspec().hashCode());
		result = 37
				* result
				+ (getCFigurename() == null ? 0 : this.getCFigurename()
						.hashCode());
		result = 37
				* result
				+ (getCFactoryname() == null ? 0 : this.getCFactoryname()
						.hashCode());
		result = 37
				* result
				+ (getCDrugstorename() == null ? 0 : this.getCDrugstorename()
						.hashCode());
		result = 37
				* result
				+ (getCDrugstorecd() == null ? 0 : this.getCDrugstorecd()
						.hashCode());
		result = 37 * result + this.getNDeelstatus();
		result = 37
				* result
				+ (getCDrugpackunitcd() == null ? 0 : this.getCDrugpackunitcd()
						.hashCode());
		result = 37
				* result
				+ (getCDrugpackunitname() == null ? 0 : this
						.getCDrugpackunitname().hashCode());
		result = 37
				* result
				+ (getCDrugpackunitprice() == null ? 0 : this
						.getCDrugpackunitprice().hashCode());
		result = 37
				* result
				+ (getCUseunitcd() == null ? 0 : this.getCUseunitcd()
						.hashCode());
		result = 37
				* result
				+ (getCUseunitname() == null ? 0 : this.getCUseunitname()
						.hashCode());
		result = 37
				* result
				+ (getNUseunitprice() == null ? 0 : this.getNUseunitprice()
						.hashCode());
		result = 37
				* result
				+ (getCSendunitcd() == null ? 0 : this.getCSendunitcd()
						.hashCode());
		result = 37
				* result
				+ (getCSendunitname() == null ? 0 : this.getCSendunitname()
						.hashCode());
		result = 37
				* result
				+ (getNSendunitprice() == null ? 0 : this.getNSendunitprice()
						.hashCode());
		result = 37
				* result
				+ (getNDrugnumber() == null ? 0 : this.getNDrugnumber()
						.hashCode());
		result = 37
				* result
				+ (getNDrugamount() == null ? 0 : this.getNDrugamount()
						.hashCode());
		result = 37
				* result
				+ (getCPacktotal() == null ? 0 : this.getCPacktotal()
						.hashCode());
		result = 37
				* result
				+ (getCRealstock() == null ? 0 : this.getCRealstock()
						.hashCode());
		result = 37 * result
				+ (getCUsetotal() == null ? 0 : this.getCUsetotal().hashCode());
		result = 37 * result
				+ (getArea() == null ? 0 : this.getArea().hashCode());
		result = 37
				* result
				+ (getInstitution() == null ? 0 : this.getInstitution()
						.hashCode());
		return result;
	}

}
