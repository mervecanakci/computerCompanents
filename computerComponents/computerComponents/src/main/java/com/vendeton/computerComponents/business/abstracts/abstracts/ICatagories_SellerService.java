package com.vendeton.computerComponents.business.abstracts.abstracts;

import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.abstracts.Catagories_Seller;

public interface ICatagories_SellerService{
	DataResult<List<Catagories_Seller>> getAll();
	Result add(Catagories_Seller catagories_Seller);
}
