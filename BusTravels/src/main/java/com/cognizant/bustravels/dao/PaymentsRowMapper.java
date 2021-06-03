package com.cognizant.bustravels.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.bustravels.bean.Payments;

public class PaymentsRowMapper implements RowMapper<Payments> {

	@Override
	public Payments mapRow(ResultSet rs, int rowNum) throws SQLException {
		Payments payments = new Payments();
		payments.setPayment_id(rs.getInt(1));
		payments.setEmail_id(rs.getString(2));
		payments.setBus_id(rs.getInt(3));
		payments.setCoupon_name(rs.getString(4));
		payments.setTotal_price(rs.getInt(5));
		payments.setNo_of_passengers(rs.getInt(6));
		payments.setPayment_date(rs.getDate(7));
		payments.setPayment_status(rs.getString(8));
		return payments;
	}

}