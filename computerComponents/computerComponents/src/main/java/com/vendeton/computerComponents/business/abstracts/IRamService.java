package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Ram;

public interface IRamService {

	
DataResult<List<Ram>> getAll();
	
	Result add(Ram ram);
	
	DataResult<Ram> getByName(String name);
	
	DataResult<Ram> getByPrice(String price);

	DataResult<Ram> getByRamId(int ramId);

	Result deleteByRamId(int ramId);
	
	Result  updateByName(int ramId,String nameUpdate);
	
	Result  updateByPrice(int ramId,String priceUpdate);
	
	
	
}
