package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.entity.Doctor;
import com.csmtech.entity.Patient;
import com.csmtech.entity.PatientDetails;
import com.csmtech.repository.PatientDetailsRepository;
import com.csmtech.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientDetailsRepository patientDetailsRepository;

	@Override
	public List<Patient> getActivePatient(Integer doctorId, String status) {

		List<Patient> patientList = null;
		try {

			Doctor doc = new Doctor();
			doc.setDoctorId(doctorId);
			patientList = patientRepository.findByDoctorIdAndStatus(doc, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@Override
	public Patient getInsuranceByPatientId(Integer pId) {

		Patient patient = null;
		try {
			patient = patientRepository.findByPatientId(pId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

	@Override
	public PatientDetails saveData(PatientDetails patientDetails) {
		PatientDetails patientDetail=null;
		Patient patient = null;
		try {
			patient = patientRepository.findByPatientId(patientDetails.getPatientId().getPatientId());
			
			patientDetails.setInsuredAmount((patientDetails.getTotalExpenses()*patient.getInsuranceSchemeID().getInsurancePercentageCover())/100);
			patientDetails.setTotalPaybleAmount(patientDetails.getTotalExpenses()-patientDetails.getInsuredAmount());
			patientDetail=patientDetailsRepository.save(patientDetails);
			
			if(patientDetail!=null)
			{
				patient.setStatus("Inactive");
				patientRepository.save(patient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return patientDetail;
	}

}
