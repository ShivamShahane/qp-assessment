package com.grocerybooking.service;

import java.util.List;

import com.grocerybooking.model.Order;
import com.grocerybooking.model.OrderItem;
import com.grocerybooking.model.User;

public interface UserService {

	
	public User registerUser (User user);
	
	public List<User> getAllUsers();
	
	public User getUserById(Long id);
	
	public Order bookGroceryItems(Long userId, List<OrderItem> orderItems);
	
}
