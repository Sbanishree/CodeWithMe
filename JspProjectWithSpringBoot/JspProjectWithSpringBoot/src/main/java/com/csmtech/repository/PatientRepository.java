package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.entity.Doctor;
import com.csmtech.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

	List<Patient> findByDoctorIdAndStatus(Doctor doc, String status);

	Patient findByPatientId(Integer pId);

}
