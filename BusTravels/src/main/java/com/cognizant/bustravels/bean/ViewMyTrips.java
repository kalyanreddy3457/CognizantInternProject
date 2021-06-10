package com.cognizant.bustravels.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ViewMyTrips {
	private int payment_id;
	private Date payment_date;
	private String bus_name;
	private String bus_source;
	private String bus_destination;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
	private Date start_time;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
	private Date end_time;
	private int total_price;
	private int no_of_passengers;
	private String payment_status;
	
   
	@Override
	public String toString() {
		return "ViewMyTrips [payment_id=" + payment_id + ", payment_date=" + payment_date + ", bus_name=" + bus_name
				+ ", bus_source=" + bus_source + ", bus_destination=" + bus_destination + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", total_price=" + total_price + ", no_of_passengers=" + no_of_passengers
				+ ", payment_status=" + payment_status + "]";
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public String getBus_name() {
		return bus_name;
	}
	public void setBus_name(String bus_name) {
		this.bus_name = bus_name;
	}
	public String getBus_source() {
		return bus_source;
	}
	public void setBus_source(String bus_source) {
		this.bus_source = bus_source;
	}
	public String getBus_destination() {
		return bus_destination;
	}
	public void setBus_destination(String bus_destination) {
		this.bus_destination = bus_destination;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
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
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	

}
