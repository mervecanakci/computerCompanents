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

import com.vendeton.computerComponents.business.abstracts.IComputerMaintenanceService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.ComputerMaintenance;

@RestController
@RequestMapping("/api/computerMaintenance")
public class ComputerMaintenanceController {
	@Autowired

private IComputerMaintenanceService computerMaintenanceService;

@GetMapping("/getall")
public DataResult<List<ComputerMaintenance>> getAll(){
	return this.computerMaintenanceService.getAll();
}

@PostMapping("/add")
public ResponseEntity<?> add(@Valid  @RequestBody ComputerMaintenance computerMaintenance) {	
	return ResponseEntity.ok(this.computerMaintenanceService.add(computerMaintenance));

}
@DeleteMapping("/deleteByComputerMaintenanceId/{computerMaintenanceId}")
public Result deleteByComputerMaintenanceId(@RequestParam(value = "computerMaintenanceId") int computerMaintenanceId) {
	return this.computerMaintenanceService.deleteByComputerMaintenanceId(computerMaintenanceId);
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
