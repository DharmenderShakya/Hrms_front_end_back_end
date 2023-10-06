package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.LeaveManagementRepository;
import com.example.demo.entity.Employee;
import com.example.demo.entity.LeaveManagement;
import com.example.demo.request.LeaveRequest;

@Service
public class LeaveManagementService {

	@Autowired
	private LeaveManagementRepository leaveRepossitory;
	
	@Autowired 
	private EmployeeRepository employeeReo; 
	
	
	public LeaveManagement addLeave(LeaveRequest leaveRequest) {
		Employee user=employeeReo.findById(leaveRequest.getEmployeeId()).get();
		LeaveManagement leaves=new LeaveManagement();
		leaves.setEmployee(user);
		leaves.setDescription(leaveRequest.getDescription());
		leaves.setEmployeeName(leaveRequest.getEmployeeName());
		leaves.setReason(leaveRequest.getReason());
		leaves.setEndDate(leaveRequest.getEndDate());
		leaves.setStartDate(leaveRequest.getStartDate());
		return leaveRepossitory.save(leaves);

		
	}
	
	public List<LeaveManagement> getleaveDetails(){
	
		return leaveRepossitory.findAll();
	}
	
	public Optional<LeaveManagement> getLeaveById(int leaveId) {
		
		return leaveRepossitory.findById(leaveId);
	}
	
	
	public LeaveManagement saveOrUpdate(int leaveId,LeaveManagement leaveManagement) {
		
		LeaveManagement leave=leaveRepossitory.findById(leaveId).get();
		leave.setReason(leaveManagement.getReason());
		leave.setStartDate(leaveManagement.getStartDate());
		leave.setEndDate(leaveManagement.getEndDate());
		leave.setDescription(leaveManagement.getDescription());
		
		return leaveRepossitory.save(leave);
	}
	
	public void leaveDeleteById(int leaveId) {
	
		leaveRepossitory.deleteById(leaveId);
	}
	
	
}
