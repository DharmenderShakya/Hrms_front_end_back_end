package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RegisterUser;

@Repository
public interface ResgisterUserRepository extends JpaRepository<RegisterUser, Integer> {
	
	public RegisterUser findByName(String name);

}
