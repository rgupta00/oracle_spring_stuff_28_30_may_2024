package com.bankapp.dto;
//DTO

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TransferDto {
	private Integer fromAccId;
	private Integer toAccId;
	private BigDecimal amount;
	
}
