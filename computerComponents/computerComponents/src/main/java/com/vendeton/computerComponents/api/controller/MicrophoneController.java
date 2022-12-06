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

import com.vendeton.computerComponents.business.abstracts.IMicrophoneService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;

import com.vendeton.computerComponents.entities.Microphone;



@RestController
@RequestMapping("/api/microphone")
public class MicrophoneController{
	@Autowired
	private IMicrophoneService microphoneService;

	@GetMapping("/getall")
	public DataResult<List<Microphone>> getAll(){
		return this.microphoneService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Microphone microphone) {	
		return ResponseEntity.ok(this.microphoneService.add(microphone));

	}
	@DeleteMapping("/deleteByMicrophoneId/{microphoneId}")
	public Result deleteByMicrophoneId(@RequestParam(value = "microphoneId") int microphoneId) {
		return this.microphoneService.deleteByMicrophoneId(microphoneId);
	}
	
	@PutMapping("/updateByName/{microphoneId}")
	public Result updateByName(@RequestParam(value = "microphoneId") int microphoneId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.microphoneService.updateByName(microphoneId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{microphoneId}")
	public Result updateByPrice(@RequestParam(value = "microphoneId") int microphoneId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.microphoneService.updateByPrice(microphoneId, priceUpdate);
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
