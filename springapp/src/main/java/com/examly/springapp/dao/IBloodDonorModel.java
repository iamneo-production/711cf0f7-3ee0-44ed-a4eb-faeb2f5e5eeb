package com.examly.springapp.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.BloodDonorModel;

public interface IBloodDonorModel extends JpaRepository<BloodDonorModel, Integer> {

/*	@Query("select b from BloodDonorModel b where b.bloodGroup = :bloodGroup")
	List<BloodDonorModel> findUserByGroup(@Param("bloodGroup") String bloodGroup); */
}