package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Mainboard;

public interface IMainboardService {
	DataResult<List<Mainboard>> getAll();

Result add(Mainboard mainboard);
	
	DataResult<Mainboard> getByName(String name);
	
	DataResult<Mainboard> getByPrice(String price);

	DataResult<Mainboard> getByMainboardId(int mainboardId);

	Result deleteByMainboardId(int mainboardId);
	
	Result  updateByName(int mainboardId,String nameUpdate);
	
	Result  updateByPrice(int mainboardId,String priceUpdate);
}
