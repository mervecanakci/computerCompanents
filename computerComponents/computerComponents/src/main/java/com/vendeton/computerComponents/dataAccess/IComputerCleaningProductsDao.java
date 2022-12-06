package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.ComputerCleaningProducts;

public interface IComputerCleaningProductsDao extends JpaRepository<ComputerCleaningProducts, Integer>{

	ComputerCleaningProducts getByName(String name);

	ComputerCleaningProducts getByPrice(String price);

	ComputerCleaningProducts getByComputerCleaningProductsId(int computerCleaningProductsId);

}
