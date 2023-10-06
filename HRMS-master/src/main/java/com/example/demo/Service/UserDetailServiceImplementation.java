package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;

@Service
public class UserDetailServiceImplementation implements UserDetailsService {

	@Autowired
	UserRepository userRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUserName(username);
		System.out.println("----------------------"+user.getUserName()+user.getPassword());
		if(user==null) {
			System.out.println("user not found");
		}
		UserDetailService userDetailService=new UserDetailService(user);
		return userDetailService;
	}

}
