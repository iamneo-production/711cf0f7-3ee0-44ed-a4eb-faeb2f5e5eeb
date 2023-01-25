package com.examly.springapp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BloodBankModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bloodBankID;
	private String bloodGroup;
	private long phlevel;
	private int bloodPressure;
	private int quntity;

	public int getBloodBankID() {
		return bloodBankID;
	}

	public void setBloodBankID(int bloodBankID) {
		this.bloodBankID = bloodBankID;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public long getPhlevel() {
		return phlevel;
	}

	public void setPhlevel(long phlevel) {
		this.phlevel = phlevel;
	}

	public int getQuntity() {
		return quntity;
	}

	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}

}