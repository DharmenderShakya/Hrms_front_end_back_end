package com.example.demo.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.demo.Service.UserDetailServiceImplementation;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
	public PasswordEncoder passwordEncoder() {
		System.out.println("this is password encoder");
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {

		System.out.println("this is user service file");
	return	new UserDetailServiceImplementation();
	}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    	
    	httpSecurity.
		csrf().
		disable().
		authorizeHttpRequests().
		requestMatchers("auth/generate-token","/user/").permitAll().
		requestMatchers(HttpMethod.GET).permitAll().
		requestMatchers(HttpMethod.POST).permitAll().
		requestMatchers(HttpMethod.DELETE).permitAll().
		requestMatchers(HttpMethod.PUT).permitAll().
		anyRequest().
		authenticated().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
		.and()
		.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
		.authenticationProvider(authenticationProvider());
		System.out.println("after----------------------------");
		return httpSecurity.build();
	
    
    }
    
    @Bean
	public AuthenticationProvider authenticationProvider() {
		System.out.println("this is doa authentication file");
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

    
}
