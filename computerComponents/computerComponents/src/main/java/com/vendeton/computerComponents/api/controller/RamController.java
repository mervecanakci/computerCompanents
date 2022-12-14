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

import com.vendeton.computerComponents.business.abstracts.IRamService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Ram;

@RestController
@RequestMapping("/api/ram")
public class RamController{
	@Autowired
	private IRamService ramService ;
	

	@GetMapping("/getall")
	public DataResult<List<Ram>> getAll(){
		return this.ramService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Ram ram) {	
		return ResponseEntity.ok(this.ramService.add(ram));

	}
	@DeleteMapping("/deleteByRamId/{ramId}")
	public Result deleteByRamId(@RequestParam(value = "ramId") int ramId) {
		return this.ramService.deleteByRamId(ramId);
	}
	
	@PutMapping("/updateByName/{ramId}")
	public Result updateByName(@RequestParam(value = "ramId") int ramId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.ramService.updateByName(ramId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{ramId}")
	public Result updateByPrice(@RequestParam(value = "ramId") int ramId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.ramService.updateByPrice(ramId, priceUpdate);
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
