package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IMonitorService;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IMonitorDao;
import com.vendeton.computerComponents.entities.Monitor;

@Service
public class MonitorManager implements IMonitorService{
	private IMonitorDao monitorDao;
	
	@Autowired
	public MonitorManager(IMonitorDao monitorDao) {
		super();
		this.monitorDao = monitorDao;
	}
	
	@Override
	public DataResult<List<Monitor>> getAll() {
		return new SuccessDataResult<List<Monitor>>(this.monitorDao.findAll(),"Monitor listed..");
	}
	@Override
	public Result add(Monitor monitor) {
		this.monitorDao.save(monitor);
		return new SuccessResult("monitor added..");
	}
	@Override
	public DataResult<Monitor> getByName(String name) {
			return new SuccessDataResult<Monitor>
			(this.monitorDao.getByName(name),"name listed..");
	}
	@Override
	public DataResult<Monitor> getByPrice(String price) {
		return new SuccessDataResult<Monitor>
		(this.monitorDao.getByPrice(price),"price listed..");
	}
	@Override
	public DataResult<Monitor> getByMonitorId(int monitorId) {
		return new SuccessDataResult<Monitor>
		(this.monitorDao.getByMonitorId(monitorId));
	}
	@Override
	public Result deleteByMonitorId(int monitorId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByName(int monitorId, String nameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByPrice(int monitorId, String priceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(com.google.common.util.concurrent.Monitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
