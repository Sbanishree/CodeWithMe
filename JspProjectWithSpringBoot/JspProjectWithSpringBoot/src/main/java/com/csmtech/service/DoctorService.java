package com.csmtech.service;

import java.util.List;

import com.csmtech.entity.Doctor;

public interface DoctorService {

	List<Doctor> getDoctorByHospitalId(Integer hospId);

}
