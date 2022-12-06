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

import com.vendeton.computerComponents.business.abstracts.IHeadsetService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Headset;

@RestController
@RequestMapping("/api/headset")
public class HeadsetController{
	@Autowired
	private IHeadsetService headsetService;


	@GetMapping("/getall")
	public DataResult<List<Headset>> getAll(){
		return this.headsetService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Headset headset) {	
		return ResponseEntity.ok(this.headsetService.add(headset));

	}
	@DeleteMapping("/deleteByHeadsetId/{headsetId}")
	public Result deleteByHeadsetId(@RequestParam(value = "headsetId") int headsetId) {
		return this.headsetService.deleteByHeadsetId(headsetId);
	}
	
	@PutMapping("/updateByName/{headsetId}")
	public Result updateByName(@RequestParam(value = "headsetId") int headsetId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.headsetService.updateByName(headsetId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{headsetId}")
	public Result updateByPrice(@RequestParam(value = "headsetId") int headsetId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.headsetService.updateByPrice(headsetId, priceUpdate);
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
