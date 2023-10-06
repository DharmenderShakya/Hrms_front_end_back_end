 package com.example.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class LeaveManagement {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="Leave_Reason")
	private String reason;
	@Column(name="Leave_Start_Date")
	private String startDate;
	private String employeeName;
	@Column(name="Leave_End")
	private String endDate;
	@Column(name="Leave_Description")
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeId",referencedColumnName = "id")
	private Employee employee;
	
	@OneToOne(cascade = CascadeType.ALL)
	private  FileData fileData;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public LeaveManagement(int id, String reason, String startDate, String employeeName, String endDate,
			String description, Employee employee, FileData fileData) {
		super();
		this.id = id;
		this.reason = reason;
		this.startDate = startDate;
		this.employeeName = employeeName;
		this.endDate = endDate;
		this.description = description;
		this.employee = employee;
		this.fileData = fileData;
	}
	public LeaveManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
//	public List<Employee> getEmployee() {
//		return employee;
//	}
//	public void setEmployee(List<Employee> employee) {
//		this.employee = employee;
//	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public FileData getFileData() {
		return fileData;
	}
	public void setFileData(FileData fileData) {
		this.fileData = fileData;
	}
	
	
}
