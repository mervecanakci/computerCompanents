package com.vendeton.computerComponents.business.abstracts.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.Manager;

public interface IManagerService {
	DataResult<List<Manager>> getAll();

Result add(Manager manager);
	
	DataResult<Manager> getByFirstName(String firstName);
	
	DataResult<Manager> getByLastName(String lastName);
	
	DataResult<Manager> getByEmail(String email);

	DataResult<Manager> getByManagerId(int managerId);

	DataResult<Manager> getByPassword(String password);

	
	Result updateByPassword(int managerId, String passwordUpdate);
	
	Result updateByLastName(int managerId, String lastNameUpdate);
	
	Result deleteByManagerId(int managerId);
	
	Result  updateByFirstName(int managerId,String firstNameUpdate);
	
	Result  updateByEmail(int managerId,String emailUpdate);
	
	
	
	
}
