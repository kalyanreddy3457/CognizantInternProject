package com.cognizant.bustravels.bean;

public class Coupon {

	private String coupon_name;
	private int price;
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Coupon [coupon_name=" + coupon_name + ", price=" + price + "]";
	}
	
}
