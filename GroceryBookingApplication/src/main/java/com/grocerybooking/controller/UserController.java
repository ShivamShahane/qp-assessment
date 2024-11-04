package com.grocerybooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.grocerybooking.model.Order;
import com.grocerybooking.model.OrderItem;
import com.grocerybooking.model.User;
import com.grocerybooking.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
    private UserServiceImpl userServiceImpl;

	
    @PostMapping("/users")
    public ResponseEntity<User> registerUser (@RequestBody User user) {
        return new ResponseEntity<>(userServiceImpl.registerUser (user), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUsers() {
    	 List<User> users = userServiceImpl.getAllUsers();
         return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @GetMapping("/get-user-byId/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
    	User user = userServiceImpl.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    
    @PostMapping("/orders")
    public ResponseEntity<Order> bookGroceryItems(@RequestParam Long userId, @RequestBody List<OrderItem> orderItems) {
        Order order = userServiceImpl.bookGroceryItems(userId, orderItems);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

}
