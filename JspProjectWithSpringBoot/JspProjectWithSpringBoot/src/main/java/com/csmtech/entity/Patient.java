package com.csmtech.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Patient implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctorId;
	
	private String patientName;
	
	private String mobNo;
	
	@ManyToOne
	@JoinColumn(name="insurance_scheme_id")
	private InsuranceScheme insuranceSchemeID;
	
	private String status;

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Doctor getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Doctor doctorId) {
		this.doctorId = doctorId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public InsuranceScheme getInsuranceSchemeID() {
		return insuranceSchemeID;
	}

	public void setInsuranceSchemeID(InsuranceScheme insuranceSchemeID) {
		this.insuranceSchemeID = insuranceSchemeID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", doctorId=" + doctorId + ", patientName=" + patientName
				+ ", mobNo=" + mobNo + ", insuranceSchemeID=" + insuranceSchemeID + ", status=" + status + "]";
	}
	
	
}
