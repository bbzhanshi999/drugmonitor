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
public class TSiipSendcollectdetail implements java.io.Serializable {

	@XmlElement(name = "ID")
	private String id;
	
	@XmlElement(name = "N_COLLECTID")
	private String NCollectid;
	
	@XmlElement(name = "C_SENDLISTCD")
	private String CSendlistcd;
	
	@XmlElement(name = "CREATORCD")
	private String creatorcd;
	
	@XmlElement(name = "CREATORNAME")
	private String creatorname;
	
	@XmlElement(name = "CREATETIME")
	private Date createtime;
	
	@XmlElement(name = "C_PATIENTID")
	private String CPatientid;
	
	@XmlElement(name = "C_PATIENTNAME")
	private String CPatientname;
	
	@XmlElement(name = "C_PATIENTNAMEPYCODE")
	private String CPatientnamepycode;
	
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
	
	@XmlElement(name = "C_BATCHCD")
	private String CBatchcd;
	
	@XmlElement(name = "C_BATCHDETAIL")
	private String CBatchdetail;
	
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
	
	@XmlElement(name = "C_DRUGUSAGECD")
	private String CDrugusagecd;
	
	@XmlElement(name = "C_DRUGUSAGENAME")
	private String CDrugusagename;
	
	@XmlElement(name = "C_DRUGUSETIMESDAYCD")
	private String CDrugusetimesdayname;
	
	@XmlElement(name = "C_DRUGUSETIMESDAYNAME")
	private String CDrugusetimesdaycd;
	
	@XmlElement(name = "C_DOCTORCD")
	private String CDoctorcd;
	
	@XmlElement(name = "C_DOCTORNAME")
	private String CDoctorname;
	
	@XmlElement(name = "C_DOCTORADVICE")
	private String CDoctoradvice;
	
	@XmlElement(name = "C_BEDCD")
	private String CBedcd;
	
	@XmlElement(name = "C_DAYTIME")
	private String CDaytime;
	
	@XmlElement(name = "C_DOSAGE")
	private String CDosage;
	
	@XmlElement(name = "area")
	private String area;
	
	@XmlElement(name = "institution")
	private String institution;

	public TSiipSendcollectdetail() {
		super();
	}

	public TSiipSendcollectdetail(String id, String NCollectid,
			String CSendlistcd, String creatorcd,
			String creatorname, Date createtime, String CPatientid,
			String CPatientname, String CDrugcd,
			String CCommonname, String CTradename,
			String CDrugspec, String CFigurename,
			String CFactoryname, String CDrugpackunitcd,
			String CDrugpackunitname, Double CDrugpackunitprice,
			String CUseunitcd, String CSendunitcd,
			String CSendunitname, Double NSendunitprice,
			Double NDrugnumber, Double NDrugamount,
			String CDrugusagecd, String CDrugusagename,
			String CDrugusetimesdayname, String CDrugusetimesdaycd,
			String CDoctorcd, String CDoctorname, String area,
			String institution) {
		this.id = id;
		this.NCollectid = NCollectid;
		this.CSendlistcd = CSendlistcd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CPatientid = CPatientid;
		this.CPatientname = CPatientname;
		this.CDrugcd = CDrugcd;
		this.CCommonname = CCommonname;
		this.CTradename = CTradename;
		this.CDrugspec = CDrugspec;
		this.CFigurename = CFigurename;
		this.CFactoryname = CFactoryname;
		this.CDrugpackunitcd = CDrugpackunitcd;
		this.CDrugpackunitname = CDrugpackunitname;
		this.CDrugpackunitprice = CDrugpackunitprice;
		this.CUseunitcd = CUseunitcd;
		this.CSendunitcd = CSendunitcd;
		this.CSendunitname = CSendunitname;
		this.NSendunitprice = NSendunitprice;
		this.NDrugnumber = NDrugnumber;
		this.NDrugamount = NDrugamount;
		this.CDrugusagecd = CDrugusagecd;
		this.CDrugusagename = CDrugusagename;
		this.CDrugusetimesdayname = CDrugusetimesdayname;
		this.CDrugusetimesdaycd = CDrugusetimesdaycd;
		this.CDoctorcd = CDoctorcd;
		this.CDoctorname = CDoctorname;
		this.area = area;
		this.institution = institution;
	}

	public TSiipSendcollectdetail(String id, String NCollectid,
			String CSendlistcd, String creatorcd,
			String creatorname, Date createtime, String CPatientid,
			String CPatientname, String CPatientnamepycode,
			String CDrugcd, String CCommonname,
			String CTradename, String CDrugspec,
			String CFigurename, String CFactoryname,
			String CBatchcd, String CBatchdetail,
			String CDrugpackunitcd, String CDrugpackunitname,
			Double CDrugpackunitprice, String CUseunitcd,
			String CUseunitname, Double NUseunitprice,
			String CSendunitcd, String CSendunitname,
			Double NSendunitprice, Double NDrugnumber,
			Double NDrugamount, String CDrugusagecd,
			String CDrugusagename, String CDrugusetimesdayname,
			String CDrugusetimesdaycd, String CDoctorcd,
			String CDoctorname, String CDoctoradvice,
			String CBedcd, String CDaytime, String CDosage,
			String area, String institution) {
		this.id = id;
		this.NCollectid = NCollectid;
		this.CSendlistcd = CSendlistcd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CPatientid = CPatientid;
		this.CPatientname = CPatientname;
		this.CPatientnamepycode = CPatientnamepycode;
		this.CDrugcd = CDrugcd;
		this.CCommonname = CCommonname;
		this.CTradename = CTradename;
		this.CDrugspec = CDrugspec;
		this.CFigurename = CFigurename;
		this.CFactoryname = CFactoryname;
		this.CBatchcd = CBatchcd;
		this.CBatchdetail = CBatchdetail;
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
		this.CDrugusagecd = CDrugusagecd;
		this.CDrugusagename = CDrugusagename;
		this.CDrugusetimesdayname = CDrugusetimesdayname;
		this.CDrugusetimesdaycd = CDrugusetimesdaycd;
		this.CDoctorcd = CDoctorcd;
		this.CDoctorname = CDoctorname;
		this.CDoctoradvice = CDoctoradvice;
		this.CBedcd = CBedcd;
		this.CDaytime = CDaytime;
		this.CDosage = CDosage;
		this.area = area;
		this.institution = institution;
	}
	@XmlTransient
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@XmlTransient
	public String getNCollectid() {
		return this.NCollectid;
	}

	public void setNCollectid(String NCollectid) {
		this.NCollectid = NCollectid;
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
	public String getCPatientid() {
		return this.CPatientid;
	}

	public void setCPatientid(String CPatientid) {
		this.CPatientid = CPatientid;
	}
	@XmlTransient
	public String getCPatientname() {
		return this.CPatientname;
	}

	public void setCPatientname(String CPatientname) {
		this.CPatientname = CPatientname;
	}
	@XmlTransient
	public String getCPatientnamepycode() {
		return this.CPatientnamepycode;
	}

	public void setCPatientnamepycode(String CPatientnamepycode) {
		this.CPatientnamepycode = CPatientnamepycode;
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
	public String getCDrugusagecd() {
		return this.CDrugusagecd;
	}

	public void setCDrugusagecd(String CDrugusagecd) {
		this.CDrugusagecd = CDrugusagecd;
	}
	@XmlTransient
	public String getCDrugusagename() {
		return this.CDrugusagename;
	}

	public void setCDrugusagename(String CDrugusagename) {
		this.CDrugusagename = CDrugusagename;
	}
	@XmlTransient
	public String getCDrugusetimesdayname() {
		return this.CDrugusetimesdayname;
	}

	public void setCDrugusetimesdayname(String CDrugusetimesdayname) {
		this.CDrugusetimesdayname = CDrugusetimesdayname;
	}
	@XmlTransient
	public String getCDrugusetimesdaycd() {
		return this.CDrugusetimesdaycd;
	}

	public void setCDrugusetimesdaycd(String CDrugusetimesdaycd) {
		this.CDrugusetimesdaycd = CDrugusetimesdaycd;
	}
	@XmlTransient
	public String getCDoctorcd() {
		return this.CDoctorcd;
	}

	public void setCDoctorcd(String CDoctorcd) {
		this.CDoctorcd = CDoctorcd;
	}
	@XmlTransient
	public String getCDoctorname() {
		return this.CDoctorname;
	}

	public void setCDoctorname(String CDoctorname) {
		this.CDoctorname = CDoctorname;
	}
	@XmlTransient
	public String getCDoctoradvice() {
		return this.CDoctoradvice;
	}

	public void setCDoctoradvice(String CDoctoradvice) {
		this.CDoctoradvice = CDoctoradvice;
	}
	@XmlTransient
	public String getCBedcd() {
		return this.CBedcd;
	}

	public void setCBedcd(String CBedcd) {
		this.CBedcd = CBedcd;
	}
	@XmlTransient
	public String getCDaytime() {
		return this.CDaytime;
	}

	public void setCDaytime(String CDaytime) {
		this.CDaytime = CDaytime;
	}
	@XmlTransient
	public String getCDosage() {
		return this.CDosage;
	}

	public void setCDosage(String CDosage) {
		this.CDosage = CDosage;
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
		if (!(other instanceof TSiipSendcollectdetail))
			return false;
		TSiipSendcollectdetail castOther = (TSiipSendcollectdetail) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getNCollectid() == castOther.getNCollectid()) || (this
						.getNCollectid() != null
						&& castOther.getNCollectid() != null && this
						.getNCollectid().equals(castOther.getNCollectid())))
				&& ((this.getCSendlistcd() == castOther.getCSendlistcd()) || (this
						.getCSendlistcd() != null
						&& castOther.getCSendlistcd() != null && this
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
				&& ((this.getCPatientid() == castOther.getCPatientid()) || (this
						.getCPatientid() != null
						&& castOther.getCPatientid() != null && this
						.getCPatientid().equals(castOther.getCPatientid())))
				&& ((this.getCPatientname() == castOther.getCPatientname()) || (this
						.getCPatientname() != null
						&& castOther.getCPatientname() != null && this
						.getCPatientname().equals(castOther.getCPatientname())))
				&& ((this.getCPatientnamepycode() == castOther
						.getCPatientnamepycode()) || (this
						.getCPatientnamepycode() != null
						&& castOther.getCPatientnamepycode() != null && this
						.getCPatientnamepycode().equals(
								castOther.getCPatientnamepycode())))
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
				&& ((this.getCBatchcd() == castOther.getCBatchcd()) || (this
						.getCBatchcd() != null
						&& castOther.getCBatchcd() != null && this
						.getCBatchcd().equals(castOther.getCBatchcd())))
				&& ((this.getCBatchdetail() == castOther.getCBatchdetail()) || (this
						.getCBatchdetail() != null
						&& castOther.getCBatchdetail() != null && this
						.getCBatchdetail().equals(castOther.getCBatchdetail())))
				&& ((this.getCDrugpackunitcd() == castOther.getCDrugpackunitcd()) || (this
						.getCDrugpackunitcd() != null
						&& castOther.getCDrugpackunitcd() != null && this
						.getCDrugpackunitcd().equals(castOther.getCDrugpackunitcd())))
				&& ((this.getCDrugpackunitname() == castOther.getCDrugpackunitname()) || (this
						.getCDrugpackunitname() != null
						&& castOther.getCDrugpackunitname() != null && this
						.getCDrugpackunitname()
						.equals(castOther.getCDrugpackunitname())))
				&& ((this.getCDrugpackunitprice() == castOther.getCDrugpackunitprice()) || (this
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
				&& ((this.getCDrugusagecd() == castOther.getCDrugusagecd()) || (this
						.getCDrugusagecd() != null
						&& castOther.getCDrugusagecd() != null && this
						.getCDrugusagecd().equals(castOther.getCDrugusagecd())))
				&& ((this.getCDrugusagename() == castOther.getCDrugusagename()) || (this
						.getCDrugusagename() != null
						&& castOther.getCDrugusagename() != null && this
						.getCDrugusagename().equals(
								castOther.getCDrugusagename())))
				&& ((this.getCDrugusetimesdayname() == castOther
						.getCDrugusetimesdayname()) || (this
						.getCDrugusetimesdayname() != null
						&& castOther.getCDrugusetimesdayname() != null && this
						.getCDrugusetimesdayname().equals(
								castOther.getCDrugusetimesdayname())))
				&& ((this.getCDrugusetimesdaycd() == castOther
						.getCDrugusetimesdaycd()) || (this
						.getCDrugusetimesdaycd() != null
						&& castOther.getCDrugusetimesdaycd() != null && this
						.getCDrugusetimesdaycd().equals(
								castOther.getCDrugusetimesdaycd())))
				&& ((this.getCDoctorcd() == castOther.getCDoctorcd()) || (this
						.getCDoctorcd() != null
						&& castOther.getCDoctorcd() != null && this
						.getCDoctorcd().equals(castOther.getCDoctorcd())))
				&& ((this.getCDoctorname() == castOther.getCDoctorname()) || (this
						.getCDoctorname() != null
						&& castOther.getCDoctorname() != null && this
						.getCDoctorname().equals(castOther.getCDoctorname())))
				&& ((this.getCDoctoradvice() == castOther.getCDoctoradvice()) || (this
						.getCDoctoradvice() != null
						&& castOther.getCDoctoradvice() != null && this
						.getCDoctoradvice()
						.equals(castOther.getCDoctoradvice())))
				&& ((this.getCBedcd() == castOther.getCBedcd()) || (this
						.getCBedcd() != null && castOther.getCBedcd() != null && this
						.getCBedcd().equals(castOther.getCBedcd())))
				&& ((this.getCDaytime() == castOther.getCDaytime()) || (this
						.getCDaytime() != null
						&& castOther.getCDaytime() != null && this
						.getCDaytime().equals(castOther.getCDaytime())))
				&& ((this.getCDosage() == castOther.getCDosage()) || (this
						.getCDosage() != null && castOther.getCDosage() != null && this
						.getCDosage().equals(castOther.getCDosage())))
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

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getNCollectid() == null ? 0 : this.getNCollectid()
						.hashCode());
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
				+ (getCPatientid() == null ? 0 : this.getCPatientid()
						.hashCode());
		result = 37
				* result
				+ (getCPatientname() == null ? 0 : this.getCPatientname()
						.hashCode());
		result = 37
				* result
				+ (getCPatientnamepycode() == null ? 0 : this
						.getCPatientnamepycode().hashCode());
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
		result = 37 * result
				+ (getCBatchcd() == null ? 0 : this.getCBatchcd().hashCode());
		result = 37
				* result
				+ (getCBatchdetail() == null ? 0 : this.getCBatchdetail()
						.hashCode());
		result = 37
				* result
				+ (getCDrugpackunitcd() == null ? 0 : this.getCDrugpackunitcd()
						.hashCode());
		result = 37
				* result
				+ (getCDrugpackunitname() == null ? 0 : this.getCDrugpackunitname()
						.hashCode());
		result = 37
				* result
				+ (getCDrugpackunitprice() == null ? 0 : this.getCDrugpackunitprice()
						.hashCode());
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
				+ (getCDrugusagecd() == null ? 0 : this.getCDrugusagecd()
						.hashCode());
		result = 37
				* result
				+ (getCDrugusagename() == null ? 0 : this.getCDrugusagename()
						.hashCode());
		result = 37
				* result
				+ (getCDrugusetimesdayname() == null ? 0 : this
						.getCDrugusetimesdayname().hashCode());
		result = 37
				* result
				+ (getCDrugusetimesdaycd() == null ? 0 : this
						.getCDrugusetimesdaycd().hashCode());
		result = 37 * result
				+ (getCDoctorcd() == null ? 0 : this.getCDoctorcd().hashCode());
		result = 37
				* result
				+ (getCDoctorname() == null ? 0 : this.getCDoctorname()
						.hashCode());
		result = 37
				* result
				+ (getCDoctoradvice() == null ? 0 : this.getCDoctoradvice()
						.hashCode());
		result = 37 * result
				+ (getCBedcd() == null ? 0 : this.getCBedcd().hashCode());
		result = 37 * result
				+ (getCDaytime() == null ? 0 : this.getCDaytime().hashCode());
		result = 37 * result
				+ (getCDosage() == null ? 0 : this.getCDosage().hashCode());
		result = 37 * result
				+ (getArea() == null ? 0 : this.getArea().hashCode());
		result = 37
				* result
				+ (getInstitution() == null ? 0 : this.getInstitution()
						.hashCode());
		return result;
	}

}
