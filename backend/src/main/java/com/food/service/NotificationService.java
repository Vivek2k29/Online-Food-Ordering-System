package com.food.service;

import java.util.List;

import com.food.model.Notification;
import com.food.model.Order;
import com.food.model.Restaurant;
import com.food.model.User;

public interface NotificationService {
	
	public Notification sendOrderStatusNotification(Order order);
	public void sendRestaurantNotification(Restaurant restaurant, String message);
	public void sendPromotionalNotification(User user, String message);
	
	public List<Notification> findUsersNotification(Long userId);

}
