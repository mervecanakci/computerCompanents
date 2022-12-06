package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Processor;

public interface IProcessorService {
DataResult<List<Processor>> getAll();
	
	Result add(Processor processor);
	
	DataResult<Processor> getByName(String name);
	
	DataResult<Processor> getByPrice(String price);

	DataResult<Processor> getByProcessorId(int processorId);

	Result deleteByProcessorId(int processorId);
	
	Result  updateByName(int processorId,String nameUpdate);
	
	Result  updateByPrice(int processorId,String priceUpdate);
}
