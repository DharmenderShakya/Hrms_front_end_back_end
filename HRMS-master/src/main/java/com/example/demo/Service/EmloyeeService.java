package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Repository.QuelificationRepository;
import com.example.demo.Repository.SalaryRepo;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.LeaveManagementRepository;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.entity.LeaveManagement;
import com.example.demo.entity.Project;
import com.example.demo.entity.Quelification;
import com.example.demo.entity.Role;
import com.example.demo.entity.Salary;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;

@Service
public class EmloyeeService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@Autowired
	private LeaveManagementRepository leaveRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private QuelificationRepository quelificationRepo;
	
	@Autowired
	private SalaryRepo salaryRepo;
	
	@Autowired
	private UserService userService;
	
	public Employee saveEmployee(Employee employee) {
		Employee addreeQuelification=new Employee();
		addreeQuelification.setAddress(employee.getAddress());
		addreeQuelification.setQuelification(employee.getQuelification());
		User user=new User();
		user.setFirstName(employee.getFirstName());
		user.setLastName(employee.getLastName());
		user.setEmail(employee.getEmail());
		user.setUserName(employee.getFirstName()+"1234");
		user.setPhone(employee.getPhone_no());
		user.setProfile(employee.getProfile());
		user.setPassword(employee.getPassword());
		userService.addUser(user);
		return  employeeRepository.save(employee);
	}
	
	public Page<Employee> getEmployee( Pageable pageable){
		return employeeRepository.findAll(pageable);
	}
	
	public List<Employee> getEmployee(){
		
		return employeeRepository.findAll();
	}
	
	
	public Optional<Employee> getByEmployeeId(int empId) {
		
		return employeeRepository.findById(empId);
	}
	
	public Employee saveOrUpdate(int empId,Employee employee) {
		
		Employee emp=employeeRepository.findById(empId).get();
		emp.setEmail(employee.getEmail());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setPhone_no(employee.getPhone_no());
		 return employeeRepository.save(emp);
	}
	
	
		
		public void assignEmployeeProject(int empId,int projectId) {
				
		Employee user=employeeRepository.findById(empId).get();
		Project role=projectRepository.findById(projectId).get();
		role.getUser().add(user);
		user.getRoles().add(role);
		
		projectRepository.save(role);
			
		}
		
		public void deleteEmployee(int id) {
			employeeRepository.deleteById(id);
		}
		
		public Address address(int empId,Address address) {
			Employee user=employeeRepository.findById(empId).get();
			user.setAddress(address);
			return addressRepo.save(address);
			
		}
//		public LeaveManagement addLeave(int empId,LeaveManagement leave) {
//			Employee user=userRepository.findById(empId).get();
//			user.setLeaveManagment(leave);
//			return leaveRepo.save(leave);
//		}
		public Quelification addQuelification (int empId,Quelification quelification) {
			Employee user=employeeRepository.findById(empId).get();
			user.setQuelification(quelification);
			return quelificationRepo.save(quelification);
		
		}
		
}
