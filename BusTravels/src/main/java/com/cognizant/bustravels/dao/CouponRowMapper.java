package com.cognizant.bustravels.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.bustravels.bean.Coupon;


public class CouponRowMapper implements RowMapper<Coupon>{

	@Override
	public Coupon mapRow(ResultSet rs, int rowNum) throws SQLException {
		Coupon coupon = new Coupon();
		coupon.setCoupon_name(rs.getString(1));
		coupon.setPrice(rs.getInt(2));
		return coupon;
	}
	

}