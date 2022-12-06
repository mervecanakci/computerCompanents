package com.vendeton.computerComponents.business.concretes.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.abstracts.ICatagories_ManagerService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.abstracts.ICatagories_ManagerDao;
import com.vendeton.computerComponents.entities.abstracts.Catagories_Manager;

@Service
public class Catagories_ManagerManager implements ICatagories_ManagerService{
private ICatagories_ManagerDao catagories_ManagerDao;
@Autowired
public Catagories_ManagerManager(ICatagories_ManagerDao catagories_ManagerDao) {
	super();
	this.catagories_ManagerDao = catagories_ManagerDao;
}
@Override
public DataResult<List<Catagories_Manager>> getAll() {
	return new SuccessDataResult<List<Catagories_Manager>>(this.catagories_ManagerDao.findAll(),"Catagories_Manager listed..");

}
@Override
public Result add(Catagories_Manager catagories_Manager) {
	this.catagories_ManagerDao.save(catagories_Manager);
	return new SuccessResult("catagories_Manager added..");
}

	

}
