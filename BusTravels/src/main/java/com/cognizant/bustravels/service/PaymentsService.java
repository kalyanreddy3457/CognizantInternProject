package com.cognizant.bustravels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bustravels.bean.Payments;
import com.cognizant.bustravels.dao.PaymentsDAO;
import com.cognizant.bustravels.exception.PaymentsException;

@Service
public class PaymentsService implements IPaymentsService{

	@Autowired
	PaymentsDAO paymentsdao;
	
	public String makePayment(Payments payment)throws PaymentsException
	{
		return paymentsdao.makePayment(payment);
	}
	public String cancelPayment(int payment_id)throws PaymentsException
	{
		return paymentsdao.cancelPayment(payment_id);
	}
}
