package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LeaveManagement;

@Repository
public interface LeaveManagementRepository extends JpaRepository<LeaveManagement, Integer>{

}
