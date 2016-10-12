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
public class TSiipDrugstoragestock implements java.io.Serializable {

	@XmlElement(name = "ID")
	private String id;
	
	@XmlElement(name = "C_DRUGCD")
	private String CDrugcd;
	
	@XmlElement(name = "C_DRUGUNITCD")
	private String CDrugunitcd;
	
	@XmlElement(name = "C_BATCHCD")
	private String CBatchcd;
	
	@XmlElement(name = "CREATORCD")
	private String creatorcd;
	
	@XmlElement(name = "CREATORNAME")
	private String creatorname;
	
	@XmlElement(name = "CREATETIME")
	private Date createtime;
	
	@XmlElement(name = "N_DRUGSTOCK")
	private String DNumber;
	
	@XmlElement(name = "D_NUMBER")
	private Double NDrugstock;
	
	@XmlElement(name = "INSTITUTION")
	private String institution;
	
	@XmlElement(name = "AREA")
	private String area;

	public TSiipDrugstoragestock() {
		super();
	}

	public TSiipDrugstoragestock(String id, String CDrugcd,
			String CDrugunitcd, String creatorcd,
			String creatorname, Date createtime, String DNumber,
			Double NDrugstock, String institution, String area) {
		this.id = id;
		this.CDrugcd = CDrugcd;
		this.CDrugunitcd = CDrugunitcd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.DNumber = DNumber;
		this.NDrugstock = NDrugstock;
		this.institution = institution;
		this.area = area;
	}

	public TSiipDrugstoragestock(String id, String CDrugcd,
			String CDrugunitcd, String CBatchcd,
			String creatorcd, String creatorname, Date createtime,
			String DNumber, Double NDrugstock, String institution,
			String area) {
		this.id = id;
		this.CDrugcd = CDrugcd;
		this.CDrugunitcd = CDrugunitcd;
		this.CBatchcd = CBatchcd;
		this.creatorcd = creatorcd;
		this.creatorname = creatorname;
		this.createtime = createtime;
		this.DNumber = DNumber;
		this.NDrugstock = NDrugstock;
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
	public String getCDrugcd() {
		return this.CDrugcd;
	}

	public void setCDrugcd(String CDrugcd) {
		this.CDrugcd = CDrugcd;
	}
	@XmlTransient
	public String getCDrugunitcd() {
		return this.CDrugunitcd;
	}

	public void setCDrugunitcd(String CDrugunitcd) {
		this.CDrugunitcd = CDrugunitcd;
	}
	@XmlTransient
	public String getCBatchcd() {
		return this.CBatchcd;
	}

	public void setCBatchcd(String CBatchcd) {
		this.CBatchcd = CBatchcd;
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
	public String getDNumber() {
		return this.DNumber;
	}

	public void setDNumber(String DNumber) {
		this.DNumber = DNumber;
	}
	@XmlTransient
	public Double getNDrugstock() {
		return this.NDrugstock;
	}

	public void setNDrugstock(Double NDrugstock) {
		this.NDrugstock = NDrugstock;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TSiipDrugstoragestock))
			return false;
		TSiipDrugstoragestock castOther = (TSiipDrugstoragestock) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getCDrugcd() == castOther.getCDrugcd()) || (this
						.getCDrugcd() != null && castOther.getCDrugcd() != null && this
						.getCDrugcd().equals(castOther.getCDrugcd())))
				&& ((this.getCDrugunitcd() == castOther.getCDrugunitcd()) || (this
						.getCDrugunitcd() != null
						&& castOther.getCDrugunitcd() != null && this
						.getCDrugunitcd().equals(castOther.getCDrugunitcd())))
				&& ((this.getCBatchcd() == castOther.getCBatchcd()) || (this
						.getCBatchcd() != null
						&& castOther.getCBatchcd() != null && this
						.getCBatchcd().equals(castOther.getCBatchcd())))
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
				&& ((this.getDNumber() == castOther.getDNumber()) || (this
						.getDNumber() != null && castOther.getDNumber() != null && this
						.getDNumber().equals(castOther.getDNumber())))
				&& ((this.getNDrugstock() == castOther.getNDrugstock()) || (this
						.getNDrugstock() != null
						&& castOther.getNDrugstock() != null && this
						.getNDrugstock().equals(castOther.getNDrugstock())))
				&& ((this.getInstitution() == castOther.getInstitution()) || (this
						.getInstitution() != null
						&& castOther.getInstitution() != null && this
						.getInstitution().equals(castOther.getInstitution())))
				&& ((this.getArea() == castOther.getArea()) || (this.getArea() != null
						&& castOther.getArea() != null && this.getArea()
						.equals(castOther.getArea())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getCDrugcd() == null ? 0 : this.getCDrugcd().hashCode());
		result = 37
				* result
				+ (getCDrugunitcd() == null ? 0 : this.getCDrugunitcd()
						.hashCode());
		result = 37 * result
				+ (getCBatchcd() == null ? 0 : this.getCBatchcd().hashCode());
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
				+ (getDNumber() == null ? 0 : this.getDNumber().hashCode());
		result = 37
				* result
				+ (getNDrugstock() == null ? 0 : this.getNDrugstock()
						.hashCode());
		result = 37
				* result
				+ (getInstitution() == null ? 0 : this.getInstitution()
						.hashCode());
		result = 37 * result
				+ (getArea() == null ? 0 : this.getArea().hashCode());
		return result;
	}

}
