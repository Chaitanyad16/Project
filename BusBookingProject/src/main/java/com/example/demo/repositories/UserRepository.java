package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.User;

public interface UserRepository extends JpaRepository<User,String>{

	List<User> findByPhoneNumberAndPassword(String phoneNumber, String password);

}
