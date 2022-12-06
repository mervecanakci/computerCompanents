package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IHeadsetService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IHeadsetDao;
import com.vendeton.computerComponents.entities.Headset;


@Service
public class HeadsetManager implements IHeadsetService{
	private IHeadsetDao headsetDao;
	@Autowired
	public HeadsetManager(IHeadsetDao headsetDao) {
		super();
		this.headsetDao = headsetDao;
	}
	@Override
	public DataResult<List<Headset>> getAll() {
		return new SuccessDataResult<List<Headset>>(this.headsetDao.findAll(),"headset listed..");

	}
	@Override
	public Result add(Headset headset) {
		this.headsetDao.save(headset);
		return new SuccessResult("headset added..");
	}
	@Override
	public DataResult<Headset> getByName(String name) {
		return new SuccessDataResult<Headset>
		(this.headsetDao.getByName(name),"name listed..");
	}
	@Override
	public DataResult<Headset> getByPrice(String price) {
		return new SuccessDataResult<Headset>
		(this.headsetDao.getByPrice(price),"price listed..");
	}
	@Override
	public DataResult<Headset> getByHeadsetId(int headsetId) {
		return new SuccessDataResult<Headset>
		(this.headsetDao.getByHeadsetId(headsetId));
	}
	@Override
	public Result deleteByHeadsetId(int headsetId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByName(int headsetId, String nameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByPrice(int headsetId, String priceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}


}
