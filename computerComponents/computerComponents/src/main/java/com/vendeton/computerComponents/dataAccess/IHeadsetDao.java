package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.Headset;

public interface IHeadsetDao extends JpaRepository<Headset, Integer>{

	Headset getByName(String name);

	Headset getByPrice(String price);

	Headset getByHeadsetId(int headsetId);

}
