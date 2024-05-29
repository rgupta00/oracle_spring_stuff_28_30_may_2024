package com.bankapp.dto;
//DTO

public class TransferDto {
	private Integer fromAccId;
	private Integer toAccId;
	private double amount;
	public TransferDto(Integer fromAccId, Integer toAccId, double amount) {
		super();
		this.fromAccId = fromAccId;
		this.toAccId = toAccId;
		this.amount = amount;
	}
	public TransferDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getFromAccId() {
		return fromAccId;
	}
	public void setFromAccId(Integer fromAccId) {
		this.fromAccId = fromAccId;
	}
	public Integer getToAccId() {
		return toAccId;
	}
	public void setToAccId(Integer toAccId) {
		this.toAccId = toAccId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
