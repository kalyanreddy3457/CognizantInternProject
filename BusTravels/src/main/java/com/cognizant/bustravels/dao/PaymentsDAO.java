package com.cognizant.bustravels.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.bustravels.bean.Payments;
import com.cognizant.bustravels.exception.PaymentsException;

@Repository
public class PaymentsDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String makePayment(Payments payment)throws PaymentsException
	{
		String sql="insert into payments (email_id,bus_id,coupon_name,total_price,no_of_passengers,payment_date,payment_status) values(?,?,?,?,?,?,?)";
		if(jdbcTemplate.update(sql,payment.getEmail_id(),payment.getBus_id(),payment.getCoupon_name(),payment.getTotal_price(),payment.getNo_of_passengers(),payment.getPayment_date(),payment.getPayment_status())>0)
		{
			return "payment Successful";
		}
		else
		{
			throw new PaymentsException("payment failed");
		}
	}
	public String cancelPayment(int payment_id)throws PaymentsException
	{
	   String sql="update payments set payment_status='cancelled' where payment_id=?";
	   String sql2="select * from payments where payment_id=?";
	   List<Payments> list=jdbcTemplate.query(sql2,new PaymentsRowMapper(),payment_id);
	   if(jdbcTemplate.update(sql,payment_id)>0)
	   {
		   String sql1="update bus_details set no_of_seats_available=no_of_seats_available+? where bus_id=?";
		   for(Payments list1:list)
		   {
		   jdbcTemplate.update(sql1,list1.getNo_of_passengers(),list1.getBus_id());
		   }
		   return "cancelled successfully";
	   }
	   else
	   {
		   throw new PaymentsException("cancellation failed");
	   }
	}

}
