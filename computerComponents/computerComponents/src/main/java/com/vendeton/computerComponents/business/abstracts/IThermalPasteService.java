package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.ThermalPaste;

public interface IThermalPasteService {

DataResult<List<ThermalPaste>> getAll();
	
	Result add(ThermalPaste thermalPaste);
	
	DataResult<ThermalPaste> getByName(String name);
	
	DataResult<ThermalPaste> getByPrice(String price);

	DataResult<ThermalPaste> getByThermalPasteId(int thermalPasteId);

	Result deleteByThermalPasteId(int thermalPasteId);
	
	Result  updateByName(int thermalPasteId,String nameUpdate);
	
	Result  updateByPrice(int thermalPasteId,String priceUpdate);


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
