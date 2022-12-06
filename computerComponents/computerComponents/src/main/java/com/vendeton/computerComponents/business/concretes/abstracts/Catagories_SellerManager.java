package com.vendeton.computerComponents.business.concretes.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendeton.computerComponents.business.abstracts.abstracts.ICatagories_SellerService;
import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.core.utilites.result.SuccessDataResult;
import com.vendeton.computerComponents.core.utilites.result.SuccessResult;
import com.vendeton.computerComponents.dataAccess.abstracts.ICatagories_SellerDao;
import com.vendeton.computerComponents.entities.abstracts.Catagories_Seller;

@Service
public class Catagories_SellerManager implements ICatagories_SellerService {

	private ICatagories_SellerDao catagories_SellerDao;
	@Autowired
	public Catagories_SellerManager(ICatagories_SellerDao catagories_SellerDao) {
		super();
		this.catagories_SellerDao = catagories_SellerDao;
	}
	@Override
	public DataResult<List<Catagories_Seller>> getAll() {
		return new SuccessDataResult<List<Catagories_Seller>>(this.catagories_SellerDao.findAll(),"Catagories_Seller listed..");

	}
	@Override
	public Result add(Catagories_Seller catagories_Seller) {
		this.catagories_SellerDao.save(catagories_Seller);
		return new SuccessResult("catagories_Seller added..");
	}
	
	
	
}
