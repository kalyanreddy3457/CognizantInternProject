package com.cognizant.bustravels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bustravels.bean.Coupon;
import com.cognizant.bustravels.bean.CouponUsed;
import com.cognizant.bustravels.dao.CouponDAO;
import com.cognizant.bustravels.exception.CouponException;

@Service
public class CouponService implements ICouponService{

	@Autowired
	CouponDAO coupondao;
	
	public String applyCoupon(String email_id,CouponUsed couponUsed)throws CouponException
	{
		return coupondao.applyCoupon(email_id,couponUsed);
	}
	public boolean addCoupon(Coupon coupon) throws CouponException {
		
		return coupondao.addUser(coupon);
	}
	
	public List<Coupon> viewCoupon() throws CouponException{
		return coupondao.viewCoupon();
	}

	public boolean deleteCoupon(String coupon_name) throws CouponException {
		return coupondao.deleteCoupon(coupon_name);
	}

	public boolean updateCoupon(Coupon coupon, String coupon_name) throws CouponException {
		return coupondao.updateCoupon(coupon, coupon_name);
	}
}
