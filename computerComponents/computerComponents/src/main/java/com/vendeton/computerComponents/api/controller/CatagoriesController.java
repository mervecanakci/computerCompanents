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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vendeton.computerComponents.business.abstracts.abstracts.ICatagoriesService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.Catagories;

@RestController
@RequestMapping("/api/catagories")

public class CatagoriesController{
	@Autowired
private ICatagoriesService catagoriesServiceo;


	@GetMapping("/getall")
	public DataResult<List<Catagories>> getAll(){
		return this.catagoriesServiceo.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Catagories catagories) {	
		return ResponseEntity.ok(this.catagoriesServiceo.add(catagories));

	}
	@DeleteMapping("/deleteByCatagoriesId/{catagoriesId}")
	public Result deleteByCatagoriesId(@RequestParam(value = "catagoriesId") int catagoriesId) {
		return this.catagoriesServiceo.deleteByCatagoriesId(catagoriesId);
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
		ErrorDataResult<Object>(validationErrors, "do??rulama hatalar??");
		return errors;	

	}	

}
