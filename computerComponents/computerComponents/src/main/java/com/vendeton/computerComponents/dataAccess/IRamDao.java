package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.Ram;

public interface IRamDao extends JpaRepository<Ram, Integer>  {

	Ram getByName(String name);

	Ram getByPrice(String price);

	Ram getByRamId(int ramId);

}
