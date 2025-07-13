package com.food.service;

import com.stripe.exception.StripeException;
import com.food.model.Order;
import com.food.model.PaymentResponse;

public interface PaymentService {
	
	public PaymentResponse generatePaymentLink(Order order) throws StripeException;

}
