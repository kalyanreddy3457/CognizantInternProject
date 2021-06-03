package com.cognizant.bustravels.bean;

public class CouponUsed {

	private String email_id;
	private String coupon_name;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	@Override
	public String toString() {
		return "CouponUsed [email_id=" + email_id + ", coupon_name=" + coupon_name + "]";
	}
	
}
