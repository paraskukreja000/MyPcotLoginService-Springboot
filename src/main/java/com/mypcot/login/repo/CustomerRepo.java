package com.mypcot.login.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mypcot.login.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	@Query(value = "SELECT * FROM CUSTOMER u WHERE u.email = :email", nativeQuery = true)
	Customer findByEmail(String email);
	
	 Optional<Customer> findOneByEmailAndPassword(String email, String password);
}
