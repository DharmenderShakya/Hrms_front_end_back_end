package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.UserRoleRepository;
import com.example.demo.Service.UserService;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService ;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/")
	public User createUser(@RequestBody  User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/{name}")
	public User getUsers(@PathVariable("name") String name){
		
		return userRepository.findByUserName(name);
		
	}
	
	
}
