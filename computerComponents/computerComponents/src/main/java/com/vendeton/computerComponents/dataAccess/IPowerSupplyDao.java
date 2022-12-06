package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.PowerSupply;

public interface IPowerSupplyDao extends JpaRepository<PowerSupply, Integer> {

	PowerSupply getByName(String name);

	PowerSupply getByPrice(String price);

	PowerSupply getByPowerSupplyId(int powerSupplyId);

}
