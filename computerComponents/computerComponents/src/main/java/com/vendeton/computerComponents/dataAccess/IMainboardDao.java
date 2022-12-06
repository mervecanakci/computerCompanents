package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.Mainboard;

public interface IMainboardDao extends JpaRepository<Mainboard, Integer>{

	Mainboard getByName(String name);

	Mainboard getByPrice(String price);

	Mainboard getByMainboardId(int mainboardId);

}
