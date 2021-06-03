package com.cognizant.bustravels.bean;
import java.time.*;
public class Payments {

	private int payment_id;
	private String email_id;
	private int bus_id;
	private String coupon_name;
	private int total_price;
	private int no_of_passengers;
	private LocalDate payment_date;
	private String payment_status;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getNo_of_passengers() {
		return no_of_passengers;
	}
	public void setNo_of_passengers(int no_of_passengers) {
		this.no_of_passengers = no_of_passengers;
	}
	public LocalDate getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(LocalDate payment_date) {
		this.payment_date = payment_date;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	@Override
	public String toString() {
		return "Payments [payment_id=" + payment_id + ", email_id=" + email_id + ", bus_id=" + bus_id + ", coupon_name="
				+ coupon_name + ", total_price=" + total_price + ", no_of_passengers=" + no_of_passengers
				+ ", payment_date=" + payment_date + ", payment_status=" + payment_status + "]";
	}
	
}
