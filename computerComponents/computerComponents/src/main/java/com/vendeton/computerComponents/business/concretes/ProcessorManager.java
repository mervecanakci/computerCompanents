package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IProcessorService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IProcessorDao;
import com.vendeton.computerComponents.entities.Processor;


@Service
public class ProcessorManager implements IProcessorService {
	private IProcessorDao processorDao;
	@Autowired
	public ProcessorManager(IProcessorDao processorDao) {
		super();
		this.processorDao = processorDao;
	}

	@Override
	public DataResult<List<Processor>> getAll() {
		return new SuccessDataResult<List<Processor>>(this.processorDao.findAll(),"Processor listed..");

	}

	@Override
	public Result add(Processor processor) {
		this.processorDao.save(processor);
		return new SuccessResult("processor added..");
	}

	@Override
	public DataResult<Processor> getByName(String name) {
		return new SuccessDataResult<Processor>
		(this.processorDao.getByName(name),"name listed..");
	}

	@Override
	public DataResult<Processor> getByPrice(String price) {
		return new SuccessDataResult<Processor>
		(this.processorDao.getByPrice(price),"price listed..");
	}

	@Override
	public DataResult<Processor> getByProcessorId(int processorId) {
		return new SuccessDataResult<Processor>
		(this.processorDao.getByProcessorId(processorId));
	}

	@Override
	public Result deleteByProcessorId(int processorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByName(int processorId, String nameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByPrice(int processorId, String priceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
