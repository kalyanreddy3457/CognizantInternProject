package com.cognizant.bustravels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bustravels.bean.BusDetails;
import com.cognizant.bustravels.exception.BusException;
import com.cognizant.bustravels.exception.UserException;
import com.cognizant.bustravels.service.BusService;

@CrossOrigin
@RestController
public class CustomerController {
	
	@Autowired
	BusService busService;
	@GetMapping("/searchBus/{source}/{destination}/{no_of_seats}")
	public ResponseEntity<List<BusDetails>> serachBus(@PathVariable String source,@PathVariable String destination,@PathVariable int no_of_seats)throws BusException
	{
		return new ResponseEntity<List<BusDetails>>(busService.searchBus(source,destination,no_of_seats),HttpStatus.OK);
	}
    @ExceptionHandler(BusException.class)
	public ResponseEntity<Object> Exception1(Exception ex)
	{
		System.out.println(ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(UserException.class)
	public ResponseEntity<Object> Exception(Exception ex)
	{
		System.out.println(ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}

}
