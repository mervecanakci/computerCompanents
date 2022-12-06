package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.CoolingSystems;

public interface ICoolingSystemsDao extends JpaRepository<CoolingSystems, Integer>{

	CoolingSystems getByName(String name);

	CoolingSystems getByPrice(String price);

	CoolingSystems getByCoolingSystemsId(int coolingSystemsId);

}
