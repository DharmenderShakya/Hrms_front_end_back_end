package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String role;

@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
private Set<UserRole> rolename=new HashSet<>();
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Set<UserRole> getRolename() {
	return rolename;
}
public void setRolename(Set<UserRole> rolename) {
	this.rolename = rolename;
}

}
