package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IMouseService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IMouseDao;
import com.vendeton.computerComponents.entities.Mouse;

@Service
public class MouseManager implements IMouseService{
	private IMouseDao mouseDao;

	@Autowired
	public MouseManager(IMouseDao mouseDao) {
		super();
		this.mouseDao = mouseDao;
	}
	@Override
	public DataResult<List<Mouse>> getAll() {
		return new SuccessDataResult<List<Mouse>>(this.mouseDao.findAll(),"mouse listed..");

	}

	@Override
	public Result add(Mouse mouse) {
		this.mouseDao.save(mouse);
		return new SuccessResult("mouse added..");
	}

	@Override
	public DataResult<Mouse> getByName(String name) {
		return new SuccessDataResult<Mouse>
		(this.mouseDao.getByName(name),"name listed..");
	}

	@Override
	public DataResult<Mouse> getByPrice(String price) {
		return new SuccessDataResult<Mouse>
		(this.mouseDao.getByPrice(price),"price listed..");
	}

	@Override
	public DataResult<Mouse> getByMauseId(int mauseId) {
		return new SuccessDataResult<Mouse>
		(this.mouseDao.getByMauseId(mauseId));
	}

	@Override
	public Result deleteByMauseId(int mauseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByName(int mauseId, String nameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByPrice(int mauseId, String priceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
