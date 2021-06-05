package com.cognizant.bustravels.service;

import com.cognizant.bustravels.bean.CouponUsed;
import com.cognizant.bustravels.exception.CouponException;

public interface ICouponService {

	public String applyCoupon(String email_id,CouponUsed couponUsed)throws CouponException;
}
