package com.vendeton.computerComponents.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.abstracts.VerificationCode;

public interface IVerificationCodeDao extends JpaRepository<VerificationCode, Integer>{

	VerificationCode getByCode(String code);

	VerificationCode getByVerificationCodeId(int verificationCodeId);

}
