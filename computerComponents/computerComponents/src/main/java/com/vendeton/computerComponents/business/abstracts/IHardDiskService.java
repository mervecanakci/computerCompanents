package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.HardDisk;

public interface IHardDiskService {
	DataResult<List<HardDisk>> getAll();

Result add(HardDisk hardDisk);
	
	DataResult<HardDisk> getByName(String name);
	
	DataResult<HardDisk> getByPrice(String price);

	DataResult<HardDisk> getByHardDiskId(int hardDiskId);

	Result deleteByHardDiskId(int hardDiskId);
	
	Result  updateByName(int hardDiskId,String nameUpdate);
	
	Result  updateByPrice(int hardDiskId,String priceUpdate);
}

