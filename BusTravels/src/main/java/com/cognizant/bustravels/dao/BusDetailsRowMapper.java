package com.cognizant.bustravels.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.bustravels.bean.BusDetails;

public class BusDetailsRowMapper implements RowMapper<BusDetails>{

	@Override
	public BusDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		BusDetails busDetails = new BusDetails();
		
		busDetails.setBus_id(rs.getInt(1));
		busDetails.setBus_name(rs.getString(2));
		busDetails.setBus_source(rs.getString(3));
		busDetails.setBus_destination(rs.getString(4));
		busDetails.setStart_time(rs.getTime(5));
		busDetails.setEnd_time(rs.getTime(6));
		busDetails.setJourney_time(rs.getString(7));
		busDetails.setPrice(rs.getInt(8));
		busDetails.setAmenities(rs.getString(9));
		busDetails.setPick_point(rs.getString(10));
		busDetails.setDrop_point(rs.getString(11));
		busDetails.setNo_of_seats_available(rs.getInt(12));
		
		return busDetails;
	}

}