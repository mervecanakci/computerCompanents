package com.vendeton.computerComponents.business.abstracts.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.User;

public interface IUserService{
	DataResult<List<User>> getAll();

Result add(User user);
	
	DataResult<User> getByFirstName(String firstName);
	
	DataResult<User> getByLastName(String lastName);
	
	DataResult<User> getByEmail(String email);

	DataResult<User> getByUserId(int userId);

	DataResult<User> getByPassword(String password);

	
	Result updateByPassword(int userId, String passwordUpdate);
	
	Result updateByLastName(int userId, String lastNameUpdate);
	
	Result deleteByUserId(int userId);
	
	Result  updateByFirstName(int userId,String firstNameUpdate);
	
	Result  updateByEmail(int userId,String emailUpdate);
	
	
	
	
	
	
	
	
	

}
