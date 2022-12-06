package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IMonitorsandAccessoriesService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IMonitorsandAccessoriesDao;
import com.vendeton.computerComponents.entities.MonitorsandAccessories;


@Service
public class MonitorsandAccessoriesManager implements IMonitorsandAccessoriesService {
	private IMonitorsandAccessoriesDao monitorsandAccessoriesDao;
	@Autowired
	public MonitorsandAccessoriesManager(IMonitorsandAccessoriesDao monitorsandAccessoriesDao) {
		super();
		this.monitorsandAccessoriesDao = monitorsandAccessoriesDao;
	}

	@Override
	public DataResult<List<MonitorsandAccessories>> getAll() {
		return new SuccessDataResult<List<MonitorsandAccessories>>(this.monitorsandAccessoriesDao.findAll(),"MonitorsandAccessories listed..");

	}

	@Override
	public Result add(MonitorsandAccessories monitorsandAccessories) {
		this.monitorsandAccessoriesDao.save(monitorsandAccessories);
		return new SuccessResult("monitorsandAccessories added..");
	}

	@Override
	public DataResult<MonitorsandAccessories> getByMonitorsandAccessoriesId(int monitorandAccessoriesId) {
		return new SuccessDataResult<MonitorsandAccessories>
		(this.monitorsandAccessoriesDao.getByMonitorsandAccessoriesId(monitorandAccessoriesId));
	}

	@Override
	public Result deleteByMonitorsandAccessoriesId(int monitorandAccessoriesId) {
		return null;
	}

	
	
}
