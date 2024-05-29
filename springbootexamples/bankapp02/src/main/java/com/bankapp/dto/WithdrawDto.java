package com.bankapp.dto;
//DTO

public class WithdrawDto {
	private Integer accId;
	private double amount;
	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public WithdrawDto(Integer accId, double amount) {
		super();
		this.accId = accId;
		this.amount = amount;
	}
	public WithdrawDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
