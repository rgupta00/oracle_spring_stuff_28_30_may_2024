package com.bankapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
	private LocalDateTime timestamp;
	private String   status;
	private String   error;
	private String  toContact;
}
