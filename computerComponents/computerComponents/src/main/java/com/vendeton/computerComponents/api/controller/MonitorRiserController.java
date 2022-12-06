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

import com.vendeton.computerComponents.business.abstracts.IMonitorRiserService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.MonitorRiser;



@RestController
@RequestMapping("/api/monitorRiser")
public class MonitorRiserController{	
	@Autowired
	private IMonitorRiserService monitorRiserService;
	

	

	@GetMapping("/getall")
	public DataResult<List<MonitorRiser>> getAll(){
		return this.monitorRiserService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody MonitorRiser monitorRiser) {	
		return ResponseEntity.ok(this.monitorRiserService.add(monitorRiser));

	}
	@DeleteMapping("/deleteByMonitorRiserId/{monitorRiserId}")
	public Result deleteByMonitorRiserId(@RequestParam(value = "monitorRiserId") int monitorRiserId) {
		return this.monitorRiserService.deleteByMonitorRiserId(monitorRiserId);
	}
	
	@PutMapping("/updateByName/{monitorRiserId}")
	public Result updateByName(@RequestParam(value = "monitorRiserId") int monitorRiserId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.monitorRiserService.updateByName(monitorRiserId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{monitorRiserId}")
	public Result updateByPrice(@RequestParam(value = "monitorRiserId") int monitorRiserId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.monitorRiserService.updateByPrice(monitorRiserId, priceUpdate);
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
