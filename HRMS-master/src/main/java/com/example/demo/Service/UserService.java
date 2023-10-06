package com.example.demo.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.UserRoleRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRoleRepository userRoleRepository ;
	
	public User addUser(User user) {
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> userRoleSet=new HashSet<>();
		Role role=new Role();
		role.setRole("NORMAL");
		UserRole userRole=new UserRole();
		userRole.setEmployee(user);
		userRole.setRole(role);
		userRoleSet.add(userRole);
		user.setUserRole(userRoleSet);
		userRoleRepository.save(userRole);
		return userRepository.save(user);
	}

	
	
}
