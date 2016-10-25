package com.simlink.task.entity;
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
public class TSiipRecipe implements java.io.Serializable{
	
	
	@XmlElement(name="AREA")
	private String area;
	
	@XmlElement(name="INSTITUTION")
	private String institution ;
	
	@XmlElement(name="C_RECIPECD")
	private String CRecipecd ;
	
	@XmlElement(name="C_RECIPECDOLD")
	private String CRecipecdold;
	
	@XmlElement(name="D_RECIPEEXPIREDATE")
	private Date DRecipeexpiredate ;
	
	@XmlElement(name="C_RECIPETYPE")
	private String CRecipetype ;
	
	@XmlElement(name="N_RECIPESORT")
	private Integer NRecipesort ;
	
	@XmlElement(name="N_SPECIALFLG")
	private Integer NSpecialflg ;
	
	@XmlElement(name="N_RECIPECOUNT")
	private Integer NRecipecount;
	
	@XmlElement(name="N_RECIPEAMOUNT")
	private Double NRecipeamount ;
	
	@XmlElement(name="C_RECIPEENTEROPER")
	private String CRecipeenteroper;
	
	@XmlElement(name="D_DOCTORDATETIME")
	private Date DDoctordatetime ;
	
	@XmlElement(name="C_DOCTORCD")
	private String CDoctorcd ;
	
	@XmlElement(name="C_DOCTORNAME")
	private String CDoctorname ; 
	
	@XmlElement(name="C_DOCTORDEPTCD")
	private String CDoctordeptcd ; 
	
	@XmlElement(name="C_DOCTORDEPTNAME")
	private String CDoctordeptname ; 
	
	@XmlElement(name="C_FEEOPER")
	private String CFeeoper; 
	
	@XmlElement(name="D_FEEDATETIME")
	private Date DFeedatetime; 
	
	@XmlElement(name="N_FEEAMOUNT")
	private Double NFeeamount; 
	
	@XmlElement(name="C_PATIENTICD10CD")
	private String CPatienticd10cd ; 
	
	@XmlElement(name="C_PATIENTICD10NAME")
	private String CPatienticd10name ; 
	
	@XmlElement(name="C_PATIENTICD10NOTES")
	private String CPatienticd10notes; 
	
	@XmlElement(name="C_PATIENTID")
	private String CPatientid; 
	
	@XmlElement(name="C_PATIENTCARDCD")
	private String CPatientcardcd; 
	
	@XmlElement(name="C_CITYCARDCD")
	private String CCitycardcd ; 
	
	@XmlElement(name="C_PATIENTTIMES")
	private Integer CPatienttimes ; 
	
	@XmlElement(name="C_RECIPECDHIS")
	private String CRecipecdhis; 
	
	@XmlElement(name="N_LEDGERNO")
	private Integer NLedgerno ; 
	
	@XmlElement(name="C_PATIENTNAME")
	private String CPatientname; 
	
	@XmlElement(name="C_PATIENTSEX")
	private String CPatientsex ; 
	
	@XmlElement(name="C_PATIENTAGE")
	private String CPatientage ; 
	
	@XmlElement(name="C_PATIENTPHONE")
	private String CPatientphone ; 
	
	@XmlElement(name="C_PATIENTWORKUNIT")
	private String CPatientworkunit; 
	
	@XmlElement(name="D_PATIENTBIRTHDAY")
	private Date DPatientbirthday; 
	
	@XmlElement(name="C_PATIENTSORTCD")
	private String CPatientsortcd; 
	
	@XmlElement(name="C_PATIENTSORTNAME")
	private String CPatientsortname; 
	
	@XmlElement(name="N_PATIENTHEIGHT")
	private Integer NPatientheight; 
	
	@XmlElement(name="N_PATIENTWEIGHT")
	private Integer NPatientweight; 
	
	@XmlElement(name="N_RECIPESTATUS")
	private Integer NRecipestatus ; 
	
	@XmlElement(name="N_INTERFACESTATUS")
	private Integer NInterfacestatus; 
	
	@XmlElement(name="N_VIPFLG")
	private Integer NVipflg ; 
	
	@XmlElement(name="C_DOCTORADVICE")
	private String CDoctoradvice ; 
	
	@XmlElement(name="D_ADDDATETIME")
	private Date DAdddatetime; 
	
	@XmlElement(name="B_TWOCODE")
	private String BTwocode; 
	
	@XmlElement(name="C_NOTESEX1")
	private String CNotesex1 ; 
	
	@XmlElement(name="C_NOTESEX2")
	private String CNotesex2 ; 
	
	@XmlElement(name="C_NOTESEX3")
	private String CNotesex3 ;
	
	@XmlElement(name="C_NOTESEX4")
	private String CNotesex4 ; 
	
	@XmlElement(name="C_NOTESEX5")
	private String CNotesex5 ; 
	
	@XmlElement(name="C_STORECD")
	private String CStorecd; 
	
	@XmlElement(name="C_UPTOPERCD")
	private String CUptopercd; 
	
	@XmlElement(name="C_UPTOPERNAME")
	private String CUptopername; 
	
	@XmlElement(name="D_UPTDATETIME")
	private Date DUptdatetime; 
	
	@XmlElement(name="C_ADJUSTCD")
	private String CAdjustcd ; 
	
	@XmlElement(name="C_ADJUSTNAME")
	private String CAdjustname ;
	
	@XmlElement(name="C_INVOICESERIALNUM")
	private String CInvoiceserialnum ; 
	
	@XmlElement(name="N_INFUSIONRECIPEFLG")
	private Integer NInfusionrecipeflg; 
	
	@XmlElement(name="N_EMERGENCYPATIENTFLG")
	private Integer NEmergencypatientflg; 
	
	@XmlElement(name="N_INFUSIONBRINGBACK")
	private Integer NInfusionbringback; 
	
	@XmlElement(name="C_PATIENTNAMEPYCODE")
	private String CPatientnamepycode; 
	
	@XmlElement(name="N_WINDOWNO")
	private Integer NWindowno ;

	public TSiipRecipe(){
		super();
	}
	public TSiipRecipe( String area, String institution , String CRecipecd , String CRecipecdold,
			Date DRecipeexpiredate , String CRecipetype , Integer NRecipesort , Integer
			 NSpecialflg , Integer NRecipecount, Double NRecipeamount , String
			 CRecipeenteroper, Date DDoctordatetime , String CDoctorcd , String
			 CDoctorname , String CDoctordeptcd , String CDoctordeptname , String CFeeoper,
			 Date DFeedatetime, Double NFeeamount, String CPatienticd10cd , String
			 CPatienticd10name , String CPatienticd10notes, String CPatientid, String
			 CPatientcardcd, String CCitycardcd , Integer CPatienttimes , String
			 CRecipecdhis, Integer NLedgerno , String CPatientname, String CPatientsex ,
			 String CPatientage , String CPatientphone , String CPatientworkunit, Date
			 DPatientbirthday, String CPatientsortcd, String CPatientsortname, Integer
			 NPatientheight, Integer NPatientweight, Integer NRecipestatus , Integer
			 NInterfacestatus, Integer NVipflg , String CDoctoradvice , Date DAdddatetime,
			 String BTwocode, String CNotesex1 , String CNotesex2 , String CNotesex3 ,
			 String CNotesex4 , String CNotesex5 , String CStorecd, String CUptopercd,
			 String CUptopername, Date DUptdatetime, String CAdjustcd , String CAdjustname
			 , String CInvoiceserialnum , Integer NInfusionrecipeflg, Integer
			 NEmergencypatientflg, Integer NInfusionbringback, String CPatientnamepycode,
			 Integer NWindowno ){
				this.area=area;
				this.institution =institution;
				this.CRecipecd =CRecipecd;
				this.CRecipecdold=CRecipecdold;
				this.DRecipeexpiredate =DRecipeexpiredate;
				this.CRecipetype =CRecipetype;
				this.NRecipesort =NRecipesort;
				this.NSpecialflg =NSpecialflg;
				this.NRecipecount=NRecipecount;
				this.NRecipeamount =NRecipeamount;
				this.CRecipeenteroper=CRecipeenteroper;
				this.DDoctordatetime =DDoctordatetime;
				this.CDoctorcd =CDoctorcd;
				this.CDoctorname =CDoctorname; 
				this.CDoctordeptcd =CDoctordeptcd; 
				this.CDoctordeptname =CDoctordeptname; 
				this.CFeeoper=CFeeoper; 
				this.DFeedatetime=DFeedatetime; 
				this.NFeeamount=NFeeamount; 
				this.CPatienticd10cd =CPatienticd10cd; 
				this.CPatienticd10name =CPatienticd10name; 
				this.CPatienticd10notes=CPatienticd10notes; 
				this.CPatientid=CPatienticd10notes; 
				this.CPatientcardcd=CPatientcardcd; 
				this.CCitycardcd =CCitycardcd; 
				this.CPatienttimes =CPatienttimes; 
				this.CRecipecdhis=CRecipecdhis; 
				this.NLedgerno =NLedgerno; 
				this.CPatientname=CPatientname; 
				this.CPatientsex =CPatientsex; 
				this.CPatientage =CPatientage; 
				this.CPatientphone =CPatientphone; 
				this.CPatientworkunit=CPatientworkunit; 
				this.DPatientbirthday=DPatientbirthday; 
				this.CPatientsortcd=CPatientsortcd; 
				this.CPatientsortname=CPatientsortname; 
				this.NPatientheight=NPatientheight; 
				this.NPatientweight=NPatientweight; 
				this.NRecipestatus =NRecipestatus; 
				this.NInterfacestatus=NInterfacestatus; 
				this.NVipflg =NVipflg; 
				this.CDoctoradvice =CDoctoradvice; 
				this.DAdddatetime=DAdddatetime; 
				this.BTwocode=BTwocode; 
				this.CNotesex1 =CNotesex1; 
				this.CNotesex2 =CNotesex2; 
				this.CNotesex3 =CNotesex3; 
				this.CNotesex4 =CNotesex4; 
				this.CNotesex5 =CNotesex5; 
				this.CStorecd=CStorecd; 
				this.CUptopercd=CUptopercd; 
				this.CUptopername=CUptopername; 
				this.DUptdatetime=DUptdatetime; 
				this.CAdjustcd =CAdjustcd; 
				this.CAdjustname =CAdjustname; 
				this.CInvoiceserialnum =CInvoiceserialnum; 
				this.NInfusionrecipeflg=NInfusionrecipeflg; 
				this.NEmergencypatientflg=NEmergencypatientflg; 
				this.NInfusionbringback=NInfusionbringback; 
				this.CPatientnamepycode=CPatientnamepycode; 
				this.NWindowno =NWindowno;
	}
	
	@XmlTransient
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	@XmlTransient
	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	@XmlTransient
	public String getCRecipecd() {
		return CRecipecd;
	}

	public void setCRecipecd(String cRecipecd) {
		CRecipecd = cRecipecd;
	}
	@XmlTransient
	public String getCRecipecdold() {
		return CRecipecdold;
	}

	public void setCRecipecdold(String cRecipecdold) {
		CRecipecdold = cRecipecdold;
	}
	@XmlTransient
	public Date getDRecipeexpiredate() {
		return DRecipeexpiredate;
	}

	public void setDRecipeexpiredate(Date dRecipeexpiredate) {
		DRecipeexpiredate = dRecipeexpiredate;
	}
	@XmlTransient
	public String getCRecipetype() {
		return CRecipetype;
	}

	public void setCRecipetype(String cRecipetype) {
		CRecipetype = cRecipetype;
	}
	@XmlTransient
	public Integer getNRecipesort() {
		return NRecipesort;
	}

	public void setNRecipesort(Integer nRecipesort) {
		NRecipesort = nRecipesort;
	}
	@XmlTransient
	public Integer getNSpecialflg() {
		return NSpecialflg;
	}

	public void setNSpecialflg(Integer nSpecialflg) {
		NSpecialflg = nSpecialflg;
	}
	@XmlTransient
	public Integer getNRecipecount() {
		return NRecipecount;
	}

	public void setNRecipecount(Integer nRecipecount) {
		NRecipecount = nRecipecount;
	}
	@XmlTransient
	public Double getNRecipeamount() {
		return NRecipeamount;
	}

	public void setNRecipeamount(Double nRecipeamount) {
		NRecipeamount = nRecipeamount;
	}
	@XmlTransient
	public String getCRecipeenteroper() {
		return CRecipeenteroper;
	}

	public void setCRecipeenteroper(String cRecipeenteroper) {
		CRecipeenteroper = cRecipeenteroper;
	}
	@XmlTransient
	public Date getDDoctordatetime() {
		return DDoctordatetime;
	}

	public void setDDoctordatetime(Date dDoctordatetime) {
		DDoctordatetime = dDoctordatetime;
	}
	@XmlTransient
	public String getCDoctorcd() {
		return CDoctorcd;
	}

	public void setCDoctorcd(String cDoctorcd) {
		CDoctorcd = cDoctorcd;
	}
	@XmlTransient
	public String getCDoctorname() {
		return CDoctorname;
	}

	public void setCDoctorname(String cDoctorname) {
		CDoctorname = cDoctorname;
	}
	@XmlTransient
	public String getCDoctordeptcd() {
		return CDoctordeptcd;
	}

	public void setCDoctordeptcd(String cDoctordeptcd) {
		CDoctordeptcd = cDoctordeptcd;
	}
	@XmlTransient
	public String getCDoctordeptname() {
		return CDoctordeptname;
	}

	public void setCDoctordeptname(String cDoctordeptname) {
		CDoctordeptname = cDoctordeptname;
	}
	@XmlTransient
	public String getCFeeoper() {
		return CFeeoper;
	}

	public void setCFeeoper(String cFeeoper) {
		CFeeoper = cFeeoper;
	}
	@XmlTransient
	public Date getDFeedatetime() {
		return DFeedatetime;
	}

	public void setDFeedatetime(Date dFeedatetime) {
		DFeedatetime = dFeedatetime;
	}
	@XmlTransient
	public Double getNFeeamount() {
		return NFeeamount;
	}

	public void setNFeeamount(Double nFeeamount) {
		NFeeamount = nFeeamount;
	}
	@XmlTransient
	public String getCPatienticd10cd() {
		return CPatienticd10cd;
	}

	public void setCPatienticd10cd(String cPatienticd10cd) {
		CPatienticd10cd = cPatienticd10cd;
	}
	@XmlTransient
	public String getCPatienticd10name() {
		return CPatienticd10name;
	}

	public void setCPatienticd10name(String cPatienticd10name) {
		CPatienticd10name = cPatienticd10name;
	}
	@XmlTransient
	public String getCPatienticd10notes() {
		return CPatienticd10notes;
	}

	public void setCPatienticd10notes(String cPatienticd10notes) {
		CPatienticd10notes = cPatienticd10notes;
	}
	@XmlTransient
	public String getCPatientid() {
		return CPatientid;
	}

	public void setCPatientid(String cPatientid) {
		CPatientid = cPatientid;
	}
	@XmlTransient
	public String getCPatientcardcd() {
		return CPatientcardcd;
	}

	public void setCPatientcardcd(String cPatientcardcd) {
		CPatientcardcd = cPatientcardcd;
	}
	@XmlTransient
	public String getCCitycardcd() {
		return CCitycardcd;
	}

	public void setCCitycardcd(String cCitycardcd) {
		CCitycardcd = cCitycardcd;
	}
	@XmlTransient
	public Integer getCPatienttimes() {
		return CPatienttimes;
	}

	public void setCPatienttimes(Integer cPatienttimes) {
		CPatienttimes = cPatienttimes;
	}
	@XmlTransient
	public String getCRecipecdhis() {
		return CRecipecdhis;
	}

	public void setCRecipecdhis(String cRecipecdhis) {
		CRecipecdhis = cRecipecdhis;
	}
	@XmlTransient
	public Integer getNLedgerno() {
		return NLedgerno;
	}

	public void setNLedgerno(Integer nLedgerno) {
		NLedgerno = nLedgerno;
	}
	@XmlTransient
	public String getCPatientname() {
		return CPatientname;
	}

	public void setCPatientname(String cPatientname) {
		CPatientname = cPatientname;
	}
	@XmlTransient
	public String getCPatientsex() {
		return CPatientsex;
	}

	public void setCPatientsex(String cPatientsex) {
		CPatientsex = cPatientsex;
	}
	@XmlTransient
	public String getCPatientage() {
		return CPatientage;
	}

	public void setCPatientage(String cPatientage) {
		CPatientage = cPatientage;
	}
	@XmlTransient
	public String getCPatientphone() {
		return CPatientphone;
	}

	public void setCPatientphone(String cPatientphone) {
		CPatientphone = cPatientphone;
	}
	@XmlTransient
	public String getCPatientworkunit() {
		return CPatientworkunit;
	}

	public void setCPatientworkunit(String cPatientworkunit) {
		CPatientworkunit = cPatientworkunit;
	}
	@XmlTransient
	public Date getDPatientbirthday() {
		return DPatientbirthday;
	}

	public void setDPatientbirthday(Date dPatientbirthday) {
		DPatientbirthday = dPatientbirthday;
	}
	@XmlTransient
	public String getCPatientsortcd() {
		return CPatientsortcd;
	}

	public void setCPatientsortcd(String cPatientsortcd) {
		CPatientsortcd = cPatientsortcd;
	}
	@XmlTransient
	public String getCPatientsortname() {
		return CPatientsortname;
	}

	public void setCPatientsortname(String cPatientsortname) {
		CPatientsortname = cPatientsortname;
	}
	@XmlTransient
	public Integer getNPatientheight() {
		return NPatientheight;
	}

	public void setNPatientheight(Integer nPatientheight) {
		NPatientheight = nPatientheight;
	}
	@XmlTransient
	public Integer getNPatientweight() {
		return NPatientweight;
	}

	public void setNPatientweight(Integer nPatientweight) {
		NPatientweight = nPatientweight;
	}
	@XmlTransient
	public Integer getNRecipestatus() {
		return NRecipestatus;
	}

	public void setNRecipestatus(Integer nRecipestatus) {
		NRecipestatus = nRecipestatus;
	}
	@XmlTransient
	public Integer getNInterfacestatus() {
		return NInterfacestatus;
	}

	public void setNInterfacestatus(Integer nInterfacestatus) {
		NInterfacestatus = nInterfacestatus;
	}
	@XmlTransient
	public Integer getNVipflg() {
		return NVipflg;
	}

	public void setNVipflg(Integer nVipflg) {
		NVipflg = nVipflg;
	}
	@XmlTransient
	public String getCDoctoradvice() {
		return CDoctoradvice;
	}

	public void setCDoctoradvice(String cDoctoradvice) {
		CDoctoradvice = cDoctoradvice;
	}
	@XmlTransient
	public Date getDAdddatetime() {
		return DAdddatetime;
	}

	public void setDAdddatetime(Date dAdddatetime) {
		DAdddatetime = dAdddatetime;
	}
	@XmlTransient
	public String getBTwocode() {
		return BTwocode;
	}

	public void setBTwocode(String bTwocode) {
		BTwocode = bTwocode;
	}
	@XmlTransient
	public String getCNotesex1() {
		return CNotesex1;
	}

	public void setCNotesex1(String cNotesex1) {
		CNotesex1 = cNotesex1;
	}
	@XmlTransient
	public String getCNotesex2() {
		return CNotesex2;
	}

	public void setCNotesex2(String cNotesex2) {
		CNotesex2 = cNotesex2;
	}
	@XmlTransient
	public String getCNotesex3() {
		return CNotesex3;
	}

	public void setCNotesex3(String cNotesex3) {
		CNotesex3 = cNotesex3;
	}
	@XmlTransient
	public String getCNotesex4() {
		return CNotesex4;
	}

	public void setCNotesex4(String cNotesex4) {
		CNotesex4 = cNotesex4;
	}
	@XmlTransient
	public String getCNotesex5() {
		return CNotesex5;
	}

	public void setCNotesex5(String cNotesex5) {
		CNotesex5 = cNotesex5;
	}
	@XmlTransient
	public String getCStorecd() {
		return CStorecd;
	}

	public void setCStorecd(String cStorecd) {
		CStorecd = cStorecd;
	}
	@XmlTransient
	public String getCUptopercd() {
		return CUptopercd;
	}

	public void setCUptopercd(String cUptopercd) {
		CUptopercd = cUptopercd;
	}
	@XmlTransient
	public String getCUptopername() {
		return CUptopername;
	}

	public void setCUptopername(String cUptopername) {
		CUptopername = cUptopername;
	}
	@XmlTransient
	public Date getDUptdatetime() {
		return DUptdatetime;
	}

	public void setDUptdatetime(Date dUptdatetime) {
		DUptdatetime = dUptdatetime;
	}
	@XmlTransient
	public String getCAdjustcd() {
		return CAdjustcd;
	}

	public void setCAdjustcd(String cAdjustcd) {
		CAdjustcd = cAdjustcd;
	}
	@XmlTransient
	public String getCAdjustname() {
		return CAdjustname;
	}

	public void setCAdjustname(String cAdjustname) {
		CAdjustname = cAdjustname;
	}
	@XmlTransient
	public String getCInvoiceserialnum() {
		return CInvoiceserialnum;
	}

	public void setCInvoiceserialnum(String cInvoiceserialnum) {
		CInvoiceserialnum = cInvoiceserialnum;
	}
	@XmlTransient
	public Integer getNInfusionrecipeflg() {
		return NInfusionrecipeflg;
	}

	public void setNInfusionrecipeflg(Integer nInfusionrecipeflg) {
		NInfusionrecipeflg = nInfusionrecipeflg;
	}
	@XmlTransient
	public Integer getNEmergencypatientflg() {
		return NEmergencypatientflg;
	}

	public void setNEmergencypatientflg(Integer nEmergencypatientflg) {
		NEmergencypatientflg = nEmergencypatientflg;
	}
	@XmlTransient
	public Integer getNInfusionbringback() {
		return NInfusionbringback;
	}

	public void setNInfusionbringback(Integer nInfusionbringback) {
		NInfusionbringback = nInfusionbringback;
	}
	@XmlTransient
	public String getCPatientnamepycode() {
		return CPatientnamepycode;
	}

	public void setCPatientnamepycode(String cPatientnamepycode) {
		CPatientnamepycode = cPatientnamepycode;
	}
	@XmlTransient
	public Integer getNWindowno() {
		return NWindowno;
	}

	public void setNWindowno(Integer nWindowno) {
		NWindowno = nWindowno;
	}  
}
