package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IPowerSupplyService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IPowerSupplyDao;
import com.vendeton.computerComponents.entities.PowerSupply;

@Service
public class PowerSupplyManager implements IPowerSupplyService{
	private IPowerSupplyDao powerSupplyDao;

	@Autowired
	public PowerSupplyManager(IPowerSupplyDao powerSupplyDao) {
		super();
		this.powerSupplyDao = powerSupplyDao;
	}
	
	@Override
	public DataResult<List<PowerSupply>> getAll() {
		return new SuccessDataResult<List<PowerSupply>>(this.powerSupplyDao.findAll(),"PowerSupply listed..");

	}


	@Override
	public Result add(PowerSupply powerSupply) {
		this.powerSupplyDao.save(powerSupply);
		return new SuccessResult("PowerSupply added..");
	}

	@Override
	public DataResult<PowerSupply> getByName(String name) {
		return new SuccessDataResult<PowerSupply>
		(this.powerSupplyDao.getByName(name),"name listed..");
	}

	@Override
	public DataResult<PowerSupply> getByPrice(String price) {
		return new SuccessDataResult<PowerSupply>
		(this.powerSupplyDao.getByPrice(price),"price listed..");
	}

	@Override
	public DataResult<PowerSupply> getByPowerSupplyId(int powerSupplyId) {
		return new SuccessDataResult<PowerSupply>
		(this.powerSupplyDao.getByPowerSupplyId(powerSupplyId));
	}

	@Override
	public Result deleteByPowerSupplyId(int powerSupplyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByName(int powerSupplyId, String nameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByPrice(int powerSupplyId, String priceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
