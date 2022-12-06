package com.vendeton.computerComponents.business.abstracts.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.Seller;

public interface ISellerService {
	DataResult<List<Seller>> getAll();

Result add(Seller seller);
	
	DataResult<Seller> getByCompanyName(String companyName);
	
	DataResult<Seller> getByWebAddress(String webAddress);

	DataResult<Seller> getBySellerId(int sellerId);

	DataResult<Seller> getByPhoneNumber(String phoneNumber);

	DataResult<Seller> getByPassword(String password);	
	
	DataResult<Seller> getByEmail(String email);
	

	Result deleteBySellerId(int sellerId);
	
	Result updateByCompanyName(int sellerId, String companyNameUpdate);

	Result updateByWebAddress(int sellerId, String webAddressUpdate);
	
	Result  updateByPhoneNumber(int sellerId,String phoneNumberUpdate);
	
	Result  updateByEmail(int sellerId,String emailUpdate);

	Result updateByPassword(int sellerId, String passwordUpdate);

}
