package com.food.service;

import java.util.List;

import com.stripe.exception.StripeException;
import com.food.Exception.CartException;
import com.food.Exception.OrderException;
import com.food.Exception.RestaurantException;
import com.food.Exception.UserException;
import com.food.model.Order;
import com.food.model.PaymentResponse;
import com.food.model.User;
import com.food.request.CreateOrderRequest;

public interface OrderService {
	
	 public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, StripeException;
	 
	 public Order updateOrder(Long orderId, String orderStatus) throws OrderException;
	 
	 public void cancelOrder(Long orderId) throws OrderException;
	 
	 public List<Order> getUserOrders(Long userId) throws OrderException;
	 
	 public List<Order> getOrdersOfRestaurant(Long restaurantId,String orderStatus) throws OrderException, RestaurantException;
	 

}
