package com.vendeton.computerComponents.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vendeton.computerComponents.business.abstracts.abstracts.ISellerService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.Seller;


@RestController
@RequestMapping("/api/seller")
public class SellerController {
	@Autowired
private ISellerService sellerService;



	@GetMapping("/getall")
	public DataResult<List<Seller>> getAll(){
		return this.sellerService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Seller seller) {	
		return ResponseEntity.ok(this.sellerService.add(seller));

	}
	@DeleteMapping("/deleteBySellerId/{sellerId}")
	public Result deleteBySellerId(@RequestParam(value = "sellerId") int sellerId) {
		return this.sellerService.deleteBySellerId(sellerId);
	}
	
	@PutMapping("/updateByCompanyName/{sellerId}")
	public Result updateByCompanyName(@RequestParam(value = "sellerId") int sellerId,@RequestParam(value = "companyNameUpdate") String companyNameUpdate) {
		return this.sellerService.updateByCompanyName(sellerId, companyNameUpdate);
	}
	@PutMapping("/updateByWebAddress/{sellerId}")
	public Result updateByWebAddress(@RequestParam(value = "sellerId") int sellerId,@RequestParam(value = "webAddressUpdate") String webAddressUpdate) {
		return this.sellerService.updateByWebAddress(sellerId, webAddressUpdate);
	}
	@PutMapping("/updateByPhoneNumber/{sellerId}")
	public Result updateByPhoneNumber(@RequestParam(value = "sellerId") int sellerId,@RequestParam(value = "phoneNumberUpdate") String phoneNumberUpdate) {
		return this.sellerService.updateByPhoneNumber(sellerId, phoneNumberUpdate);
	}
	@PutMapping("/updateByEmail/{sellerId}")
	public Result updateByEmail(@RequestParam(value = "sellerId") int sellerId,@RequestParam(value = "emailUpdate") String emailUpdate) {
		return this.sellerService.updateByEmail(sellerId, emailUpdate);
	}
	@PutMapping("/updateByPassword/{sellerId}")
	public Result updateByPassword(@RequestParam(value = "sellerId") int sellerId,@RequestParam(value = "passwordUpdate") String passwordUpdate) {
		return this.sellerService.updateByPassword(sellerId, passwordUpdate);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)

	@ResponseStatus(HttpStatus.BAD_REQUEST)

	public ErrorDataResult<Object>handleValidationException
	(MethodArgumentNotValidException exceptions) {
		
		Map<String, String> validationErrors=new HashMap<String, String>();

		for(FieldError fieldError :exceptions.getBindingResult().getFieldErrors()) {
			
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	} 

		ErrorDataResult<Object>errors=new 
		ErrorDataResult<Object>(validationErrors, "doğrulama hataları");
		return errors;	

	}	
	
}



		