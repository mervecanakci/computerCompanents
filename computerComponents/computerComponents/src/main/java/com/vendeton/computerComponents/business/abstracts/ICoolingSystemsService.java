package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.CoolingSystems;

public interface ICoolingSystemsService{
	DataResult<List<CoolingSystems>> getAll();

Result add(CoolingSystems coolingSystems);
	
	DataResult<CoolingSystems> getByName(String name);
	
	DataResult<CoolingSystems> getByPrice(String price);

	DataResult<CoolingSystems> getByCoolingSystemsId(int coolingSystemsId);

	Result deleteByCoolingSystemsId(int coolingSystemsId);
	
	Result  updateByName(int coolingSystemsId,String nameUpdate);
	
	Result  updateByPrice(int coolingSystemsId,String priceUpdate);
}
