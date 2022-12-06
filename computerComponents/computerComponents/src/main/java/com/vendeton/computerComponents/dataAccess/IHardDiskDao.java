package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.HardDisk;

public interface IHardDiskDao extends JpaRepository<HardDisk, Integer>{

	HardDisk getByName(String name);

	HardDisk getByPrice(String price);

	HardDisk getByHardDiskId(int hardDiskId);

}
