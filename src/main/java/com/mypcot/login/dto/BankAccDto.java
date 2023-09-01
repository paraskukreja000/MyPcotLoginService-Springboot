package com.mypcot.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccDto {
	long accno;
	String name;
	int amount;
	String email;
}
