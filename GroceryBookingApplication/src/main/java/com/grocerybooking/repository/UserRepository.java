package com.grocerybooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocerybooking.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
