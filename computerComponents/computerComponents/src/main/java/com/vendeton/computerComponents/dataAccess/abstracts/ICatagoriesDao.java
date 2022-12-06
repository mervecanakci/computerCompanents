package com.vendeton.computerComponents.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.abstracts.Catagories;

public interface ICatagoriesDao extends JpaRepository<Catagories, Integer> {

	Catagories getByCatagoriesId(int catagoriesId);

	
}
