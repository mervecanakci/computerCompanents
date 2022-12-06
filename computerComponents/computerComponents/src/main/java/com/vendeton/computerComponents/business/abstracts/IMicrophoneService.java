package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.Microphone;

public interface IMicrophoneService {
	DataResult<List<Microphone>> getAll();

Result add(Microphone microphone);
	
	DataResult<Microphone> getByName(String name);
	
	DataResult<Microphone> getByPrice(String price);

	DataResult<Microphone> getByMicrophoneId(int microphoneId);

	Result deleteByMicrophoneId(int microphoneId);
	
	Result  updateByName(int microphoneId,String nameUpdate);
	
	Result  updateByPrice(int microphoneId,String priceUpdate);
}
