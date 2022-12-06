package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.ComputerCleaningProducts;

public interface IComputerCleaningProductsService {
	DataResult<List<ComputerCleaningProducts>> getAll();

Result add(ComputerCleaningProducts computerCleaningProductsService);
	
	DataResult<ComputerCleaningProducts> getByName(String name);
	
	DataResult<ComputerCleaningProducts> getByPrice(String price);

	DataResult<ComputerCleaningProducts> getByComputerCleaningProductsId(int computerCleaningProductsId);

	Result deleteByComputerCleaningProductsId(int computerCleaningProductsId);
	
	Result  updateByName(int computerCleaningProductsId,String nameUpdate);
	
	Result  updateByPrice(int computerCleaningProductsId,String priceUpdate);
}
