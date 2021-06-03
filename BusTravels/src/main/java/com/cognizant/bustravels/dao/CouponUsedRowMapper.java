package com.cognizant.bustravels.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.bustravels.bean.CouponUsed;

public class CouponUsedRowMapper implements RowMapper<CouponUsed> {

	@Override
	public CouponUsed mapRow(ResultSet rs, int rowNum) throws SQLException {
		CouponUsed couponUsed = new CouponUsed();
		couponUsed.setEmail_id(rs.getString(1));
		couponUsed.setCoupon_name(rs.getString(2));
		return couponUsed;
	}

}