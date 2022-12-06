package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.Casing;

public interface ICasingDao extends JpaRepository<Casing, Integer>{

	Casing getByName(String name);

	Casing getByPrice(String price);

	Casing getByCasingId(int casingId);

}
