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

import com.vendeton.computerComponents.business.abstracts.IKeyboardService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;

import com.vendeton.computerComponents.entities.Keyboard;

@RestController
@RequestMapping("/api/keyboard")
public class KeyboardController{
	@Autowired
	private IKeyboardService keyboardService;


	

	@GetMapping("/getall")
	public DataResult<List<Keyboard>> getAll(){
		return this.keyboardService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Keyboard keyboard) {	
		return ResponseEntity.ok(this.keyboardService.add(keyboard));

	}
	@DeleteMapping("/deleteByKeyboardId/{keyboardId}")
	public Result deleteByKeyboardId(@RequestParam(value = "keyboardId") int keyboardId) {
		return this.keyboardService.deleteByKeyboardId(keyboardId);
	}
	
	@PutMapping("/updateByName/{keyboardId}")
	public Result updateByName(@RequestParam(value = "keyboardId") int keyboardId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.keyboardService.updateByName(keyboardId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{keyboardId}")
	public Result updateByPrice(@RequestParam(value = "keyboardId") int keyboardId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.keyboardService.updateByPrice(keyboardId, priceUpdate);
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
