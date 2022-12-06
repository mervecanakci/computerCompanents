package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.ICasingService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.ICasingDao;
import com.vendeton.computerComponents.entities.Casing;

@Service
public class CasingManager implements ICasingService{
	
private ICasingDao casingDao;
@Autowired
public CasingManager(ICasingDao casingDao) {
	super();
	this.casingDao = casingDao;
}
@Override
public DataResult<List<Casing>> getAll() {
	return new SuccessDataResult<List<Casing>>(this.casingDao.findAll(),"casing listed..");

}
@Override
public Result add(Casing casing) {
	this.casingDao.save(casing);
	return new SuccessResult("casing added..");
}
@Override
public DataResult<Casing> getByName(String name) {
	return new SuccessDataResult<Casing>
	(this.casingDao.getByName(name),"name listed..");
}
@Override
public DataResult<Casing> getByPrice(String price) {
	return new SuccessDataResult<Casing>
	(this.casingDao.getByPrice(price),"price listed..");
}
@Override
public DataResult<Casing> getByCasingId(int casingId) {
	return new SuccessDataResult<Casing>
	(this.casingDao.getByCasingId(casingId));
}
@Override
public Result deleteByCasingId(int casingId) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByName(int casingId, String nameUpdate) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByPrice(int casingId, String priceUpdate) {
	// TODO Auto-generated method stub
	return null;
}

	
}
