package com.vendeton.computerComponents.business.concretes.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.abstracts.ICatagories_UserService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.abstracts.ICatagories_UserDao;
import com.vendeton.computerComponents.entities.abstracts.Catagories_User;

@Service
public class Catagories_UserManager implements ICatagories_UserService {

	private ICatagories_UserDao catagories_UserDao;
	@Autowired
	public Catagories_UserManager(ICatagories_UserDao catagories_UserDao) {
		super();
		this.catagories_UserDao = catagories_UserDao;
	}
	@Override
	public DataResult<List<Catagories_User>> getAll() {
		return new SuccessDataResult<List<Catagories_User>>(this.catagories_UserDao.findAll(),"catagories_User listed..");

	}
	@Override
	public Result add(Catagories_User catagories_User) {
		this.catagories_UserDao.save(catagories_User);
		return new SuccessResult("catagories_User added..");
	}
	
	


}
