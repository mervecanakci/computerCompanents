package com.vendeton.computerComponents.business.abstracts.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;

import com.vendeton.computerComponents.entities.abstracts.Catagories_User;


public interface ICatagories_UserService{

	DataResult<List<Catagories_User>> getAll();
	Result add(Catagories_User catagories_User);
}