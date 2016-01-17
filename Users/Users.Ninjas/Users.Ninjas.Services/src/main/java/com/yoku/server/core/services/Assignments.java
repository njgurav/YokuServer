package com.yoku.server.core.services;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.yoku.server.core.db.MySQLDbHelper;
import com.yoku.server.core.dto.AssignmentDTO;
import com.yoku.server.core.dto.AvailableAssignmentRequestDTO;
import com.yoku.server.core.dto.AvailableAssignmentResponseDTO;
import com.yoku.server.core.dto.DateInfo;
import com.yoku.server.core.dto.Dimension;
import com.yoku.server.core.dto.LocationDTO;
import com.yoku.server.core.dto.ParcelInfo;
import com.yoku.server.core.dto.ReceiverInfo;
import com.yoku.server.core.dto.SenderInfo;

public class Assignments {
	
	private static final Logger logger = Logger.getLogger(Assignments.class.getName());
	
	private static final String QUERY_FETCH_ASSIGNMENTS = "SELECT "
			+" a.id, a.title, a.createdOn, a.expiresOn, "
			+" b.id as senderId, b.companyName, b.companyAddress, b.phone1 as senderPhone, b.firstname as senderFirstName, b.lastname as senderLastName, "
			+" c.id as receiverId, c.firstName, c.lastName, c.address, c.phone1, "
			+" d.id as parcelId, d.parcelName, d.parcelDescription, d.weight, "
			+" e.width, e.height, e.length, "
			+" f.latitude as senderLatitude, f.longitude as senderLongitude, f.address as senderAddress, "
			+" g.latitude as receiverLatitude, g.longitude as receiverLongitude, g.address as receiverAddress "
			+" FROM"
			+" tbl_assignments a,"
			+" tbl_merchant_info b,"
			+" tbl_user_info c,"
			+" tbl_parcel_info d, "
			+" tbl_dimension_info e,"
			+" tbl_location_info f, "
			+" tbl_location_info g "
			+" WHERE f.latitude in" 
			+" ( SELECT latitude "
			+" FROM tbl_location_info"
			+" where (( 6371.39 * ACOS( COS( RADIANS( ? ) ) * COS( RADIANS( latitude ) ) * COS( RADIANS( longitude ) - RADIANS( ? ) ) + SIN( RADIANS( ? ) ) * SIN( RADIANS( latitude ) ) ) ) )< ?"
			+" )" 
			+" AND f.longitude in"  
			+" ( SELECT longitude "
			+" FROM tbl_location_info"
			+" where (( 6371.39 * ACOS( COS( RADIANS( ? ) ) * COS( RADIANS( latitude ) ) * COS( RADIANS( longitude ) - RADIANS( ? ) ) + SIN( RADIANS( ? ) ) * SIN( RADIANS( latitude ) ) ) ) )< ?"
			+" ) "
			+" AND b.location = f.id"
			+" AND d.dimension = e.parcelId"
			+" AND a.senderId = b.id"
			+" AND a.receiverId = c.id"
			+" AND a.parcelId = d.id"
			+" AND c.location = g.id"
			+" LIMIT 0 , 30";
	
	public AvailableAssignmentResponseDTO fetchAvailableAssignments(AvailableAssignmentRequestDTO request){
		
		if(logger.isLoggable(Level.INFO)){
			logger.log(Level.INFO, "Entered Service Assignments.fetchAvailableAssignments ");
		}
		AvailableAssignmentResponseDTO response = null;
		MySQLDbHelper dbHelper = new MySQLDbHelper();
		
		String[] params = new String[8];
		params[0] = String.valueOf(request.getLatitude());
		params[1] = String.valueOf(request.getLongitude());
		params[2] = String.valueOf(request.getLatitude());
		params[3] = "40.63";
		params[4] = String.valueOf(request.getLatitude());
		params[5] = String.valueOf(request.getLongitude());
		params[6] = String.valueOf(request.getLatitude());
		params[7] = "40.63";
		
		ResultSet dbResult = dbHelper.readData(QUERY_FETCH_ASSIGNMENTS, params);
		
		if(dbResult!=null){
			response = new AvailableAssignmentResponseDTO();
			AssignmentDTO[] assignments = null;
			try {
				dbResult.last();
				int count = dbResult.getRow();
				dbResult.beforeFirst();
				assignments = new AssignmentDTO[count];
				int counter = 0;
				while(dbResult.next()){
					
					Date createdOnDate = dbResult.getDate("createdOn");
					DateInfo createdOn = new DateInfo();
					createdOn.setDayOfMonth(createdOnDate.getDay());
					createdOn.setMonthOfYear(createdOnDate.getMonth()+1);
					createdOn.setYear((createdOnDate.getYear()-100) + 2000);
					//createdOn.setHourOfDay(createdOnDate.getHours());
					//createdOn.setMinuteOfHour(createdOnDate.getMinutes());
					
					Date expiresOnDate = dbResult.getDate("expiresOn");
					DateInfo expiresOn = new DateInfo();
					expiresOn.setDayOfMonth(expiresOnDate.getDay());
					expiresOn.setMonthOfYear(expiresOnDate.getMonth()+1);
					expiresOn.setYear((expiresOnDate.getYear()-100) + 2000);
					//expiresOn.setHourOfDay(expiresOnDate.getHours());
					//expiresOn.setMinuteOfHour(expiresOnDate.getMinutes());
					
					LocationDTO from = new LocationDTO();
					//from.setAddress(dbResult.getString("senderAddress"));
					from.setLatitude(Double.parseDouble(dbResult.getString("senderLatitude")));
					from.setLongitude(Double.parseDouble(dbResult.getString("senderLongitude")));
					
					LocationDTO to = new LocationDTO();
					//to.setAddress(dbResult.getString("receiverAddress"));
					to.setLatitude(Double.parseDouble(dbResult.getString("receiverLatitude")));
					to.setLongitude(Double.parseDouble(dbResult.getString("receiverLongitude")));
					
					SenderInfo senderInfo = new SenderInfo();
					senderInfo.setCompanyAddress(dbResult.getString("companyAddress"));
					senderInfo.setCompanyName(dbResult.getString("companyName"));
					senderInfo.setCompanyPhoneNumber1(dbResult.getString("senderPhone"));
					senderInfo.setFirstName(dbResult.getString("senderFirstName"));
					senderInfo.setLastName(dbResult.getString("senderLastName"));
					senderInfo.setLocation(from);
					senderInfo.setSenderId(dbResult.getString("senderId"));
					
					ReceiverInfo receiverInfo = new ReceiverInfo();
					receiverInfo.setFirstName(dbResult.getString("firstName"));
					receiverInfo.setLastName(dbResult.getString("lastName"));
					receiverInfo.setLocation(to);
					receiverInfo.setAddress(dbResult.getString("address"));
					receiverInfo.setPhoneNumber1(dbResult.getString("phone1"));
					receiverInfo.setReceiverId(dbResult.getString("receiverId"));
					
					Dimension dimension = new Dimension();
					dimension.setHeight(Float.parseFloat(dbResult.getString("height")));
					dimension.setWidth(Float.parseFloat(dbResult.getString("width")));
					dimension.setLength(Float.parseFloat(dbResult.getString("length")));
					
					ParcelInfo parcel = new ParcelInfo();
					parcel.setIsFragile(false);
					parcel.setIsInflammable(false);
					parcel.setParcelName(dbResult.getString("parcelName"));
					parcel.setWeight(Float.parseFloat(dbResult.getString("weight")));
					parcel.setParcelDescription(dbResult.getString("parcelDescription"));
					parcel.setDimension(dimension);
					parcel.setParcelId(dbResult.getString("parcelId"));
					
					assignments[counter] = new AssignmentDTO();
					assignments[counter].setCreatedOn(createdOn);
					assignments[counter].setExpiresOn(expiresOn);
					assignments[counter].setTitle(dbResult.getString("title"));
					assignments[counter].setParcel(parcel);
					assignments[counter].setReceiver(receiverInfo);
					assignments[counter].setSender(senderInfo);
					assignments[counter].setId(dbResult.getString("id"));
					counter++;
				}
				
				response.setAssignments(assignments);
			} catch (SQLException e) {
				if(logger.isLoggable(Level.SEVERE)){
					logger.log(Level.SEVERE, "Unable to iterate over the ResultSet received in Assignments.fetchAvailableAssignments", e);
				}
			} finally {
				try {
					dbResult.close();
				} catch (SQLException e) {
					if(logger.isLoggable(Level.SEVERE)){
						logger.log(Level.SEVERE, "Unable to close the ResultSet received in Assignments.fetchAvailableAssignments", e);
					}
				}
			}
		}
		if(logger.isLoggable(Level.INFO)){
			logger.log(Level.INFO, "Exiting Service Assignments.fetchAvailableAssignments ");
		}
		return response;
	}

}
