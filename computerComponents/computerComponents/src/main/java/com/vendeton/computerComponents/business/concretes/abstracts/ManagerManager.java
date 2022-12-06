package com.vendeton.computerComponents.business.concretes.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.abstracts.IManagerService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.abstracts.IManagerDao;
import com.vendeton.computerComponents.entities.abstracts.Manager;

@Service
public class ManagerManager implements IManagerService{
	private IManagerDao managerDao;
	@Autowired
	public ManagerManager(IManagerDao managerDao) {
		super();
		this.managerDao = managerDao;
	}
	@Override
	public DataResult<List<Manager>> getAll() {
		return new SuccessDataResult<List<Manager>>(this.managerDao.findAll(),"Manager listed..");

	}
	@Override
	public Result add(Manager manager) {
		this.managerDao.save(manager);
		return new SuccessResult("Manager added..");
	}
	@Override
	public DataResult<Manager> getByFirstName(String firstName) {
		return new SuccessDataResult<Manager>
		(this.managerDao.getByFirstName(firstName),"firstName listed..");
	}
	@Override
	public DataResult<Manager> getByLastName(String lastName) {
		return new SuccessDataResult<Manager>
		(this.managerDao.getByLastName(lastName),"lastName listed..");
	}
	@Override
	public DataResult<Manager> getByEmail(String email) {
		return new SuccessDataResult<Manager>
		(this.managerDao.getByEmail(email),"email listed..");
	}
	@Override
	public DataResult<Manager> getByManagerId(int managerId) {
		return new SuccessDataResult<Manager>
		(this.managerDao.getByManagerId(managerId));
	}
	@Override
	public DataResult<Manager> getByPassword(String password) {
		return new SuccessDataResult<Manager>
		(this.managerDao.getByPassword(password),"password listed..");
	}
	@Override
	public Result updateByPassword(int managerId, String passwordUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByLastName(int managerId, String lastNameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result deleteByManagerId(int managerId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByFirstName(int managerId, String firstNameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByEmail(int managerId, String emailUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
