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
import com.cognizant.bustravels.bean.Coupon;
import com.cognizant.bustravels.bean.Issues;
import com.cognizant.bustravels.exception.BusException;
import com.cognizant.bustravels.exception.CouponException;
import com.cognizant.bustravels.exception.UserException;
import com.cognizant.bustravels.service.BusService;
import com.cognizant.bustravels.service.CouponService;
import com.cognizant.bustravels.service.IssuesService;


@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	BusService busService;
	@Autowired
    IssuesService issuesService;
	@Autowired
	CouponService couponService;
	
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
	@GetMapping("/viewAllBus")
	public ResponseEntity<List<BusDetails>> viewAllBus()throws BusException
	{
		return new ResponseEntity<List<BusDetails>>(busService.viewAllBus(),HttpStatus.OK);
	}
	@GetMapping("/viewBuses/{bus_id}")
	public ResponseEntity<List<BusDetails>> viewBuses(@PathVariable int bus_id)throws BusException
	{
		return new ResponseEntity<List<BusDetails>>(busService.viewBuses(bus_id),HttpStatus.OK);
	}
    @GetMapping("/displayIssues")
	public ResponseEntity<List<Issues>> displayIssues()
	{
		return new ResponseEntity<List<Issues>>(issuesService.displayIssues(),HttpStatus.OK);
	}
	@PostMapping("/addCoupon")
	public ResponseEntity<String> addCoupon(@RequestBody Coupon coupon)throws CouponException{
	    	
	    	if(couponService.addCoupon(coupon))
	    	{
	    		return new ResponseEntity<String>("Coupon is added",HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<String>("Coupon is not added",HttpStatus.NOT_FOUND);
	    	}
	    	
	 }
	 
	 @GetMapping("/viewCoupon")
	    public ResponseEntity<List<Coupon>> viewCoupon()throws CouponException{
	    	
	   		return new ResponseEntity<List<Coupon>>(couponService.viewCoupon(),HttpStatus.OK);
	    	
	    }
	 
	 @DeleteMapping("/deleteCoupon/{coupon_name}")
	    public ResponseEntity<String> deleteCoupon(@PathVariable String coupon_name)throws CouponException{
		 if(couponService.deleteCoupon(coupon_name))
	    	{
	    		return new ResponseEntity<String>("coupon is deleted",HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<String>("coupon is not deleted",HttpStatus.NOT_FOUND);
	    	}
	 }
	 
	 @PutMapping("/updateCoupon/{coupon_name}")
	 public ResponseEntity<String> updateCoupon( @RequestBody Coupon coupon,@PathVariable String coupon_name)throws CouponException{
	    	
	    	if(couponService.updateCoupon( coupon,coupon_name))
	    	{
	    		
	    		return new ResponseEntity<String>("Coupon price is changed",HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<String>("Coupon price is not changed",HttpStatus.NOT_FOUND);
	    	}
	    	
	    }

    @ExceptionHandler(CouponException.class)
	public ResponseEntity<Object> Exception6(Exception ex)
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
    @ExceptionHandler(BusException.class)
	public ResponseEntity<Object> Exception1(Exception ex)
	{
		System.out.println(ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}
