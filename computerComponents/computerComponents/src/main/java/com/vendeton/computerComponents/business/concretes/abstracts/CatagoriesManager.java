package com.vendeton.computerComponents.business.concretes.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.abstracts.ICatagoriesService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.abstracts.ICatagoriesDao;
import com.vendeton.computerComponents.entities.abstracts.Catagories;

@Service

public class CatagoriesManager implements ICatagoriesService{

private ICatagoriesDao catagoriesDao;
@Autowired
public CatagoriesManager(ICatagoriesDao catagoriesDao) {
	super();
	this.catagoriesDao = catagoriesDao;
}
@Override
public DataResult<List<Catagories>> getAll() {
	return new SuccessDataResult<List<Catagories>>(this.catagoriesDao.findAll(),"Catagories listed..");

}
@Override
public Result add(Catagories catagories) {
	this.catagoriesDao.save(catagories);
	return new SuccessResult("Catagories added..");
}
@Override
public DataResult<Catagories> getByCatagoriesId(int catagoriesId) {
	return new SuccessDataResult<Catagories>
	(this.catagoriesDao.getByCatagoriesId(catagoriesId));
}
@Override
public Result deleteByCatagoriesId(int catagoriesId) {
	// TODO Auto-generated method stub
	return null;
}

	
	

}
