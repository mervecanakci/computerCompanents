package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.MonitorRiser;

public interface IMonitorRiserService {
	DataResult<List<MonitorRiser>> getAll();

	
Result add(MonitorRiser monitorRiser);
	
	DataResult<MonitorRiser> getByName(String name);
	
	DataResult<MonitorRiser> getByPrice(String price);

	DataResult<MonitorRiser> getByMonitorRiserId(int monitorRiserId);

	Result deleteByMonitorRiserId(int monitorRiserId);
	
	Result  updateByName(int monitorRiserId,String nameUpdate);
	
	Result  updateByPrice(int monitorRiserId,String priceUpdate);
}
