package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

	@Column(name="project_name")
	private String name;
	private String employeeName;
	@Column(name="Project_Assign_Date")
	private String assignDate;
	@Column(name="Project_submit_Date")
	private String submiDate;
	@Column(name="Project_Description")
private String projectDescription;
	private String teamLeader;
public String getTeamLeader() {
		return teamLeader;
	}
	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}
@ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
}, fetch = FetchType.EAGER,
mappedBy = "roles")
private Set<Employee> user=new HashSet<>();
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<Employee> getUser() {
	return user;
}
public void setUser(Set<Employee> user) {
	this.user = user;
}

public Project(int id, String name, String employeeName, String assignDate, String submiDate, String projectDescription,
		String teamLeader, Set<Employee> user) {
	super();
	this.id = id;
	this.name = name;
	this.employeeName = employeeName;
	this.assignDate = assignDate;
	this.submiDate = submiDate;
	this.projectDescription = projectDescription;
	this.teamLeader = teamLeader;
	this.user = user;
}
public Project() {
	super();
	// TODO Auto-generated constructor stub
}
public String getAssignDate() {
	return assignDate;
}
public void setAssignDate(String assignDate) {
	this.assignDate = assignDate;
}
public String getSubmiDate() {
	return submiDate;
}
public void setSubmiDate(String submiDate) {
	this.submiDate = submiDate;
}
public String getProjectDescription() {
	return projectDescription;
}
public void setProjectDescription(String projectDescription) {
	this.projectDescription = projectDescription;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}


}
