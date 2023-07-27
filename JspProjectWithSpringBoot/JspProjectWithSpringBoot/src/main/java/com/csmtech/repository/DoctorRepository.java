package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.csmtech.entity.Doctor;
import com.csmtech.entity.Hospital;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

	@Query("FROM Doctor where hospitalId.hospitalId=:hospitalId")
	List<Doctor> getDoctorList(Integer hospitalId);

	List<Doctor> findByHospitalId(Hospital hosp);
}
