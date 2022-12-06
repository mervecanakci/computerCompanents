package com.vendeton.computerComponents.business.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.ComputerMaintenance;

public interface IComputerMaintenanceService {
	DataResult<List<ComputerMaintenance>> getAll();

Result add(ComputerMaintenance computerMaintenance);
	
	
	DataResult<ComputerMaintenance> getByComputerMaintenanceId(int computerMaintenanceId);

	Result deleteByComputerMaintenanceId(int computerMaintenanceId);
}
