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

import com.vendeton.computerComponents.business.abstracts.IComputerCleaningProductsService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.ComputerCleaningProducts;

@RestController
@RequestMapping("/api/computerCleaningProductsService")
public class ComputerCleaningProductsController{
	@Autowired
private IComputerCleaningProductsService computerCleaningProductsService;


	@GetMapping("/getall")
	public DataResult<List<ComputerCleaningProducts>> getAll(){
		return this.computerCleaningProductsService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody ComputerCleaningProducts computerCleaningProductsService) {	
		return ResponseEntity.ok(this.computerCleaningProductsService.add(computerCleaningProductsService));

	}
	@DeleteMapping("/deleteByComputerCleaningProductsId/{computerCleaningProductsId}")
	public Result deleteByComputerCleaningProductsId(@RequestParam(value = "computerCleaningProductsId") int computerCleaningProductsId) {
		return this.computerCleaningProductsService.deleteByComputerCleaningProductsId(computerCleaningProductsId);
	}
	
	@PutMapping("/updateByName/{computerCleaningProductsId}")
	public Result updateByName(@RequestParam(value = "computerCleaningProductsId") int computerCleaningProductsId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.computerCleaningProductsService.updateByName(computerCleaningProductsId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{computerCleaningProductsId}")
	public Result updateByPrice(@RequestParam(value = "computerCleaningProductsId") int computerCleaningProductsId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.computerCleaningProductsService.updateByPrice(computerCleaningProductsId, priceUpdate);
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
