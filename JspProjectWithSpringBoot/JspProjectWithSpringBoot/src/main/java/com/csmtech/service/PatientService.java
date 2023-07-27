package com.csmtech.service;

import java.util.List;

import com.csmtech.entity.Patient;
import com.csmtech.entity.PatientDetails;

public interface PatientService {

	List<Patient> getActivePatient(Integer doctorId,String status);

	Patient getInsuranceByPatientId(Integer pId);

	PatientDetails saveData(PatientDetails patientDetails);

}
