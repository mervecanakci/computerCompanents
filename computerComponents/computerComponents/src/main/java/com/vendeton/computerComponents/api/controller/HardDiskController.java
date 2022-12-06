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

import com.vendeton.computerComponents.business.abstracts.IHardDiskService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.HardDisk;

@RestController
@RequestMapping("/api/hardDisk")
public class HardDiskController{
	@Autowired
	
private IHardDiskService hardDiskService ;


	

	@GetMapping("/getall")
	public DataResult<List<HardDisk>> getAll(){
		return this.hardDiskService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody HardDisk hardDisk) {	
		return ResponseEntity.ok(this.hardDiskService.add(hardDisk));

	}
	@DeleteMapping("/deleteByHardDiskId/{hardDiskId}")
	public Result deleteByHardDiskId(@RequestParam(value = "hardDiskId") int hardDiskId) {
		return this.hardDiskService.deleteByHardDiskId(hardDiskId);
	}
	
	@PutMapping("/updateByName/{hardDiskId}")
	public Result updateByName(@RequestParam(value = "hardDiskId") int hardDiskId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.hardDiskService.updateByName(hardDiskId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{hardDiskId}")
	public Result updateByPrice(@RequestParam(value = "hardDiskId") int hardDiskId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.hardDiskService.updateByPrice(hardDiskId, priceUpdate);
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
