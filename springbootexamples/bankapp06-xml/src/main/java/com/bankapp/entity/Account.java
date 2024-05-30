package com.bankapp.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	
	@NotNull(message = "{account.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{account.name.invalid}")
	private String name;
	
	@NotNull(message = "{account.balance.absent}")
	@Range(min = 100, max = 100000, message = "{account.balance.invalid}")
	private BigDecimal balance;
	
	@NotNull(message = "{account.phone.absent}")
	@Pattern(regexp = "[789][0-9]{9}", message = "{account.phone.invalid}")
	private String phone;
	
	@Email(message = "{account.email.invalid}")
	@NotNull(message = "{account.email.absent}")
	private String email;
	
	@NotNull(message = "address should not be null")
	private String address;
	
	public Account(String name, BigDecimal balance, String phone, String email, String address) {
		this.name = name;
		this.balance = balance;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	
}
