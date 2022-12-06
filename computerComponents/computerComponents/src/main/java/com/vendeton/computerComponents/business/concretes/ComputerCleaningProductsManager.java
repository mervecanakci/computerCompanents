package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IComputerCleaningProductsService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IComputerCleaningProductsDao;
import com.vendeton.computerComponents.entities.ComputerCleaningProducts;

@Service
public class ComputerCleaningProductsManager implements IComputerCleaningProductsService{
private IComputerCleaningProductsDao computerCleaningProductsDao;
@Autowired
public ComputerCleaningProductsManager(IComputerCleaningProductsDao computerCleaningProductsDao) {
	super();
	this.computerCleaningProductsDao = computerCleaningProductsDao;
}
@Override
public DataResult<List<ComputerCleaningProducts>> getAll() {
	return new SuccessDataResult<List<ComputerCleaningProducts>>(this.computerCleaningProductsDao.findAll(),"ComputerCleaningProducts listed..");

}
@Override
public Result add(ComputerCleaningProducts computerCleaningProducts) {
	this.computerCleaningProductsDao.save(computerCleaningProducts);
	return new SuccessResult("ComputerCleaningProducts added..");
}
@Override
public DataResult<ComputerCleaningProducts> getByName(String name) {
	return new SuccessDataResult<ComputerCleaningProducts>
	(this.computerCleaningProductsDao.getByName(name),"name listed..");
}
@Override
public DataResult<ComputerCleaningProducts> getByPrice(String price) {
	return new SuccessDataResult<ComputerCleaningProducts>
	(this.computerCleaningProductsDao.getByPrice(price),"price listed..");
}
@Override
public DataResult<ComputerCleaningProducts> getByComputerCleaningProductsId(int computerCleaningProductsId) {
	return new SuccessDataResult<ComputerCleaningProducts>
	(this.computerCleaningProductsDao.getByComputerCleaningProductsId(computerCleaningProductsId));
}
@Override
public Result deleteByComputerCleaningProductsId(int computerCleaningProductsId) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByName(int computerCleaningProductsId, String nameUpdate) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByPrice(int computerCleaningProductsId, String priceUpdate) {
	// TODO Auto-generated method stub
	return null;
}


}
