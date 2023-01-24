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

import com.examly.springapp.dao.IBloodDonorModel;
import com.examly.springapp.model.BloodDonorModel;


@RestController
public class BloodDonorModelController {
	
	@Autowired
	IBloodDonorModel iDonor;

	@GetMapping("/donor")
	public List<BloodDonorModel> getAllMovie(){
		return iDonor.findAll();
	}
	
	/*@GetMapping("/donor/{bloodGroup}")
	public List<BloodDonorModel> searchDonor(@PathVariable("bloodGroup") String bloodGroup) {
		return iDonor.findUserByGroup(bloodGroup);
	}*/
	
	@GetMapping("/donor/{id}")
	public BloodDonorModel getMovie(@PathVariable("id") int id) {
		try {
			Optional<BloodDonorModel> donor= iDonor.findById(id);
			if(donor.isEmpty()) return null;
			return donor.get();
			
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping("/admin/donor")
	public String addMovie(@RequestBody BloodDonorModel donor) {
		try {
			iDonor.save(donor);
			return "Donor added";
		} catch (Exception e) {
			//e.printStackTrace();
			return "Donor already exist";
		}
		
	}
	
	@DeleteMapping("/admin/donor/{id}")
	public String deleteMovie(@PathVariable("id") int id) {
		iDonor.deleteById(id);
		return "Donor Removed";
	}
	
	@PutMapping("/admin/donor/{id}")
	public String updateMovie(@PathVariable("id") int id,@RequestBody BloodDonorModel donor) {
		try {
			Optional<BloodDonorModel> donorObtained=iDonor.findById(id);
			if(donorObtained.isEmpty()) return null;
			donorObtained.map(m->{
			    m.setBloodGroup(donor.getBloodGroup());
			    m.setBloodPressure(donor.getBloodPressure());
			    m.setDonorEmail(donor.getDonorEmail());
			    m.setPhlevel(donor.getPhlevel());
			    m.setActive(donor.isActive());
				return iDonor.save(m);
			});
			return "Donor Updated";
		} catch (Exception e) {
			return null;
		}
	}
}
