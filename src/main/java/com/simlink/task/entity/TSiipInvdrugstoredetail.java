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
public class TSiipInvdrugstoredetail implements java.io.Serializable {

	@XmlElement(name = "ID")
	private String id;
	
	@XmlElement(name = "C_INVSTORECD")
	private String CInvstorecd;
	
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
	
	@XmlElement(name = "C_DRUGSPEC")
	private String CDrugspec;
	
	@XmlElement(name = "C_FIGURENAME")
	private String CFigurename;
	
	@XmlElement(name = "C_FACTORYNAME")
	private String CFactoryname;
	
	@XmlElement(name = "C_POSITIONCD")
	private String CPositioncd;
	
	@XmlElement(name = "D_UPTDATETIME")
	private Date DUptdatetime;
	
	@XmlElement(name = "C_DRUGINVUNITCD")
	private String CDruginvunitcd;
	
	@XmlElement(name = "C_DRUGINVUNITNAME")
	private String CDruginvunitname;
	
	@XmlElement(name = "N_OLDSTOCK")
	private Double NOldstock;
	
	@XmlElement(name = "N_REALSTOCK")
	private Double NRealstock;
	
	@XmlElement(name = "N_OLDAMOUNT")
	private Double NOldamout;
	
	@XmlElement(name = "N_REALAMOUNT")
	private Double NRealamount;
	
	@XmlElement(name = "C_PACKUNITCD")
	private String CPackunitcd;
	
	@XmlElement(name = "C_PACKUNITNAME")
	private String CPackunitname;
	
	@XmlElement(name = "C_USEUNITCD")
	private String CUseunitcd;
	
	@XmlElement(name = "C_USEUNITNAME")
	private String CUseunitname;
	
	@XmlElement(name = "N_PACKUNITPRICE")
	private Double NPackunitprice;
	
	@XmlElement(name = "N_USEUNITPRICE")
	private Double NUseunitprice;
	
	@XmlElement(name = "N_INVUNITPRICE")
	private Double NInvunitprice;
	
	@XmlElement(name = "N_DRUGPACKMODULUS")
	private Double NDrugpackmodulus;
	
	@XmlElement(name = "area")
	private String area;
	
	@XmlElement(name = "institution")
	private String institution;

	public TSiipInvdrugstoredetail() {
		super();
	}

	public TSiipInvdrugstoredetail(String id, String CInvstorecd,
			String creatorcd, String creatorname, Date createtime,
			String CDrugcd, String CTradename,
			String CCommonname, String CDrugspec,
			String CFigurename, String CFactoryname,
			String CDruginvunitcd, Double NOldstock,
			Double NBeforeinvamout, String CPackunitcd,
			String CPackunitname, String CUseunitcd,
			String CUseunitname, Double NPackunitprice,
			Double NUseunitprice, Double NInvunitprice, String area,
			String institution) {
		this.id = id;
		this.CInvstorecd = CInvstorecd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CDrugcd = CDrugcd;
		this.CTradename = CTradename;
		this.CCommonname = CCommonname;
		this.CDrugspec = CDrugspec;
		this.CFigurename = CFigurename;
		this.CFactoryname = CFactoryname;
		this.CDruginvunitcd = CDruginvunitcd;
		this.NOldstock = NOldstock;
		this.CPackunitcd = CPackunitcd;
		this.CPackunitname = CPackunitname;
		this.CUseunitcd = CUseunitcd;
		this.CUseunitname = CUseunitname;
		this.NPackunitprice = NPackunitprice;
		this.NUseunitprice = NUseunitprice;
		this.NInvunitprice = NInvunitprice;
		this.area = area;
		this.institution = institution;
	}

	public TSiipInvdrugstoredetail(String id, String CInvstorecd,
			String creatorcd, String creatorname, Date createtime,
			String CDrugcd, String CTradename,
			String CCommonname, String CDrugspec,
			String CFigurename, String CFactoryname,
			String CPositioncd, Date DUptdatetime,
			String CDruginvunitcd, String CDruginvunitname,
			Double NOldstock, Double NRealstock,
			Double NBeforeinvamout, Double NAfterinvamount,
			String CPackunitcd, String CPackunitname,
			String CUseunitcd, String CUseunitname,
			Double NPackunitprice, Double NUseunitprice,
			Double NInvunitprice, Double NDrugpackmodulus, String area,
			String institution) {
		this.id = id;
		this.CInvstorecd = CInvstorecd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.CDrugcd = CDrugcd;
		this.CTradename = CTradename;
		this.CCommonname = CCommonname;
		this.CDrugspec = CDrugspec;
		this.CFigurename = CFigurename;
		this.CFactoryname = CFactoryname;
		this.CPositioncd = CPositioncd;
		this.DUptdatetime = DUptdatetime;
		this.CDruginvunitcd = CDruginvunitcd;
		this.CDruginvunitname = CDruginvunitname;
		this.NOldstock = NOldstock;
		this.NRealstock = NRealstock;
		this.CPackunitcd = CPackunitcd;
		this.CPackunitname = CPackunitname;
		this.CUseunitcd = CUseunitcd;
		this.CUseunitname = CUseunitname;
		this.NPackunitprice = NPackunitprice;
		this.NUseunitprice = NUseunitprice;
		this.NInvunitprice = NInvunitprice;
		this.NDrugpackmodulus = NDrugpackmodulus;
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
	public String getCPositioncd() {
		return this.CPositioncd;
	}

	public void setCPositioncd(String CPositioncd) {
		this.CPositioncd = CPositioncd;
	}
	@XmlTransient
	public Date getDUptdatetime() {
		return this.DUptdatetime;
	}

	public void setDUptdatetime(Date DUptdatetime) {
		this.DUptdatetime = DUptdatetime;
	}
	@XmlTransient
	public String getCDruginvunitcd() {
		return this.CDruginvunitcd;
	}

	public void setCDruginvunitcd(String CDruginvunitcd) {
		this.CDruginvunitcd = CDruginvunitcd;
	}
	@XmlTransient
	public String getCDruginvunitname() {
		return this.CDruginvunitname;
	}

	public void setCDruginvunitname(String CDruginvunitname) {
		this.CDruginvunitname = CDruginvunitname;
	}
	@XmlTransient
	public Double getNOldstock() {
		return this.NOldstock;
	}

	public void setNOldstock(Double NOldstock) {
		this.NOldstock = NOldstock;
	}
	@XmlTransient
	public Double getNRealstock() {
		return this.NRealstock;
	}

	public void setNRealstock(Double NRealstock) {
		this.NRealstock = NRealstock;
	}
	@XmlTransient
	public String getCPackunitcd() {
		return this.CPackunitcd;
	}
	@XmlTransient
	public Double getNOldamout() {
		return NOldamout;
	}

	public void setNOldamout(Double nOldamout) {
		NOldamout = nOldamout;
	}
	@XmlTransient
	public Double getNRealamount() {
		return NRealamount;
	}

	public void setNRealamount(Double nRealamount) {
		NRealamount = nRealamount;
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
	public Double getNPackunitprice() {
		return this.NPackunitprice;
	}

	public void setNPackunitprice(Double NPackunitprice) {
		this.NPackunitprice = NPackunitprice;
	}
	@XmlTransient
	public Double getNUseunitprice() {
		return this.NUseunitprice;
	}

	public void setNUseunitprice(Double NUseunitprice) {
		this.NUseunitprice = NUseunitprice;
	}
	@XmlTransient
	public Double getNInvunitprice() {
		return this.NInvunitprice;
	}

	public void setNInvunitprice(Double NInvunitprice) {
		this.NInvunitprice = NInvunitprice;
	}
	@XmlTransient
	public Double getNDrugpackmodulus() {
		return this.NDrugpackmodulus;
	}

	public void setNDrugpackmodulus(Double NDrugpackmodulus) {
		this.NDrugpackmodulus = NDrugpackmodulus;
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

}
