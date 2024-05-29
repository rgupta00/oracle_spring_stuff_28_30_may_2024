package com.bankapp.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="account_table")
@Data
@NoArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private BigDecimal balance;
	private String phone;
	private String email;
	private String address;
	
	public Account(String name, BigDecimal balance, String phone, String email, String address) {
		this.name = name;
		this.balance = balance;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	
}
