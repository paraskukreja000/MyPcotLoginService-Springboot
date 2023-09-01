package com.mypcot.login.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mypcot.login.entity.Accounts;

public interface AccountRepo extends JpaRepository<Accounts, Integer>{

	@Query(value = "SELECT accno FROM accounts u WHERE u.email = :email", nativeQuery = true)
	public List<String> findAllAccountByEmail(String email);
	
	@Query(value = "SELECT * FROM accounts u WHERE u.email = :email and u.accno = :accno", nativeQuery = true)
	public Accounts findOneByEmailAndAccno(String email, long accno);
	
	
	@Query(value = "DELETE FROM accounts u WHERE u.email = :email and u.accno = :accno", nativeQuery = true)
	public void deleteByEmailAndAccno(String email, long accno);
	
	
}
