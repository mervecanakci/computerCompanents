package com.vendeton.computerComponents.business.abstracts.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.Catagories;

public interface ICatagoriesService {
	DataResult<List<Catagories>> getAll();

Result add(Catagories catagories);
	
	
	DataResult<Catagories> getByCatagoriesId(int catagoriesId);

	Result deleteByCatagoriesId(int catagoriesId);	
}
