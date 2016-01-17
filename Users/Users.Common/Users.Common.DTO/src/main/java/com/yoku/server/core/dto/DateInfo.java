package com.yoku.server.core.dto;

import com.yoku.server.framework.dto.BaseRequestDTO;

public class DateInfo extends BaseRequestDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer dayOfMonth;
	
	private Integer monthOfYear;
	
	private Integer year;
	
	private Integer hourOfDay;
	
	private Integer minuteOfHour;
	
	public DateInfo(){
		
	}

	public Integer getDayOfMonth() {
		return dayOfMonth;
	}


	public void setDayOfMonth(Integer dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}


	public Integer getMonthOfYear() {
		return monthOfYear;
	}


	public void setMonthOfYear(Integer monthOfYear) {
		this.monthOfYear = monthOfYear;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public Integer getHourOfDay() {
		return hourOfDay;
	}


	public void setHourOfDay(Integer hourOfDay) {
		this.hourOfDay = hourOfDay;
	}


	public Integer getMinuteOfHour() {
		return minuteOfHour;
	}


	public void setMinuteOfHour(Integer minuteOfHour) {
		this.minuteOfHour = minuteOfHour;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
