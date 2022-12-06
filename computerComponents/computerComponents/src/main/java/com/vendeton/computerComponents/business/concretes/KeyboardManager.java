package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IKeyboardService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IKeyboardDao;
import com.vendeton.computerComponents.entities.Keyboard;

@Service
public class KeyboardManager implements IKeyboardService{
	private IKeyboardDao keyboardDao;
	@Autowired
	public KeyboardManager(IKeyboardDao keyboardDao) {
		super();
		this.keyboardDao = keyboardDao;
	}
	@Override
	public DataResult<List<Keyboard>> getAll() {
		return new SuccessDataResult<List<Keyboard>>(this.keyboardDao.findAll(),"Keyboard listed..");

	}
	@Override
	public Result add(Keyboard keyboard) {
		this.keyboardDao.save(keyboard);
		return new SuccessResult("keyboard added..");
	}
	@Override
	public DataResult<Keyboard> getByName(String name) {
		return new SuccessDataResult<Keyboard>
		(this.keyboardDao.getByName(name),"name listed..");
	}
	@Override
	public DataResult<Keyboard> getByPrice(String price) {
		return new SuccessDataResult<Keyboard>
		(this.keyboardDao.getByPrice(price),"price listed..");
	}
	@Override
	public DataResult<Keyboard> getByKeyboardId(int keyboardId) {
		return new SuccessDataResult<Keyboard>
		(this.keyboardDao.getByKeyboardId(keyboardId));
	}
	@Override
	public Result deleteByKeyboardId(int keyboardId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByName(int keyboardId, String nameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByPrice(int keyboardId, String priceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}


}
