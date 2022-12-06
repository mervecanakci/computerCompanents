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

import com.vendeton.computerComponents.business.abstracts.IPowerSupplyService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.PowerSupply;



@RestController
@RequestMapping("/api/powerSupply")
public class PowerSupplyController{
	@Autowired
	private IPowerSupplyService  powerSupplyService ;


	

	@GetMapping("/getall")
	public DataResult<List<PowerSupply>> getAll(){
		return this.powerSupplyService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody PowerSupply powerSupply) {	
		return ResponseEntity.ok(this.powerSupplyService.add(powerSupply));

	}
	@DeleteMapping("/deleteByPowerSupplyId/{powerSupplyId}")
	public Result deleteByPowerSupplyId(@RequestParam(value = "powerSupplyId") int powerSupplyId) {
		return this.powerSupplyService.deleteByPowerSupplyId(powerSupplyId);
	}
	
	@PutMapping("/updateByName/{powerSupplyId}")
	public Result updateByName(@RequestParam(value = "powerSupplyId") int powerSupplyId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.powerSupplyService.updateByName(powerSupplyId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{powerSupplyId}")
	public Result updateByPrice(@RequestParam(value = "powerSupplyId") int powerSupplyId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.powerSupplyService.updateByPrice(powerSupplyId, priceUpdate);
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
