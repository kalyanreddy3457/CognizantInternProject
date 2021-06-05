package com.cognizant.bustravels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bustravels.bean.BusDetails;
import com.cognizant.bustravels.bean.CouponUsed;
import com.cognizant.bustravels.bean.Issues;
import com.cognizant.bustravels.bean.Payments;
import com.cognizant.bustravels.bean.User;
import com.cognizant.bustravels.exception.BusException;
import com.cognizant.bustravels.exception.CouponException;
import com.cognizant.bustravels.exception.IssuesException;
import com.cognizant.bustravels.exception.PaymentsException;
import com.cognizant.bustravels.exception.UserException;
import com.cognizant.bustravels.service.BusService;
import com.cognizant.bustravels.service.CouponService;
import com.cognizant.bustravels.service.IssuesService;
import com.cognizant.bustravels.service.PaymentsService;
import com.cognizant.bustravels.service.UserService;

@CrossOrigin
@RestController
public class CustomerController {
	
	@Autowired
	BusService busService;
	@Autowired
	PaymentsService paymentsService;
	@Autowired
	CouponService couponService;
	@Autowired
	UserService userService;
	@Autowired
    IssuesService issuesService;
	
	@GetMapping("/searchBus/{source}/{destination}/{no_of_seats}")
	public ResponseEntity<List<BusDetails>> serachBus(@PathVariable String source,@PathVariable String destination,@PathVariable int no_of_seats)throws BusException
	{
		return new ResponseEntity<List<BusDetails>>(busService.searchBus(source,destination,no_of_seats),HttpStatus.OK);
	}
	@GetMapping("/viewMyTrips/{email_id}")
	public ResponseEntity<List<BusDetails>> viewMyTrips(@PathVariable String email_id)throws BusException
	{
		return new ResponseEntity<List<BusDetails>>(busService.viewMyTrips(email_id),HttpStatus.OK);
	}
	@PostMapping("/makePayment")
	public ResponseEntity<String> makePayment(@RequestBody Payments payments)throws PaymentsException
	{
		return new ResponseEntity<String>(paymentsService.makePayment(payments),HttpStatus.OK);
	}
	@PutMapping("/cancelPayment/{payment_id}")
	public ResponseEntity<String> cancelPayment(@PathVariable int payment_id)throws PaymentsException
	{
		return new ResponseEntity<String>(paymentsService.cancelPayment(payment_id),HttpStatus.OK);
	}
	@PutMapping("/applyCoupon/{email_id}")
	public ResponseEntity<String> applyCoupon(@PathVariable String email_id,@RequestBody CouponUsed couponUsed)throws CouponException
	{
		return new ResponseEntity<String>(couponService.applyCoupon(email_id,couponUsed),HttpStatus.OK);
	}
	
    @PostMapping("/addIssues")
    public ResponseEntity<String> addCompany(@RequestBody Issues issues)throws IssuesException
    {
    	if(issuesService.addIssues(issues))
    	{
    		return new ResponseEntity<String>("Issue is added",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("Issue is not added",HttpStatus.NOT_FOUND);
    	}
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
    @ExceptionHandler(PaymentsException.class)
	public ResponseEntity<Object> Exception2(Exception ex)
	{
		System.out.println(ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(CouponException.class)
	public ResponseEntity<Object> Exception3(Exception ex)
	{
		System.out.println(ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(IssuesException.class)
	public ResponseEntity<Object> Exception4(Exception ex)
	{
		System.out.println(ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
    @PostMapping("/login")
    public ResponseEntity<String> verifyLogin(@RequestBody User user)throws UserException
    {
    	if(userService.verifyLogin(user))
    	{
    	return new ResponseEntity<String>("User is Valid",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("InValid User",HttpStatus.NOT_FOUND);
    	}
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> addUser(@RequestBody User user)throws UserException{
    	
    	if(userService.addUser(user))
    	{
    		return new ResponseEntity<String>("User is added",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("User is not added",HttpStatus.NOT_FOUND);
    	}
    	
    }

}
