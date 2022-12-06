package com.vendeton.computerComponents.business.concretes.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.abstracts.ISellerService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.abstracts.ISellerDao;
import com.vendeton.computerComponents.entities.abstracts.Seller;

@Service
public class SellerManager implements ISellerService {
private ISellerDao sellerDao;
@Autowired
public SellerManager(ISellerDao sellerDao) {
	super();
	this.sellerDao = sellerDao;
}
@Override
public DataResult<List<Seller>> getAll() {
	return new SuccessDataResult<List<Seller>>(this.sellerDao.findAll(),"Seller listed..");

}
@Override
public Result add(Seller seller) {
	this.sellerDao.save(seller);
	return new SuccessResult("Seller added..");
}
@Override
public DataResult<Seller> getByCompanyName(String companyName) {
	return new SuccessDataResult<Seller>
	(this.sellerDao.getByCompanyName(companyName),"companyName listed..");
}
@Override
public DataResult<Seller> getByWebAddress(String webAddress) {
	return new SuccessDataResult<Seller>
	(this.sellerDao.getByWebAddress(webAddress),"webAddress listed..");
}
@Override
public DataResult<Seller> getBySellerId(int sellerId) {
	return new SuccessDataResult<Seller>
	(this.sellerDao.getBySellerId(sellerId));
}
@Override
public DataResult<Seller> getByPhoneNumber(String phoneNumber) {
	return new SuccessDataResult<Seller>
	(this.sellerDao.getByPhoneNumber(phoneNumber),"phoneNumber listed..");
}
@Override
public DataResult<Seller> getByPassword(String password) {
	return new SuccessDataResult<Seller>
	(this.sellerDao.getByPassword(password),"password listed..");
}
@Override
public DataResult<Seller> getByEmail(String email) {
	return new SuccessDataResult<Seller>
	(this.sellerDao.getByEmail(email),"email listed..");
}
@Override
public Result deleteBySellerId(int sellerId) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByCompanyName(int sellerId, String companyNameUpdate) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByWebAddress(int sellerId, String webAddressUpdate) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByPhoneNumber(int sellerId, String phoneNumberUpdate) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByEmail(int sellerId, String emailUpdate) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Result updateByPassword(int sellerId, String passwordUpdate) {
	// TODO Auto-generated method stub
	return null;
}

	

	
}



		