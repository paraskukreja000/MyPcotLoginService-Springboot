package com.mypcot.login.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypcot.login.dto.BankAccDto;
import com.mypcot.login.entity.Accounts;
import com.mypcot.login.service.BankAccService;

@RestController
public class BankAccController {
	
	@Autowired
	private BankAccService bs;
	
	@PostMapping("/allAccounts")
	public ResponseEntity<List<Accounts>> getAllAccByEmail(@RequestBody String email){
		List<Accounts> acc = bs.getAllAccountByEmail(email);
		return ResponseEntity.of(Optional.of(acc));
	}
	
	@PostMapping("/accountByAccno")
	public ResponseEntity<Accounts> getAccByEmailAndAccno(@RequestBody BankAccDto dto){
		Accounts acc = bs.getAccountByEmailAndAccno(dto.getEmail(), dto.getAccno());
		return ResponseEntity.of(Optional.of(acc));
	}
	
	@PostMapping("/addAcc")
	public ResponseEntity<Accounts> addAccount(@RequestBody Accounts account){
		try {
			bs.addAccount(account);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/updateName")
	public ResponseEntity<String> updateAccount(@RequestBody BankAccDto account){
		try {
			bs.updateNameAccount(account);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@PutMapping("/deposit")
	public ResponseEntity<String> depositAmount(@RequestBody BankAccDto acc){
//		Accounts acc = null;
		try {
			String result = bs.depositAmount(acc);
			return ResponseEntity.ok().body(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/withdraw")
	public ResponseEntity<String> withdrawAmount(@RequestBody BankAccDto account){
		try {
			String result = bs.withdrawAmount(account);
			return ResponseEntity.ok().body(result);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	@DeleteMapping("/delete/{accno}")
	public ResponseEntity<String> deleteAccount(@PathVariable int accno) {
		try {
			bs.deleteAccount(accno);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
