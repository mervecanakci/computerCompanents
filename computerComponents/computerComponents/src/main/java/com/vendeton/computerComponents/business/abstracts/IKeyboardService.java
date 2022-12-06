package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Keyboard;

public interface IKeyboardService {
	DataResult<List<Keyboard>> getAll();

Result add(Keyboard keyboard);
	
	DataResult<Keyboard> getByName(String name);
	
	DataResult<Keyboard> getByPrice(String price);

	DataResult<Keyboard> getByKeyboardId(int keyboardId);

	Result deleteByKeyboardId(int keyboardId);
	
	Result  updateByName(int keyboardId,String nameUpdate);
	
	Result  updateByPrice(int keyboardId,String priceUpdate);
}
