package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.ComputerParts;

public interface IComputerPartsDao extends JpaRepository<ComputerParts, Integer>{


	ComputerParts getByComputerPartsId(int computerPartsId);

}
