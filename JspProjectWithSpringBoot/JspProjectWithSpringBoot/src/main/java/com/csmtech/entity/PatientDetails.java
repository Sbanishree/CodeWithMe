package com.csmtech.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PatientDetails implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientDetailsId;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patientId;
	
	private Date admissionDate ;
	
	private Date dischargeDate;
	
	private Double totalExpenses;
	
	private Double insuredAmount;
	
	private Double totalPaybleAmount;

	public Integer getPatientDetailsId() {
		return patientDetailsId;
	}

	public void setPatientDetailsId(Integer patientDetailsId) {
		this.patientDetailsId = patientDetailsId;
	}

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public Double getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(Double totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	public Double getInsuredAmount() {
		return insuredAmount;
	}

	public void setInsuredAmount(Double insuredAmount) {
		this.insuredAmount = insuredAmount;
	}

	public Double getTotalPaybleAmount() {
		return totalPaybleAmount;
	}

	public void setTotalPaybleAmount(Double totalPaybleAmount) {
		this.totalPaybleAmount = totalPaybleAmount;
	}

	@Override
	public String toString() {
		return "PatientDetails [patientDetailsId=" + patientDetailsId + ", patientId=" + patientId + ", admissionDate="
				+ admissionDate + ", dischargeDate=" + dischargeDate + ", totalExpenses=" + totalExpenses
				+ ", insuredAmount=" + insuredAmount + ", totalPaybleAmount=" + totalPaybleAmount + "]";
	}

	
	
	
	
}
