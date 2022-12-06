package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Speaker;

public interface ISpeakerService {

DataResult<List<Speaker>> getAll();
	
	Result add(Speaker speaker);
	
	DataResult<Speaker> getByName(String name);
	
	DataResult<Speaker> getByPrice(String price);

	DataResult<Speaker> getBySpeakerId(int speakerId);

	Result deleteBySpeakerId(int speakerId);
	
	Result  updateByName(int speakerId,String nameUpdate);
	
	Result  updateByPrice(int speakerId,String priceUpdate);
	
}
