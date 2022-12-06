
package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IMainboardService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IMainboardDao;
import com.vendeton.computerComponents.entities.Mainboard;


@Service
public class MainboardManager implements IMainboardService{
	private IMainboardDao mainboardDao;

	
	@Autowired
	public MainboardManager(IMainboardDao mainboardDao) {
		super();
		this.mainboardDao = mainboardDao;
	}


	@Override
	public DataResult<List<Mainboard>> getAll() {
		return new SuccessDataResult<List<Mainboard>>(this.mainboardDao.findAll(),"mainboard listed..");

	}


	@Override
	public Result add(Mainboard mainboard) {
		this.mainboardDao.save(mainboard);
		return new SuccessResult("mainboard added..");
	}


	@Override
	public DataResult<Mainboard> getByName(String name) {
		return new SuccessDataResult<Mainboard>
		(this.mainboardDao.getByName(name),"name listed..");
	}


	@Override
	public DataResult<Mainboard> getByPrice(String price) {
		return new SuccessDataResult<Mainboard>
		(this.mainboardDao.getByPrice(price),"price listed..");
	}


	@Override
	public DataResult<Mainboard> getByMainboardId(int mainboardId) {
		return new SuccessDataResult<Mainboard>
		(this.mainboardDao.getByMainboardId(mainboardId));
	}


	@Override
	public Result deleteByMainboardId(int mainboardId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Result updateByName(int mainboardId, String nameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Result updateByPrice(int mainboardId, String priceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

}
