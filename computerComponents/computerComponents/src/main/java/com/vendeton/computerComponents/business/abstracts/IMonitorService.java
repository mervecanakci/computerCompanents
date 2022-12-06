package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.google.common.util.concurrent.Monitor;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;

public interface IMonitorService {
	DataResult<List<com.vendeton.computerComponents.entities.Monitor>> getAll();

Result add(Monitor monitor);
	
	DataResult<com.vendeton.computerComponents.entities.Monitor> getByName(String name);
	
	DataResult<com.vendeton.computerComponents.entities.Monitor> getByPrice(String price);

	DataResult<com.vendeton.computerComponents.entities.Monitor> getByMonitorId(int monitorId);

	Result deleteByMonitorId(int monitorId);
	
	Result  updateByName(int monitorId,String nameUpdate);
	
	Result  updateByPrice(int monitorId,String priceUpdate);

	Result add(com.vendeton.computerComponents.entities.Monitor monitor);
}
