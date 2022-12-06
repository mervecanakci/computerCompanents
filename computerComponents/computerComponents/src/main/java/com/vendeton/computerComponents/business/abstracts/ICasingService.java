package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Casing;

public interface ICasingService{
	DataResult<List<Casing>> getAll();

Result add(Casing casing);
	
	DataResult<Casing> getByName(String name);
	
	DataResult<Casing> getByPrice(String price);

	DataResult<Casing> getByCasingId(int casingId);

	Result deleteByCasingId(int casingId);
	
	Result  updateByName(int casingId,String nameUpdate);
	
	Result  updateByPrice(int casingId,String priceUpdate);
}
