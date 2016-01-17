package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

public class ReceiverInfo extends BaseRequestDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String receiverId;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String phoneNumber1;
	
	private String phoneNumber2;
	
	private LocationDTO location;
	
	public ReceiverInfo(){
		
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	
	public LocationDTO getLocation(){
		return this.location;
	}
	
	public void setLocation(LocationDTO location){
		this.location = location;
	}

}
