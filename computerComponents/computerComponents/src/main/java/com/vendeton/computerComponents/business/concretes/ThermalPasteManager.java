package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IThermalPasteService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IThermalPasteDao;
import com.vendeton.computerComponents.entities.ThermalPaste;





@Service
public class ThermalPasteManager implements IThermalPasteService{
private IThermalPasteDao thermalPasteDao;

@Autowired
public ThermalPasteManager(IThermalPasteDao thermalPasteDao) {
	super();
	this.thermalPasteDao = thermalPasteDao;
}

	@Override
	public DataResult<List<ThermalPaste>> getAll() {
		return new SuccessDataResult<List<ThermalPaste>>(this.thermalPasteDao.findAll(),"ThermalPaste listed..");

	}

	@Override
	public Result add(ThermalPaste thermalPaste) {
		this.thermalPasteDao.save(thermalPaste);
		return new SuccessResult("ThermalPaste added..");
	}

	@Override
	public DataResult<ThermalPaste> getByName(String name) {
		return new SuccessDataResult<ThermalPaste>
		(this.thermalPasteDao.getByName(name),"name listed..");
	}

	@Override
	public DataResult<ThermalPaste> getByPrice(String price) {
		return new SuccessDataResult<ThermalPaste>
		(this.thermalPasteDao.getByPrice(price),"price listed..");
	}

	@Override
	public DataResult<ThermalPaste> getByThermalPasteId(int thermalPasteId) {
		return new SuccessDataResult<ThermalPaste>
		(this.thermalPasteDao.getByThermalPasteId(thermalPasteId));
	}

	@Override
	public Result updateByName(int thermalPasteId, String nameUpdate) {		
		return null;
	}

	@Override
	public Result updateByPrice(int thermalPasteId, String priceUpdate) {
		return null;
	}

	@Override
	public Result deleteByThermalPasteId(int thermalPasteId) {	
		return null;
	}
	
	
}
