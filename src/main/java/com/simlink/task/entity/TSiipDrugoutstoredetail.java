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
public class TSiipDrugoutstoredetail implements java.io.Serializable {

	@XmlElement(name = "ID")
	private String id;
	
	@XmlElement(name = "C_OUTBILLCD")
	private String COutbillcd;
	
	@XmlElement(name = "CREATORCD")
	private String creatorcd;
	
	@XmlElement(name = "CREATORNAME")
	private String creatorname;
	
	@XmlElement(name = "CREATETIME")
	private Date createtime;
	
	@XmlElement(name = "C_DRUGCD")
	private String CDrugcd;
	
	@XmlElement(name = "C_TRADENAME")
	private String CTradename;
	
	@XmlElement(name = "C_COMMONNAME")
	private String CCommonname;
	
	@XmlElement(name = "C_FACTORYNAME")
	private String CFactoryname;
	
	@XmlElement(name = "C_DRUGSPEC")
	private String CDrugspec;
	
	@XmlElement(name = "C_FIGURENAME")
	private String CFigurename;
	
	@XmlElement(name = "C_BATCHCD")
	private String CBatchcd;
	
	@XmlElement(name = "C_BATCHDETAIL")
	private String CBatchdetail;
	
	@XmlElement(name = "C_POSITIONCD")
	private String CPositioncd;
	
	@XmlElement(name = "C_PACKUNITCD")
	private String CPackunitcd;
	
	@XmlElement(name = "C_PACKUNITNAME")
	private String CPackunitname;
	
	@XmlElement(name = "N_PACKUNITPRICE")
	private Double NPackunitprice;
	
	@XmlElement(name = "C_USEUNITCD")
	private String CUserunitcd;
	
	@XmlElement(name = "C_USEUNITNAME")
	private String CUseunitname;
	
	@XmlElement(name = "N_USEUNITPRICE")
	private Double NUseunitprice;
	
	@XmlElement(name = "C_OUTSTORECD")
	private String COutstorecd;
	
	@XmlElement(name = "C_OUTSTORENAME")
	private String COutstorename;
	
	@XmlElement(name = "N_OUTSTOREPRICE")
	private Double NOutstoreprice;
	
	@XmlElement(name = "N_DRUGCOUNT")
	private Integer NDrugcount;
	
	@XmlElement(name = "N_DRUGAMOUNT")
	private Double NDrugamount;
	
	@XmlElement(name = "D_UPTDATETIME")
	private Date DUptdatetime;
	
	@XmlElement(name = "institution")
	private String institution;
	
	@XmlElement(name = "area")
	private String area;

	public TSiipDrugoutstoredetail() {
		super();
	}

	public TSiipDrugoutstoredetail(String id, String COutbillcd,
			String creatorcd, String creatorname, Date createtime,
			String CDrugcd, String CTradename,
			String CCommonname, String CFactoryname,
			String CDrugspec, String CFigurename,
			String CPackunitcd, String CPackunitname,
			Double NPackunitprice, String CUseunitname,
			Double NUseunitprice, String COutstorecd,
			String COutstorename, Double NOutstoreprice,
			Integer NDrugcount, Double NDrugamount, String institution,
			String area, String CUserunitcd) {
		this.id = id;
		this.COutbillcd = COutbillcd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CDrugcd = CDrugcd;
		this.CTradename = CTradename;
		this.CCommonname = CCommonname;
		this.CFactoryname = CFactoryname;
		this.CDrugspec = CDrugspec;
		this.CFigurename = CFigurename;
		this.CPackunitcd = CPackunitcd;
		this.CPackunitname = CPackunitname;
		this.NPackunitprice = NPackunitprice;
		this.CUseunitname = CUseunitname;
		this.NUseunitprice = NUseunitprice;
		this.COutstorecd = COutstorecd;
		this.COutstorename = COutstorename;
		this.NOutstoreprice = NOutstoreprice;
		this.NDrugcount = NDrugcount;
		this.NDrugamount = NDrugamount;
		this.institution = institution;
		this.area = area;
		this.CUserunitcd=CUserunitcd;
	}

	public TSiipDrugoutstoredetail(String id, String COutbillcd,
			String creatorcd, String creatorname, Date createtime,
			String CDrugcd, String CTradename,
			String CCommonname, String CFactoryname,
			String CDrugspec, String CFigurename,
			String CBatchcd, String CBatchdetail,
			String CPositioncd, String CPackunitcd,
			String CPackunitname, Double NPackunitprice,
			String CUseunitname, Double NUseunitprice,
			String COutstorecd, String COutstorename,
			Double NOutstoreprice, Integer NDrugcount, Double NDrugamount,
			Date DUptdatetime, String institution, String area, String CUserunitcd) {
		this.id = id;
		this.CUserunitcd=CUserunitcd;
		this.COutbillcd = COutbillcd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CDrugcd = CDrugcd;
		this.CTradename = CTradename;
		this.CCommonname = CCommonname;
		this.CFactoryname = CFactoryname;
		this.CDrugspec = CDrugspec;
		this.CFigurename = CFigurename;
		this.CBatchcd = CBatchcd;
		this.CBatchdetail = CBatchdetail;
		this.CPositioncd = CPositioncd;
		this.CPackunitcd = CPackunitcd;
		this.CPackunitname = CPackunitname;
		this.NPackunitprice = NPackunitprice;
		this.CUseunitname = CUseunitname;
		this.NUseunitprice = NUseunitprice;
		this.COutstorecd = COutstorecd;
		this.COutstorename = COutstorename;
		this.NOutstoreprice = NOutstoreprice;
		this.NDrugcount = NDrugcount;
		this.NDrugamount = NDrugamount;
		this.DUptdatetime = DUptdatetime;
		this.institution = institution;
		this.area = area;
	}
	@XmlTransient
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@XmlTransient
	public String getCOutbillcd() {
		return this.COutbillcd;
	}

	public void setCOutbillcd(String COutbillcd) {
		this.COutbillcd = COutbillcd;
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
	public String getCTradename() {
		return this.CTradename;
	}

	public void setCTradename(String CTradename) {
		this.CTradename = CTradename;
	}
	@XmlTransient
	public String getCCommonname() {
		return this.CCommonname;
	}

	public void setCCommonname(String CCommonname) {
		this.CCommonname = CCommonname;
	}
	@XmlTransient
	public String getCFactoryname() {
		return this.CFactoryname;
	}

	public void setCFactoryname(String CFactoryname) {
		this.CFactoryname = CFactoryname;
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
	public String getCBatchcd() {
		return this.CBatchcd;
	}

	public void setCBatchcd(String CBatchcd) {
		this.CBatchcd = CBatchcd;
	}
	@XmlTransient
	public String getCBatchdetail() {
		return this.CBatchdetail;
	}

	public void setCBatchdetail(String CBatchdetail) {
		this.CBatchdetail = CBatchdetail;
	}
	@XmlTransient
	public String getCPositioncd() {
		return this.CPositioncd;
	}

	public void setCPositioncd(String CPositioncd) {
		this.CPositioncd = CPositioncd;
	}
	@XmlTransient
	public String getCPackunitcd() {
		return this.CPackunitcd;
	}

	public void setCPackunitcd(String CPackunitcd) {
		this.CPackunitcd = CPackunitcd;
	}
	@XmlTransient
	public String getCPackunitname() {
		return this.CPackunitname;
	}

	public void setCPackunitname(String CPackunitname) {
		this.CPackunitname = CPackunitname;
	}
	@XmlTransient
	public Double getNPackunitprice() {
		return this.NPackunitprice;
	}

	public void setNPackunitprice(Double NPackunitprice) {
		this.NPackunitprice = NPackunitprice;
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
	public String getCOutstorecd() {
		return this.COutstorecd;
	}

	public void setCOutstorecd(String COutstorecd) {
		this.COutstorecd = COutstorecd;
	}
	@XmlTransient
	public String getCOutstorename() {
		return this.COutstorename;
	}

	public void setCOutstorename(String COutstorename) {
		this.COutstorename = COutstorename;
	}
	@XmlTransient
	public Double getNOutstoreprice() {
		return this.NOutstoreprice;
	}

	public void setNOutstoreprice(Double NOutstoreprice) {
		this.NOutstoreprice = NOutstoreprice;
	}
	@XmlTransient
	public Integer getNDrugcount() {
		return this.NDrugcount;
	}

	public void setNDrugcount(Integer NDrugcount) {
		this.NDrugcount = NDrugcount;
	}
	@XmlTransient
	public Double getNDrugamount() {
		return this.NDrugamount;
	}

	public void setNDrugamount(Double NDrugamount) {
		this.NDrugamount = NDrugamount;
	}
	@XmlTransient
	public Date getDUptdatetime() {
		return this.DUptdatetime;
	}

	public void setDUptdatetime(Date DUptdatetime) {
		this.DUptdatetime = DUptdatetime;
	}
	@XmlTransient
	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	@XmlTransient
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@XmlTransient
	public String getCUserunitcd() {
		return CUserunitcd;
	}

	public void setCUserunitcd(String cUserunitcd) {
		CUserunitcd = cUserunitcd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TSiipDrugoutstoredetail))
			return false;
		TSiipDrugoutstoredetail castOther = (TSiipDrugoutstoredetail) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getCOutbillcd() == castOther.getCOutbillcd()) || (this
						.getCOutbillcd() != null
						&& castOther.getCOutbillcd() != null && this
						.getCOutbillcd().equals(castOther.getCOutbillcd())))
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
				&& ((this.getCTradename() == castOther.getCTradename()) || (this
						.getCTradename() != null
						&& castOther.getCTradename() != null && this
						.getCTradename().equals(castOther.getCTradename())))
				&& ((this.getCCommonname() == castOther.getCCommonname()) || (this
						.getCCommonname() != null
						&& castOther.getCCommonname() != null && this
						.getCCommonname().equals(castOther.getCCommonname())))
				&& ((this.getCFactoryname() == castOther.getCFactoryname()) || (this
						.getCFactoryname() != null
						&& castOther.getCFactoryname() != null && this
						.getCFactoryname().equals(castOther.getCFactoryname())))
				&& ((this.getCDrugspec() == castOther.getCDrugspec()) || (this
						.getCDrugspec() != null
						&& castOther.getCDrugspec() != null && this
						.getCDrugspec().equals(castOther.getCDrugspec())))
				&& ((this.getCFigurename() == castOther.getCFigurename()) || (this
						.getCFigurename() != null
						&& castOther.getCFigurename() != null && this
						.getCFigurename().equals(castOther.getCFigurename())))
				&& ((this.getCBatchcd() == castOther.getCBatchcd()) || (this
						.getCBatchcd() != null
						&& castOther.getCBatchcd() != null && this
						.getCBatchcd().equals(castOther.getCBatchcd())))
				&& ((this.getCBatchdetail() == castOther.getCBatchdetail()) || (this
						.getCBatchdetail() != null
						&& castOther.getCBatchdetail() != null && this
						.getCBatchdetail().equals(castOther.getCBatchdetail())))
				&& ((this.getCPositioncd() == castOther.getCPositioncd()) || (this
						.getCPositioncd() != null
						&& castOther.getCPositioncd() != null && this
						.getCPositioncd().equals(castOther.getCPositioncd())))
				&& ((this.getCPackunitcd() == castOther.getCPackunitcd()) || (this
						.getCPackunitcd() != null
						&& castOther.getCPackunitcd() != null && this
						.getCPackunitcd().equals(castOther.getCPackunitcd())))
				&& ((this.getCPackunitname() == castOther.getCPackunitname()) || (this
						.getCPackunitname() != null
						&& castOther.getCPackunitname() != null && this
						.getCPackunitname()
						.equals(castOther.getCPackunitname())))
				&& ((this.getNPackunitprice() == castOther.getNPackunitprice()) || (this
						.getNPackunitprice() != null
						&& castOther.getNPackunitprice() != null && this
						.getNPackunitprice().equals(
								castOther.getNPackunitprice())))
				&& ((this.getCUseunitname() == castOther.getCUseunitname()) || (this
						.getCUseunitname() != null
						&& castOther.getCUseunitname() != null && this
						.getCUseunitname().equals(castOther.getCUseunitname())))
				&& ((this.getNUseunitprice() == castOther.getNUseunitprice()) || (this
						.getNUseunitprice() != null
						&& castOther.getNUseunitprice() != null && this
						.getNUseunitprice()
						.equals(castOther.getNUseunitprice())))
				&& ((this.getCOutstorecd() == castOther.getCOutstorecd()) || (this
						.getCOutstorecd() != null
						&& castOther.getCOutstorecd() != null && this
						.getCOutstorecd().equals(castOther.getCOutstorecd())))
				&& ((this.getCOutstorename() == castOther.getCOutstorename()) || (this
						.getCOutstorename() != null
						&& castOther.getCOutstorename() != null && this
						.getCOutstorename()
						.equals(castOther.getCOutstorename())))
				&& ((this.getNOutstoreprice() == castOther.getNOutstoreprice()) || (this
						.getNOutstoreprice() != null
						&& castOther.getNOutstoreprice() != null && this
						.getNOutstoreprice().equals(
								castOther.getNOutstoreprice())))
				&& (this.getNDrugcount() == castOther.getNDrugcount())
				&& ((this.getNDrugamount() == castOther.getNDrugamount()) || (this
						.getNDrugamount() != null
						&& castOther.getNDrugamount() != null && this
						.getNDrugamount().equals(castOther.getNDrugamount())))
				&& ((this.getDUptdatetime() == castOther.getDUptdatetime()) || (this
						.getDUptdatetime() != null
						&& castOther.getDUptdatetime() != null && this
						.getDUptdatetime().equals(castOther.getDUptdatetime())))
				&& ((this.getInstitution() == castOther.getInstitution()) || (this
						.getInstitution() != null
						&& castOther.getInstitution() != null && this
						.getInstitution().equals(castOther.getInstitution())))
				&& ((this.getArea() == castOther.getArea()) || (this.getArea() != null
						&& castOther.getArea() != null && this.getArea()
						.equals(castOther.getArea())));
	}


}
