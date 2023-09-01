package com.mypcot.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mypcot.login.dto.CustomerLoginDto;
import com.mypcot.login.dto.LoginMesage;
import com.mypcot.login.entity.Customer;
import com.mypcot.login.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo ur;
	
	public String register(Customer customer) {
		String pass = customer.getPassword();
//		customer.setPassword(passwordEncoder.encode(pass));
		ur.save(customer);
		return "Customer account created";
	}
	
	public LoginMesage loginEmployee(CustomerLoginDto dto) {
        Customer cust= ur.findByEmail(dto.getEmail());
        if (cust != null) {
        	String password = dto.getPassword();
            String encodedPassword = cust.getPassword();
//            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
        	Boolean isPwdRight = password.equals(encodedPassword);
        	if (isPwdRight) {
                Optional<Customer> employee = ur.findOneByEmailAndPassword(dto.getEmail(), dto.getPassword());
                if (employee.isPresent()) {
                    return new LoginMesage("Login Success", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {
                return new LoginMesage("password Not Match", false);
            }
        }else {
            return new LoginMesage("Email not exits", false);
        }
    }
}
