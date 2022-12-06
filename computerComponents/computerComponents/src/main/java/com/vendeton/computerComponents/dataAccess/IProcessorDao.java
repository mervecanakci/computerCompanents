package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.Processor;

public interface IProcessorDao extends JpaRepository<Processor, Integer> {

	Processor getByName(String name);

	Processor getByPrice(String price);

	Processor getByProcessorId(int processorId);

}
