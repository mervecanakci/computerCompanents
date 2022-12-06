package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IHardDiskService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IHardDiskDao;
import com.vendeton.computerComponents.entities.HardDisk;

@Service
public class HardDiskManager implements IHardDiskService{
private IHardDiskDao hardDiskDao;
@Autowired
public HardDiskManager(IHardDiskDao hardDiskDao) {
	super();
	this.hardDiskDao = hardDiskDao;
}
@Override
public DataResult<List<HardDisk>> getAll() {
	return new SuccessDataResult<List<HardDisk>>(this.hardDiskDao.findAll(),"HardDisk listed..");

}
@Override
public Result add(HardDisk hardDisk) {
	this.hardDiskDao.save(hardDisk);
	return new SuccessResult("hardDisk added..");
}
@Override
public DataResult<HardDisk> getByName(String name) {
	return new SuccessDataResult<HardDisk>
	(this.hardDiskDao.getByName(name),"name listed..");
}

@Override
public DataResult<HardDisk> getByPrice(String price) {
	return new SuccessDataResult<HardDisk>
	(this.hardDiskDao.getByPrice(price),"price listed..");
}
@Override
public DataResult<HardDisk> getByHardDiskId(int hardDiskId) {
	return new SuccessDataResult<HardDisk>
	(this.hardDiskDao.getByHardDiskId(hardDiskId));
}
@Override
public Result deleteByHardDiskId(int hardDiskId) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByName(int hardDiskId, String nameUpdate) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByPrice(int hardDiskId, String priceUpdate) {
	// TODO Auto-generated method stub
	return null;
}

}
