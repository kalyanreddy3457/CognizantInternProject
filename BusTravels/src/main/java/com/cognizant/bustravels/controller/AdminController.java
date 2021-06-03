package com.cognizant.bustravels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bustravels.bean.BusDetails;
import com.cognizant.bustravels.exception.BusException;
import com.cognizant.bustravels.exception.UserException;
import com.cognizant.bustravels.service.BusService;


@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	BusService busService;
	
	@PostMapping("/addBus")
	public ResponseEntity<String> addBus(@RequestBody BusDetails bus)throws BusException
	{
		return new ResponseEntity<String>(busService.addBus(bus),HttpStatus.OK);
	}
	@PutMapping("/updateBus/{bus_id}")
	public ResponseEntity<String> updateBus(@RequestBody BusDetails bus,@PathVariable int bus_id)throws BusException
	{
		return new ResponseEntity<String>(busService.updateBus(bus,bus_id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteBus/{bus_id}")
	public ResponseEntity<String> deleteBus(@PathVariable int bus_id)throws BusException
	{
		return new ResponseEntity<String>(busService.deleteBus(bus_id),HttpStatus.OK);
	}
	@GetMapping("/viewBus/{source}/{destination}")
	public ResponseEntity<List<BusDetails>> viewBus(@PathVariable String source,@PathVariable String destination)throws BusException
	{
		return new ResponseEntity<List<BusDetails>>(busService.viewBus(source,destination),HttpStatus.OK);
	}
    @ExceptionHandler(UserException.class)
	public ResponseEntity<Object> Exception(Exception ex)
	{
		System.out.println(ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(BusException.class)
	public ResponseEntity<Object> Exception1(Exception ex)
	{
		System.out.println(ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}
