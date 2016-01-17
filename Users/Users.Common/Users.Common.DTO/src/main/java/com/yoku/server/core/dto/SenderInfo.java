package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

public class SenderInfo extends BaseRequestDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String senderId;
	
	private String firstName;
	
	private String lastName;
	
	private String companyName;
	
	private String companyAddress;
	
	private String companyRegistration;
	
	private String companyPhoneNumber1;
	
	private String companyPhoneNumber2;
	
	private LocationDTO location;
	
	public SenderInfo(){
		
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyRegistration() {
		return companyRegistration;
	}

	public void setCompanyRegistration(String companyRegistration) {
		this.companyRegistration = companyRegistration;
	}

	public String getCompanyPhoneNumber1() {
		return companyPhoneNumber1;
	}

	public void setCompanyPhoneNumber1(String companyPhoneNumber1) {
		this.companyPhoneNumber1 = companyPhoneNumber1;
	}

	public String getCompanyPhoneNumber2() {
		return companyPhoneNumber2;
	}

	public void setCompanyPhoneNumber2(String companyPhoneNumber2) {
		this.companyPhoneNumber2 = companyPhoneNumber2;
	}
	
	public LocationDTO getLocation(){
		return this.location;
	}
	
	public void setLocation(LocationDTO location){
		this.location = location;
	}
	
}
