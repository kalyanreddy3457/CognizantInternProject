package com.cognizant.bustravels.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.bustravels.bean.BusDetails;
import com.cognizant.bustravels.exception.BusException;

@Repository
public class BusDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public String addBus(BusDetails bus)throws BusException
	{
		String sql="insert into bus_details (bus_name,bus_source,bus_destination,start_time,end_time,journey_time,price,amenities,pick_point,drop_point,no_of_seats_available) values(?,?,?,?,?,?,?,?,?,?,?)";
	    if(jdbcTemplate.update(sql,bus.getBus_name(),bus.getBus_source(),bus.getBus_destination(),bus.getStart_time(),bus.getEnd_time(),bus.getJourney_time(),bus.getPrice(),bus.getAmenities(),bus.getPick_point(),bus.getDrop_point(),bus.getNo_of_seats_available())>0)
	    	return "added Succesfully";
	    else
	    	throw new BusException("bus details added already");
	}
	public String updateBus(BusDetails bus,int bus_id)throws BusException
	{
		String sql="update bus_details set bus_name=?,bus_source=?,bus_destination=?,start_time=?,end_time=?,journey_time=?,price=?,amenities=?,pick_point=?,drop_point=?,no_of_seats_available=? where bus_id=?";
		if(jdbcTemplate.update(sql,bus.getBus_name(),bus.getBus_source(),bus.getBus_destination(),bus.getStart_time(),bus.getEnd_time(),bus.getJourney_time(),bus.getPrice(),bus.getAmenities(),bus.getPick_point(),bus.getDrop_point(),bus.getNo_of_seats_available(),bus_id)>0)
		{
			return "updated successfully";
		}
		else
		{
			throw new BusException("update failed");
		}
	}
	public String deleteBus(int bus_id)throws BusException
	{
		String sql="delete from bus_details where bus_id=?";
		if(jdbcTemplate.update(sql,bus_id)>0)
		{
			return "deleted Successfully";
		}
		else
		{
			throw new BusException("Bus_id is not available");
		}
	}
	public List<BusDetails> viewBus(String source,String destination)throws BusException
	{
		String sql="select * from bus_details where bus_source=? and bus_destination=?";
		try
		{
			List<BusDetails> list=jdbcTemplate.query(sql,new BusDetailsRowMapper(),source,destination);
			if(list.isEmpty())
			{
				throw new BusException("NO Buses available for this source and destination");
			}
			else
				return list;
		}
		catch(DataAccessException e)
		{
			throw new BusException("Input fields are wrong");
		}
	}
	public List<BusDetails> searchBus(String source,String destination,int no_of_seats)throws BusException
	{
		String sql="select * from bus_details where bus_source=? and bus_destination=? and no_of_seats_available>=?";
		try
		{
			List<BusDetails> list=jdbcTemplate.query(sql,new BusDetailsRowMapper(),source,destination,no_of_seats);
			if(list.isEmpty())
			{
				throw new BusException("NO Buses available for this source and destination");
			}
			else
				return list;
		}
		catch(DataAccessException e)
		{
			throw new BusException("Input fields are wrong");
		}
	}
	public List<BusDetails> viewMyTrips(String email_id)throws BusException
	{
		String sql="select * from bus_details where bus_id in (select bus_id from payments where email_id=?)";
		try
		{
		List<BusDetails> list=jdbcTemplate.query(sql,new BusDetailsRowMapper(),email_id);
		if(list.isEmpty())
		{
			throw new BusException("no trips are made....");
		}
		else
			return list;
		}
		catch(DataAccessException e)
		{
			throw new BusException("check the email_id");
		}
	}
	public List<BusDetails> viewBuses(int bus_id)throws BusException
	{
		String sql="select * from bus_details where bus_id=?";
		try
		{
			List<BusDetails> list=jdbcTemplate.query(sql,new BusDetailsRowMapper(),bus_id);
			if(list.isEmpty())
			{
				throw new BusException("No Bus is available with bus_id");
			}
			else
				return list;
		}
		catch(DataAccessException e)
		{
			throw new BusException("bus_id is invalid");
		}
	}
}
