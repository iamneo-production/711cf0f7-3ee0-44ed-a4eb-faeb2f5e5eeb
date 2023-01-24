package com.examly.springapp.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.dao.IBloodBankModel;
import com.examly.springapp.model.BloodBankModel;



@RestController
public class BloodBankModelController {

	@Autowired
	IBloodBankModel iSample;
	
	@PostMapping("/admin/addSample")
	public String addSample(@RequestBody BloodBankModel sample) {
		iSample.save(sample);
		return "Sample Added";
	}
	

	
	@GetMapping("/sample")
	public List<BloodBankModel> getAllSample()
	{
		return iSample.findAll();
	}
	
	@PutMapping("/admin/sample/{bloodBankID}")
	public BloodBankModel updateSample(@PathVariable("bloodBankID") int bloodBankID,@RequestBody BloodBankModel donor) {
		try {
			Optional<BloodBankModel> donorObtained=iSample.findById(bloodBankID);
			if(donorObtained.isEmpty()) return null;
			donorObtained.map(m->{
			    m.setBloodGroup(donor.getBloodGroup());
			    m.setBloodPressure(donor.getBloodPressure());
			    m.setPhlevel(donor.getPhlevel());
			    m.setQuntity(donor.getQuntity());
				return iSample.save(m);
			});
			return donor;
		} catch (Exception e) {
			return null;
		}
	}
	
/*	@GetMapping("/sample/{bloodGroup}")
	public List<BloodBankModel> searchSample(@PathVariable("bloodGroup") String bloodGroup) {
		return iSample.findUserByGroup(bloodGroup); 
	} */
	
	@DeleteMapping("admin/sample/{bloodBankID}")
	public String cancelSample(@PathVariable("bloodBankID") int bloodBankID) {
		iSample.deleteById(bloodBankID);
		return "Sample deleted";
	}
	
	
}
