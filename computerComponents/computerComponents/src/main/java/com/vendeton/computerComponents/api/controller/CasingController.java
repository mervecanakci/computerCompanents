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

import com.vendeton.computerComponents.business.abstracts.ICasingService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Casing;

@RestController
@RequestMapping("/api/casing")
public class CasingController{
	@Autowired	
private ICasingService casingService;


	@GetMapping("/getall")
	public DataResult<List<Casing>> getAll(){
		return this.casingService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Casing casing) {	
		return ResponseEntity.ok(this.casingService.add(casing));

	}
	@DeleteMapping("/deleteByCasingId/{casingId}")
	public Result deleteByCasingId(@RequestParam(value = "casingId") int casingId) {
		return this.casingService.deleteByCasingId(casingId);
	}
	
	@PutMapping("/updateByName/{casingId}")
	public Result updateByName(@RequestParam(value = "casingId") int casingId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.casingService.updateByName(casingId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{casingId}")
	public Result updateByPrice(@RequestParam(value = "casingId") int casingId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.casingService.updateByPrice(casingId, priceUpdate);
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
