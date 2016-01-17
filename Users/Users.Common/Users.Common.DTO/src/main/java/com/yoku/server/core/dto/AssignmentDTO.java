package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseDTO;

public class AssignmentDTO extends BaseDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String title;
	
	private DateInfo createdOn;
	
	private DateInfo expiresOn;
	
	private String icon;
	
	private SenderInfo sender;
	
	private ReceiverInfo receiver;
	
	private ParcelInfo parcel;
	
	public AssignmentDTO(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DateInfo getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(DateInfo createdOn) {
		this.createdOn = createdOn;
	}

	public DateInfo getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(DateInfo expiresOn) {
		this.expiresOn = expiresOn;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public SenderInfo getSender() {
		return sender;
	}

	public void setSender(SenderInfo sender) {
		this.sender = sender;
	}

	public ReceiverInfo getReceiver() {
		return receiver;
	}

	public void setReceiver(ReceiverInfo receiver) {
		this.receiver = receiver;
	}

	public ParcelInfo getParcel() {
		return parcel;
	}

	public void setParcel(ParcelInfo parcel) {
		this.parcel = parcel;
	}

}
