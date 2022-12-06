package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.ComputerParts;

public interface IComputerPartsService {
	DataResult<List<ComputerParts>> getAll();

Result add(ComputerParts computerParts);
	
	
	DataResult<ComputerParts> getByComputerPartsId(int computerPartsId);

	Result deleteByComputerPartsId(int computerPartsId);
	
	
}
