package com.bankapp.controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankapp.dto.AccountDetailDto;
import com.bankapp.entity.Account;
import com.bankapp.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

//@RestController
@Controller
@ResponseBody
public class AccountCrudController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountCrudController(AccountService accountService) {
		this.accountService = accountService;
	}


	//@ResponseBody annotation ie contain inside @RestController automatically covert java object to json
	//-----------get all accounts-----
	@GetMapping(path = "accounts", produces =
		{MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Account>> getAll(){
		List<Account> accounts= accountService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(accounts);
	}
	
	//------------get account by id--------
	@Operation(summary = "Get a account by its id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the Account", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Account.class)) }),
	  @ApiResponse(responseCode = "404", description = "Account not found", 
	    content = @Content) })
	@GetMapping(path = "accounts/{id}")
	public ResponseEntity<Account> getById(@PathVariable  int id) {
		Account account= accountService.getById(id);
		
		return ResponseEntity.ok(account);
	}
	
	
	//@RequestBody force json object to be converted to java object, 
	//proper "parser" jackson parser is alredy in the classpath
	//we just need to add parser for xml
	
	//------------add account-------
	@PostMapping(path = "accounts")
	public ResponseEntity<Account> addAccount( @RequestBody  @Valid Account account) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.addAccount(account));
	}
	
	
	//------------delete account by id--------we dont return anything 204
	@DeleteMapping(path = "accounts/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable  int id) {
		 accountService.deleteAccount(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//------------update account by id--------
	@PutMapping(path = "accounts/{id}")
	public ResponseEntity<String> updateAccount(@PathVariable  int id,@RequestBody AccountDetailDto accountDetailDto) {
		 accountService.updateAccount(id, accountDetailDto);
		 String message= "account details are updated successfully";
		 return ResponseEntity.ok(message);
	}

}
