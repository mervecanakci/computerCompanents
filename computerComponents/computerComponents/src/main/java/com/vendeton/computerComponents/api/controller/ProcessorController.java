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

import com.vendeton.computerComponents.business.abstracts.IProcessorService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.ErrorDataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Processor;



@RestController
@RequestMapping("/api/processor")
public class ProcessorController {
	@Autowired
	private IProcessorService processorService;
	


	@GetMapping("/getall")
	public DataResult<List<Processor>> getAll(){
		return this.processorService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Processor processor) {	
		return ResponseEntity.ok(this.processorService.add(processor));

	}
	@DeleteMapping("/deleteByProcessorId/{processorId}")
	public Result deleteByProcessorId(@RequestParam(value = "processorId") int processorId) {
		return this.processorService.deleteByProcessorId(processorId);
	}
	
	@PutMapping("/updateByName/{processorId}")
	public Result updateByName(@RequestParam(value = "processorId") int processorId,@RequestParam(value = "nameUpdate") String nameUpdate) {
		return this.processorService.updateByName(processorId, nameUpdate);
	}
	@PutMapping("/updateByPrice/{processorId}")
	public Result updateByPrice(@RequestParam(value = "processorId") int processorId,@RequestParam(value = "priceUpdate") String priceUpdate) {
		return this.processorService.updateByPrice(processorId, priceUpdate);
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
