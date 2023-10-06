package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>{

}
