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

import com.vendeton.computerComponents.business.abstracts.IMonitorsandAccessoriesService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.MonitorsandAccessories;



@RestController
@RequestMapping("/api/monitorsandAccessories")
public class MonitorsandAccessoriesController {
	@Autowired
	private IMonitorsandAccessoriesService monitorsandAccessoriesService ;
	

	@GetMapping("/getall")
	public DataResult<List<MonitorsandAccessories>> getAll(){
		return this.monitorsandAccessoriesService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody MonitorsandAccessories monitorsandAccessories) {	
		return ResponseEntity.ok(this.monitorsandAccessoriesService.add(monitorsandAccessories));

	}
	@DeleteMapping("/deleteByMonitorsandAccessoriesId/{monitorandAccessoriesId}")
	public Result deleteByMonitorsandAccessoriesId(@RequestParam(value = "monitorandAccessoriesId") int monitorandAccessoriesId) {
		return this.monitorsandAccessoriesService.deleteByMonitorsandAccessoriesId(monitorandAccessoriesId);
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
