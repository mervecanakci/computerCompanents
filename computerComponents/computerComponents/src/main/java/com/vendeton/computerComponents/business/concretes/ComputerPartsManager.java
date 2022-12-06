package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IComputerPartsService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IComputerPartsDao;
import com.vendeton.computerComponents.entities.ComputerParts;

@Service
public class ComputerPartsManager implements IComputerPartsService{
private IComputerPartsDao computerPartsDao;
@Autowired
public ComputerPartsManager(IComputerPartsDao computerPartsDao) {
	super();
	this.computerPartsDao = computerPartsDao;
}
@Override
public DataResult<List<ComputerParts>> getAll() {
	return new SuccessDataResult<List<ComputerParts>>(this.computerPartsDao.findAll(),"ComputerParts listed..");

}
@Override
public Result add(ComputerParts computerParts) {
	this.computerPartsDao.save(computerParts);
	return new SuccessResult("ComputerParts added..");
}
@Override
public DataResult<ComputerParts> getByComputerPartsId(int computerPartsId) {
	return new SuccessDataResult<ComputerParts>
	(this.computerPartsDao.getByComputerPartsId(computerPartsId));
}
@Override
public Result deleteByComputerPartsId(int computerPartsId) {
	// TODO Auto-generated method stub
	return null;
}

} 
