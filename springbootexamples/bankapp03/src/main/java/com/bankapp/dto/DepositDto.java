package com.bankapp.dto;
//DTO

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepositDto {
	private Integer accId;
	private BigDecimal amount;
	
}
