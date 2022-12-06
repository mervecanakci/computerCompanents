package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IComputerMaintenanceService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IComputerMaintenanceDao;
import com.vendeton.computerComponents.entities.ComputerMaintenance;

@Service
public class ComputerMaintenanceManager implements IComputerMaintenanceService {
private IComputerMaintenanceDao computerMaintenanceDao;
@Autowired
public ComputerMaintenanceManager(IComputerMaintenanceDao computerMaintenanceDao) {
	super();
	this.computerMaintenanceDao = computerMaintenanceDao;
}
@Override
public DataResult<List<ComputerMaintenance>> getAll() {
	return new SuccessDataResult<List<ComputerMaintenance>>(this.computerMaintenanceDao.findAll(),"ComputerMaintenance listed..");

}
@Override
public Result add(ComputerMaintenance computerMaintenance) {
	this.computerMaintenanceDao.save(computerMaintenance);
	return new SuccessResult("ComputerMaintenance added..");
}
@Override
public DataResult<ComputerMaintenance> getByComputerMaintenanceId(int computerMaintenanceId) {
	return new SuccessDataResult<ComputerMaintenance>
	(this.computerMaintenanceDao.getByComputerMaintenanceId(computerMaintenanceId));
}
@Override
public Result deleteByComputerMaintenanceId(int computerMaintenanceId) {
	// TODO Auto-generated method stub
	return null;
}


}
