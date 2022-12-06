package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IDisplayCardService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IDisplayCardDao;
import com.vendeton.computerComponents.entities.DisplayCard;

@Service
public class DisplayCardManager implements IDisplayCardService{
private IDisplayCardDao displayCardDao;
@Autowired
public DisplayCardManager(IDisplayCardDao displayCardDao) {
	super();
	this.displayCardDao = displayCardDao;
}
@Override
public DataResult<List<DisplayCard>> getAll() {
	return new SuccessDataResult<List<DisplayCard>>(this.displayCardDao.findAll(),"DisplayCard listed..");

}
@Override
public Result add(DisplayCard displayCard) {
	this.displayCardDao.save(displayCard);
	return new SuccessResult("DisplayCard added..");
}
@Override
public DataResult<DisplayCard> getByName(String name) {
	return new SuccessDataResult<DisplayCard>
	(this.displayCardDao.getByName(name),"name listed..");
}
@Override
public DataResult<DisplayCard> getByPrice(String price) {
	return new SuccessDataResult<DisplayCard>
	(this.displayCardDao.getByPrice(price),"price listed..");
}
@Override
public DataResult<DisplayCard> getByDisplayCardId(int displayCardId) {
	return new SuccessDataResult<DisplayCard>
	(this.displayCardDao.getByDisplayCardId(displayCardId));
}
@Override
public Result deleteByDisplayCardId(int displayCardId) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByName(int displayCardId, String nameUpdate) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByPrice(int displayCardId, String priceUpdate) {
	// TODO Auto-generated method stub
	return null;
}

}
