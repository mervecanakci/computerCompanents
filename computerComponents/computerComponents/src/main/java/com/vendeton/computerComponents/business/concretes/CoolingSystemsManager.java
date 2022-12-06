package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.ICoolingSystemsService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.ICoolingSystemsDao;
import com.vendeton.computerComponents.entities.CoolingSystems;

@Service
public class CoolingSystemsManager implements ICoolingSystemsService{
private ICoolingSystemsDao coolingSystemsDao;
@Autowired
public CoolingSystemsManager(ICoolingSystemsDao coolingSystemsDao) {
	super();
	this.coolingSystemsDao = coolingSystemsDao;
}
@Override
public DataResult<List<CoolingSystems>> getAll() {
	return new SuccessDataResult<List<CoolingSystems>>(this.coolingSystemsDao.findAll(),"CoolingSystems listed..");

}
@Override
public Result add(CoolingSystems coolingSystems) {
	this.coolingSystemsDao.save(coolingSystems);
	return new SuccessResult("CoolingSystems added..");
}
@Override
public DataResult<CoolingSystems> getByName(String name) {
	return new SuccessDataResult<CoolingSystems>
	(this.coolingSystemsDao.getByName(name),"name listed..");
}
@Override
public DataResult<CoolingSystems> getByPrice(String price) {
	return new SuccessDataResult<CoolingSystems>
	(this.coolingSystemsDao.getByPrice(price),"price listed..");
}
@Override
public DataResult<CoolingSystems> getByCoolingSystemsId(int coolingSystemsId) {
	return new SuccessDataResult<CoolingSystems>
	(this.coolingSystemsDao.getByCoolingSystemsId(coolingSystemsId));
}
@Override
public Result deleteByCoolingSystemsId(int coolingSystemsId) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByName(int coolingSystemsId, String nameUpdate) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByPrice(int coolingSystemsId, String priceUpdate) {
	// TODO Auto-generated method stub
	return null;
}

}
