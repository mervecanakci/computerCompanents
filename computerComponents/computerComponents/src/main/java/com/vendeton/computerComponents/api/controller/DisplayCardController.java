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

import com.vendeton.computerComponents.business.abstracts.IDisplayCardService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;

import com.vendeton.computerComponents.entities.DisplayCard;

@RestController
@RequestMapping("/api/displayCard")
public class DisplayCardController{
	
	@Autowired
private IDisplayCardService displayCardService;




@GetMapping("/getall")
public DataResult<List<DisplayCard>> getAll(){
	return this.displayCardService.getAll();
}

@PostMapping("/add")
public ResponseEntity<?> add(@Valid  @RequestBody DisplayCard displayCard) {	
	return ResponseEntity.ok(this.displayCardService.add(displayCard));

}
@DeleteMapping("/deleteByDisplayCardId/{displayCardId}")
public Result deleteByDisplayCardId(@RequestParam(value = "displayCardId") int displayCardId) {
	return this.displayCardService.deleteByDisplayCardId(displayCardId);
}

@PutMapping("/updateByName/{displayCardId}")
public Result updateByName(@RequestParam(value = "displayCardId") int displayCardId,@RequestParam(value = "nameUpdate") String nameUpdate) {
	return this.displayCardService.updateByName(displayCardId, nameUpdate);
}
@PutMapping("/updateByPrice/{displayCardId}")
public Result updateByPrice(@RequestParam(value = "displayCardId") int displayCardId,@RequestParam(value = "priceUpdate") String priceUpdate) {
	return this.displayCardService.updateByPrice(displayCardId, priceUpdate);
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
