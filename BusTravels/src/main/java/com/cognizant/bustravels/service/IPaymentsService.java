package com.cognizant.bustravels.service;

import com.cognizant.bustravels.bean.Payments;
import com.cognizant.bustravels.exception.PaymentsException;

public interface IPaymentsService {

	public String makePayment(Payments payment)throws PaymentsException;
	public String cancelPayment(int payment_id)throws PaymentsException;
}
