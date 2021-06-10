package com.cognizant.bustravels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bustravels.bean.BusDetails;
import com.cognizant.bustravels.bean.ViewMyTrips;
import com.cognizant.bustravels.dao.BusDAO;
import com.cognizant.bustravels.exception.BusException;

@Service
public class BusService implements IBusService{

	@Autowired
	BusDAO busdao;
	
	public String addBus(BusDetails bus)throws BusException
	{
		return busdao.addBus(bus);
	}
	public String updateBus(BusDetails bus,int bus_id)throws BusException
	{
		return busdao.updateBus(bus,bus_id);
	}
	public String deleteBus(int bus_id)throws BusException
	{
		return busdao.deleteBus(bus_id);
	}
	public List<BusDetails> viewBus(String source,String destination)throws BusException
	{
		return busdao.viewBus(source,destination);
	}
	public List<BusDetails> searchBus(String source,String destination,int no_of_seats)throws BusException
	{
		return busdao.searchBus(source,destination,no_of_seats);
	}
	public List<ViewMyTrips> viewMyTrips(String email_id)throws BusException
	{
		return busdao.viewMyTrips(email_id);
	}
	public List<BusDetails> viewBuses(int bus_id) throws BusException {
		return busdao.viewBuses(bus_id);
	}
	public List<BusDetails> viewAllBus()throws BusException
	{
		return busdao.viewAllBus();
	}
}
