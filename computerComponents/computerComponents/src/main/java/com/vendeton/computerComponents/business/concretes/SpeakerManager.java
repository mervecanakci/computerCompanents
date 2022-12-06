package com.vendeton.computerComponents.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.ISpeakerService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.ISpeakerDao;
import com.vendeton.computerComponents.entities.Speaker;

@Service
public class SpeakerManager implements ISpeakerService {
private ISpeakerDao speakerDao;


@Autowired
public SpeakerManager(ISpeakerDao speakerDao) {
	super();
	this.speakerDao = speakerDao;
}
	@Override
	public DataResult<List<Speaker>> getAll() {
		return new SuccessDataResult<List<Speaker>>(this.speakerDao.findAll(),"speaker listed..");

	}

	@Override
	public Result add(Speaker speaker) {
		this.speakerDao.save(speaker);
		return new SuccessResult("speaker added..");
	}

	@Override
	public DataResult<Speaker> getByName(String name) {
		return new SuccessDataResult<Speaker>
		(this.speakerDao.getByName(name),"name listed..");
	}

	@Override
	public DataResult<Speaker> getByPrice(String price) {
		return new SuccessDataResult<Speaker>
		(this.speakerDao.getByPrice(price),"price listed..");
	}

	@Override
	public DataResult<Speaker> getBySpeakerId(int speakerId) {
		return new SuccessDataResult<Speaker>
		(this.speakerDao.getBySpeakerId(speakerId));
	}

	@Override
	public Result deleteBySpeakerId(int speakerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByName(int speakerId, String nameUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateByPrice(int speakerId, String priceUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}