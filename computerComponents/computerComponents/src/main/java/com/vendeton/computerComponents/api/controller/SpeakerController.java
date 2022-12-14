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

import com.vendeton.computerComponents.business.abstracts.ISpeakerService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Speaker;


@RestController
@RequestMapping("/api/speaker")
public class SpeakerController{
	@Autowired
private ISpeakerService speakerService;


	

	@GetMapping("/getall")
	public DataResult<List<Speaker>> getAll(){
		return this.speakerService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Speaker speaker) {	
		return ResponseEntity.ok(this.speakerService.add(speaker));

	}
	@DeleteMapping("/deleteBySpeakerId/{speakerId}")
	public Result deleteBySpeakerId(@RequestParam(value = "speakerId") int speakerId) {
		return this.speakerService.deleteBySpeakerId(speakerId);
	}
	
	@PutMapping("/updateByName/{speakerId}")
	public Result updateByName(@RequestParam(value = "speakerId") int speakerId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.speakerService.updateByName(speakerId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{speakerId}")
	public Result updateByPrice(@RequestParam(value = "speakerId") int speakerId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.speakerService.updateByPrice(speakerId, priceUpdate);
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