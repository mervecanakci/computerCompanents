package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.DisplayCard;

public interface IDisplayCardService {
	
	
	DataResult<List<DisplayCard>> getAll();

	
Result add(DisplayCard displayCard);
	
	DataResult<DisplayCard> getByName(String name);
	
	DataResult<DisplayCard> getByPrice(String price);

	DataResult<DisplayCard> getByDisplayCardId(int displayCardId);

	Result deleteByDisplayCardId(int displayCardId);
	
	Result  updateByName(int displayCardId,String nameUpdate);
	
	Result  updateByPrice(int displayCardId,String priceUpdate);
}
