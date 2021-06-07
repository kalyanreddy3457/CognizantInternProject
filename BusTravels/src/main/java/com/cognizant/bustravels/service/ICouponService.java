package com.cognizant.bustravels.service;

import java.util.List;

import com.cognizant.bustravels.bean.Coupon;
import com.cognizant.bustravels.bean.CouponUsed;
import com.cognizant.bustravels.exception.CouponException;

public interface ICouponService {

	public String applyCoupon(String email_id,CouponUsed couponUsed)throws CouponException;
	public boolean addCoupon(Coupon coupon) throws CouponException;
	public List<Coupon> viewCoupon() throws CouponException;
	public boolean deleteCoupon(String coupon_name) throws CouponException;
	public boolean updateCoupon(Coupon coupon, String coupon_name) throws CouponException;
}
