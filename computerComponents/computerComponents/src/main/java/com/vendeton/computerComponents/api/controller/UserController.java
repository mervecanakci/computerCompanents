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

import com.vendeton.computerComponents.business.abstracts.abstracts.IUserService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.User;


@RestController
@RequestMapping("/api/user")

public class UserController{
	@Autowired
	private IUserService userService;
	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody User user) {	
		return ResponseEntity.ok(this.userService.add(user));

	}
	@DeleteMapping("/deleteByUserId/{userId}")
	public Result deleteByUserId(@RequestParam(value = "userId") int userId) {
		return this.userService.deleteByUserId(userId);
	}
	
	@PutMapping("/updateByFirstName/{userId}")
	public Result updateByFirstName(@RequestParam(value = "userId") int userId,@RequestParam(value = "firstNameUpdate") String firstNameUpdate) {
		return this.userService.updateByFirstName(userId, firstNameUpdate);
	}

	@PutMapping("/updateByLastName/{userId}")
	public Result updateByLastName(@RequestParam(value = "userId") int userId,@RequestParam(value = "lastNameUpdate") String lastNameUpdate) {
		return this.userService.updateByLastName(userId, lastNameUpdate);
	}

	@PutMapping("/updateByEmail/{userId}")
	public Result updateByEmail(@RequestParam(value = "userId") int userId,@RequestParam(value = "emailUpdate") String emailUpdate) {
		return this.userService.updateByEmail(userId, emailUpdate);
	}

	@PutMapping("/updateByPassword/{userId}")
	public Result updateByPassword(@RequestParam(value = "userId") int userId,@RequestParam(value = "passwordUpdate") String passwordUpdate) {
		return this.userService.updateByPassword(userId, passwordUpdate);
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
