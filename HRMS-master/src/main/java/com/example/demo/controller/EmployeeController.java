package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.EmloyeeService;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.entity.LeaveManagement;
import com.example.demo.entity.Quelification;
import com.example.demo.entity.Role;
import com.example.demo.entity.Salary;
import com.example.demo.entity.UserRole;

@RestController
@RequestMapping("/hrms")
public class EmployeeController {
	@Autowired
	private EmloyeeService emloyeeService;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addUser(@RequestBody Employee employee) {
		return ResponseEntity.ok(emloyeeService.saveEmployee(employee));
	}
	@GetMapping("/getEmployee")
	public Page<Employee> getAllEmployee(Pageable pageable){
		return emloyeeService.getEmployee(pageable);
	}
	@GetMapping("/getEmployeeDetails")
	public List<Employee> getAllEmployee(){
		return emloyeeService.getEmployee();
	}
	
	@GetMapping("/getById/{empId}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable int empId) {
		return ResponseEntity.of(emloyeeService.getByEmployeeId(empId));
	}
	
	@PutMapping("/updateEmployee/{id}")
	public Employee saveUpdateEmployee(@PathVariable int id ,@RequestBody Employee employee) {
		return emloyeeService.saveOrUpdate(id, employee);
	}
	
	@PostMapping("/getDetails/{empId}/project/{projectId}")
	public void saveAssignDetails(@PathVariable int empId,@PathVariable int projectId) {
		emloyeeService.assignEmployeeProject(empId, projectId);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void  deleteEmployee(@PathVariable int id) {
		emloyeeService.deleteEmployee(id);
	}
	@PostMapping("/addAddress")
	public Address addAddress(@PathVariable int empId,@RequestBody Address address) {
		 
		return emloyeeService.address(empId, address);
		
	}
	@PostMapping("/addQuelification")
	public Quelification addQuelification(@PathVariable int empId,@RequestBody Quelification quelification) {
		return  emloyeeService.addQuelification(empId, quelification);
	}
//	@PostMapping("/addLeave")
//	public LeaveManagement addLeave(@PathVariable int emnId,@RequestBody LeaveManagement leave) {
//		return emloyeeService.addLeave(emnId, leave);
//	}
}
