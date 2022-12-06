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

import com.vendeton.computerComponents.business.abstracts.IMonitorService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Monitor;

@RestController
@RequestMapping("/api/monitor")
public class MonitorController{
	@Autowired
	private IMonitorService monitorService;
	

	

	@GetMapping("/getall")
	public DataResult<List<Monitor>> getAll(){
		return this.monitorService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Monitor monitor) {	
		return ResponseEntity.ok(this.monitorService.add(monitor));

	}
	@DeleteMapping("/deleteByMonitorId/{monitorId}")
	public Result deleteByMonitorId(@RequestParam(value = "monitorId") int monitorId) {
		return this.monitorService.deleteByMonitorId(monitorId);
	}
	
	@PutMapping("/updateByName/{monitorId}")
	public Result updateByName(@RequestParam(value = "monitorId") int monitorId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.monitorService.updateByName(monitorId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{monitorId}")
	public Result updateByPrice(@RequestParam(value = "monitorId") int monitorId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.monitorService.updateByPrice(monitorId, priceUpdate);
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
