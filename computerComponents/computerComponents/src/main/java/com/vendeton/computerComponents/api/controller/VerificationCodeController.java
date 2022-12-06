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

import com.vendeton.computerComponents.business.abstracts.abstracts.IVerificationCodeService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.VerificationCode;


@RestController
@RequestMapping("/api/verificationCode")
public class VerificationCodeController{
	@Autowired
	private IVerificationCodeService verificationCodeService;
	
	
	@GetMapping("/getall")
	public DataResult<List<VerificationCode>> getAll(){
		return this.verificationCodeService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody VerificationCode verificationCode) {	
		return ResponseEntity.ok(this.verificationCodeService.add(verificationCode));

	}
	@DeleteMapping("/deleteByVerificationCodeId/{verificationCodeId}")
	public Result deleteByVerificationCodeId(@RequestParam(value = "verificationCodeId") int verificationCodeId) {
		return this.verificationCodeService.deleteByVerificationCodeId(verificationCodeId);
	}
	
	@PutMapping("/updateByCode/{verificationCodeId}")
	public Result updateByCode(@RequestParam(value = "verificationCodeId") int verificationCodeId,@RequestParam(value = "codeUpdate") String codeUpdate) {
		return this.verificationCodeService.updateByCode(verificationCodeId, codeUpdate);
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
