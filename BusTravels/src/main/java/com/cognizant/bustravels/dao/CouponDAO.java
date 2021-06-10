package com.cognizant.bustravels.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.bustravels.bean.Coupon;
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
			if(jdbcTemplate.update(sql1,email_id,couponUsed.getCoupon_name())>0)
			{
			return "Coupon appiled";
			}
			else
			{
				throw new CouponException("Coupon not appiled");
			}
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
	public boolean addUser(Coupon coupon) throws CouponException {
		try
		{
		String sql="insert into coupon values(?,?)";
		return jdbcTemplate.update(sql,coupon.getCoupon_name(),coupon.getPrice())>0;
		}
		catch(DuplicateKeyException e)
		{
			throw new CouponException("Coupon is already added");
		}
	}

	public List<Coupon> viewCoupon()  throws CouponException {
		String sql="select * from coupon";
		return jdbcTemplate.query(sql,new CouponRowMapper());
	}

	public boolean deleteCoupon(String coupon_name) throws CouponException {
		String sql="delete from coupon where coupon_name=?";
		if(jdbcTemplate.update(sql,coupon_name)>0)
		return true;
		else
			throw new CouponException("Coupon is already deleted"); 
	}

	public boolean updateCoupon(Coupon coupon, String coupon_name) throws CouponException {
		try
		{
		String sql="update coupon set price=? where coupon_name = ? ";
		return jdbcTemplate.update(sql,coupon.getPrice(),coupon_name)>0;
		}
		catch(DataAccessException e)
		{
			throw new CouponException("Coupon price is same as before");
		}
	}

}
