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

import com.vendeton.computerComponents.business.abstracts.abstracts.IManagerService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.Manager;

@RestController
@RequestMapping("/api/manager")
public class ManagerController{
	@Autowired
	private IManagerService managerService;
	
	@GetMapping("/getall")
	public DataResult<List<Manager>> getAll(){
		return this.managerService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Manager manager) {	
		return ResponseEntity.ok(this.managerService.add(manager));

	}
	@DeleteMapping("/deleteByManagerId/{managerId}")
	public Result deleteByManagerId(@RequestParam(value = "managerId") int managerId) {
		return this.managerService.deleteByManagerId(managerId);
	}
	
	@PutMapping("/updateByFirstName/{managerId}")
	public Result updateByFirstName(@RequestParam(value = "managerId") int managerId,@RequestParam(value = "firstNameUpdate") String firstNameUpdate) {
		return this.managerService.updateByFirstName(managerId, firstNameUpdate);
	}

	@PutMapping("/updateByLastName/{managerId}")
	public Result updateByLastName(@RequestParam(value = "managerId") int managerId,@RequestParam(value = "lastNameUpdate") String lastNameUpdate) {
		return this.managerService.updateByLastName(managerId, lastNameUpdate);
	}

	@PutMapping("/updateByEmail/{managerId}")
	public Result updateByEmail(@RequestParam(value = "managerId") int managerId,@RequestParam(value = "emailUpdate") String emailUpdate) {
		return this.managerService.updateByEmail(managerId, emailUpdate);
	}

	@PutMapping("/updateByPassword/{managerId}")
	public Result updateByPassword(@RequestParam(value = "managerId") int managerId,@RequestParam(value = "passwordUpdate") String passwordUpdate) {
		return this.managerService.updateByPassword(managerId, passwordUpdate);
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
