package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IRamService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IRamDao;
import com.vendeton.computerComponents.entities.Ram;


@Service
public class RamManager implements IRamService{
	private IRamDao ramDao;
	@Autowired

	public RamManager(IRamDao ramDao) {
		super();
		this.ramDao = ramDao;
	}
	@Override
	public DataResult<List<Ram>> getAll() {
		return new SuccessDataResult<List<Ram>>(this.ramDao.findAll(),"ram listed..");

	}

	@Override
	public Result add(Ram ram) {
		this.ramDao.save(ram);
		return new SuccessResult("ram added..");
	}

	@Override
	public DataResult<Ram> getByName(String name) {
		return new SuccessDataResult<Ram>
		(this.ramDao.getByName(name),"name listed..");
	}

	@Override
	public DataResult<Ram> getByPrice(String price) {
		return new SuccessDataResult<Ram>
		(this.ramDao.getByPrice(price),"price listed..");
	}

	@Override
	public DataResult<Ram> getByRamId(int ramId) {
		return new SuccessDataResult<Ram>
		(this.ramDao.getByRamId(ramId),"ramId listed..");
	}

	@Override
	public Result deleteByRamId(int ramId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByName(int ramId, String nameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByPrice(int ramId, String priceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}



}
