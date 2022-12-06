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

import com.vendeton.computerComponents.business.abstracts.IMouseService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Mouse;



@RestController
@RequestMapping("/api/mouse")
public class MouseController{
	@Autowired
	private IMouseService mouseService;

	

	@GetMapping("/getall")
	public DataResult<List<Mouse>> getAll(){
		return this.mouseService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Mouse mouse) {	
		return ResponseEntity.ok(this.mouseService.add(mouse));

	}
	@DeleteMapping("/deleteByMauseId/{mauseId}")
	public Result deleteByMauseId(@RequestParam(value = "mauseId") int mauseId) {
		return this.mouseService.deleteByMauseId(mauseId);
	}
	
	@PutMapping("/updateByName/{mauseId}")
	public Result updateByName(@RequestParam(value = "mauseId") int mauseId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.mouseService.updateByName(mauseId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{mauseId}")
	public Result updateByPrice(@RequestParam(value = "mauseId") int mauseId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.mouseService.updateByPrice(mauseId, priceUpdate);
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
