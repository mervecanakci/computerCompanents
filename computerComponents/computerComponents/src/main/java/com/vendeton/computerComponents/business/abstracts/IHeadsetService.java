package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Headset;

public interface IHeadsetService {
	DataResult<List<Headset>> getAll();

Result add(Headset headset);
	
	DataResult<Headset> getByName(String name);
	
	DataResult<Headset> getByPrice(String price);

	DataResult<Headset> getByHeadsetId(int headsetId);

	Result deleteByHeadsetId(int headsetId);
	
	Result  updateByName(int headsetId,String nameUpdate);
	
	Result  updateByPrice(int headsetId,String priceUpdate);
}
