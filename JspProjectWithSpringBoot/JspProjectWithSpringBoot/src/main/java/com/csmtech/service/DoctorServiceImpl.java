package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.entity.Doctor;
import com.csmtech.entity.Hospital;
import com.csmtech.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	@Override
	public List<Doctor> getDoctorByHospitalId(Integer hospId) {
		
		List<Doctor> doctorList=null;
		try {
			
			// doctorList=doctorRepository.getDoctorList(hospId);  
			
			Hospital hosp = new Hospital();
			hosp.setHospitalId(hospId);
			doctorList=doctorRepository.findByHospitalId(hosp);
			
			System.err.println(doctorList+"***********************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorList;
	}

}
