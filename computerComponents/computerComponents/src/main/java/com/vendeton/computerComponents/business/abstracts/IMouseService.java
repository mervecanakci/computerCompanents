package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Mouse;

public interface IMouseService {
	DataResult<List<Mouse>> getAll();

Result add(Mouse mouse);
	
	DataResult<Mouse> getByName(String name);
	
	DataResult<Mouse> getByPrice(String price);

	DataResult<Mouse> getByMauseId(int mauseId);

	Result deleteByMauseId(int mauseId);
	
	Result  updateByName(int mauseId,String nameUpdate);
	
	Result  updateByPrice(int mauseId,String priceUpdate);
}
