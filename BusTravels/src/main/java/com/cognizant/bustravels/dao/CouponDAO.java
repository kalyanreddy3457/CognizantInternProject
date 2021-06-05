package com.cognizant.bustravels.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.bustravels.bean.CouponUsed;
import com.cognizant.bustravels.exception.CouponException;

@Repository
public class CouponDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String applyCoupon(String email_id,CouponUsed couponUsed)throws CouponException
	{
		String sql="select * from coupon_used where email_id=? and coupon_name=?";
		List<CouponUsed> list=jdbcTemplate.query(sql,new CouponUsedRowMapper(),email_id,couponUsed.getCoupon_name());
		try
		{
		if(list.isEmpty())
		{
			String sql1="insert into coupon_used values(?,?)";
			jdbcTemplate.update(sql1,email_id,couponUsed.getCoupon_name());
			return "Coupon appiled";
		}
		else
		{
			throw new CouponException("Coupon already used");
		}
		}
		catch(DataAccessException e)
		{
			throw new CouponException("coupon name is invalid");
		}
	}

}
