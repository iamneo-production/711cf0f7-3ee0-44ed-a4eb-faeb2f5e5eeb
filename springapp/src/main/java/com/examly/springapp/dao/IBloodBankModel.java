package com.examly.springapp.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.BloodBankModel;


public interface IBloodBankModel extends JpaRepository<BloodBankModel, Integer> { 
	 
	 
		/* @Query("select b from BloodBankModel b where b.bloodGroup = :bloodGroup")
		List<BloodBankModel> findUserByGroup(@Param("bloodGroup") String bloodGroup); */
}