package com.cognizant.bustravels.bean;
import java.sql.Time;
public class BusDetails {

	private int bus_id;
	private String bus_name;
	private String bus_source;
	private String bus_destination;
	private Time start_time;
	private Time end_time;
	private String journey_time;
	private int price;
	private String amenities;
	private String pick_point;
	private String drop_point;
	private int no_of_seats_available;
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
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
	public Time getStart_time() {
		return start_time;
	}
	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}
	public Time getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}
	public String getJourney_time() {
		return journey_time;
	}
	public void setJourney_time(String journey_time) {
		this.journey_time = journey_time;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	public String getPick_point() {
		return pick_point;
	}
	public void setPick_point(String pick_point) {
		this.pick_point = pick_point;
	}
	public String getDrop_point() {
		return drop_point;
	}
	public void setDrop_point(String drop_point) {
		this.drop_point = drop_point;
	}
	public int getNo_of_seats_available() {
		return no_of_seats_available;
	}
	public void setNo_of_seats_available(int no_of_seats_available) {
		this.no_of_seats_available = no_of_seats_available;
	}
	@Override
	public String toString() {
		return "BusDetails [bus_id=" + bus_id + ", bus_name=" + bus_name + ", bus_source=" + bus_source
				+ ", bus_destination=" + bus_destination + ", start_time=" + start_time + ", end_time=" + end_time
				+ ", journey_time=" + journey_time + ", price=" + price + ", amenities=" + amenities + ", pick_point="
				+ pick_point + ", drop_point=" + drop_point + ", no_of_seats_available=" + no_of_seats_available + "]";
	}
	
}
