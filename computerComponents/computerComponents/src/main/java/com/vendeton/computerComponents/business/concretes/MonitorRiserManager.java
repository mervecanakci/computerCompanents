package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IMonitorRiserService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IMonitorRiserDao;
import com.vendeton.computerComponents.entities.MonitorRiser;

@Service
public class MonitorRiserManager implements IMonitorRiserService{	

	private IMonitorRiserDao monitorRiserDao;
	@Autowired
	public MonitorRiserManager(IMonitorRiserDao monitorRiserDao) {
		super();
		this.monitorRiserDao = monitorRiserDao;
	}
	@Override
	public DataResult<List<MonitorRiser>> getAll() {
		return new SuccessDataResult<List<MonitorRiser>>(this.monitorRiserDao.findAll(),"MonitorRiser listed..");

	}
	@Override
	public Result add(MonitorRiser monitorRiser) {
		this.monitorRiserDao.save(monitorRiser);
		return new SuccessResult("MonitorRiser added..");
	}
	@Override
	public DataResult<MonitorRiser> getByName(String name) {
		return new SuccessDataResult<MonitorRiser>
		(this.monitorRiserDao.getByName(name),"name listed..");
	}
	@Override
	public DataResult<MonitorRiser> getByPrice(String price) {
		return new SuccessDataResult<MonitorRiser>
		(this.monitorRiserDao.getByPrice(price),"price listed..");
	}
	@Override
	public DataResult<MonitorRiser> getByMonitorRiserId(int monitorRiserId) {
		return new SuccessDataResult<MonitorRiser>
		(this.monitorRiserDao.getByMonitorRiserId(monitorRiserId));
	}
	@Override
	public Result deleteByMonitorRiserId(int monitorRiserId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByName(int monitorRiserId, String nameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByPrice(int monitorRiserId, String priceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
