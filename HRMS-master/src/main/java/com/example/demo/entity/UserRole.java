package com.example.demo.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserRole {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int userRoleId;

@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
private User employee;

@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
private Role role;

public int getUserRoleId() {
	return userRoleId;
}

public void setUserRoleId(int userRoleId) {
	this.userRoleId = userRoleId;
}


public User getEmployee() {
	return employee;
}

public void setEmployee(User employee) {
	this.employee = employee;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

public UserRole() {
}

}
