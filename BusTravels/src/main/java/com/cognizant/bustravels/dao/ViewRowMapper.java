package com.cognizant.bustravels.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.bustravels.bean.ViewMyTrips;

public class ViewRowMapper implements RowMapper<ViewMyTrips>{

	@Override
	public ViewMyTrips mapRow(ResultSet rs, int rowNum) throws SQLException {
		ViewMyTrips view = new ViewMyTrips();
		view.setPayment_date(rs.getDate(1));
		view.setBus_name(rs.getString(2));
		view.setBus_source(rs.getString(3));
		view.setBus_destination(rs.getString(4));
		view.setStart_time(rs.getTime(5));
		view.setEnd_time(rs.getTime(6));
		view.setTotal_price(rs.getInt(7));
		view.setNo_of_passengers(rs.getInt(8));
		view.setPayment_status(rs.getString(9));
		view.setPayment_id(rs.getInt(10));
		return view;
	}
}
