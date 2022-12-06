package com.vendeton.computerComponents.business.abstracts.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.Catagories_Manager;

public interface ICatagories_ManagerService{
	
	DataResult<List<Catagories_Manager>> getAll();
	
	Result add(Catagories_Manager catagories_Manager);
}
