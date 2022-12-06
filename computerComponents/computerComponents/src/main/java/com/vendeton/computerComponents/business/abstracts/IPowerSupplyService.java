package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.PowerSupply;

public interface IPowerSupplyService {
	DataResult<List<PowerSupply>> getAll();
	Result add(PowerSupply powerSupply);
	
	DataResult<PowerSupply> getByName(String name);
	
	DataResult<PowerSupply> getByPrice(String price);

	DataResult<PowerSupply> getByPowerSupplyId(int powerSupplyId);

	Result deleteByPowerSupplyId(int powerSupplyId);
	
	Result  updateByName(int powerSupplyId,String nameUpdate);
	
	Result  updateByPrice(int powerSupplyId,String priceUpdate);
}

