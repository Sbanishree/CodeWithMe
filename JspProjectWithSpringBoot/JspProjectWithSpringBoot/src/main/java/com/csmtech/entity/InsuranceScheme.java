package com.csmtech.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class InsuranceScheme implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer insuranceSchemeId;
	
	@ManyToOne
	@JoinColumn(name="insurance_id")
	private Insurance insuranceId;
	
	private String insuranceSchemeName;
	
	private Double insurancePercentageCover;


	public Integer getInsuranceSchemeId() {
		return insuranceSchemeId;
	}

	public void setInsuranceSchemeId(Integer insuranceSchemeId) {
		this.insuranceSchemeId = insuranceSchemeId;
	}

	public Insurance getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Insurance insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getInsuranceSchemeName() {
		return insuranceSchemeName;
	}

	public void setInsuranceSchemeName(String insuranceSchemeName) {
		this.insuranceSchemeName = insuranceSchemeName;
	}

	public Double getInsurancePercentageCover() {
		return insurancePercentageCover;
	}

	public void setInsurancePercentageCover(Double insurancePercentageCover) {
		this.insurancePercentageCover = insurancePercentageCover;
	}
	
	@Override
	public String toString() {
		return "InsuranceScheme [insuranceSchemeId=" + insuranceSchemeId + ", insuranceId=" + insuranceId
				+ ", insuranceSchemeName=" + insuranceSchemeName + ", insurancePercentageCover="
				+ insurancePercentageCover + "]";
	}
	

}
