package com.grocerybooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocerybooking.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
