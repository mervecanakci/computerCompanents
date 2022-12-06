package com.vendeton.computerComponents.business.abstracts.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.VerificationCode;

public interface IVerificationCodeService{
	DataResult<List<VerificationCode>> getAll();

    Result add(VerificationCode verificationCode);
	
	DataResult<VerificationCode> getByCode(String code);

	DataResult<VerificationCode> getByVerificationCodeId(int verificationCodeId);

	Result deleteByVerificationCodeId(int verificationCodeId);
	
	Result  updateByCode(int verificationCodeId,String codeUpdate);
	
}
