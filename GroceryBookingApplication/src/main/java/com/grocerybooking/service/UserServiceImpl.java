package com.grocerybooking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grocerybooking.model.Order;
import com.grocerybooking.model.OrderItem;
import com.grocerybooking.model.User;
import com.grocerybooking.repository.OrderRepository;
import com.grocerybooking.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private OrderRepository orderRepository;

	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User  not found"));
	}

	@Override
	public Order bookGroceryItems(Long userId, List<OrderItem> orderItems) {
		User user = userRepository.findById(userId).orElseThrow();
	    Order order = new Order();
	    order.setUser (user);
	    order.setOrderItems(orderItems);
	    return orderRepository.save(order);
	}

	
}
