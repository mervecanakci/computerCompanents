package com.vendeton.computerComponents.business.concretes.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.abstracts.IUserService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.abstracts.IUserDao;
import com.vendeton.computerComponents.entities.abstracts.User;

@Service
public class UserManager implements IUserService{

	private IUserDao userDao;
	@Autowired
	public UserManager(IUserDao userDao) {
		super();
		this.userDao = userDao;
	}
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"User listed..");

	}
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User added..");
	}
	@Override
	public DataResult<User> getByFirstName(String firstName) {
		return new SuccessDataResult<User>
		(this.userDao.getByFirstName(firstName),"firstName listed..");
	}
	@Override
	public DataResult<User> getByLastName(String lastName) {
		return new SuccessDataResult<User>
		(this.userDao.getByLastName(lastName),"lastName listed..");
	}
	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>
		(this.userDao.getByEmail(email),"email listed..");
	}
	@Override
	public DataResult<User> getByUserId(int userId) {
		return new SuccessDataResult<User>
		(this.userDao.getByUserId(userId));
	}
	@Override
	public DataResult<User> getByPassword(String password) {
		return new SuccessDataResult<User>
		(this.userDao.getByPassword(password),"password listed..");
	}
	@Override
	public Result updateByPassword(int userId, String passwordUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByLastName(int userId, String lastNameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result deleteByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByFirstName(int userId, String firstNameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByEmail(int userId, String emailUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
