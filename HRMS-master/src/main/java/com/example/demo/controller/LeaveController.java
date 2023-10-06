package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.LeaveManagementService;
import com.example.demo.entity.Employee;
import com.example.demo.entity.LeaveManagement;
import com.example.demo.request.LeaveRequest;

@RestController
@RequestMapping("/hrms")
public class LeaveController {

	@Autowired
	private LeaveManagementService leaveService;
	
	@Autowired
	private EmployeeRepository employeeReo;
	
	@PostMapping("/saveleave")
	public ResponseEntity<LeaveManagement>  addLeave(@RequestBody LeaveRequest leaveRequest) {
		return ResponseEntity.ok(leaveService.addLeave(leaveRequest));
	}
	
	@GetMapping("/getLeaveDetails")
	public List<LeaveManagement> getAllLeaveDetails() {
		 return leaveService.getleaveDetails();
	}
	
	@PutMapping("/updateLeave/{leave_id}")
	public ResponseEntity<LeaveManagement> saveOrUpdateLeave(@PathVariable int leave_id,@RequestBody LeaveManagement leaveManagement){
		return ResponseEntity.ok(leaveService.saveOrUpdate(leave_id, leaveManagement));
	}
	
	@GetMapping("/getByLeaveId/{leaveId}")
	public ResponseEntity<LeaveManagement> leaveGetById(@PathVariable int leaveId) {
		
		return ResponseEntity.of(leaveService.getLeaveById(leaveId));
	}
	
	@DeleteMapping("/deleteByLeaveId/{leaveId}")
	public void deleteById(@PathVariable int leaveId) {
		leaveService.leaveDeleteById(leaveId);
	}
}
