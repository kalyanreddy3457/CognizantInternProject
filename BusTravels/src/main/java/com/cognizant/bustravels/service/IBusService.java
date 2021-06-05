package com.cognizant.bustravels.service;

import java.util.List;

import com.cognizant.bustravels.bean.BusDetails;
import com.cognizant.bustravels.exception.BusException;

public interface IBusService {

	public String addBus(BusDetails bus)throws BusException;
	public String updateBus(BusDetails bus,int bus_id)throws BusException;
	public String deleteBus(int bus_id)throws BusException;
	public List<BusDetails> viewBus(String source,String destination)throws BusException;
	public List<BusDetails> searchBus(String source,String destination,int no_of_seats)throws BusException;
	public List<BusDetails> viewMyTrips(String email_id)throws BusException;
}
