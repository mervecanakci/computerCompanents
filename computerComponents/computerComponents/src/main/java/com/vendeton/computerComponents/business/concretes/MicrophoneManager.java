package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.IMicrophoneService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.IMicrophoneDao;
import com.vendeton.computerComponents.entities.Microphone;



@Service
public class MicrophoneManager implements IMicrophoneService{
	private IMicrophoneDao microphoneDao;
	@Autowired
	public MicrophoneManager(IMicrophoneDao microphoneDao) {
		super();
		this.microphoneDao = microphoneDao;
	}
	@Override
	public DataResult<List<Microphone>> getAll() {
		return new SuccessDataResult<List<Microphone>>(this.microphoneDao.findAll(),"microphone listed..");

	}
	@Override
	public Result add(Microphone microphone) {
		this.microphoneDao.save(microphone);
		return new SuccessResult("microphone added..");
	}
	@Override
	public DataResult<Microphone> getByName(String name) {
		return new SuccessDataResult<Microphone>
		(this.microphoneDao.getByName(name),"name listed..");
	}
	@Override
	public DataResult<Microphone> getByPrice(String price) {
		return new SuccessDataResult<Microphone>
		(this.microphoneDao.getByPrice(price),"price listed..");
	}
	@Override
	public DataResult<Microphone> getByMicrophoneId(int microphoneId) {
		return new SuccessDataResult<Microphone>
		(this.microphoneDao.getByMicrophoneId(microphoneId));
	}
	@Override
	public Result deleteByMicrophoneId(int microphoneId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByName(int microphoneId, String nameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByPrice(int microphoneId, String priceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
