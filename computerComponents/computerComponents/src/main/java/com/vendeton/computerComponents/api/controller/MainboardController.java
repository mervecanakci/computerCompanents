
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

import com.vendeton.computerComponents.business.abstracts.IMainboardService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Mainboard;

@RestController
@RequestMapping("/api/mainboard")
public class MainboardController{
	@Autowired
	private IMainboardService mainboardService;


	@GetMapping("/getall")
	public DataResult<List<Mainboard>> getAll(){
		return this.mainboardService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Mainboard mainboard) {	
		return ResponseEntity.ok(this.mainboardService.add(mainboard));

	}
	@DeleteMapping("/deleteByMainboardId/{mainboardId}")
	public Result deleteByMainboardId(@RequestParam(value = "mainboardId") int mainboardId) {
		return this.mainboardService.deleteByMainboardId(mainboardId);
	}
	
	@PutMapping("/updateByName/{mainboardId}")
	public Result updateByName(@RequestParam(value = "mainboardId") int mainboardId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.mainboardService.updateByName(mainboardId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{mainboardId}")
	public Result updateByPrice(@RequestParam(value = "mainboardId") int mainboardId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.mainboardService.updateByPrice(mainboardId, priceUpdate);
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
