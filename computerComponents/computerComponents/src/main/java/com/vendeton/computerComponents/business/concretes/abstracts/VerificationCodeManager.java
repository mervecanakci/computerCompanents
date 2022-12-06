package com.vendeton.computerComponents.business.concretes.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.abstracts.IVerificationCodeService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.abstracts.IVerificationCodeDao;
import com.vendeton.computerComponents.entities.abstracts.VerificationCode;

@Service
	public class VerificationCodeManager implements IVerificationCodeService {
	private IVerificationCodeDao verificationCodeDao;
	@Autowired
	public VerificationCodeManager(IVerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}
	@Override
	public DataResult<List<VerificationCode>> getAll() {
		return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.findAll(),"VerificationCode listed..");

	}
	@Override
	public Result add(VerificationCode verificationCode) {
		this.verificationCodeDao.save(verificationCode);
		return new SuccessResult("VerificationCode added..");
	}
	@Override
	public DataResult<VerificationCode> getByCode(String code) {
		return new SuccessDataResult<VerificationCode>
		(this.verificationCodeDao.getByCode(code),"code listed..");
	}
	@Override
	public DataResult<VerificationCode> getByVerificationCodeId(int verificationCodeId) {
		return new SuccessDataResult<VerificationCode>
		(this.verificationCodeDao.getByVerificationCodeId(verificationCodeId));
	}
	@Override
	public Result deleteByVerificationCodeId(int verificationCodeId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result updateByCode(int verificationCodeId, String codeUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
