package com.food.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.model.Notification;
import com.food.model.Order;
import com.food.model.Restaurant;
import com.food.model.User;
import com.food.repository.NotificationRepository;

@Service
public class NotificationServiceImplementation implements NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	@Override
	public Notification sendOrderStatusNotification(Order order) {
		Notification notification = new Notification();
		notification.setMessage("your order is "+order.getOrderStatus()+ " order id is - "+order.getId());
		notification.setCustomer(order.getCustomer());
		notification.setSentAt(new Date());
		
		return notificationRepository.save(notification);
	}

	@Override
	public void sendRestaurantNotification(Restaurant restaurant, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendPromotionalNotification(User user, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Notification> findUsersNotification(Long userId) {
		// TODO Auto-generated method stub
		return notificationRepository.findByCustomerId(userId);
	}

}
