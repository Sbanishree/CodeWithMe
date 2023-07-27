package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.entity.Hospital;
import com.csmtech.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepository;

	@Override
	public List<Hospital> getAllHospital() {
		List<Hospital> hospitalList = null;
		
		try {
			
			hospitalList =hospitalRepository.findAll(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hospitalList;
	}

}
