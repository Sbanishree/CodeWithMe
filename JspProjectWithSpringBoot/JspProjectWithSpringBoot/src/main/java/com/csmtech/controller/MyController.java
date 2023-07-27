package com.csmtech.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.csmtech.entity.Doctor;
import com.csmtech.entity.Hospital;
import com.csmtech.entity.Patient;
import com.csmtech.entity.PatientDetails;
import com.csmtech.service.DoctorService;
import com.csmtech.service.HospitalService;
import com.csmtech.service.PatientService;

@Controller
public class MyController {

	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private PatientService patientService;

	@RequestMapping("/view")
	public String view(Model model) {

		List<Hospital> hospitalList = null;
		try {

			hospitalList = hospitalService.getAllHospital();
			model.addAttribute("hospitalList", hospitalList);
			System.out.println("MyPageeeeeeeeeeee");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "MyPage";

	}

	@ResponseBody
	@RequestMapping("/getDoctorByHospitalId")
	public List<Doctor> getDoctorByHospitalId(@RequestParam("hospId") Integer hospId) {

		List<Doctor> doctorList = null;
		try {

			doctorList = doctorService.getDoctorByHospitalId(hospId);
			// model.addAttribute("hospitalList", hospitalList);
			System.out.println("MyPageeeeeeeeeeee");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return doctorList;

	}

	@ResponseBody
	@RequestMapping("/getActivePatientByDocId")
	public List<Patient> getActivePatientByDoctorId(@RequestParam("docId") Integer doctorId) {
		List<Patient> patientList = null;
		try {
			patientList = patientService.getActivePatient(doctorId, "Active");
			System.out.println(patientList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientList;

	}

	@ResponseBody
	@RequestMapping("/getInsuranceByPatientId")
	public Patient getInsuranceByPatientId(@RequestParam("patientId") Integer pId) {

		Patient p = null;
		try {
			p = patientService.getInsuranceByPatientId(pId);
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@PostMapping("/saveData")
	public String saveData(@RequestParam("hospitalId") Integer hospitalId, @RequestParam("doctorId") Integer doctorId,
			@RequestParam("patientId") Patient patientId,
			@RequestParam("admissionDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date addmissionDate,
			@RequestParam("dischargeDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date dischargeDate,
			@RequestParam("expensesId") Double expenses,RedirectAttributes res) {
		PatientDetails patientDetails = null;

		try {
			patientDetails = new PatientDetails();
			patientDetails.setAdmissionDate(addmissionDate);
			patientDetails.setDischargeDate(dischargeDate);
			patientDetails.setTotalExpenses(expenses);
			patientDetails.setPatientId(patientId);
			PatientDetails pd = patientService.saveData(patientDetails);
		    if(pd!=null)
		    {
		    	
		    	res.addFlashAttribute("msg", "Data Saved Successfully");
		    }
		    else
		    {
		    	res.addFlashAttribute("msg", "Data not Saved ");
		    }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/view";
	}

}
