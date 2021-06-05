package com.cognizant.bustravels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
