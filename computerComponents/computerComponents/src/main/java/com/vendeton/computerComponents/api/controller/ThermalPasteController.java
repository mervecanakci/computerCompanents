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

import com.vendeton.computerComponents.business.abstracts.IThermalPasteService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.ThermalPaste;


@RestController
@RequestMapping("/api/thermalPaste")
public class ThermalPasteController{
	@Autowired
private IThermalPasteService thermalPasteService;


	@GetMapping("/getall")
	public DataResult<List<ThermalPaste>> getAll(){
		return this.thermalPasteService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody ThermalPaste thermalPaste) {	
		return ResponseEntity.ok(this.thermalPasteService.add(thermalPaste));

	}
	@DeleteMapping("/deleteByThermalPasteId/{thermalPasteId}")
	public Result deleteByThermalPasteId(@RequestParam(value = "thermalPasteId") int thermalPasteId) {
		return this.thermalPasteService.deleteByThermalPasteId(thermalPasteId);
	}
	
	@PutMapping("/updateByName/{thermalPasteId}")
	public Result updateByName(@RequestParam(value = "thermalPasteId") int thermalPasteId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.thermalPasteService.updateByName(thermalPasteId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{thermalPasteId}")
	public Result updateByPrice(@RequestParam(value = "thermalPasteId") int thermalPasteId,@RequestParam(value = "updateByPrice") String updateByPrice) {
		return this.thermalPasteService.updateByPrice(thermalPasteId, updateByPrice);
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
