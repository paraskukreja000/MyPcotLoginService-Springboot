package com.mypcot.login.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.mypcot.login.dto.BankAccDto;
import com.mypcot.login.entity.Accounts;
import com.mypcot.login.repo.AccountRepo;

@Service
public class BankAccService implements CommandLineRunner{

	@Autowired
	private AccountRepo ar;
	
	@Override
	public void run(String... args) throws Exception {
		List<Accounts> acc = new ArrayList<Accounts>();
		acc.add(new Accounts(123, "a", 200, "abc@g.com"));
		acc.add(new Accounts(124, "b", 200, "abc@g.com"));
		acc.add(new Accounts(125, "c", 200, "abc@g.com"));
		acc.add(new Accounts(137, "d", 200, "abcd@g.com"));
		acc.add(new Accounts(138, "e", 200, "abcer@g.com"));
		ar.saveAll(acc);
	}

	

	public List<Accounts> getAllAccountByEmail(String email) {
		List<Accounts> acc = ar.findAccountByEmail(email);
		return acc;
	}
	
	public Accounts getAccountByEmailAndAccno(String email,long accno) {
		Accounts acc = ar.findOneByEmailAndAccno(email, accno);
		return acc;
	}

	
	public Accounts addAccount(Accounts account) {
		if(account.getEmail() != null && account.getName() != null) {;
			ar.save(account);			
		}
		return account;
	}

	
	public Accounts updateNameAccount(BankAccDto account) {
		Accounts acc = ar.findOneByEmailAndAccno(account.getEmail(), account.getAccno());
		acc.setName(account.getName());
		ar.save(acc);
		return acc;
	}

	
	public String deleteAccount(int accno) {
		ar.deleteById(accno);
		return accno+" Delete Successfull";
		
	}

	
	public String depositAmount(BankAccDto account) {		
		Accounts ac = ar.findOneByEmailAndAccno(account.getEmail(),account.getAccno());
		ac.setBalance(ac.getBalance() + account.getAmount());
		ar.save(ac);
		return "your new balance is: "+(ac.getBalance() + account.getAmount());
	}

	
	public String withdrawAmount(BankAccDto account) {
		Accounts ac = ar.findOneByEmailAndAccno(account.getEmail(),account.getAccno());
		if(ac.getBalance()>=account.getAmount()) {
			ac.setBalance(ac.getBalance() - account.getAmount());
		}
		ar.save(ac);
		return "your new balance is: "+(ac.getBalance() - account.getAmount());
	}




}
